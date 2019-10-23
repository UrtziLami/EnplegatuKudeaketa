package kontroladorea;

import java.io.IOException;
import java.util.logging.Logger;

import kontroladorea.Logger.nireLogerra;

public class Nagusia {
	public final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);// logerraSortu

	public static void main(String[] args) {

		try {
			nireLogerra.setup();
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("arasoak log fitxastegiak sortzeko");
		}
	}

}
