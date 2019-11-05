package leihoak;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import kontroladorea.Kontroladorea;

public class E_Kudeaketa extends JPanel {
	private JTable taula;
	private TableColumnModel columnModel;

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
	private Object[][] datuak;

	public E_Kudeaketa() {
		setLayout(null);
		setBounds(150, 150, 650, 490);
		taula = new JTable();
		taula.setBounds(52, 65, 392, 235);

		scrollPane = new JScrollPane(taula);
		scrollPane.setViewportBorder(null);
		scrollPane.setBounds(23, 65, 605, 235);
		add(scrollPane);
		taularenBaliokKalkulatu();
		btnGehitu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				E_Eremuak emp = new E_Eremuak();
				Leihoak.aldatuLeihoa(emp);
			}
		});
		btnGehitu.setBounds(52, 27, 89, 23);
		add(btnGehitu);
		
		btnKendu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int ezabatuEnpleKod= (int)datuak[taula.getSelectedRow()][0];
				System.out.println(ezabatuEnpleKod);
				Kontroladorea.ezabatuEnplegatua(ezabatuEnpleKod);
				taularenBaliokKalkulatu();
			}
		});

		btnKendu.setBounds(281, 27, 89, 23);
		add(btnKendu);

		btnAldatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				E_Eremuak emp = new E_Eremuak();
				Leihoak.aldatuLeihoa(emp);
			}
		});
		btnAldatu.setBounds(500, 27, 89, 23);
		add(btnAldatu);

		btnLehenengoa.setBounds(52, 342, 89, 23);
		add(btnLehenengoa);

		btnHurrengoa.setBounds(355, 342, 89, 23);
		add(btnHurrengoa);

		btnAztera.setBounds(196, 342, 89, 23);
		add(btnAztera);

		btnNewButton.setBounds(514, 342, 89, 23);
		add(btnNewButton);

		btnAtzera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aldatuLeihoMenua();
			}
		});
		btnAtzera.setBounds(281, 402, 89, 23);
		add(btnAtzera);

	}

	private void taularenBaliokKalkulatu() {
		Object[][] datuak = Kontroladorea.lortuEnplegatuenDatuak();
		String[] taulaBurua = new String[] { "ID", "Izen Abizena", "Departamentua", "Soldata", "Ardura", "AltaData",
				"ZuzendariKodea", "Maila" };
		modelo = new DefaultTableModel(datuak, taulaBurua);
		taula.setModel(modelo);
		columnModel = taula.getColumnModel();
		columnModel.getColumn(0).setPreferredWidth(25);
		columnModel.getColumn(1).setPreferredWidth(150);
	}

	private void aldatuLeihoMenua() {
		Menua men = new Menua();
		Leihoak.aldatuLeihoa(men);
	}
}
