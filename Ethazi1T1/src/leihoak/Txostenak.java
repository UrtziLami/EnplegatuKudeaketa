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
	private FileOutputStream irteera;
	private String dok = "", msg = null;
	
	private JButton btnInpTXT = new JButton("Txostena inprimatu .txt-an");
	private JButton btnInpPDF = new JButton("Departamentuak Inprimatu .pdf-an");
	private JButton btnAtzera = new JButton("Atzera");
	
	public Txostenak() {
		setLayout(null);
		setBounds(150, 150, 650, 490);
		
		btnInpTXT.addActionListener(new ActionListener() {
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
						
					}
				}
			}
		});
		btnInpTXT.setBounds(196, 106, 297, 47);
		add(btnInpTXT);
		
		btnInpPDF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (aukera.showDialog(null, "Gorde") == JFileChooser.APPROVE_OPTION) {
					fitx = aukera.getSelectedFile();
					if (fitx.getName().endsWith("pdf")) {
						try {// meter el metodo para leer de un fichero pdf y meterlo en dok
							Kontroladorea.pdfSortu(fitx.getAbsolutePath());
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
		btnInpPDF.setBounds(196, 228, 297, 47);
		add(btnInpPDF);
		
		btnAtzera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menua men = new Menua();
				Leihoak.aldatuLeihoa(men);			}
		});
		btnAtzera.setBounds(301, 396, 89, 23);
		add(btnAtzera);
		
		
	}
}
