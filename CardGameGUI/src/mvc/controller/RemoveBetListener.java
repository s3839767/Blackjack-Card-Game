package mvc.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import model.interfaces.GameEngine;
import model.interfaces.Player;
import mvc.view.CardFrame;
import mvc.view.StatusBarPanel;
import mvc.view.SummaryPanel;

public class RemoveBetListener implements ActionListener {
	GameEngine ge; 
	JComboBox<Player> players;
	SummaryPanel sumPanel;
	StatusBarPanel sbPanel;
	
	public RemoveBetListener(CardFrame cardFrame, JComboBox players) {
		ge = cardFrame.getGameEngine();
		this.players = players;
		this.sumPanel = cardFrame.getCentrePanel().getSummaryPanel();
		this.sbPanel = cardFrame.getStatusBarPanel();
		
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Player player = (Player) players.getSelectedItem();
		
		if(!player.getPlayerId().equals("HOUSE")) {
			player.resetBet();
			sumPanel.updateBet(player);
			sbPanel.setStatus("Player " + player.getPlayerName() + " has reset their bet.");
		
		}
		else {
			JOptionPane.showMessageDialog(null ,"You cannot remove a bet with the House.", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

}
