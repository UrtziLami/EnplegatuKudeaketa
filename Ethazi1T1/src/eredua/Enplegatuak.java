package eredua;

import java.sql.Date;

public class Enplegatuak {
	private int enpKod, departKod, soldata;
	private Date AltaData;
	private String IzenAbizena, ardura;

	public Enplegatuak(int enpKod, int departKod, int soldata, Date altaData, String izenAbizena, String ardura) {
		super();
		this.enpKod = enpKod;
		this.departKod = departKod;
		this.soldata = soldata;
		AltaData = altaData;
		IzenAbizena = izenAbizena;
		this.ardura = ardura;
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

	public Date getAltaData() {
		return AltaData;
	}

	public void setAltaData(Date altaData) {
		AltaData = altaData;
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

}
