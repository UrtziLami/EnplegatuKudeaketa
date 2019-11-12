package leihoak;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import kontroladorea.Kontroladorea;

public class Txostenak extends JPanel {

	private JFileChooser aukera = new JFileChooser();
	private File fitx;
	private String msg = null;

	private JButton btnInpEnp = new JButton("Inprimatu Enplegatuak");
	private JButton btnInpDep = new JButton("Inprimatu Departamentuak");
	private JButton btnAtzera = new JButton("Atzera");

	public Txostenak() {
		setLayout(null);
		setBounds(150, 150, 650, 490);
		
		btnInpDep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (aukera.showDialog(null, "Gorde") == JFileChooser.APPROVE_OPTION) {
					fitx = aukera.getSelectedFile();
					if (fitx.getName().endsWith("pdf")) {
						try {
							Kontroladorea.pdfSortuDep(fitx.getAbsolutePath());
							msg = "Fitxategia gorde da.";
						} catch (Exception ex) {
							System.out.println(ex.getMessage());
						}
						if (msg != null) {
							JOptionPane.showMessageDialog(null, msg);
						}else
							JOptionPane.showMessageDialog(null, "Fitxategi ez bateragarria.");
					}else if (fitx.getName().endsWith("txt")) {
							try {
								Kontroladorea.txtSortuDep(fitx.getAbsolutePath());
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
		btnInpDep.setBounds(196, 106, 297, 47);
		add(btnInpDep);
		
		btnInpEnp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (aukera.showDialog(null, "Gorde") == JFileChooser.APPROVE_OPTION) {
					fitx = aukera.getSelectedFile();
					if (fitx.getName().endsWith("pdf")) {
						try {
							Kontroladorea.pdfSortuEnp(fitx.getAbsolutePath());
							msg = "Fitxategia gorde da.";
						} catch (Exception ex) {
							System.out.println(ex.getMessage());
						}
						if (msg != null) {
							JOptionPane.showMessageDialog(null, msg);
						}else
							JOptionPane.showMessageDialog(null, "Fitxategi ez bateragarria.");
					}else if (fitx.getName().endsWith("txt")) {
							try {
								Kontroladorea.txtSortuEnp(fitx.getAbsolutePath());
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
		btnInpEnp.setBounds(196, 228, 297, 47);
		add(btnInpEnp);
		
		btnAtzera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menua men = new Menua();
				Leihoak.aldatuLeihoa(men);			}
		});
		btnAtzera.setBounds(301, 396, 89, 23);
		add(btnAtzera);
		
		
	}
}
