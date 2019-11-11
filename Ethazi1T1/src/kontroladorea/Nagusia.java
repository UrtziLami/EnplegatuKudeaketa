package kontroladorea;

import java.io.IOException;
import java.util.logging.Logger;

import kontroladorea.Logger.nireLogerra;
import leihoak.Leihoak;
import leihoak.Menua;

public class Nagusia {
	public final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);// logerraSortu

	public static void main(String[] args) {

		try {
			nireLogerra.setup();
		} catch (IOException e) {
			e.printStackTrace();
			Nagusia.LOGGER.severe("ERROREA LOG FITXATEGIA SORTZERAKOAN");
			throw new RuntimeException("arasoak log fitxastegiak sortzeko");
		}

		Leihoak leihoa = new Leihoak();
		Menua menua = new Menua();
		Leihoak.aldatuLeihoa(menua);
		
	}

}
