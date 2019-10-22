package leihoak;

import javax.swing.JPanel;
import java.awt.TextArea;
import javax.swing.JButton;

public class D_Bilatu extends JPanel {

	/**
	 * Create the panel.
	 */
	public D_Bilatu() {
		setLayout(null);
		
		TextArea textArea = new TextArea();
		textArea.setBounds(30, 30, 445, 303);
		add(textArea);
		
		JButton btnAzkena = new JButton("Hasiera");
		btnAzkena.setBounds(30, 359, 89, 23);
		add(btnAzkena);
		
		JButton btnHurrengoa = new JButton("Hurrengoa");
		btnHurrengoa.setBounds(149, 359, 89, 23);
		add(btnHurrengoa);
		
		JButton btnAtzera = new JButton("Atzera");
		btnAtzera.setBounds(273, 359, 89, 23);
		add(btnAtzera);
		
		JButton btnAzkena_1 = new JButton("Azkena");
		btnAzkena_1.setBounds(386, 359, 89, 23);
		add(btnAzkena_1);

	}
}
