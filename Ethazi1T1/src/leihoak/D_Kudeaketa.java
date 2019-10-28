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
		
		JButton btnNewButton = new JButton("Departamentuak Erregistratu");
		btnNewButton.setBounds(79, 82, 343, 64);
		add(btnNewButton);
		
		JButton btnDepartamentuakBilatu = new JButton("Departamentuak Bilatu");
		btnDepartamentuakBilatu.setBounds(79, 209, 343, 64);
		add(btnDepartamentuakBilatu);

	}
}
