package eredua;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class SortuTXT {

	private static String format;
	private static ArrayList<Departamentu> deptak = new ArrayList<>();
	private static ArrayList<Enplegatu> enpak = new ArrayList<>();

	public static void sortuTXTEnp(File fitx) {
		try {
			PrintWriter pw = new PrintWriter(new FileWriter(fitx));
			enpak = Selekzioak.ateraEnple();
			String depIzena, zuzIzena;
			format = "|%-15S  |  %-20S  |  %-30S  |  %-10S  |  %-15S  |  %-25S  |  %-20S  |  %-20S  |\r\n";
			pw.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			pw.printf(format, "EnplegatuKod", "IzenAbizena", "Departamentua", "Soldata", "Ardura", "AltaData", "Zuzendaria", "Maila");
			pw.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			for (Enplegatu enp : enpak) {
				depIzena = Selekzioak.deptIzena(enp.getDepartKod());
				zuzIzena = Selekzioak.zuzIzena(enp.getZuzendariKod());
				pw.printf(format, enp.getEnpKod(), enp.getIzenAbizena(), depIzena, enp.getSoldata(),
						enp.getArdura(), enp.getAltaData(), zuzIzena, enp.getMaila());
			}
			pw.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void sortuTXTDep(File fitx) {
		try {
			PrintWriter pw = new PrintWriter(new FileWriter(fitx));
			deptak = Selekzioak.ateraDepart();
			format = "|%-15S  |  %-30S  |  %-20S  |\r\n";
			pw.println("-------------------------------------------------------------------------------");
			pw.printf(format, "DepartamentuKod", "DepartIzena", "Eraikuntza");
			pw.println("-------------------------------------------------------------------------------");
			for (Departamentu dep : deptak) {
				pw.printf(format, dep.getDepartKod(), dep.getDepartIzena(), dep.getEraikuntza());
			}
			pw.println("-------------------------------------------------------------------------------");
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
