package eredua;

public class Departamentu {
	private int departKod;
	private String eraikuntza, DepartIzena;

	public Departamentu(int departKod, String eraikuntza, String departIzena) {
		this.departKod = departKod;
		this.eraikuntza = eraikuntza;
		DepartIzena = departIzena;
	}

	public int getDepartKod() {
		return departKod;
	}

	public void setDepartKod(int departKod) {
		this.departKod = departKod;
	}

	public String getEraikuntza() {
		return eraikuntza;
	}

	public void setEraikuntza(String eraikuntza) {
		this.eraikuntza = eraikuntza;
	}

	public String getDepartIzena() {
		return DepartIzena;
	}

	public void setDepartIzena(String departIzena) {
		DepartIzena = departIzena;
	}

}
