package leihoak;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menua extends JPanel {
	
	private JButton btnDepKudeaketa = new JButton("Departamentuen Kudeaketa");
	private JButton btnEnpKudeaketa = new JButton("Enplegatuen Kudeaketa");
	private JButton btnTxostenakSortu = new JButton("Txostenak Sortu");

	public Menua() {
		setLayout(null);
		setBounds(150, 150, 520, 490);
		
		btnDepKudeaketa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				D_Kudeaketa dep = new D_Kudeaketa();
				Leihoak.aldatuLeihoa(dep);
			}
		});
		btnDepKudeaketa.setBounds(100, 66, 312, 61);
		add(btnDepKudeaketa);
		
		btnEnpKudeaketa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				E_Erregistratu emp = new E_Erregistratu();
				Leihoak.aldatuLeihoa(emp);
			}
		});
		btnEnpKudeaketa.setBounds(100, 176, 312, 61);
		add(btnEnpKudeaketa);
		
		btnTxostenakSortu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Txostenak txos = new Txostenak();
				Leihoak.aldatuLeihoa(txos);
			}
		});
		btnTxostenakSortu.setBounds(100, 293, 312, 61);
		add(btnTxostenakSortu);

	}

}
