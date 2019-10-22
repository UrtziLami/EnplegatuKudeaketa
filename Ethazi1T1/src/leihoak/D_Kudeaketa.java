package leihoak;

import javax.swing.JPanel;
import java.awt.Button;
import javax.swing.JButton;

public class D_Kudeaketa extends JPanel {

	/**
	 * Create the panel.
	 */
	public D_Kudeaketa() {
		setLayout(null);
		
		JButton btnNewButton = new JButton("Departamentua Erregistratu");
		btnNewButton.setBounds(98, 93, 294, 41);
		add(btnNewButton);
		
		JButton btnDepartamentuakBilatu = new JButton("Departamentuak Bilatu");
		btnDepartamentuakBilatu.setBounds(98, 201, 294, 41);
		add(btnDepartamentuakBilatu);

	}
}
