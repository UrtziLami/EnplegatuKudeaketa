package eredua;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import kontroladorea.Nagusia;

public class Ezabaketak {
	
	public static void ezabatuDepartamentua(int deptKod) {
		Connection konexioa = Konexioa.getKonexioa("enpkude");
		try {
			PreparedStatement st = konexioa.prepareStatement(
					"DELETE FROM `departamentu` WHERE `DepartamentuKod`= " + deptKod);
			st.executeUpdate();
			st.close();
			System.out.println("Ezabatu da departamentua");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "EZ DA EZABATU DEPARTAMENTUA" );
			Nagusia.LOGGER.severe("EZ DA EZABATU DEPARTAMENTUA");
			System.out.println("Ez da ezabatu departamentua");
		}
	}
	
	public static void ezabatuEnplegatua(int enpKod) {
		Connection konexioa = Konexioa.getKonexioa("enpkude");
		try {
			PreparedStatement st = konexioa.prepareStatement(
					"DELETE  FROM `enplegatu` WHERE `EnplegatuKod` = " + enpKod);
			st.executeUpdate();
			st.close();
			System.out.println("Ezabatu da enplegatua");
		
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "EZ DA EZABATU ENPLEGATUA" );
			Nagusia.LOGGER.severe("EZ DA EZABATU ENPLEGATUA");
			System.out.println("Ez da ezabatu enplegatua");
		}
	}

}
