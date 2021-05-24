import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;


public class App {
	
	public static void main(String[] args) {

		
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				JFrame steamer = null;
				try {
					steamer = new MainFrame("STEAMER");
				} catch (Exception e) {
					e.printStackTrace();
				}
				steamer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				steamer.setSize(600,300);
				steamer.setVisible(true);
			}
		});

	};
}