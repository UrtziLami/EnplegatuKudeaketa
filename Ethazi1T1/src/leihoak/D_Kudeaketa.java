package leihoak;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import kontroladorea.Kontroladorea;
import kontroladorea.Nagusia;

public class D_Kudeaketa extends JPanel {

	private JTable taula = new JTable();
	private JScrollPane scrollPane;
	private DefaultTableModel modelo = new DefaultTableModel();
	private Object[][] datuak;
	private JTextField txtFIzena = new JTextField();
	private JTextField txtFKokapena = new JTextField();

	private String izena, kokapena;

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
	private KeyAdapter letrakBakarrik = new KeyAdapter() {
		public void keyTyped(KeyEvent e) {
			char caracter = e.getKeyChar();
			if (((caracter < 'A') || (caracter > 'z')) && (caracter != ' ')) {
				e.consume();
			}
		}
	};

	public D_Kudeaketa() {
		setLayout(null);
		setBounds(150, 150, 650, 490);

		btnLehena.setBounds(30, 359, 89, 23);
		add(btnLehena);

		btnAtzera.setBounds(195, 359, 89, 23);
		add(btnAtzera);

		btnHurrengoa.setBounds(369, 359, 89, 23);
		add(btnHurrengoa);

		btnAzkena.setBounds(536, 359, 89, 23);
		add(btnAzkena);

		// *************taularen datuak
		taula.setBounds(30, 123, 446, 214);
		add(taula);

		scrollPane = new JScrollPane(taula);
		scrollPane.setViewportBorder(null);
		scrollPane.setBounds(30, 123, 595, 214);
		add(scrollPane);
		taularnBalioakBirkalkulatu();
		taula.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		taula.getTableHeader().setResizingAllowed(false);
		taula.getTableHeader().setReorderingAllowed(false);

		/* Taula amaiera */

		lblIzena.setBounds(52, 31, 46, 14);
		add(lblIzena);

		txtFIzena.setBounds(125, 28, 170, 20);
		add(txtFIzena);
		txtFIzena.setColumns(10);
		txtFIzena.addKeyListener(letrakBakarrik);

		lblKokapena.setBounds(52, 78, 67, 14);
		add(lblKokapena);

		txtFKokapena.setBounds(125, 75, 170, 20);
		add(txtFKokapena);
		txtFKokapena.setColumns(10);
		txtFKokapena.addKeyListener(letrakBakarrik);

		btnGehitu.setBounds(338, 56, 89, 23);
		btnGehitu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (txtFIzena.getText().length() > 0 && txtFKokapena.getText().length() > 0) {
					izena = txtFIzena.getText();
					kokapena = txtFKokapena.getText();
					Kontroladorea.sartuDept(izena, kokapena);
					taularnBalioakBirkalkulatu();
				} else {
					JOptionPane.showMessageDialog(null, "ez dira datuak sartu departamentuak sortzeko" );
					Nagusia.LOGGER.severe("ez dira datuak sartu departamentua sortzeko");
				}
			}
		});
		add(btnGehitu);
		btnAldatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (txtFIzena.getText().length() > 0 && txtFKokapena.getText().length() > 0) {
				int aldatuDepartKod = (int) datuak[taula.getSelectedRow()][0];
				String izenBerria = txtFIzena.getText();
				String eraikuntzaBerria = txtFKokapena.getText();

				Kontroladorea.aldatuDepartamentua(aldatuDepartKod, izenBerria, eraikuntzaBerria);
				taularnBalioakBirkalkulatu();
			} else {
				JOptionPane.showMessageDialog(null, "ez dira datuak sartu departamentuak sortzeko" );
				Nagusia.LOGGER.severe("ez dira datuak sartu departamentua sortzeko");
			}}
		});

		btnAldatu.setBounds(536, 56, 89, 23);
		add(btnAldatu);
		btnKendu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int ezabatuDepartKod = (int) datuak[taula.getSelectedRow()][0];
				Kontroladorea.ezabatuDepartamentua(ezabatuDepartKod);
				taularnBalioakBirkalkulatu();
			}
		});

		btnKendu.setBounds(437, 56, 89, 23);
		add(btnKendu);

		btnAtzeraa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aldatuLeihoMenua();
			}
		});
		btnAtzeraa.setBounds(285, 403, 89, 23);
		add(btnAtzeraa);

	}

	private void taularnBalioakBirkalkulatu() {
		datuak = Kontroladorea.lortuDepartamentuenDatuak();
		String[] taulaBurua = new String[] { "ID", "DepartamentuIzena", "Eraikina" };
		modelo = new DefaultTableModel(datuak, taulaBurua) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		taula.setModel(modelo);
	}

	private void aldatuLeihoMenua() {
		Menua men = new Menua();
		Leihoak.aldatuLeihoa(men);
	}

}
