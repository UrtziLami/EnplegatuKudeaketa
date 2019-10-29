package leihoak;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTextField;

import kontroladorea.Kontroladorea;

import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class E_Eremuak extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	
	JButton btnAtzera = new JButton("Atzera");
	
	JLabel lblIzenAbizenak = new JLabel("Izen Abizenak:");
	JLabel lblDepartamentua = new JLabel("Departamentua:");
	JLabel lblSoldata = new JLabel("Soldata:");
	JLabel lblArdura = new JLabel("Ardura:");
	JLabel lblMaila = new JLabel("Maila:");
	
	JComboBox cmbxDepartamentuak = new JComboBox();
	JComboBox cmbxArdurak = new JComboBox();
	JComboBox cmbxMailak = new JComboBox();
	
	public E_Eremuak() {
		setLayout(null);
		setBounds(150, 150, 520, 489);
		
		lblIzenAbizenak.setBounds(67, 51, 109, 14);
		add(lblIzenAbizenak);
		
		lblDepartamentua.setBounds(67, 114, 109, 14);
		add(lblDepartamentua);
		
		lblSoldata.setBounds(67, 172, 46, 14);
		add(lblSoldata);
		
		lblArdura.setBounds(67, 231, 46, 14);
		add(lblArdura);
		
		lblMaila.setBounds(67, 296, 46, 14);
		add(lblMaila);
		
		textField = new JTextField();
		textField.setBounds(177, 48, 218, 20);
		add(textField);
		textField.setColumns(10);
		
		cmbxDepartamentuak.setBounds(177, 111, 109, 20);
		add(cmbxDepartamentuak);
		
		textField_1 = new JTextField();
		textField_1.setBounds(177, 169, 218, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		cmbxArdurak.setBounds(177, 228, 109, 20);
		add(cmbxArdurak);
		
		cmbxMailak.setBounds(177, 293, 109, 20);
		add(cmbxMailak);
		
		btnAtzera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Kontroladorea kont = new Kontroladorea();
				kont.aldatuLeihoEnpKudeaketa();
			}
		});
		btnAtzera.setBounds(214, 403, 89, 23);
		add(btnAtzera);

	}
}
