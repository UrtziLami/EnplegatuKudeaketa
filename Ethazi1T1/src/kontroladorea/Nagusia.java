package kontroladorea;

import java.util.logging.Logger;

public class Nagusia {
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);//logerraSortu
	public static void main(String[] args) {
		
		try {
            nireLogerra.setup();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("arasoak log fitxastegiak sortzeko");
        }
	}

}
