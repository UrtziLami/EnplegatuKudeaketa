
package leihoak;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import eredua.Departamentu;
import kontroladorea.Kontroladorea;

public class E_Eremuak extends JPanel {
	private JTextField txtfIzenAbizenak = new JTextField();
	private JTextField txtfSoldata = new JTextField();
	
	private JButton btnAtzera = new JButton("Atzera");
	private JButton btnGehitu = new JButton("Gehitu");
	
	private JLabel lblIzenAbizenak = new JLabel("Izen Abizenak:");
	private JLabel lblDepartamentua = new JLabel("Departamentua:");
	private JLabel lblSoldata = new JLabel("Soldata:");
	private JLabel lblArdura = new JLabel("Ardura:");
	private JLabel lblMaila = new JLabel("Maila:");
	private JLabel lblZuzendariKodea = new JLabel("Zuzendari Kodea:");
	
	private JComboBox cmbxDepartamentuak = new JComboBox();
	private JComboBox cmbxArdurak = new JComboBox();
	private JComboBox cmbxMailak = new JComboBox();
	private JComboBox cmbxZuzKod = new JComboBox();
	
	private ArrayList<Departamentu> deptak = new ArrayList<Departamentu>();
	private ArrayList<Integer> zuzKod = new ArrayList<Integer>();
	
	private String izenAbizena, ardura, maila;
	private int soldata, zuzendariKod, depart;
	private KeyAdapter letrakBakarrik= new KeyAdapter()
	{
		   public void keyTyped(KeyEvent e)
		   {
		      char caracter = e.getKeyChar();
		      if(((caracter < 'A') ||
		         (caracter > 'z')) &&
		         (caracter != ' ' ))
		      {
		         e.consume(); 
		      }
		   }
		};
		private KeyAdapter zenbakiakBakarrik= new KeyAdapter()
		{
			   public void keyTyped(KeyEvent e)
			   {
			      char caracter = e.getKeyChar();
			      if(((caracter < '0') ||
			         (caracter > '9')))
			      {
			         e.consume(); 
			      }
			   }
			};
		
	
	public E_Eremuak() {
		setLayout(null);
		setBounds(150, 150, 520, 489);
		
		lblIzenAbizenak.setBounds(67, 51, 109, 14);
		add(lblIzenAbizenak);
		
		lblDepartamentua.setBounds(67, 101, 109, 14);
		add(lblDepartamentua);
		
		lblSoldata.setBounds(67, 155, 46, 14);
		add(lblSoldata);
		
		lblArdura.setBounds(67, 207, 46, 14);
		add(lblArdura);
		
		lblMaila.setBounds(67, 301, 46, 14);
		add(lblMaila);
		
		txtfIzenAbizenak = new JTextField();
		txtfIzenAbizenak.setBounds(177, 48, 261, 20);
		add(txtfIzenAbizenak);
		txtfIzenAbizenak.setColumns(10);
		txtfIzenAbizenak.addKeyListener(letrakBakarrik);
		
		cmbxDepartamentuak.setBounds(177, 98, 261, 20);
		deptak = Kontroladorea.lortuDepartamentuak();
		for (int i = 0; i < deptak.size(); i++) {
			cmbxDepartamentuak.addItem(deptak.get(i).getDepartIzena());
		}
		add(cmbxDepartamentuak);
		
		txtfSoldata.setBounds(177, 152, 261, 20);
		add(txtfSoldata);
		txtfSoldata.setColumns(10);
		txtfSoldata.addKeyListener(letrakBakarrik);
		
		cmbxArdurak.setBounds(177, 204, 155, 20);
		cmbxArdurak.addItem("Tutorea");
		cmbxArdurak.addItem("Irakaslea");
		cmbxArdurak.addItem("Idazkaria");
		cmbxArdurak.addItem("Atezaina");
		cmbxArdurak.addItem("Zuzendaria");
		cmbxArdurak.addItem("Mintegi-burua");
		add(cmbxArdurak);
		
		cmbxMailak.setBounds(177, 298, 155, 20);
		cmbxMailak.addItem("Mintegi-burua");
		cmbxMailak.addItem("Zuzendari orokorra");
		cmbxMailak.addItem("Ikasketa burua");
		cmbxMailak.addItem("Zuzendari ordea");
		cmbxMailak.addItem("Idazkaria");
		cmbxMailak.addItem("Zuzendari Nagusia");
		add(cmbxMailak);
		
		btnAtzera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aldatuLeihoEnpKudeaketa();
			}
		});
		btnAtzera.setBounds(214, 403, 89, 23);
		add(btnAtzera);
		
		btnGehitu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Departamentu dept =deptak.get(cmbxDepartamentuak.getSelectedIndex());
				depart = dept.getDepartKod();
				soldata = Integer.parseInt(txtfSoldata.getText());
				izenAbizena = txtfIzenAbizenak.getText();
				ardura = (String) cmbxArdurak.getSelectedItem();
				maila = (String) cmbxMailak.getSelectedItem();
				zuzendariKod = (int) cmbxZuzKod.getSelectedItem();
				Kontroladorea.sartuEnp(depart, soldata, zuzendariKod, izenAbizena, ardura, maila);
			}
		});
		btnGehitu.setBounds(214, 352, 89, 23);
		add(btnGehitu);
		
		
		lblZuzendariKodea.setBounds(67, 252, 109, 14);
		add(lblZuzendariKodea);
		
		cmbxZuzKod.setBounds(177, 249, 155, 20);
		zuzKod = Kontroladorea.lortuZuzendariKod();
		for (int i = 0; i < zuzKod.size(); i++) {
			cmbxZuzKod.addItem(zuzKod.get(i));
		}
		add(cmbxZuzKod);

	}
	
	private  void aldatuLeihoEnpKudeaketa() {
		E_Kudeaketa enp = new E_Kudeaketa();
		Leihoak.aldatuLeihoa(enp);
	}
}
