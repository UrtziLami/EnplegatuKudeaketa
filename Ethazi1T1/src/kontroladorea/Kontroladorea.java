package kontroladorea;

import java.io.File;
import java.util.ArrayList;

import eredua.Aldaketak;
import eredua.Departamentu;
import eredua.Enplegatu;
import eredua.Ezabaketak;
import eredua.FitxategiakIrakurri;
import eredua.Inportak;
import eredua.Konexioa;
import eredua.Selekzioak;
import eredua.SortuPDF;
import eredua.SortuTXT;

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

	public static void aldatuDepartamentua(int departamentuKodea, String izenBerria, String eraikuntzaBerria) {
		izenBerria = izenBerria.toUpperCase();
		eraikuntzaBerria = eraikuntzaBerria.toUpperCase();
		Departamentu departamentuBerria = new Departamentu(departamentuKodea, izenBerria, eraikuntzaBerria);
		Aldaketak.departamentuAldatu(departamentuBerria);
	}

	public static ArrayList<Departamentu> lortuDepartamentuak() {
		ArrayList<Departamentu> departamentuenLista = new ArrayList<Departamentu>();
		departamentuenLista = Selekzioak.ateraDepart();
		return departamentuenLista;
	}

	public static Object[][] lortuDepartamentuenDatuak() {
		ArrayList<Departamentu> departamentuenLista = new ArrayList<Departamentu>();
		departamentuenLista = lortuDepartamentuak();
		Object[][] datuak = new Object[departamentuenLista.size()][3];
		for (int i = 0; i < departamentuenLista.size(); i++) {
			datuak[i][0] = departamentuenLista.get(i).getDepartKod();
			datuak[i][1] = departamentuenLista.get(i).getDepartIzena();
			datuak[i][2] = departamentuenLista.get(i).getEraikuntza();
		}
		return datuak;
	}

	public static void ezabatuDepartamentua(int departKod) {
		System.out.println("ezabatutako departamentua: " + departKod);
		Ezabaketak.ezabatuDepartamentua(departKod);
	}

	public static void ezabatuEnplegatua(int enpleKod) {
		System.out.println("ezabatutako enplegatua: " + enpleKod);
		Ezabaketak.ezabatuEnplegatua(enpleKod);
	}

	public static ArrayList<Enplegatu> lortuEnplegatuak() {
		ArrayList<Enplegatu> enplegatuenLista = new ArrayList<Enplegatu>();
		enplegatuenLista = Selekzioak.ateraEnple();
		return enplegatuenLista;
	}

	public static Object[][] lortuEnplegatuenDatuak() {
		ArrayList<Enplegatu> enplegatuenLista = new ArrayList<Enplegatu>();
		enplegatuenLista = lortuEnplegatuak();
		Object[][] datuak = new Object[enplegatuenLista.size()][8];
		int cont = 0;
		for (Enplegatu enplegatu : enplegatuenLista) {
			datuak[cont][0] = enplegatu.getEnpKod();
			datuak[cont][1] = enplegatu.getIzenAbizena().toLowerCase();
			datuak[cont][2] = enplegatu.getDepartKod();
			datuak[cont][3] = enplegatu.getSoldata();
			datuak[cont][4] = enplegatu.getArdura().toLowerCase();
			datuak[cont][5] = enplegatu.getAltaData();
			datuak[cont][6] = enplegatu.getZuzendariKod();
			datuak[cont][7] = enplegatu.getMaila().toLowerCase();
			cont++;
		}
		return datuak;
	}
	public static void itziKonexioa() {
		Konexioa.konexioaItzi();
	}

	public static void pdfSortuEnp(String path) {
		SortuPDF.sortuPDFEnp(new File(path));
	}
	
	public static void pdfSortuDep(String path) {
		SortuPDF.sortuPDFDep(new File(path));
	}
	
	public static void txtSortuEnp(String path) {
		SortuTXT.sortuTXTEnp(new File(path));
	}
	
	public static void txtSortuDep(String path) {
		SortuTXT.sortuTXTDep(new File(path));
	}

	public static Object[][] lortuZuzendariKod(String maila) {
		Object[][] objetuenLista;
		ArrayList<Integer> kodeak = new ArrayList<Integer>();
		ArrayList<Enplegatu> enpak = new ArrayList<Enplegatu>();
		enpak = lortuEnplegatuak();
		for (int i = 0; i < enpak.size(); i++) {
			if (maila.equals("Soila")) {
				if (enpak.get(i).getMaila().equals("IDAZKARI") || enpak.get(i).getMaila().equals("IKASKETA BURUA")
						|| enpak.get(i).getMaila().equals("ZUZENDARI ORDEA")) {
					kodeak.add(enpak.get(i).getEnpKod());
				}
			} else if (((maila.equals("Ikasketa burua") || maila.equals("Zuzendari ordea") || maila.equals("Idazkaria"))
					&& enpak.get(i).getMaila().equals("ZUZENDARI NAGUSIA"))) {
				kodeak.add(enpak.get(i).getEnpKod());
			}else if (((maila.equals("Mintegi-burua"))
					&& enpak.get(i).getMaila().equals("IKASKETA BURUA"))) {
				kodeak.add(enpak.get(i).getEnpKod());
			}
		}
		objetuenLista= new Object[kodeak.size()][2]; 
		System.out.println(kodeak.size());
		for (int i = 0; i < kodeak.size(); i++) {
			objetuenLista[i][0]=kodeak.get(i);
			objetuenLista[i][1]= Selekzioak.zuzIzena( kodeak.get(i));
		}
		
		return objetuenLista;
	}

	public static void sartuEnp(int departKod, int soldata, int zuzendariKod, String izenAbizena, String ardura, String maila) {
		Enplegatu enp = new Enplegatu();
		enp.setDepartKod(departKod);
		enp.setArdura(ardura.toUpperCase());
		enp.setSoldata(soldata);
		enp.setZuzendariKod(zuzendariKod);
		enp.setIzenAbizena(izenAbizena.toUpperCase());
		enp.setMaila(maila.toUpperCase());
		Inportak.erregistratuEnplegatuak(enp);
	}
	
	public static void aldatuEnp(int enplegatuKod ,int departKod, int soldata, int zuzendariKod, String izenAbizena, String ardura, String maila) {
		Enplegatu enp = new Enplegatu();
		enp.setEnpKod(enplegatuKod);
		enp.setDepartKod(departKod);
		enp.setArdura(ardura.toUpperCase());
		enp.setSoldata(soldata);
		enp.setZuzendariKod(zuzendariKod);
		enp.setIzenAbizena(izenAbizena.toUpperCase());
		enp.setMaila(maila.toUpperCase());
		Aldaketak.enplegatuAldatu(enp);
	}

	public static void sartuDept(String departIzena, String eraikuntza) {
		Departamentu dept = new Departamentu();
		dept.setDepartIzena(departIzena.toUpperCase());
		dept.setEraikuntza(eraikuntza.toUpperCase());
		Inportak.erregistratuDepartamentuak(dept);
	}

}
