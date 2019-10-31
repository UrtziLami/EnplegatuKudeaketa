package eredua;

import java.sql.Date;

public class Enplegatu {

	private int enpKod, departKod, soldata, zuzendariKod;
	private String IzenAbizena, ardura, maila, AltaData;
	
	public Enplegatu(int enpKod, int departKod, int soldata, int zuzendariKod, String izenAbizena, String ardura,
			String maila, String altaData) {
		this.enpKod = enpKod;
		this.departKod = departKod;
		this.soldata = soldata;
		this.zuzendariKod = zuzendariKod;
		IzenAbizena = izenAbizena;
		this.ardura = ardura;
		this.maila = maila;
		AltaData = altaData;
	}

	public Enplegatu() {
	}

	public int getZuzendariKod() {
		return zuzendariKod;
	}

	public void setZuzendariKod(int zuzendariKod) {
		this.zuzendariKod = zuzendariKod;
	}

	public String getMaila() {
		return maila;
	}

	public void setMaila(String maila) {
		this.maila = maila;
	}

	public int getEnpKod() {
		return enpKod;
	}

	public void setEnpKod(int enpKod) {
		this.enpKod = enpKod;
	}

	public int getDepartKod() {
		return departKod;
	}

	public void setDepartKod(int departKod) {
		this.departKod = departKod;
	}

	public int getSoldata() {
		return soldata;
	}

	public void setSoldata(int soldata) {
		this.soldata = soldata;
	}

	public String getIzenAbizena() {
		return IzenAbizena;
	}

	public void setIzenAbizena(String izenAbizena) {
		IzenAbizena = izenAbizena;
	}

	public String getArdura() {
		return ardura;
	}

	public void setArdura(String ardura) {
		this.ardura = ardura;
	}

	public String getAltaData() {
		return AltaData;
	}

	public void setAltaData(String altaData) {
		AltaData = altaData;
	}

}
