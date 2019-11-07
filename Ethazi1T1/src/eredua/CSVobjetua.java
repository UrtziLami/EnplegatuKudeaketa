package eredua;
import java.sql.Date;

import com.opencsv.bean.CsvBindByName;

public class CSVobjetua {
	 	@CsvBindByName(column = "IzenAbizena")
	    private String IzenAbizena;
	    @CsvBindByName(column = "soldata")
	    private int soldata;
	    @CsvBindByName(column = "AltaData")
	    private String AltaData;
	    @CsvBindByName(column = "ardura")
	    private String ardura;
	    @CsvBindByName(column = "maila")
	    private String maila;
	    @CsvBindByName(column = "departKod")
	    private int departKod; 
	    @CsvBindByName(column = "zuzendariKod")
	    private String zuzendariKod;
	    @CsvBindByName(column = "eraikuntza")
	    private String eraikuntza;
	    @CsvBindByName(column = "DepartIzena")
	    private String DepartIzena;
	    
		
	    /******Getters and Setters*******/
	    public String getEraikuntza() {
			return eraikuntza;
		}
		public String getDepartIzena() {
			return DepartIzena;
		}
		public void setEraikuntza(String eraikuntza) {
			this.eraikuntza = eraikuntza;
		}
		public void setDepartIzena(String departIzena) {
			DepartIzena = departIzena;
		}
	    /************************************/
		public String getIzenAbizena() {
			return IzenAbizena;
		}
		public int getSoldata() {
			return soldata;
		}
		public String getAltaData() {
			return AltaData;
		}
		public String getArdura() {
			return ardura;
		}
		public String getMaila() {
			return maila;
		}
		public int getDepartKod() {
			return departKod;
		}
		public String getZuzendariKod() {
			return zuzendariKod;
		}
		public void setIzenAbizena(String izenAbizena) {
			IzenAbizena = izenAbizena;
		}
		public void setSoldata(int soldata) {
			this.soldata = soldata;
		}
		public void setAltaData(String altaData) {
			AltaData = altaData;
		}
		public void setArdura(String ardura) {
			this.ardura = ardura;
		}
		public void setMaila(String maila) {
			this.maila = maila;
		}
		public void setDepartKod(int departKod) {
			this.departKod = departKod;
		}
		public void setZuzendariKod(String zuzendariKod) {
			this.zuzendariKod = zuzendariKod;
		} 
	    
	 
}
