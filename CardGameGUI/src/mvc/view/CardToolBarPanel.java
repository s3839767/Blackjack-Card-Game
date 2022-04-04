package mvc.view;

import java.awt.BorderLayout;

import javax.swing.JPanel;

public class CardToolBarPanel extends JPanel {

	
	
	public CardToolBarPanel(CardFrame cardFrame) { // easier to add a toolbar panel rather than the toolbar itself onto the CardFrame
	
		setLayout(new BorderLayout());
		add(new CardToolBar(cardFrame), BorderLayout.PAGE_START);
		
	}
	
}
