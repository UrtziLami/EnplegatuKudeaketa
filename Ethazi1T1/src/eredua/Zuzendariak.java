package eredua;

public class Zuzendariak {
	private int zuzenKod, enpleKod;
	private String maila;

	public Zuzendariak(int zuzenKod, int enpleKod, String maila) {
		super();
		this.zuzenKod = zuzenKod;
		this.enpleKod = enpleKod;
		this.maila = maila;
	}

	public int getZuzenKod() {
		return zuzenKod;
	}

	public void setZuzenKod(int zuzenKod) {
		this.zuzenKod = zuzenKod;
	}

	public int getEnpleKod() {
		return enpleKod;
	}

	public void setEnpleKod(int enpleKod) {
		this.enpleKod = enpleKod;
	}

	public String getMaila() {
		return maila;
	}

	public void setMaila(String maila) {
		this.maila = maila;
	}
}
