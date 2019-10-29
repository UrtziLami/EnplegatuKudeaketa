package leihoak;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import kontroladorea.*;

public class D_Bilatu extends JPanel {
	private JTable taula = new JTable();
	private JTextField txtFIzena = new JTextField();
	private JTextField txtFKokapena = new JTextField();
	
	private JButton btnLehena = new JButton("<<");
	private JButton btnAtzera = new JButton("<");
	private JButton btnHurrengoa = new JButton(">");
	private JButton btnAzkena = new JButton(">>");
	private JButton btnGehitu = new JButton("Gehitu");
	private JButton btnAldatu = new JButton("Aldatu");
	private JButton btnKendu = new JButton("Kendu");
	private JButton btnAtzeraa = new JButton("Atzera");
	
	private JLabel lblIzena = new JLabel("Izena:");
	private JLabel lblKokapena = new JLabel("Kokapena:");
	
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
		 
		taula.setBounds(30, 123, 446, 214);
		add(taula);
		
		lblIzena.setBounds(52, 31, 46, 14);
		add(lblIzena);
		
		txtFIzena.setBounds(125, 28, 170, 20);
		add(txtFIzena);
		txtFIzena.setColumns(10);
		
		lblKokapena.setBounds(52, 78, 67, 14);
		add(lblKokapena);
		
		txtFKokapena.setBounds(125, 75, 170, 20);
		add(txtFKokapena);
		txtFKokapena.setColumns(10);
		
		btnGehitu.setBounds(361, 11, 89, 23);
		add(btnGehitu);
		
		btnAldatu.setBounds(361, 79, 89, 23);
		add(btnAldatu);
		
		btnKendu.setBounds(361, 45, 89, 23);
		add(btnKendu);
		
		btnAtzeraa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Kontroladorea.aldatuLeihoDepKudeatu();
			}
		});
		btnAtzeraa.setBounds(214, 403, 89, 23);
		add(btnAtzeraa);


	}
}
