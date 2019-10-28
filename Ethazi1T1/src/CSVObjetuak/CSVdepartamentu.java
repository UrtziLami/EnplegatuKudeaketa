package CSVObjetuak;
import com.opencsv.bean.CsvBindByName;
public class CSVdepartamentu {
	@CsvBindByName(column = "eraikuntza")
    private String eraikuntza;
    @CsvBindByName(column = "DepartIzena")
    private String DepartIzena;
    
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
    
}
