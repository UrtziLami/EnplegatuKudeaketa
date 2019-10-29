package leihoak;

import javax.swing.JPanel;
import java.awt.Button;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.awt.event.ActionEvent;

public class D_Kudeaketa extends JPanel {
	
	JFileChooser aukera = new JFileChooser();
	File fitx;
	FileInputStream sarrera;
	String dok = "";

	/**
	 * Create the panel.
	 */
	public D_Kudeaketa() {
		setLayout(null);
		
		JButton btnNewButton = new JButton("Departamentuak Erregistratu(Fitxateigitk)");
		btnNewButton.addActionListener(new ActionListener() {
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
		btnNewButton.setBounds(79, 82, 343, 64);
		add(btnNewButton);
		
		JButton btnDepartamentuakBilatu = new JButton("Departamentuak Kudeatu");
		btnDepartamentuakBilatu.setBounds(79, 209, 343, 64);
		add(btnDepartamentuakBilatu);

	}
}
