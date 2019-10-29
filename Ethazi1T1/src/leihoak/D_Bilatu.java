package leihoak;

import javax.swing.JPanel;
import java.awt.TextArea;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import kontroladorea.*;

public class D_Bilatu extends JPanel {
	private JTable table = new JTable();
	private JTextField textField = new JTextField();
	private JTextField textField_1;
	
	JButton btnLehena = new JButton("<<");
	JButton btnAtzera = new JButton("<");
	JButton btnHurrengoa = new JButton(">");
	JButton btnAzkena = new JButton(">>");
	JButton btnGehitu = new JButton("Gehitu");
	JButton btnAldatu = new JButton("Aldatu");
	JButton btnKendu = new JButton("Kendu");
	JButton btnAtzeraa = new JButton("Atzera");
	
	JLabel lblIzena = new JLabel("Izena:");
	JLabel lblKokapena = new JLabel("Kokapena:");
	
	public D_Bilatu() {
		setLayout(null);
		setBounds(150, 150, 520, 488);
		
		btnLehena.setBounds(30, 359, 89, 23);
		add(btnLehena);
		
		btnAtzera.setBounds(149, 359, 89, 23);
		add(btnAtzera);
		
		btnHurrengoa.setBounds(273, 359, 89, 23);
		add(btnHurrengoa);
		
		btnAzkena.setBounds(386, 359, 89, 23);
		add(btnAzkena);
		 
		table.setBounds(30, 123, 446, 214);
		add(table);
		
		lblIzena.setBounds(52, 31, 46, 14);
		add(lblIzena);
		
		textField.setBounds(125, 28, 170, 20);
		add(textField);
		textField.setColumns(10);
		
		lblKokapena.setBounds(52, 78, 67, 14);
		add(lblKokapena);
		
		textField_1 = new JTextField();
		textField_1.setBounds(125, 75, 170, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		btnGehitu.setBounds(361, 11, 89, 23);
		add(btnGehitu);
		
		btnAldatu.setBounds(361, 79, 89, 23);
		add(btnAldatu);
		
		btnKendu.setBounds(361, 45, 89, 23);
		add(btnKendu);
		
		btnAtzeraa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Kontroladorea kont = new Kontroladorea();
				kont.aldatuLeihoDepKudeatu();
			}
		});
		btnAtzeraa.setBounds(214, 403, 89, 23);
		add(btnAtzeraa);


	}
}
