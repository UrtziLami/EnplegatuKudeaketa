package eredua;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import kontroladorea.Nagusia;

public class Konexioa {
	private String maquina = "localhost";
	private String usuario = "root";
	private String clave = "";
	private int puerto = 3306;
	private String  serbitzaria    = "";
	private static Konexioa konexio = null;
	private static Connection kon;

	// KONSTRUKTOREA
	// datu basearen izena jasotzen du
	private Konexioa(String datuBasea) {
		this.serbitzaria="jdbc:mariadb://"+this.maquina+":"+
                this.puerto+"/"+datuBasea;

		// driverra erregistratu
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, "ERROREA DIRVERRA ERREGISTRATZERAKOAN" );
			Nagusia.LOGGER.severe("ERROREA DIRVERRA ERREGISTRATZERAKOAN");// mensaje error
			System.exit(0); // parar la ejecución
		}

		try {
			kon = DriverManager.getConnection(this.serbitzaria, this.usuario, this.clave);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "ERROREA SERBITZARIRA KONEKTATZERAKOAN" );
			Nagusia.LOGGER.severe("ERROREA SERBITZARIRA KONEKTATZERAKOAN");
			System.exit(0); // parar la ejecución
		}
		System.out.println("Conectado a " + datuBasea);
	}

	// singelton konexioa
	public static Connection getKonexioa(String datuBasea) {
		if (kon == null) {
			konexio = new Konexioa(datuBasea);
		} else {
			System.out.println(
					"ezin izan da " + datuBasea + " objetua sortu lehendik existitzen delako ");
		}
		return kon;
	}
	public static void  konexioaItzi() {
		try {
			kon.close();
			kon=null;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "ERROREA SERBITZARIRA DESKONEKTATZERAKOAN" );
			Nagusia.LOGGER.severe("ERROREA SERBITZARIRA DESKONEKTATZERAKOAN");

		}
		
		
	}

}
