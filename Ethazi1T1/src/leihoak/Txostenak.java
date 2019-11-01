package leihoak;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Txostenak extends JPanel {
	
	private JFileChooser aukera = new JFileChooser();
	private File fitx;
	private FileOutputStream irteera;
	private String dok = "", msg = null;
	
	private JButton btnEnpInprimatu = new JButton("Enplegatuak Inprimatu");
	private JButton btnDepInprimatu = new JButton("Departamentuak Inprimatu");
	private JButton btnAtzera = new JButton("Atzera");
	
	public Txostenak() {
		setLayout(null);
		setBounds(150, 150, 520, 490);
		
		btnEnpInprimatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (aukera.showDialog(null, "Gorde") == JFileChooser.APPROVE_OPTION) {
					fitx = aukera.getSelectedFile();
					if (fitx.getName().endsWith("txt")) {
						try {// meter el metodo para escribir de un fichero txt y meterlo en 'dok'
							
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
						try {// meter el metodo para escribir de un fichero txt y meterlo en 'dok'
							
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
		
		btnAtzera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menua men = new Menua();
				Leihoak.aldatuLeihoa(men);			}
		});
		btnAtzera.setBounds(214, 403, 89, 23);
		add(btnAtzera);

	}
	
}
