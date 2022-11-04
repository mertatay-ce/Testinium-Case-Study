package org.testinium.network.utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

public class Log4j2Manager {
    private static final Logger log= (Logger) LogManager.getLogger(Log4j2Manager.class);


    public static void info(String message)
    {
        log.info(message);
    }
    public static void error(String message,Throwable t)
    {
        log.error(message, t);
    }
}
