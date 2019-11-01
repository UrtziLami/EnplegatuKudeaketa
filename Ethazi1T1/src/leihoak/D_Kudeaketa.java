package leihoak;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

import kontroladorea.Kontroladorea;

public class D_Kudeaketa extends JPanel {
	
	private JTable taula = new JTable();
	private JTextField txtFIzena = new JTextField();
	private JTextField txtFKokapena = new JTextField();
	
	private String izena, kokapena;
	
	private JButton btnLehena = new JButton("<<");
	private JButton btnAtzera = new JButton("<");
	private JButton btnHurrengoa = new JButton(">");
	private JButton btnAzkena = new JButton(">>");
	private JButton btnGehitu = new JButton("Gehitu");
	private JButton btnAldatu = new JButton("Aldatu");
	private JButton btnKendu = new JButton("Kendu");
	private JButton btnAtzeraa = new JButton("Atzera");
	
	private JLabel lblIzena = new JLabel("Izena:");
	private JLabel lblKokapena = new JLabel("Kokapena:");
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
	
	public D_Kudeaketa() {
		setLayout(null);
		setBounds(150, 150, 520, 488);
		
		btnLehena.setBounds(30, 359, 89, 23);
		add(btnLehena);
		
		btnAtzera.setBounds(149, 359, 89, 23);
		add(btnAtzera);
		
		btnHurrengoa.setBounds(273, 359, 89, 23);
		add(btnHurrengoa);
		
		btnAzkena.setBounds(386, 359, 89, 23);
		add(btnAzkena);
		 
		taula.setBounds(30, 123, 446, 214);
		add(taula);
		
		lblIzena.setBounds(52, 31, 46, 14);
		add(lblIzena);
		
		txtFIzena.setBounds(125, 28, 170, 20);
		add(txtFIzena);
		txtFIzena.setColumns(10);
		txtFIzena.addKeyListener(letrakBakarrik);
		
		lblKokapena.setBounds(52, 78, 67, 14);
		add(lblKokapena);
		
		txtFKokapena.setBounds(125, 75, 170, 20);
		add(txtFKokapena);
		txtFKokapena.setColumns(10);
		txtFKokapena.addKeyListener(letrakBakarrik);
		
		
		btnGehitu.setBounds(361, 11, 89, 23);
		btnGehitu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				izena = txtFIzena.getText();
				kokapena = txtFKokapena.getText();
				Kontroladorea.sartuDept(izena, kokapena);
			}
		});
		add(btnGehitu);
		
		btnAldatu.setBounds(361, 79, 89, 23);
		add(btnAldatu);
		
		btnKendu.setBounds(361, 45, 89, 23);
		add(btnKendu);
		
		btnAtzeraa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aldatuLeihoMenua();
			}
		});
		btnAtzeraa.setBounds(214, 403, 89, 23);
		add(btnAtzeraa);


	}
	private void aldatuLeihoMenua() {
		Menua men = new Menua();
		Leihoak.aldatuLeihoa(men);
	}
	
}
