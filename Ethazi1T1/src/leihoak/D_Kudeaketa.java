package leihoak;

import javax.swing.JPanel;

import kontroladorea.Kontroladorea;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.awt.event.ActionEvent;

public class D_Kudeaketa extends JPanel {
	
	private JFileChooser aukera = new JFileChooser();
	private File fitx;
	private FileInputStream sarrera;
	private String dok = "";

	private JButton btnDepErregisFitx = new JButton("Departamentuak Erregistratu(Fitxateigitk)");
	private JButton btnDepKudeatu = new JButton("Departamentuak Kudeatu");
	private JButton btnAtzera = new JButton("Atzera");
	
	public D_Kudeaketa() {
		setLayout(null);
		setBounds(150, 150, 520, 489);
		
		btnDepErregisFitx.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (aukera.showDialog(null, "Ireki") == JFileChooser.APPROVE_OPTION) {
					fitx = aukera.getSelectedFile();
					if (fitx.canRead()) {
						if (fitx.getName().endsWith("csv")) {
							try {// meter el metodo para leer de un fichero csv y meterlo en dok

							} catch (Exception ex) {
								System.out.println(ex.getMessage());
							}
						} else if (fitx.getName().endsWith("xml")) {
							try {// meter el metodo para leer de un fichero xml y meterlo en dok

							} catch (Exception ex) {
								System.out.println(ex.getMessage());
							}
						} else if (fitx.getName().endsWith("json")) {
							try {// meter el metodo para leer de un fichero json y meterlo en dok

							} catch (Exception ex) {
								System.out.println(ex.getMessage());
							}
						}else
							JOptionPane.showMessageDialog(null, "Fitxategi ez bateragarria.");
					}
				}
			}
		});
		btnDepErregisFitx.setBounds(79, 82, 343, 64);
		add(btnDepErregisFitx);
		
		btnDepKudeatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				D_Bilatu dep = new D_Bilatu();
				Leihoak.aldatuLeihoa(dep);
			}
		});
		btnDepKudeatu.setBounds(79, 209, 343, 64);
		add(btnDepKudeatu);
	
		btnAtzera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Kontroladorea.aldatuLeihoMenua();
			}
		});
		btnAtzera.setBounds(214, 403, 89, 23);
		add(btnAtzera);

	}
}
