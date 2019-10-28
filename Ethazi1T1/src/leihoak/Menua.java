package leihoak;

import javax.swing.JPanel;
import javax.swing.JButton;

public class Menua extends JPanel {

	/**
	 * Create the panel.
	 */
	public Menua() {
		setLayout(null);
		
		JButton btnDepartamentuenKudeaketa = new JButton("Departamentuen Kudeaketa");
		btnDepartamentuenKudeaketa.setBounds(100, 66, 312, 61);
		add(btnDepartamentuenKudeaketa);
		
		JButton btnEnplegatuenKudeaketa = new JButton("Enplegatuen Kudeaketa");
		btnEnplegatuenKudeaketa.setBounds(100, 176, 312, 61);
		add(btnEnplegatuenKudeaketa);
		
		JButton btnTxostenakSortu = new JButton("Txostenak Sortu");
		btnTxostenakSortu.setBounds(100, 293, 312, 61);
		add(btnTxostenakSortu);

	}

}
