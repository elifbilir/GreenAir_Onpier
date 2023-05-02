package com.GreenAir_Onpier.utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log {

    private static final Logger logger = LogManager.getLogger(Log.class);

    public static void log(String message) {
        logger.info(message);
    }

}
