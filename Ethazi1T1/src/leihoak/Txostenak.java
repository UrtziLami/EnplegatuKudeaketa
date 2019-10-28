package leihoak;

import javax.swing.JPanel;

import java.io.File;
import java.io.FileOutputStream;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Txostenak extends JPanel {
	
	JFileChooser aukera = new JFileChooser();
	File fitx;
	FileOutputStream irteera;
	String dok = "", msg = null;
	
	/**
	 * Create the panel.
	 */
	public Txostenak() {
		setLayout(null);
		
		JButton btnEnplegatuakInprimatu = new JButton("Enplegatuak Inprimatu");
		btnEnplegatuakInprimatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (aukera.showDialog(null, "Gorde") == JFileChooser.APPROVE_OPTION) {
					fitx = aukera.getSelectedFile();
					if (fitx.getName().endsWith("txt")) {
						try {// meter el metodo para escribir de un fichero txt y meterlo en dok
							
							msg = "Fitxategia gorde da.";
						} catch (Exception ex) {
							System.out.println(ex.getMessage());
						}
						if (msg != null) {
							JOptionPane.showMessageDialog(null, msg);
						}else
							JOptionPane.showMessageDialog(null, "Fitxategi ez bateragarria.");
						
					}else if (fitx.getName().endsWith("pdf")) {
						try {// meter el metodo para leer de un fichero pdf y meterlo en dok

							msg = "Fitxategia gorde da.";
						} catch (Exception ex) {
							System.out.println(ex.getMessage());
						}
						if (msg != null) {
							JOptionPane.showMessageDialog(null, msg);
						}else
							JOptionPane.showMessageDialog(null, "Fitxategi ez bateragarria.");
					}else
						JOptionPane.showMessageDialog(null, "Fitxategi ez bateragarria.");
				}
			}
		});
		btnEnplegatuakInprimatu.setBounds(103, 107, 297, 47);
		add(btnEnplegatuakInprimatu);
		
		JButton btnDepartamentuakInprimatu = new JButton("Departamentuak Inprimatu");
		btnDepartamentuakInprimatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDepartamentuakInprimatu.setBounds(103, 225, 297, 47);
		add(btnDepartamentuakInprimatu);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addItem(".txt");
		comboBox.addItem(".pdf");
		comboBox.setBounds(216, 344, 79, 20);
		add(comboBox);

	}
}
