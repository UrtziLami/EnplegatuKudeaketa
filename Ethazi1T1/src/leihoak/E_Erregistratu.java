package leihoak;

import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

import kontroladorea.Kontroladorea;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class E_Erregistratu extends JPanel {

	JFileChooser aukera = new JFileChooser();
	File fitx;
	FileInputStream sarrera;
	String dok = "";
	
	JButton btnEnpErregisFitx = new JButton("Enplegatua erregistratu(Fitxateigitik)");
	JButton btnEnpKudeaketa = new JButton("Enplegatuak kudeatu");
	JButton btnAtzera = new JButton("Atzera");

	public E_Erregistratu() {
		setLayout(null);
		setBounds(150, 150, 520, 490);

		btnEnpErregisFitx.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (aukera.showDialog(null, "Ireki") == JFileChooser.APPROVE_OPTION) {
					fitx = aukera.getSelectedFile();
					if (fitx.canRead()) {
						if (fitx.getName().endsWith("csv")) {
							try {// meter el metodo para leer de un fichero csv y meterlo en dok
								
								JOptionPane.showMessageDialog(null, "Ondo erregistratu dira");
							} catch (Exception ex) {
								System.out.println(ex.getMessage());
							}
						} else if (fitx.getName().endsWith("xml")) {
							try {// meter el metodo para leer de un fichero xml y meterlo en dok
								
								JOptionPane.showMessageDialog(null, "Ondo erregistratu dira");
							} catch (Exception ex) {
								System.out.println(ex.getMessage());
							}
						} else if (fitx.getName().endsWith("json")) {
							try {// meter el metodo para leer de un fichero json y meterlo en dok
								
								JOptionPane.showMessageDialog(null, "Ondo erregistratu dira");
							} catch (Exception ex) {
								System.out.println(ex.getMessage());
							}
						}else
							JOptionPane.showMessageDialog(null, "Fitxategi ez bateragarria.");
					}
				}
			}
		});
		btnEnpErregisFitx.setBounds(79, 82, 343, 64);
		add(btnEnpErregisFitx);
		
		btnEnpKudeaketa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				E_Kudeaketa emp = new E_Kudeaketa();
				Leihoak.aldatuLeihoa(emp);
			}
		});
		btnEnpKudeaketa.setBounds(79, 209, 343, 64);
		add(btnEnpKudeaketa);
		
		btnAtzera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Kontroladorea kont = new Kontroladorea();
				kont.aldatuLeihoMenua();
			}
		});
		btnAtzera.setBounds(214, 403, 89, 23);
		add(btnAtzera);

	}
}
