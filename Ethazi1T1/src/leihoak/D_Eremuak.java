package leihoak;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class D_Eremuak extends JPanel {
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public D_Eremuak() {
		setLayout(null);
		
		JLabel lblIzena = new JLabel("Izena:");
		lblIzena.setBounds(115, 123, 46, 14);
		add(lblIzena);
		
		JLabel lblKokapena = new JLabel("Kokapena:");
		lblKokapena.setBounds(115, 201, 71, 14);
		add(lblKokapena);
		
		textField = new JTextField();
		textField.setBounds(194, 120, 195, 20);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(196, 198, 195, 20);
		add(textField_1);

	}
}
