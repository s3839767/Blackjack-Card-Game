package mvc.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import model.interfaces.GameEngine;
import model.interfaces.Player;
import mvc.view.CardFrame;
import mvc.view.CardPanel;
import mvc.view.StatusBarPanel;
import mvc.view.SummaryPanel;

public class DealListener implements ActionListener {
	GameEngine ge; 
	JComboBox<Player> players;
	SummaryPanel sumPanel;
	StatusBarPanel sbPanel;
	CardPanel cPanel;
	CardFrame cardFrame;
	boolean hasPlayerDealt = false; 
	
	public DealListener(CardFrame cardFrame, JComboBox players) {
		ge = cardFrame.getGameEngine();
		this.players = players;
		this.sumPanel = cardFrame.getCentrePanel().getSummaryPanel();
		this.sbPanel = cardFrame.getStatusBarPanel();
		this.cardFrame = cardFrame;
		this.cPanel = cardFrame.getCentrePanel().getCardPanel();
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Player player = (Player) players.getSelectedItem();
		cPanel.clearCardPanel();
		
		if(player.getPlayerId().equals("HOUSE")) { // an if condition separating the two threads according to if the player selected is the House or not.
			if(hasPlayerDealt == true) { // an if condition used so that the House can only deal if the player has dealt before. 
				
			new Thread() {
				@Override
				public void run() {	
					
					
					ge.dealHouse(100);
					
					
					
				}	
				
			}.start();
			hasPlayerDealt = false;
			}
		    else {
		    	JOptionPane.showMessageDialog(null ,"You need to deal to a player first.", "Error", JOptionPane.ERROR_MESSAGE);
		    }
		
		}
		
		else if(!(player.getBet() == 0)) { // an if condition used to enforce the game rule of the player not being able to bet if he has not placed a bet.
			new Thread() {
				@Override
				public void run() {	
					
					
					ge.dealPlayer(player, 100);
					
					sumPanel.updatePlayerScore(player);
					sbPanel.setStatus("Player " + player.getPlayerName() + " has dealt " + player.getResult() + ".");
					
					
				}	
				
			}.start();
			hasPlayerDealt = true;
				
		}
		else {
			JOptionPane.showMessageDialog(null ,"You cannot play if you haven't placed a bet.", "Error", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	
	
	
}


