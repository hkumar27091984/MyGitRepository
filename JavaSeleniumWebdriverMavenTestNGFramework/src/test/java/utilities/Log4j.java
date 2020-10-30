package utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

public class Log4j {

	private static Logger logger = (Logger) LogManager.getLogger(Log4j.class);

	public static void debug(String message, String exception) {
		logger.debug(message, exception);
    }

    public static void info(String message) {
    	logger.info(message);
    }

    public static void warn(String message) {
    	logger.warn(message);
    }

    public static void error(String message) {
    	logger.error(message);
    }

    public static void trace(String message) {
    	logger.trace(message);
    }

	
}
