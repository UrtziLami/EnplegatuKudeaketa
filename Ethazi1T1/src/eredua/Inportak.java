package eredua;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import kontroladorea.Nagusia;

public class Inportak {

	public static void erregistratuEnplegatuak(Enplegatu enp) {
		SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date(System.currentTimeMillis());
		System.out.println();
		Connection konexioa = Konexioa.getKonexioa("enpkude");
		try {
			PreparedStatement st = konexioa.prepareStatement(
					"INSERT INTO `enplegatu` (`IzenAbizena`, `DepartKod`, `Soldata`, `Ardura`, `AltaData`, `ZuzendariKod`, `Maila`) VALUES(?,?,?,?,?,?,?)");
			st.setString(1, enp.getIzenAbizena());
			st.setInt(2, enp.getDepartKod());
			st.setInt(3, enp.getSoldata());
			st.setString(4, enp.getArdura());
			st.setString(5, formatter.format(date));
			st.setInt(6, enp.getZuzendariKod());
			st.setString(7, enp.getMaila());
			st.executeUpdate();
			st.close();
			System.out.println("Gehitu da enplegatua");
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "EZ DA GEHITU ENPLEGATUA" );
			Nagusia.LOGGER.severe("EZ DA GEHITU ENPLEGATUA");
			System.out.println("Ez da gehitu enplegatua");
		}
	}
	
	public static void erregistratuDepartamentuak(Departamentu dept) {
		Connection konexioa = Konexioa.getKonexioa("enpkude");
		try {
			PreparedStatement st = konexioa.prepareStatement(
					"INSERT INTO `departamentu`( `DepartIzena`, `Kokapena`) VALUES (?,?)");
			st.setString(1, dept.getDepartIzena());
			st.setString(2, dept.getEraikuntza());
			st.executeUpdate();
			st.close();
			System.out.println("Gehitu da departamentua");
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "EZ DA GEHITU DEPARTAMENTUA" );
			Nagusia.LOGGER.severe("EZ DA GEHITU DEPARTAMENTUA");
			System.out.println("Ez da gehitu departamentua");
		}
		
	}

}
