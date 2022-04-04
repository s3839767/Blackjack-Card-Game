package mvc.view;


import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JToolBar;

import model.SimplePlayer;
import model.interfaces.Player;
import mvc.controller.AddBetListener;
import mvc.controller.AddPlayerListener;
import mvc.controller.DealListener;
import mvc.controller.RemoveBetListener;
import mvc.controller.RemovePlayerListener;
import mvc.model.Model;
import mvc.model.Model.Button;

public class CardToolBar extends JToolBar {

	
	private Model model = new Model();
	JComboBox<Player> players = new JComboBox<Player>();
	
	public CardToolBar(CardFrame cardFrame) {
		
		
	
		// reference used: https://docs.oracle.com/javase/8/docs/api/javax/swing/ListCellRenderer.html
		players.setRenderer(new DefaultListCellRenderer() // allows certain functions to occur on the players Combobox.
		{
			public Component getListCellRendererComponent
					(JList<?> list,
                    Object value,
                    int index,
                    boolean isSelected,
                    boolean cellHasFocus) 
			{
				if (value != null)
					setText(((Player) value).getPlayerName());
				
				return this;
			}
		
		});
		
		

		for (Button bt : Button.values()) { // loops through an enum of buttons in order to add them as JButtons on the toolbar along with a corresponding Action Listener.
			if (bt.equals(Button.valueOf("Deal"))) {
				JButton dealButton = new JButton(model.getStringOfButton(bt));
				dealButton.addActionListener(new DealListener(cardFrame, players));
				add(dealButton);
			}
			else if (bt.equals(Button.valueOf("PlaceBet"))) {
				JButton pBetButton = new JButton(model.getStringOfButton(bt));
				pBetButton.addActionListener(new AddBetListener(cardFrame, players));
				add(pBetButton);
			}
			else if (bt.equals(Button.valueOf("RemoveBet"))) {
				JButton rBetButton = new JButton(model.getStringOfButton(bt));
				rBetButton.addActionListener(new RemoveBetListener(cardFrame, players));
				add(rBetButton);
			}
			else if (bt.equals(Button.valueOf("AddPlayer"))) {
				SimplePlayer player = new SimplePlayer("HOUSE", "House", -1);
				players.addItem(player);
				add(players);
				
				JButton aPlayerButton = new JButton(model.getStringOfButton(bt));
				aPlayerButton.addActionListener(new AddPlayerListener(cardFrame, players));
				add(aPlayerButton);
			}
			else if (bt.equals(Button.valueOf("RemovePlayer"))) {
				JButton rPlayerButton = new JButton(model.getStringOfButton(bt));
				rPlayerButton.addActionListener(new RemovePlayerListener(cardFrame, players));
				add(rPlayerButton);
			}
		}
	}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
