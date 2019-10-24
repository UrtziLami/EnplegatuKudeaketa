package leihoak;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class E_Eremuak extends JPanel {
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public E_Eremuak() {
		setLayout(null);
		
		JLabel lblIzenAbizenak = new JLabel("Izen Abizenak:");
		lblIzenAbizenak.setBounds(67, 51, 88, 14);
		add(lblIzenAbizenak);
		
		JLabel lblDepartamentua = new JLabel("Departamentua:");
		lblDepartamentua.setBounds(67, 114, 88, 14);
		add(lblDepartamentua);
		
		JLabel lblSoldata = new JLabel("Soldata:");
		lblSoldata.setBounds(67, 172, 46, 14);
		add(lblSoldata);
		
		JLabel lblNewLabel = new JLabel("Ardura:");
		lblNewLabel.setBounds(67, 231, 46, 14);
		add(lblNewLabel);
		
		JLabel lblMaila = new JLabel("Maila:");
		lblMaila.setBounds(67, 296, 46, 14);
		add(lblMaila);
		
		textField = new JTextField();
		textField.setBounds(177, 48, 218, 20);
		add(textField);
		textField.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(177, 111, 109, 20);
		add(comboBox);
		
		textField_1 = new JTextField();
		textField_1.setBounds(177, 169, 218, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(177, 228, 109, 20);
		add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(177, 293, 109, 20);
		add(comboBox_2);

	}
}
