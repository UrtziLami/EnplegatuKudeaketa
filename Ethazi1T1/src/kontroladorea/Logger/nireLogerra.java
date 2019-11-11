package kontroladorea.Logger;

import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class nireLogerra {

    static public void setup() throws IOException {

        // lortu loger globala konfiguratzeko
        Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

        // ezabatu erregistroaren irteera kontsolan
        Logger rootLogger = Logger.getLogger("");
        Handler[] handlers = rootLogger.getHandlers();
        if (handlers[0] instanceof ConsoleHandler) {
            rootLogger.removeHandler(handlers[0]);
        }

        logger.setLevel(Level.INFO);
        FileHandler fileTxt = new FileHandler("Logging.txt",true);


        // textura formateatu 
        SimpleFormatter formatterTxt = new SimpleFormatter();
        fileTxt.setFormatter(formatterTxt);
        logger.addHandler(fileTxt);
    }
}