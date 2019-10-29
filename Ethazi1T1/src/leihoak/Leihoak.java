package leihoak;

import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

public class Leihoak extends JFrame {

	public static JFrame frame;
	
	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public Leihoak() {
		getContentPane().setLayout(null);
		
		frame = new JFrame();
		frame.setBounds(150, 150, 430, 525);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setResizable(true);
		frame.setTitle("Enplegatuen eta Departamentuen Kudeaketa");
		
	}
	
	public static void aldatuLeihoa(JPanel panela) {
		frame.setContentPane(panela);
		frame.setPreferredSize(panela.getSize());
		frame.setResizable(false);
		frame.pack();
		frame.setPreferredSize(null);
	}
}
