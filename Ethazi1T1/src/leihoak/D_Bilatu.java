package leihoak;

import javax.swing.JPanel;
import java.awt.TextArea;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class D_Bilatu extends JPanel {
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public D_Bilatu() {
		setLayout(null);
		
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
		
		table = new JTable();
		table.setBounds(30, 123, 446, 214);
		add(table);
		
		JLabel lblIzena = new JLabel("Izena:");
		lblIzena.setBounds(52, 31, 46, 14);
		add(lblIzena);
		
		textField = new JTextField();
		textField.setBounds(125, 28, 170, 20);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblKokapena = new JLabel("Kokapena:");
		lblKokapena.setBounds(52, 78, 56, 14);
		add(lblKokapena);
		
		textField_1 = new JTextField();
		textField_1.setBounds(125, 75, 170, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnGehitu = new JButton("Gehitu");
		btnGehitu.setBounds(361, 11, 89, 23);
		add(btnGehitu);
		
		JButton btnAldatu = new JButton("Aldatu");
		btnAldatu.setBounds(361, 79, 89, 23);
		add(btnAldatu);
		
		JButton btnKendu = new JButton("Kendu");
		btnKendu.setBounds(361, 45, 89, 23);
		add(btnKendu);

	}
}
