

import java.util.Arrays;
import java.util.List;
import static strings.com.carson.Password.Strength.*;

/**
 * Raw data for testing
 */
public class Raw {
    public static final String[] emails =
                    ("    frode@sbcglobal.net\n" +
                    "    jshearer@sbcglobal.net\n" +
                    "    mccurley@comcast.net\n" +
                    "    bigmauler@aol.com\n" +
                    "    dowdy@att.net\n" +
                    "    caidaperl@outlook.com\n" +
                    "    dowdy@gmail.com\n" +
                    "    barlow@verizon.net\n" +
                    "    tamas@outlook.com\n" +
                    "    alhajj@sbcglobal.net\n" +
                    "    janneh@att.net\n" +
                    "    mrdvt@aol.com\n" +
                    "    kohlis@mac.com\n" +
                    "    elflord@att.net\n" +
                    "    damian@mac.com\n" +
                    "    lamprecht@yahoo.ca\n" +
                    "    garland@outlook.com\n" +
                    "    eabrown@msn.com\n" +
                    "    augusto@verizon.net\n" +
                    "    rohitm@verizon.net\n" +
                    "    aardo@live.com\n" +
                    "    nelson@sbcglobal.net\n" +
                    "    breegster@live.com\n" +
                    "    dexter@yahoo.com\n" +
                    "    thaljef@sbcglobal.net\n" +
                    "    yxing@hotmail.com\n" +
                    "    barnett@msn.com\n" +
                    "    mschwartz@yahoo.com\n" +
                    "    dkeeler@icloud.com\n" +
                    "    joglo@icloud.com\n" +
                    "    dpitts@att.net\n" +
                    "    netsfr@sbcglobal.net\n" +
                    "    markjugg@outlook.com\n" +
                    "    mglee@msn.com\n" +
                    "    ehood@yahoo.ca\n" +
                    "    jfreedma@me.com\n" +
                    "    ilyaz@comcast.net\n" +
                    "    rjones@me.com\n" +
                    "    maneesh@msn.com\n" +
                    "    pspoole@live.com\n" +
                    "    sharon@yahoo.ca\n" +
                    "    guialbu@msn.com\n" +
                    "    dunstan@mac.com\n" +
                    "    rsmartin@sbcglobal.net\n" +
                    "    fglock@live.com\n" +
                    "    jigsaw@yahoo.ca\n" +
                    "    cremonini@outlook.com\n" +
                    "    sherzodr@mac.com\n" +
                    "    rkobes@gmail.com\n" +
                    "    mastinfo@hotmail.com\n" +
                    "    gboss@verizon.net\n" +
                    "    bflong@msn.com\n" +
                    "    jonadab@me.com\n" +
                    "    kwilliams@verizon.net\n" +
                    "    floxy@sbcglobal.net\n" +
                    "    nasor@aol.com\n" +
                    "    boein@aol.com\n" +
                    "    jadavis@icloud.com\n" +
                    "    clkao@live.com\n" +
                    "    augusto@outlook.com\n" +
                    "    joglo@msn.com\n" +
                    "    clkao@msn.com\n" +
                    "    dburrows@optonline.net\n" +
                    "    grothoff@live.com\n" +
                    "    crowl@yahoo.com\n" +
                    "    breegster@yahoo.ca\n" +
                    "    oster@att.net\n" +
                    "    druschel@att.net\n" +
                    "    bwcarty@optonline.net\n" +
                    "    grolschie@msn.com\n" +
                    "    peterhoeg@outlook.com\n" +
                    "    mxiao@yahoo.com\n" +
                    "    fukuchi@aol.com\n" +
                    "    cmdrgravy@att.net\n" +
                    "    bartak@mac.com\n" +
                    "    isaacson@msn.com\n" +
                    "    plover@yahoo.ca\n" +
                    "    msusa@yahoo.com\n" +
                    "    stevelim@sbcglobal.net\n" +
                    "    shawnce@live.com\n" +
                    "    darin@optonline.net\n" +
                    "    psharpe@sbcglobal.net\n" +
                    "    wikinerd@me.com\n" +
                    "    kudra@hotmail.com\n" +
                    "    ivoibs@outlook.com\n" +
                    "    comdig@yahoo.ca\n" +
                    "    smpeters@icloud.com\n" +
                    "    devphil@me.com\n" +
                    "    andrei@optonline.net\n" +
                    "    moinefou@yahoo.ca\n" +
                    "    jbailie@hotmail.com\n" +
                    "    ninenine@sbcglobal.net\n" +
                    "    chronos@yahoo.com\n" +
                    "    fallorn@outlook.com\n" +
                    "    barlow@yahoo.com\n" +
                    "    staikos@msn.com\n" +
                    "    cvrcek@msn.com\n" +
                    "    tellis@yahoo.com\n" +
                    "    fukuchi@yahoo.com\n" +
                    "    dleconte@hotmail.com\n")
            .replace(" ","")
            .split("\n");
    public static final List<Pair<String, Password.Strength>> passwords = Arrays.asList(
            new Pair<>("hello",WEAK2),
            new Pair<>("1234",WEAK1),
            new Pair<>("abc123xyz",STRONG1),
            new Pair<>("1337h@xor!",STRONG2));

    static class Pair<A,B>{
        public final A a;
        public final B b;

        public Pair(A a, B b) {
            this.a = a;
            this.b = b;
        }
    }

    public static final List<String> isbn = Arrays.asList(
            "0-670-03441-X",
            "0-201-48558-3",
            "1-56592-262-X",
            "0-06-027900-1",
            "0-439-45695-9",
            "0-470-84371-3",
            "1-4000-3136-2",
            "0-19-856453-8",
            "1-85671-104-8");
}
