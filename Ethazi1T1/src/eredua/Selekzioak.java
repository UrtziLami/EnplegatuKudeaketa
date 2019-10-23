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
	
	public static ArrayList<String> ateraDepart(Departamentu dept) {
		Statement st = null;
		Connection konexioa = Konexioa.getKonexioa("EnpKude");

		ArrayList<String> zerbitzuArray = new ArrayList<String>();

		String izena;

		try {
			st = konexioa.createStatement();
			ResultSet rs = st.executeQuery(
					"SELECT zg.izena FROM zerbitzugehigarriak_ostatu zgo, zerbitzugehigarriak zg WHERE zgo.ostatu_ostatu_id ="
							+ "hartutakoOstatua.getOstatuKod()"
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
	
	

	
}
