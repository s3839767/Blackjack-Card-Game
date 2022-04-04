package mvc.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import model.interfaces.GameEngine;
import model.interfaces.Player;
import mvc.view.AddBetPane;
import mvc.view.CardFrame;
import mvc.view.StatusBarPanel;
import mvc.view.SummaryPanel;

public class AddBetListener implements ActionListener {
	GameEngine ge; 
	JComboBox<Player> players;
	AddBetPane abpane;
	SummaryPanel sumPanel;
	StatusBarPanel sbPanel;
	
	public AddBetListener(CardFrame cardFrame, JComboBox players) {
		ge = cardFrame.getGameEngine();
		this.players = players;
		this.sumPanel = cardFrame.getCentrePanel().getSummaryPanel();
		this.sbPanel = cardFrame.getStatusBarPanel();
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Player player = (Player) players.getSelectedItem();
	try {	//used to catch if a user accidentally inputs a wrong value or nothing in the option pane.
		
		if(!player.getPlayerId().equals("HOUSE")) {
			abpane = new AddBetPane();
			player.setBet(abpane.getBet());
			sumPanel.updateBet(player);
			sbPanel.setStatus("Player " + player.getPlayerName() + " has placed a bet of " + player.getBet() + ".");
		}
		else {
			JOptionPane.showMessageDialog(null ,"You cannot place a bet with the House.", "Error", JOptionPane.ERROR_MESSAGE);
		}
	} catch(NumberFormatException ex) {
		
	}
	}

}
