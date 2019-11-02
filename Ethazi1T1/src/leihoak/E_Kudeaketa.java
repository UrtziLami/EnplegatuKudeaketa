package leihoak;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import eredua.Enplegatu;
import kontroladorea.Kontroladorea;

public class E_Kudeaketa extends JPanel {
	private JTable taula;
	private DefaultTableModel modelo = new DefaultTableModel() {
		public boolean isCellEditable(int row, int column) {
			return false;
		}
	};
	private JScrollPane scrollPane;
	private JButton btnGehitu = new JButton("Gehitu");
	private JButton btnKendu = new JButton("Kendu");
	private JButton btnAldatu = new JButton("Aldatu");
	private JButton btnLehenengoa = new JButton("<<");
	private JButton btnAztera = new JButton("<");
	private JButton btnHurrengoa = new JButton(">");
	private JButton btnNewButton = new JButton(">>");
	private JButton btnAtzera = new JButton("Atzera");

	public E_Kudeaketa() {
		setLayout(null);
		setBounds(150, 150, 520, 490);
		taula = new JTable();
		taula.setBounds(52, 65, 392, 235);
		Object[][] datuak = Kontroladorea.lortuEnplegatuenDatuak();
	
		scrollPane = new JScrollPane(taula);
		scrollPane.setViewportBorder(null);
		scrollPane.setBounds(52, 65, 392, 235);
		add(scrollPane);
		String[] taulaBurua = new String[] { "ID", "Izen Abizena", "Departamentua", "soldata", "Ardura", "AltaData",
				"ZuzendariKodea", "Maila" };
		modelo = new DefaultTableModel(datuak, taulaBurua);
	

		
		
		
		taula.setModel(modelo);

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
				aldatuLeihoMenua();
			}
		});
		btnAtzera.setBounds(214, 403, 89, 23);
		add(btnAtzera);

	}

	private void aldatuLeihoMenua() {
		Menua men = new Menua();
		Leihoak.aldatuLeihoa(men);
	}
}
