package leihoak;

import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;
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

	public E_Erregistratu() {
		setLayout(null);

		JButton btnEnplegatuErregistratu = new JButton("Enplegatua erregistratu(Fitxateigitik)");
		btnEnplegatuErregistratu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		btnEnplegatuErregistratu.setBounds(79, 82, 343, 64);
		add(btnEnplegatuErregistratu);

		JButton btnFitxategitikErregistratu = new JButton("Enplegatuak kudeatu");
		btnFitxategitikErregistratu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

			}
		});
		btnFitxategitikErregistratu.setBounds(79, 209, 343, 64);
		add(btnFitxategitikErregistratu);

	}
}
