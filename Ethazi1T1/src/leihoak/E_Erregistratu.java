package leihoak;

import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class E_Erregistratu extends JPanel {

	/**
	 * Create the panel.
	 */
	public E_Erregistratu() {
		setLayout(null);
		
		JButton btnEnplegatuErregistratu = new JButton("Enplegatu erregistratu");
		btnEnplegatuErregistratu.setBounds(88, 78, 308, 55);
		add(btnEnplegatuErregistratu);
		
		JButton btnFitxategitikErregistratu = new JButton("Fitxategitik erregistratu");
		btnFitxategitikErregistratu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Creamos el objeto JFileChooser
				JFileChooser fc=new JFileChooser();
				 
				//Indicamos lo que podemos seleccionar
				fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				 
				//Creamos el filtro
				FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.TXT", "txt");
				 
				//Le indicamos el filtro
				fc.setFileFilter(filtro);
				 
				//Abrimos la ventana, guardamos la opcion seleccionada por el usuario
				//int seleccion=fc.showOpenDialog(contentPane);
				 
				//Si el usuario, pincha en aceptar
				//if(seleccion==JFileChooser.APPROVE_OPTION){
				 
				    //Seleccionamos el fichero
				    File fichero=fc.getSelectedFile();
				 
				    //Ecribe la ruta del fichero seleccionado en el campo de texto
				   // textField.setText(fichero.getAbsolutePath());
				 
				    try(FileReader fr=new FileReader(fichero)){
				        String cadena="";
				        int valor=fr.read();
				        while(valor!=-1){
				            cadena=cadena+(char)valor;
				            valor=fr.read();
				        }
				       // textArea.setText(cadena);
				    } catch (IOException e1) {
				        e1.printStackTrace();
				    }
				}
			
			}
		});
		btnFitxategitikErregistratu.setBounds(88, 195, 308, 55);
		add(btnFitxategitikErregistratu);

	}
}
