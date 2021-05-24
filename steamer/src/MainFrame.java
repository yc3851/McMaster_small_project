import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;


public class MainFrame extends JFrame {

	private static final long serialVersionUID = 2550139179038932026L;

	private DetailsPanel penal;

	public MainFrame(String title) throws Exception {
		super(title);

		setLayout(new BorderLayout());

		JTextArea textArea = new JTextArea();

		penal = new DetailsPanel();

		penal.addDetailListener(new DetailListener() {
			public void detailEventOccurred(DetailEvent event) {
				String text = event.getResult();
				if (text.equals("Clear2550139179038932026L")) {
					textArea.setText(null);
				} 
				else if (text.equals("Price: -0.01")) {
					textArea.append("Price: N/A \n");
				} else {
					textArea.append(text + "\n");
				}
			}
		});

		Container container = getContentPane();
		container.add(textArea, BorderLayout.CENTER);
		container.add(penal, BorderLayout.WEST);

	}
}
