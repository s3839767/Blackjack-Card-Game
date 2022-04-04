package mvc.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import model.SimplePlayer;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import mvc.view.AddPlayerPane;
import mvc.view.CardFrame;
import mvc.view.StatusBarPanel;
import mvc.view.SummaryPanel;

public class AddPlayerListener implements ActionListener {
	GameEngine ge; 
	JComboBox<Player> players;
	AddPlayerPane apane;
	SummaryPanel sumPanel;
	StatusBarPanel sbPanel;

	public AddPlayerListener(CardFrame cardFrame, JComboBox players) {
		ge = cardFrame.getGameEngine();
		this.players = players;
		this.sumPanel = cardFrame.getCentrePanel().getSummaryPanel();
		this.sbPanel = cardFrame.getStatusBarPanel();
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		apane = new AddPlayerPane();
		
		try { // used to catch if a user accidentally inputs a wrong value or nothing in the option pane.
			Player player = new SimplePlayer(apane.getPlayerID(), apane.getPlayerName(), apane.getPlayerPoints());
			
			players.addItem(player);
			ge.addPlayer(player);
			sumPanel.createPlayer(player);
			sbPanel.setStatus("Player " + apane.getPlayerName() + " has been added.");
		
		} catch(NumberFormatException ex) {
			
		}
	}

	
	
	
}
