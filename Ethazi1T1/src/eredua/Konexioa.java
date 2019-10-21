package eredua;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Konexioa {
	private String maquina = "localhost";
	private String usuario = "root";
	private String clave = "";
	private int puerto = 3306;
	private static Konexioa konexio = null;
	private Connection kon;

	// KONSTRUCTOREA
	// datu basearen izena jasotzen du
	private Konexioa(String datuBasea) {

		// driverra erregistratu
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.err.println("ERROR AL REGISTRAR EL DRIVER");// mensage error
			System.exit(0); // parar la ejecución
		}

		try {
			kon = DriverManager.getConnection("jdbc:mysql://" + this.maquina, this.usuario, this.clave);
		} catch (SQLException e) {
			System.err.println("ERROR AL CONECTAR CON EL SERVIDOR");
			System.exit(0); // parar la ejecución
		}
		System.out.println("Conectado a " + datuBasea);
	}

	// singelton konexioa
	public static Konexioa getKonexioa(String datuBasea) {
		if (konexio == null) {
			konexio = new Konexioa(datuBasea);
		} else {
			System.out.println(
					"No se puede crear el objeto " + datuBasea + " porque ya existe un objeto de la clase SoyUnico");
		}

		return konexio;

	}

}
