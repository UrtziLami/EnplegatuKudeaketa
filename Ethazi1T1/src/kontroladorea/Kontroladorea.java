package kontroladorea;

import leihoak.*;

public class Kontroladorea {
	
	public static void aldatuLeihoDepKudeatu() {
		D_Kudeaketa dep = new D_Kudeaketa();
		Leihoak.aldatuLeihoa(dep);
	}
	
	public static void aldatuLeihoMenua() {
		Menua men = new Menua();
		Leihoak.aldatuLeihoa(men);
	}
	
	public static void aldatuLeihoEnpKudeaketa() {
		E_Kudeaketa enp = new E_Kudeaketa();
		Leihoak.aldatuLeihoa(enp);
	}
	
	public static void aldatuLeihoEnpErregistratu() {
		E_Erregistratu enp = new E_Erregistratu();
		Leihoak.aldatuLeihoa(enp);
	}

}
