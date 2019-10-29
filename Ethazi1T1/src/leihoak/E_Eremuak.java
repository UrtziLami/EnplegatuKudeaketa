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
	
	private JButton btnAtzera = new JButton("Atzera");
	private JButton btnGehitu = new JButton("Gehitu");
	
	private JLabel lblIzenAbizenak = new JLabel("Izen Abizenak:");
	private JLabel lblDepartamentua = new JLabel("Departamentua:");
	private JLabel lblSoldata = new JLabel("Soldata:");
	private JLabel lblArdura = new JLabel("Ardura:");
	private JLabel lblMaila = new JLabel("Maila:");
	
	private JComboBox cmbxDepartamentuak = new JComboBox();
	private JComboBox cmbxArdurak = new JComboBox();
	private JComboBox cmbxMailak = new JComboBox();
	
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
				Kontroladorea.aldatuLeihoEnpKudeaketa();
			}
		});
		btnAtzera.setBounds(214, 403, 89, 23);
		add(btnAtzera);
		
		btnGehitu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnGehitu.setBounds(214, 352, 89, 23);
		add(btnGehitu);

	}
}
