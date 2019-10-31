package eredua;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Ezabaketak {
	
	public static void ezabatuDepartamentua(int deptKod) {
		Connection konexioa = Konexioa.getKonexioa("enpkude");
		try {
			PreparedStatement st = konexioa.prepareStatement(
					"DELETE * FROM `departamentu` WHERE `DepartamentuKod` = " + deptKod);
			st.executeUpdate();
			st.close();
			System.out.println("Ezabatu da departamentua");
			konexioa.close();
		} catch (SQLException e) {
			System.out.println("Ez da ezabatu departamentua");
		}
	}
	
	public static void ezabatuEnplegatua(int enpKod) {
		Connection konexioa = Konexioa.getKonexioa("enpkude");
		try {
			PreparedStatement st = konexioa.prepareStatement(
					"DELETE * FROM `enplegatu` WHERE `EnplegatuKod` = " + enpKod);
			st.executeUpdate();
			st.close();
			System.out.println("Ezabatu da enplegatua");
			konexioa.close();
		} catch (SQLException e) {
			System.out.println("Ez da ezabatu enplegatua");
		}
	}

}
