package eredua;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import kontroladorea.Nagusia;

public class Aldaketak {

	public static void enplegatuAldatu(Enplegatu enp) {
		Connection konexioa = Konexioa.getKonexioa("enpkude");
		try {
			PreparedStatement st = konexioa.prepareStatement(
					"UPDATE `enplegatu` SET `IzenAbizena` = ?, `DepartKod` = ?, `Soldata` = ?, `Ardura` = ?, `ZuzendariKod` = ?, `Maila` = ? WHERE `enplegatu`.`EnplegatuKod` = ?");
			st.setString(1, enp.getIzenAbizena());
			st.setInt(2, enp.getDepartKod());
			st.setInt(3, enp.getSoldata());
			st.setString(4, enp.getArdura());
			st.setInt(5, enp.getZuzendariKod());
			st.setString(6, enp.getMaila());
			st.setInt(7, enp.getEnpKod());

			st.executeUpdate();
			st.close();
			System.out.println("Aldatu da enplegatua");
		} catch (SQLException e) {
			Nagusia.LOGGER.severe("EZ DA ALDATU ENPLEGATUA");
			System.out.println("Ez da aldatu enplegatua");
			JOptionPane.showMessageDialog(null, "EZ DA ALDATU ENPLEGATUA" );
		}
	}

	public static void departamentuAldatu(Departamentu dept) {
		Connection konexioa = Konexioa.getKonexioa("enpkude");
		try {
			PreparedStatement st = konexioa.prepareStatement(
					"UPDATE `departamentu` SET `DepartIzena`= ? ,`Eraikuntza`=? WHERE `DepartamentuKod`= ? ");
			st.setString(1, dept.getDepartIzena());
			st.setString(2, dept.getEraikuntza());
			st.setInt(3, dept.getDepartKod());

			st.executeUpdate();
			st.close();
			System.out.println("Aldatu da departamentua");
		} catch (SQLException e) {
			Nagusia.LOGGER.severe("EZ DA ALDATU DEPARTAMENTUA");
			JOptionPane.showMessageDialog(null, "EZ DA ALDATU DEPARTAMENTUA" );
			System.out.println("Ez da aldatu departamentua");
		}
	}

}
