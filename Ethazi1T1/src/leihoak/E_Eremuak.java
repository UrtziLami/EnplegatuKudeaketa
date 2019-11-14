
package leihoak;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import eredua.Departamentu;
import kontroladorea.Kontroladorea;
import kontroladorea.Nagusia;

public class E_Eremuak extends JPanel {
	private JTextField txtfIzenAbizenak = new JTextField();
	private JTextField txtfSoldata = new JTextField();

	private JButton btnAtzera = new JButton("Atzera");
	private JButton btnGehitu = new JButton("Gehitu");

	private JLabel lblIzenAbizenak = new JLabel("Izen Abizenak:");
	private JLabel lblDepartamentua = new JLabel("Departamentua:");
	private JLabel lblSoldata = new JLabel("Soldata:");
	private JLabel lblArdura = new JLabel("Ardura:");
	private JLabel lblMaila = new JLabel("Maila:");
	private JLabel lblZuzendariKodea = new JLabel("Zuzendari Kodea:");

	private JComboBox<String> cmbxDepartamentuak = new JComboBox<String>();
	private JComboBox<String> cmbxArdurak = new JComboBox<String>();
	private JComboBox<String> cmbxMailak = new JComboBox<String>();
	private JComboBox<String> cmbxZuzKod = new JComboBox<String>();

	private ArrayList<Departamentu> deptak = new ArrayList<Departamentu>();
	private Object[][] zuzKod;

	private String izenAbizena, ardura, maila;
	private int soldata, zuzendariKod, depart;
	private KeyAdapter letrakBakarrik = new KeyAdapter() {
		public void keyTyped(KeyEvent e) {
			char caracter = e.getKeyChar();
			if (((caracter < 'A') || (caracter > 'z')) && (caracter != ' ')) {
				e.consume();
			}
		}
	};
	private KeyAdapter zenbakiakBakarrik = new KeyAdapter() {
		public void keyTyped(KeyEvent e) {
			char caracter = e.getKeyChar();
			if (((caracter < '0') || (caracter > '9'))) {
				e.consume();
			}
		}
	};

