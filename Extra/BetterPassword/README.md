# Password Hashing
#### By Carson

There are many misconceptions about computer power when regarding brute-forcing (correctly salted and hashed) password databases.
This program was created to give real-life statistics on how much processing power would actually be needed to crack a password.

For demonstration purposes, I have implemented SHA-256 and PBKDF2. 
##### SHA (Secure Hash Algorithm 2)
SHA is designed to be as quick as possible while still meeting cryptography standards (ie no flaws or exploits know after many experts
have attempted to find some)

##### PBKD2F (Password-Based Key Derivation Function 2)

PBKDF2(henceforth PBK) is a hashing functioning designed to be as slow or fast as needed (also while still meeting cryptography standards)
PBK also implements a iteration count parameter to allow implementation to easily scale when processing power increases. 
While applying SHA or any other hash function thousands or millions of times would have the same effect, 
it has not been tested enough to be used in production. There may be mathematical exploits when SHA is applied multiple times,
and while none have been yet discovered, PBKDF2 has been much more rigorously tested because it is built to scale with iterations, 
and therefor should always be used above SHA when dealing with passwords
An addition point regarding looped SHA is that "rolling your own" (creating or modifying an existing cryptography function/process/standard) is majorly insecure and, when used in production, largely rejected by the community
(see [questions like these](https://security.stackexchange.com/questions/38370/development-of-asymmetric-encryption-algorithm) and [Don't be a Dave](https://security.stackexchange.com/questions/25585/is-my-developers-home-brew-password-security-right-or-wrong-and-why))

PBK uses an iteration input which scales linearly
(For example, running with X iterations will be twice as fast as an iteration count of X*2).
Citing from multiple sources [which can all be found here](https://en.wikipedia.org/wiki/PBKDF2#cite_note-1])),
The recommended number of PBK iterations for security in 2000 was 1000, and in 2005 it was 4096.
Lastpass, a password manager, used 10,000 client-side and 100,000 for server-side in 2011,
 and this number has almost definitely gone up since then.

In this program, an iteration count of 65536 (2 to the 16th power) was picked due to it being the default on Linux. 
This is also, coincidentally, the byte limit for methods in Java, after being compiled to bytecode [source](https://en.wikipedia.org/wiki/65,536)


Now notes on the actually code I wrote: <br>
It starts by taking the input string and classifying it based on groups such as `Lowercase`, `Numbers`,`Special Characters`. 
This simulates places where an attacker may attack only lowercase passwords - much easier then handling all the 200ish ASCII chars.
There are approximately 92 characters on a full-sized keyboard, not counting unprintable characters.

Different groups are declared as singletons in the Type class, an inner class of BetterPassword. 
Due to it being an enum, it is static, and therefor can be accessed from static context.
Adding additional groups (or changing them) is as easy as editing that single class.

A self-proclaimed `Entropy` is then generated from the range of the groups it is a part of.
For example, the password `password` would be part of one group; lowercase. It's "entropy" is 26.
Entropy is normally considered the amount of "randomness" in a specific password, and in this context it is used incorrectly.
A more appropriate word here may be `complexity`, but even that does not fit perfectly.

The Entropy is then used to calculate the number of hashes it would need to crack ever single password within the specified range and length.
A database storing passwords should store the hash (If a website knows your password in plaintext, it's a scam and shouldn't be used. [never store in plaintext](https://stackoverflow.com/questions/1197417/why-are-plain-text-passwords-bad-and-how-do-i-convince-my-boss-that-his-treasur))
An attacker with access to that database wants to crack username/password combination to use on sites like Paypal. 
The number of hashes is the max number of attempts an attacker will have to go through to crack your password.

With this special "no. of hashes" number, it proceeds to calculate the hash-rate of the client's computer.
There are two variables that hold hash count information: `hashes` and `iters`. 
`iters` contains the number of iterations to run `hashes` amount of hashes. This is used to make sure the split of hashes is an integer.
`iters` needs to be divisible by four. By default, it uses an value of 16, which means each thread will process 4 iterations of hashes
For each hashing algorithm, a different hash count is used. This is to make sure it is completed within a reasonable time.

|  |SHA | PBK
|---:|:---:|:---:|
Hashes |1,000,000 | 1,000
Iters  | 16 |  16
Total hashes | 16,000,000 | 16,000

This, however, is calculated with two calls to `System.currentTimeMillis()`. 
This will throw some issues when the system time is changed in the middle of processing. 

The exact implementation of this is:
- Store the current time
- Create four `Runner` objects
  - Inside of each `Runner` is all the objects needed to preform hashing
- Start four threads each with a dedicated `Runner` instance
  - On each thread, preform `hashes` hashes `iters/4` times
  - On the end of each iteration, print a `'.'`
- Stall the main thread until all four threads are done
- Store the new time
- calculate the time difference
- calculate the hash-rate

This process can take anywhere from 30 seconds to several minutes, depending on hardware.
Hash-rate is also cached within the HashFunction instance variable, which speeds up consecutive password strength requests.

Once this is done, seconds/days/years to crack are calculated and displayed. Please keep in mind that it is not a real
representation of time it would take to crack - it's the time it would take to crack **in** Java **on** your computer, which is 
very slow compare to [FPGA chips](https://en.wikipedia.org/wiki/Field-programmable_gate_array), parallel GPUs, or even just a native implementation. 

The real problem with passwords is that humans, by nature, are very predictable.
Dictionary attacks are exceedingly powerful when built correctly, and can decrease the cracking time greatly.
90% of people use one of the top 10,000 passwords. An attacker using such a list could crack a majority of passwords
extremely quickly, and if you think about it, it's the same type people using common passwords that reuse passwords. 
Not reusing of passwords will protect you even if a service you use gets hacked AND they incorrectly stored passwords in their database.

## Possible changes
###### 1
Changing the Types enum to accept a lambda `() -> String`. It would look something like this
```java
enum Type{
    LOWERCASE(() -> "abcdefghijklmnopqrstuvwxyz"),
    UPPERCASE(() -> "ABCDEFGHIJKLMNOPQRSTUVWXYZ"),
    SPECIAL(() -> "~!@#$%^&*()_+{}-=[]:;<>?,./'|\\"),
    NUMBER(() -> "0123456789"),
    UNICODE(() -> /*code that produces all unicode printable characters*/);
}
```
To make generation of Strings more flexible

###### 2
Storing hash amount inside of the HashFunction singleton, so adding more hash functions are easier
###### 3
Store objects needed for all hashing methods in a single object, to allow less verbose lambda and constructors for HashFunction.
This is a good practice in general, and should be first on this list to complete.
###### 4
When switching between hashing algorithms, have the "keyword" be stored in the HashVariable singleton. 
Again, this makes adding new functions faster and easier