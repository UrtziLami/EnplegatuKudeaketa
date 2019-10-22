package leihoak;

import javax.swing.JPanel;
import javax.swing.JButton;

public class Txostenak extends JPanel {

	/**
	 * Create the panel.
	 */
	public Txostenak() {
		setLayout(null);
		
		JButton btnEnplegatuakInprimatu = new JButton("Enplegatuak Inprimatu");
		btnEnplegatuakInprimatu.setBounds(103, 107, 297, 47);
		add(btnEnplegatuakInprimatu);
		
		JButton btnDepartamentuakInprimatu = new JButton("Departamentuak Inprimatu");
		btnDepartamentuakInprimatu.setBounds(103, 225, 297, 47);
		add(btnDepartamentuakInprimatu);

	}
}
