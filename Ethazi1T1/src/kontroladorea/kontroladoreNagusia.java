package kontroladorea;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import leihoak.Leihoak;

public class kontroladoreNagusia implements ActionListener, MouseListener {

	private Leihoak view;

	private Leihoak leihoak;

	// CONSTRUCTOR
	kontroladoreNagusia(Leihoak view) {
		this.leihoak = view;
		cargarTabla();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// Objeto para ejecutar los procedimientos almacenados
		// en la base de datos
		CallableStatement cs;

		// COMANDO EJECTUADO
		String comando = arg0.getActionCommand();

		// Deberá coincidir con alguno de los parámetros
		// indicados en setActionCommand invocado en la
		// clase View
		switch (comando) {
		case "INSERTAR":

			break;

		case "BORRAR":

			break;

		case "MODIFICAR":

			break;

		default:

			break;
		}
		// limpiar el formulario
		limpia();

		// refrescar la tabla
		cargarTabla();
	}

	private void limpia() {
	}

	// Método que recarga los datos de la tabla de la base de datos
	// en la tabla de la clase View
	protected void cargarTabla() {

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
	}
}
