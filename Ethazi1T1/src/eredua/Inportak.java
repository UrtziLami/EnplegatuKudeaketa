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
		Connection konexioa = Konexioa.getKonexioa("EnpKude");
		try {
			PreparedStatement st = konexioa.prepareStatement(
					"INSERT INTO `enplegatu` (`IzenAbizena`, `DepartKod`, `Soldata`, `Ardura`, `AltaData`, `ZuzendariKod`, `Maila`)"
							+ " VALUES(?, ?, ?, ?, ?, ?, ?)");
			st.setString(1, enp.getIzenAbizena());
			st.setInt(2, enp.getDepartKod());
			st.setInt(3, enp.getSoldata());
			st.setString(4, enp.getArdura());
			st.setDate(5, enp.getAltaData());
			st.setInt(6, enp.getZuzendariKod());
			st.setString(7, enp.getMaila());
			st.executeUpdate();
			st.close();
			System.out.println("Gehitu da enplegatua");
		} catch (SQLException e) {
			System.out.println("Ez da gehitu enplegatua");
		}
	}
	
	public static void erregistratuDepartamentuak(Departamentu dept) {
		Connection konexioa = Konexioa.getKonexioa("EnpKude");
		try {
			PreparedStatement st = konexioa.prepareStatement(
					"INSERT INTO `departamentu` (`DepartIzena`, `Eraikuntza`)"
							+ " VALUES(?, ?)");
			st.setString(1, dept.getDepartIzena());
			st.setString(2, dept.getEraikuntza());
			st.executeUpdate();
			st.close();
			System.out.println("Gehitu da departamentua");
		} catch (SQLException e) {
			System.out.println("Ez da gehitu departamentua");
		}
	}

}
