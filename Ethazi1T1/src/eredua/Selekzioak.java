package eredua;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * 
 * @author Aitor datu basetik selekzioak egiteko
 */
public class Selekzioak {

	public static ArrayList<Departamentu> ateraDepart() {
		Statement st = null;
		Connection konexioa = Konexioa.getKonexioa("enpkude");
		ArrayList<Departamentu> deptArray = new ArrayList<Departamentu>();
		String izena, eraikuntza;
		int deptKod;

		try {
			st = konexioa.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM `departamentu`");
			while (rs.next()) {
				deptKod = (rs.getInt("DepartamentuKod"));
				izena = (rs.getString("DepartIzena"));
				eraikuntza = (rs.getString("Eraikuntza"));
				Departamentu dept = new Departamentu(deptKod, izena, eraikuntza);
				deptArray.add(dept);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return deptArray;
	}

	public static ArrayList<Enplegatu> ateraEnple() {
		Statement st = null;
		Connection konexioa = Konexioa.getKonexioa("enpkude");
		ArrayList<Enplegatu> enpArray = new ArrayList<Enplegatu>();
		String izena, ardura, maila, altaData;
		int enpKod, deptKod, soldata, zuzendariKod;

		try {
			st = konexioa.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM `enplegatu`");
			while (rs.next()) {
				enpKod = (rs.getInt("EnplegatuKod"));
				izena = (rs.getString("IzenAbizena"));
				deptKod = (rs.getInt("DepartKod"));
				soldata = (rs.getInt("Soldata"));
				ardura = (rs.getString("Ardura"));
				altaData = (rs.getString("AltaData"));
				zuzendariKod = (rs.getInt("ZuzendariKod"));
				maila = (rs.getString("Maila"));
				Enplegatu enp = new Enplegatu(enpKod, deptKod, soldata, zuzendariKod, altaData, izena, ardura, maila);
				enpArray.add(enp);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return enpArray;
	}
	
}
