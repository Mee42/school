import java.util.regex.Pattern;

/**
 * @author Carson Graham
 * Date: 2018-11-14
 * Notes: While this will support many emails, it does not entirly fit the format specificed in RFC 5322
 * For example, carson@72.66.54.108 is a valid email address, but it will be incorrectly parsed
 */
public class Email {
    private final String username;
    private final String hostName;
    private final String hostExtension;

    public Email(String email) {
        String[] split = email.split("@",2);//split email into two parts based on @
        if(split.length  != 2)
            throw new IllegalArgumentException("Email does not contain a valid @");
        this.username = split[0];

        String[] host = split[1].split(Pattern.quote("."),2);//Pattern.quote() is needed because "." is compiled to a regex
        if(host.length != 2)
            throw new IllegalArgumentException("Email does not contain a valid host name");
        this.hostName = host[0];
        this.hostExtension = host[1];
    }


    public String getUsername() {
        return username;
    }

    public String getHostName() {
        return hostName;
    }

    public String getHostExtension() {
        return hostExtension;
    }


    @Override
    public String toString() {
        return username + "@" + hostName + "." + hostExtension;
    }
}
/*
No output, {@See Main.testEmail()}
 */
