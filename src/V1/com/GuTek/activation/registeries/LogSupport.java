/*
    Author: .GuTeK <dev@gutcode.pl>
    Project: GUT-ENGINE [MINECRAFT ENGINE]
    Price: WEBSITE
    Resources: 2/6780
    Data: 26.02.2024
    Contact Discord: .GuTeK#0001
    Contact e-mail: dev@gutcode.pl
    Our websites: https://gutcode.pl
    ⓒ 2024 by .GuTeK | ALL RIGHTS RESERVED |
*/

package V1.com.GuTek.activation.registeries;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LogSupport {
    private static boolean debug;
    private static Logger logger;
    private static final Level level;

    private LogSupport() {
    }

    public static void log(final String msg) {
        if (LogSupport.debug) {
            System.out.println(msg);
        }
        LogSupport.logger.log(LogSupport.level, msg);
    }

    public static void log(final String msg, final Throwable t) {
        if (LogSupport.debug) {
            System.out.println(msg + "; Exception: " + t);
        }
        LogSupport.logger.log(LogSupport.level, msg, t);
    }

    public static boolean isLoggable() {
        return LogSupport.debug || LogSupport.logger.isLoggable(LogSupport.level);
    }

    static {
        LogSupport.debug = false;
        level = Level.FINE;
        try {
            LogSupport.debug = Boolean.getBoolean(name::"javax.activation.debug");
        }
        catch (Throwable t) {}
        LogSupport.logger = Logger.getLogger(name:"javax.activation")
    }
}
