package mvc.view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class CentrePanel extends JPanel {

	private CardFrame cardFrame;
	private CardPanel cardpanel;
	private SummaryPanel sumpanel;
	private TitledBorder titledBorder;
	
	
	public CentrePanel(CardFrame cardFrame) { // this CentrePanel is used to support the addition of two panels; the CardPanel and SummaryPanel in the middle of the CardFrame
		
		setLayout(new BorderLayout());
		this.cardFrame = cardFrame;
		
		
	}
	public void populate() { // added helper method for readability purposes
		
		this.cardpanel = new CardPanel(cardFrame);
		
		titledBorder = BorderFactory.createTitledBorder("Card Panel");
		cardpanel.setBackground(Color.BLACK);
		titledBorder.setTitleColor(Color.WHITE);
		cardpanel.setBorder(titledBorder);
		
		add(cardpanel, BorderLayout.NORTH);
		
		
		
		
		
		this.sumpanel = new SummaryPanel(cardFrame);
		add(sumpanel, BorderLayout.SOUTH);
		
		
	}
	
	public CardPanel getCardPanel() {
		
		return cardpanel;
	}
	
	public SummaryPanel getSummaryPanel() {
		
		return sumpanel;
	}
}
