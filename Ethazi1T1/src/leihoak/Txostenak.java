package leihoak;

import javax.swing.JPanel;

import kontroladorea.Kontroladorea;

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
	
	JButton btnEnpInprimatu = new JButton("Enplegatuak Inprimatu");
	JButton btnDepInprimatu = new JButton("Departamentuak Inprimatu");
	JButton btnAtzera = new JButton("Atzera");
	
	JComboBox cmbxAtzizkia = new JComboBox();
	
	public Txostenak() {
		setLayout(null);
		setBounds(150, 150, 520, 490);
		
		btnEnpInprimatu.addActionListener(new ActionListener() {
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
		btnEnpInprimatu.setBounds(103, 107, 297, 47);
		add(btnEnpInprimatu);
		
		btnDepInprimatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		btnDepInprimatu.setBounds(103, 225, 297, 47);
		add(btnDepInprimatu);
		
		cmbxAtzizkia.addItem(".txt");
		cmbxAtzizkia.addItem(".pdf");
		cmbxAtzizkia.setBounds(216, 344, 79, 20);
		add(cmbxAtzizkia);
		
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
