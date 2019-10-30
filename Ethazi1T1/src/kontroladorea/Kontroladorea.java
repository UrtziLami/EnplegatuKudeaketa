package kontroladorea;

import java.util.ArrayList;

import eredua.Departamentu;
import eredua.Enplegatu;
import eredua.FitxategiakIrakurri;
import eredua.Inportak;
import eredua.Selekzioak;

public class Kontroladorea {

	public static void fitxategitikIgo(String ruta, String fitxategimota) {
		ArrayList<Object> objetuak = new ArrayList<Object>();
		switch (fitxategimota) {
		case "json":
			objetuak = FitxategiakIrakurri.irakurriFitzategiaJSON(ruta);
			break;
		case "xml":
			objetuak = FitxategiakIrakurri.irakurriFitzategiaXML(ruta);
			break;
		case "csv":
			objetuak = FitxategiakIrakurri.irakurriFitzategiaCSV(ruta);
			break;
		}
		for (Object object : objetuak) {
			if (object instanceof Enplegatu) {
				Inportak.erregistratuEnplegatuak((Enplegatu) object);
			} else if (object instanceof Departamentu) {
				Inportak.erregistratuDepartamentuak((Departamentu) object);
			}
		}
	}

	public static ArrayList<Departamentu> lortuDepartamentuak() {
		ArrayList<Departamentu> departamentuenLista = new ArrayList<Departamentu>();
		departamentuenLista = Selekzioak.ateraDepart();
		return departamentuenLista;
	}

	public static ArrayList<Enplegatu> lortuEnplegatuak() {
		ArrayList<Enplegatu> enplegatuenLista = new ArrayList<Enplegatu>();
		enplegatuenLista = Selekzioak.ateraEnple();
		return enplegatuenLista;
	}

}
