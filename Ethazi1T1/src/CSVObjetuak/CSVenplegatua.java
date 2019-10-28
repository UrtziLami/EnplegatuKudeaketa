package CSVObjetuak;
import java.sql.Date;

import com.opencsv.bean.CsvBindByName;

public class CSVenplegatua {
	 	@CsvBindByName(column = "IzenAbizena")
	    private String IzenAbizena;
	    @CsvBindByName(column = "soldata")
	    private int soldata;
	    @CsvBindByName(column = "AltaData")
	    private Date AltaData;
	    @CsvBindByName(column = "ardura")
	    private String ardura;
	    @CsvBindByName(column = "maila")
	    private String maila;
	    @CsvBindByName(column = "departKod")
	    private int departKod; 
	    @CsvBindByName(column = "zuzendariKod")
	    private String zuzendariKod;
	    
	    /******Getters and Setters*******/
		public String getIzenAbizena() {
			return IzenAbizena;
		}
		public int getSoldata() {
			return soldata;
		}
		public Date getAltaData() {
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
		public void setAltaData(Date altaData) {
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
