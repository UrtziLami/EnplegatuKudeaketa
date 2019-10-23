package eredua;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;



public class Inportak {
	
	public static void erregistratuEnplegatuak(Enplegatu enp) {
		//ArrayList<Bezeroa> arrayBezeroak = new ArrayList<Bezeroa>();
		Connection konexioa = Konexioa.getKonexioa("EnpKude");
		try {
			PreparedStatement st = konexioa
					.prepareStatement("INSERT INTO `pertsona` (`nan`, `izena`, `abizenak`, `jaiotze_data`, `pasahitza`)"
							+ " VALUES(?, ?, ?, ?, ?)");
			st.setString(5, "");
			st.executeUpdate();
			st.close();
			System.out.println("Gehitu da pertsona");
		} catch (SQLException e) {
			System.out.println("Ez da gehitu pertsona");
		}

		//arrayBezeroak = bezeroDatuak();
		//return arrayBezeroak;
	}
	
	
 

}


