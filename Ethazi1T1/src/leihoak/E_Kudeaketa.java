package leihoak;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import kontroladorea.Kontroladorea;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class E_Kudeaketa extends JPanel {
	private JTable taula;
	private TableColumnModel columnModel;

	private DefaultTableModel modelo = new DefaultTableModel() {

	};
	private JScrollPane scrollPane;
	private JButton btnGehitu = new JButton("Gehitu");
	private JButton btnKendu = new JButton("Kendu");
	private JButton btnAldatu = new JButton("Aldatu");
	private JButton btnAtzera = new JButton("Atzera");
	private Object[][] datuak, datufiltratuak;
	private JTextField textField;

	public E_Kudeaketa() {
		setLayout(null);
		setBounds(150, 150, 650, 490);
		taula = new JTable();
		taula.setBounds(52, 65, 392, 235);

		scrollPane = new JScrollPane(taula);
		scrollPane.setViewportBorder(null);
		scrollPane.setBounds(21, 116, 605, 306);
		add(scrollPane);
		
		btnGehitu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				E_Eremuak emp = new E_Eremuak();
				Leihoak.aldatuLeihoa(emp);
			}
		});
		btnGehitu.setBounds(52, 27, 89, 23);
		add(btnGehitu);
		btnKendu.setEnabled(false);

		btnKendu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println(datufiltratuak[taula.getSelectedRow()][0]);
				int ezabatuEnpleKod = (int) datufiltratuak[taula.getSelectedRow()][0];

				Kontroladorea.ezabatuEnplegatua(ezabatuEnpleKod);
				taularenBaliokKalkulatu();
			}
		});

		btnKendu.setBounds(281, 27, 89, 23);
		add(btnKendu);
		btnAldatu.setEnabled(false);

		btnAldatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = (int) datufiltratuak[taula.getSelectedRow()][0];
				String izena = (String) datufiltratuak[taula.getSelectedRow()][1];
				int soldata = (int) datufiltratuak[taula.getSelectedRow()][3];
				E_Eremuak emp = new E_Eremuak(id, izena, soldata);
				Leihoak.aldatuLeihoa(emp);
			}
		});
		btnAldatu.setBounds(500, 27, 89, 23);
		add(btnAldatu);

		btnAtzera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aldatuLeihoMenua();
			}
		});
		btnAtzera.setBounds(281, 433, 89, 23);
		add(btnAtzera);

		textField = new JTextField();
		textField.setBounds(204, 73, 248, 20);
		add(textField);
		textField.setColumns(10);
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				filtroakalkulatu();
			}
		});

		JLabel lblFiltroa = new JLabel("Filtroa:");
		lblFiltroa.setBounds(148, 76, 46, 14);
		add(lblFiltroa);
		taula.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent event) {
				btnAldatu.setEnabled(true);
				btnKendu.setEnabled(true);
			}
		});
		taularenBaliokKalkulatu();
	}

	private void taularenBaliokKalkulatu() {
		datuak = Kontroladorea.lortuEnplegatuenDatuak();
		filtroakalkulatu();
	}
	private void filtroakalkulatu() {
		String text = textField.getText();
		String[] taulaBurua = new String[] { "ID", "Izen Abizena", "Departamentua", "Soldata", "Ardura", "AltaData",
				"ZuzendariKodea", "Maila" };
		if (text.length() > 0) {
			int j = 0;
			for (int i = 0; i < datuak.length; i++) {
				if ((((String) datuak[i][1]).contains(text) || ((String) datuak[i][4]).contains(text)  || ((String) datuak[i][7]).contains(text))) {
					j++;
				}
			}
			datufiltratuak= new Object [j][8];
			j=0;
			for (int i = 0; i < datuak.length; i++) {
				if ((((String) datuak[i][1]).contains(text) || ((String) datuak[i][4]).contains(text)  || ((String) datuak[i][7]).contains(text))) {
					datufiltratuak[j]=datuak[i];
					j++;
				}
			}

			
		} else {
			
			datufiltratuak=datuak;
		}
		modelo = new DefaultTableModel(datufiltratuak, taulaBurua) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
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
