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

public class Menua extends JPanel {
	
	private JButton btnDepKudeaketa = new JButton("Departamentuen Kudeaketa");
	private JButton btnEnpKudeaketa = new JButton("Enplegatuen Kudeaketa");
	private JButton btnTxostenakSortu = new JButton("Txostenak Sortu");
	private JButton btnErregisFitxategitik = new JButton("Erregistratu Fitxategitik");
	
	private JFileChooser aukera = new JFileChooser();
	private File fitx;
	private FileInputStream sarrera;
	private String dok = "";

	public Menua() {
		setLayout(null);
		setBounds(150, 150, 650, 490);
		
		btnDepKudeaketa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				D_Kudeaketa dep = new D_Kudeaketa();
				Leihoak.aldatuLeihoa(dep);
			}
		});
		btnDepKudeaketa.setBounds(181, 66, 312, 61);
		add(btnDepKudeaketa);
		
		btnEnpKudeaketa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				E_Kudeaketa emp = new E_Kudeaketa();
				Leihoak.aldatuLeihoa(emp);
			}
		});
		btnEnpKudeaketa.setBounds(181, 152, 312, 61);
		add(btnEnpKudeaketa);
		
		btnTxostenakSortu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Txostenak txos = new Txostenak();
				Leihoak.aldatuLeihoa(txos);
			}
		});
		btnTxostenakSortu.setBounds(181, 322, 312, 61);
		add(btnTxostenakSortu);
		
		
		btnErregisFitxategitik.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (aukera.showDialog(null, "Ireki") == JFileChooser.APPROVE_OPTION) {
					fitx = aukera.getSelectedFile();
					if (fitx.canRead()) {
						if (fitx.getName().endsWith("csv")) {
							try {// meter el metodo para leer de un fichero csv y meterlo en dok
								Kontroladorea.fitxategitikIgo(fitx.getAbsolutePath(),"csv");
							} catch (Exception ex) {
								System.out.println(ex.getMessage());
							}
						} else if (fitx.getName().endsWith("xml")) {
							try {// meter el metodo para leer de un fichero xml y meterlo en dok
								Kontroladorea.fitxategitikIgo(fitx.getAbsolutePath(),"xml");
							} catch (Exception ex) {
								System.out.println(ex.getMessage());
							}
						} else if (fitx.getName().endsWith("json")) {
							try {// meter el metodo para leer de un fichero json y meterlo en dok
								Kontroladorea.fitxategitikIgo(fitx.getAbsolutePath(),"json");
							} catch (Exception ex) {
								System.out.println(ex.getMessage());
							}
						}else
							JOptionPane.showMessageDialog(null, "Fitxategi ez bateragarria.");
					}
				}
			}
		});
		btnErregisFitxategitik.setBounds(181, 237, 312, 61);
		add(btnErregisFitxategitik);

	}
}