	public E_Eremuak() {
		setLayout(null);
		setBounds(150, 150, 650, 490);

		lblIzenAbizenak.setBounds(67, 51, 109, 14);
		add(lblIzenAbizenak);

		lblDepartamentua.setBounds(67, 101, 109, 14);
		add(lblDepartamentua);

		lblSoldata.setBounds(67, 155, 46, 14);
		add(lblSoldata);

		lblArdura.setBounds(67, 207, 46, 14);
		add(lblArdura);

		lblMaila.setBounds(67, 256, 46, 14);
		add(lblMaila);

		txtfIzenAbizenak = new JTextField();
		txtfIzenAbizenak.setBounds(219, 48, 304, 20);
		add(txtfIzenAbizenak);
		txtfIzenAbizenak.setColumns(10);
		txtfIzenAbizenak.addKeyListener(letrakBakarrik);

		cmbxDepartamentuak.setBounds(219, 98, 304, 20);
		deptak = Kontroladorea.lortuDepartamentuak();
		for (int i = 0; i < deptak.size(); i++) {
			cmbxDepartamentuak.addItem(deptak.get(i).getDepartIzena());
		}
		add(cmbxDepartamentuak);

		txtfSoldata.setBounds(219, 152, 304, 20);
		add(txtfSoldata);
		txtfSoldata.setColumns(10);
		txtfSoldata.addKeyListener(zenbakiakBakarrik);

		cmbxArdurak.setBounds(219, 204, 155, 20);
		cmbxArdurak.addItem("Tutorea");
		cmbxArdurak.addItem("Irakaslea");
		cmbxArdurak.addItem("Idazkaria");
		cmbxArdurak.addItem("Atezaina");
		cmbxArdurak.addItem("Zuzendaria");
		cmbxArdurak.addItem("Mintegi-burua");
		cmbxArdurak.addActionListener(new ActionListener() {// add actionlistner to listen for change
			@Override
			public void actionPerformed(ActionEvent e) {
				String zuz = (String) cmbxArdurak.getSelectedItem();
				if (zuz.equals("Zuzendaria")) {
					cmbxMailak.setEnabled(true);
					cmbxZuzKod.setEnabled(false);

				} else if (zuz.equals("Mintegi-burua")) {
					cmbxMailak.setSelectedItem("Mintegi-burua");
					cmbxMailak.setEnabled(false);
					kalkulatuZuzendariak(zuz);
				} else if (zuz.equals("Idazkaria")) {
					cmbxMailak.setSelectedItem("Idazkaria");
					cmbxMailak.setEnabled(false);
					kalkulatuZuzendariak(zuz);
				} else {
					cmbxMailak.setEnabled(false);
					zuz = "Soila";
					kalkulatuZuzendariak(zuz);
				}

			}
		});
		add(cmbxArdurak);

		cmbxMailak.setBounds(219, 253, 155, 20);
		cmbxMailak.setEnabled(false);
		cmbxMailak.addItem("Mintegi-burua");
		cmbxMailak.addItem("Ikasketa burua");
		cmbxMailak.addItem("Zuzendari ordea");
		cmbxMailak.addItem("Idazkaria");
		cmbxMailak.addItem("Zuzendari Nagusia");
		cmbxMailak.addActionListener(new ActionListener() {// add actionlistner to listen for change
			@Override
			public void actionPerformed(ActionEvent e) {
				String nag = (String) cmbxMailak.getSelectedItem();
				kalkulatuZuzendariak(nag);
				if (nag.equals("Zuzendari Nagusia")) {
					cmbxZuzKod.setEnabled(false);
				} else {
					cmbxZuzKod.setEnabled(true);
				}
			}
		});

		add(cmbxMailak);

		btnAtzera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aldatuLeihoEnpKudeaketa();
			}
		});
		btnAtzera.setBounds(285, 404, 89, 23);
		add(btnAtzera);
	

		btnGehitu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (txtfSoldata.getText().length() > 0 && txtfIzenAbizenak.getText().length() > 0) {
					soldata = Integer.parseInt(txtfSoldata.getText());
					izenAbizena = txtfIzenAbizenak.getText();
					Departamentu dept = deptak.get(cmbxDepartamentuak.getSelectedIndex());
					depart = dept.getDepartKod();

					ardura = (String) cmbxArdurak.getSelectedItem();
					if (cmbxMailak.isEnabled()) {
						maila = (String) cmbxMailak.getSelectedItem();
					} else
						maila = "SOILA";
					if (cmbxZuzKod.isEnabled()) {
						zuzendariKod = (int) cmbxZuzKod.getSelectedIndex();
						zuzendariKod=(int) zuzKod[zuzendariKod][0];
					} else {
						zuzendariKod = 0;
					}
					Kontroladorea.sartuEnp(depart, soldata, zuzendariKod, izenAbizena, ardura, maila);
				} else {
					JOptionPane.showMessageDialog(null, "ez dira datuak sartu enplegatua sortzeko");
					Nagusia.LOGGER.severe("ez dira datuak sartu enplegatua sortzeko");
				}
			}
		});
		btnGehitu.setBounds(285, 351, 89, 23);
		add(btnGehitu);

		lblZuzendariKodea.setBounds(67, 302, 109, 14);
		add(lblZuzendariKodea);
		cmbxZuzKod.setEnabled(false);

		cmbxZuzKod.setBounds(219, 299, 155, 20);

		add(cmbxZuzKod);

	}
	public E_Eremuak(int enplegatuKod, String izena,  int sol ) {
		
		txtfIzenAbizenak.setText(izena);
		txtfSoldata.setText(Integer.toString(sol));
		setLayout(null);
		setBounds(150, 150, 650, 490);
		

		lblIzenAbizenak.setBounds(67, 51, 109, 14);
		add(lblIzenAbizenak);

		lblDepartamentua.setBounds(67, 101, 109, 14);
		add(lblDepartamentua);

		lblSoldata.setBounds(67, 155, 46, 14);
		add(lblSoldata);

		lblArdura.setBounds(67, 207, 46, 14);
		add(lblArdura);

		lblMaila.setBounds(67, 256, 46, 14);
		add(lblMaila);

		
		txtfIzenAbizenak.setBounds(219, 48, 304, 20);
		add(txtfIzenAbizenak);
		txtfIzenAbizenak.setColumns(10);
		txtfIzenAbizenak.addKeyListener(letrakBakarrik);

		cmbxDepartamentuak.setBounds(219, 98, 304, 20);
		deptak = Kontroladorea.lortuDepartamentuak();
		for (int i = 0; i < deptak.size(); i++) {
			cmbxDepartamentuak.addItem(deptak.get(i).getDepartIzena());
		}
		add(cmbxDepartamentuak);

		txtfSoldata.setBounds(219, 152, 304, 20);
		add(txtfSoldata);
		txtfSoldata.setColumns(10);
		txtfSoldata.addKeyListener(zenbakiakBakarrik);

		cmbxArdurak.setBounds(219, 204, 155, 20);
		cmbxArdurak.addItem("Tutorea");
		cmbxArdurak.addItem("Irakaslea");
		cmbxArdurak.addItem("Idazkaria");
		cmbxArdurak.addItem("Atezaina");
		cmbxArdurak.addItem("Zuzendaria");
		cmbxArdurak.addItem("Mintegi-burua");
		cmbxArdurak.addActionListener(new ActionListener() {// add actionlistner to listen for change
			@Override
			public void actionPerformed(ActionEvent e) {
				String zuz = (String) cmbxArdurak.getSelectedItem();
				if (zuz.equals("Zuzendaria")) {
					cmbxMailak.setEnabled(true);
					cmbxZuzKod.setEnabled(false);

				} else if (zuz.equals("Mintegi-burua")) {
					cmbxMailak.setSelectedItem("Mintegi-burua");
					cmbxMailak.setEnabled(false);
					kalkulatuZuzendariak(zuz);
				} else if (zuz.equals("Idazkaria")) {
					cmbxMailak.setSelectedItem("Idazkaria");
					cmbxMailak.setEnabled(false);
					kalkulatuZuzendariak(zuz);
				} else {
					cmbxMailak.setEnabled(false);
					zuz = "Soila";
					kalkulatuZuzendariak(zuz);
				}

			}
		});
		add(cmbxArdurak);

		cmbxMailak.setBounds(219, 253, 155, 20);
		cmbxMailak.setEnabled(false);
		cmbxMailak.addItem("Mintegi-burua");
		cmbxMailak.addItem("Ikasketa burua");
		cmbxMailak.addItem("Zuzendari ordea");
		cmbxMailak.addItem("Idazkaria");
		cmbxMailak.addItem("Zuzendari Nagusia");
		cmbxMailak.addActionListener(new ActionListener() {// add actionlistner to listen for change
			@Override
			public void actionPerformed(ActionEvent e) {
				String nag = (String) cmbxMailak.getSelectedItem();
				kalkulatuZuzendariak(nag);
				if (nag.equals("Zuzendari Nagusia")) {
					cmbxZuzKod.setEnabled(false);
				} else {
					cmbxZuzKod.setEnabled(true);
				}
			}
		});

		add(cmbxMailak);

		btnAtzera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aldatuLeihoEnpKudeaketa();
			}
		});
		btnAtzera.setBounds(285, 404, 89, 23);
		add(btnAtzera);
		btnGehitu.setText("Aldatu");

		btnGehitu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (txtfSoldata.getText().length() > 0 && txtfIzenAbizenak.getText().length() > 0) {
					soldata = Integer.parseInt(txtfSoldata.getText());
					izenAbizena = txtfIzenAbizenak.getText();
					Departamentu dept = deptak.get(cmbxDepartamentuak.getSelectedIndex());
					depart = dept.getDepartKod();

					ardura = (String) cmbxArdurak.getSelectedItem();
					if (cmbxMailak.isEnabled()) {
						maila = (String) cmbxMailak.getSelectedItem();
					} else
						maila = "SOILA";
					if (cmbxZuzKod.isEnabled()) {
						zuzendariKod = (int) cmbxZuzKod.getSelectedIndex();
						zuzendariKod=(int) zuzKod[zuzendariKod][0];
					} else {
						zuzendariKod = 0;
					}
					Kontroladorea.aldatuEnp(enplegatuKod ,depart, soldata, zuzendariKod, izenAbizena, ardura, maila);
				} else {
					JOptionPane.showMessageDialog(null, "ez dira datuak sartu enplegatua sortzeko");
					Nagusia.LOGGER.severe("ez dira datuak sartu enplegatua sortzeko");
				}
			}
		});
		btnGehitu.setBounds(285, 351, 89, 23);
		add(btnGehitu);

		lblZuzendariKodea.setBounds(67, 302, 109, 14);
		add(lblZuzendariKodea);
		cmbxZuzKod.setEnabled(false);

		cmbxZuzKod.setBounds(219, 299, 155, 20);

		add(cmbxZuzKod);

	}

	private void kalkulatuZuzendariak(String maila) {
		zuzKod = Kontroladorea.lortuZuzendariKod(maila);
		cmbxZuzKod.removeAllItems();
		if (zuzKod.length > 0) {
		for (int i = 0; i < zuzKod.length; i++) {
			cmbxZuzKod.addItem((String)zuzKod[i][1]);
		}
		
			cmbxZuzKod.setEnabled(true);
		}
	}

	private void aldatuLeihoEnpKudeaketa() {
		E_Kudeaketa enp = new E_Kudeaketa();
		Leihoak.aldatuLeihoa(enp);
	}
}
