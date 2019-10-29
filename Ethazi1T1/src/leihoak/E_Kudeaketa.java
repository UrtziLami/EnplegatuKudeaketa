package leihoak;

import javax.swing.JPanel;
import javax.swing.JTable;

import kontroladorea.Kontroladorea;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class E_Kudeaketa extends JPanel {
	private JTable table;
	
	JButton btnGehitu = new JButton("Gehitu");
	JButton btnKendu = new JButton("Kendu");
	JButton btnAldatu = new JButton("Aldatu");
	JButton btnLehenengoa = new JButton("<<");
	JButton btnAztera = new JButton("<");
	JButton btnHurrengoa = new JButton(">");
	JButton btnNewButton = new JButton(">>");
	JButton btnAtzera = new JButton("Atzera");

	public E_Kudeaketa() {
		setLayout(null);
		setBounds(150, 150, 520, 490);
		
		table = new JTable();
		table.setBounds(52, 65, 392, 235);
		add(table);
		
		btnGehitu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				E_Eremuak emp = new E_Eremuak();
				Leihoak.aldatuLeihoa(emp);
			}
		});
		btnGehitu.setBounds(52, 27, 89, 23);
		add(btnGehitu);
		
		btnKendu.setBounds(208, 27, 89, 23);
		add(btnKendu);
		
		btnAldatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				E_Eremuak emp = new E_Eremuak();
				Leihoak.aldatuLeihoa(emp);
			}
		});
		btnAldatu.setBounds(355, 27, 89, 23);
		add(btnAldatu);
		
		btnLehenengoa.setBounds(23, 342, 89, 23);
		add(btnLehenengoa);
		
		btnHurrengoa.setBounds(273, 342, 89, 23);
		add(btnHurrengoa);
		
		btnAztera.setBounds(144, 342, 89, 23);
		add(btnAztera);
		
		btnNewButton.setBounds(394, 342, 89, 23);
		add(btnNewButton);
		
		btnAtzera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Kontroladorea kont = new Kontroladorea();
				kont.aldatuLeihoEnpErregistratu();
			}
		});
		btnAtzera.setBounds(214, 403, 89, 23);
		add(btnAtzera);

	}
}
