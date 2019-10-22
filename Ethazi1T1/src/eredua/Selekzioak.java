package eredua;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
/**
 * 
 * @author Aitor
 * datu basetik selekzioak egiteko
 */
public class Selekzioak {
	
	public static ArrayList<String> filtroZerbitzuGehigarri(Ostatua hartutakoOstatua) {
		Statement st = null;
		Connection konexioa = Konexioa.getKonexioa();

		ArrayList<String> zerbitzuArray = new ArrayList<String>();

		String izena;

		try {
			st = konexioa.createStatement();
			ResultSet rs = st.executeQuery(
					"SELECT zg.izena FROM zerbitzugehigarriak_ostatu zgo, zerbitzugehigarriak zg WHERE zgo.ostatu_ostatu_id ="
							+ hartutakoOstatua.getOstatuKod()
							+ " AND zg.kod_zerbitzuak=zgo.zerbitzuGehigarriak_kod_zerbitzuak");

			while (rs.next()) {
				izena = (rs.getString("izena"));
				zerbitzuArray.add(izena);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return zerbitzuArray;
	}
	
	public static void erregistratuBezeroak(String pasahitza, String NAN, String izena, String abizenak,
			String jaioData) {
		//ArrayList<Bezeroa> arrayBezeroak = new ArrayList<Bezeroa>();
		Connection konexioa = Konexioa.getKonexioa();
		try {
			PreparedStatement st = konexioa
					.prepareStatement("INSERT INTO `pertsona` (`nan`, `izena`, `abizenak`, `jaiotze_data`, `pasahitza`)"
							+ " VALUES(?, ?, ?, ?, ?)");
			st.setString(1, NAN);
			st.setString(2, izena);
			st.setString(3, abizenak);
			st.setString(4, jaioData);
			st.setString(5, pasahitza);
			st.executeUpdate();
			st.close();
			System.out.println("Gehitu da pertsona");
		} catch (SQLException e) {
			System.out.println("Ez da gehitu pertsona");
		}

		try {
			PreparedStatement st = konexioa.prepareStatement("INSERT INTO `bezeroa` (`nan`)" + " VALUES(?)");
			st.setString(1, NAN);
			st.executeUpdate();
			st.close();
			System.out.println("Gehitu da bezeroa");
		} catch (SQLException e) {
			System.out.println("Ez da gehitu bezeroa");
		}

		//arrayBezeroak = bezeroDatuak();
		//return arrayBezeroak;
	}

	
}
