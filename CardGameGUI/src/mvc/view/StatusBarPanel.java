package mvc.view;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StatusBarPanel extends JPanel {

	private JPanel sBarPanel = new JPanel();
	JLabel statusLabel;
	
	public StatusBarPanel(CardFrame cardFrame) {
		
		
		setLayout(new BorderLayout());
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		setBorder(BorderFactory.createTitledBorder("Status"));
		add(sBarPanel);
		populate();
		
			
	}
	
	public void populate() {
		statusLabel = new JLabel("Sleeping");
		add(statusLabel, BorderLayout.CENTER);
		
	}
	
	public void setStatus(String status) { // Other classes will use this setter to output text in the StatusBarPanel
		statusLabel.setText(status);
	}
	
	
	
}
