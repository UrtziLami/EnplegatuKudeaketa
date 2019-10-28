package leihoak;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JButton;

public class E_Kudeaketa extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public E_Kudeaketa() {
		setLayout(null);
		
		table = new JTable();
		table.setBounds(52, 65, 392, 235);
		add(table);
		
		JButton btnGehitu = new JButton("Gehitu");
		btnGehitu.setBounds(52, 27, 89, 23);
		add(btnGehitu);
		
		JButton btnKendu = new JButton("Kendu");
		btnKendu.setBounds(208, 27, 89, 23);
		add(btnKendu);
		
		JButton btnAldatu = new JButton("Aldatu");
		btnAldatu.setBounds(355, 27, 89, 23);
		add(btnAldatu);
		
		JButton btnLehenengoa = new JButton("Lehena");
		btnLehenengoa.setBounds(23, 342, 89, 23);
		add(btnLehenengoa);
		
		JButton btnHurrengoa = new JButton("Hurrengoa");
		btnHurrengoa.setBounds(273, 342, 89, 23);
		add(btnHurrengoa);
		
		JButton btnAztera = new JButton("Atzera");
		btnAztera.setBounds(144, 342, 89, 23);
		add(btnAztera);
		
		JButton btnNewButton = new JButton("Azkena");
		btnNewButton.setBounds(394, 342, 89, 23);
		add(btnNewButton);

	}
}
