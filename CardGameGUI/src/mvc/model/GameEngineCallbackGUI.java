package mvc.model;

import javax.swing.SwingUtilities;

import model.interfaces.GameEngine;
import model.interfaces.Player;
import model.interfaces.PlayingCard;
import mvc.view.CardFrame;
import mvc.view.CardPanel;
import mvc.view.StatusBarPanel;
import mvc.view.SummaryPanel;
import view.interfaces.GameEngineCallback;

public class GameEngineCallbackGUI  implements GameEngineCallback {

	SummaryPanel sumPanel;
	StatusBarPanel sbPanel;
	CardPanel cpanel;
	CardFrame cardFrame;
	
	
	public GameEngineCallbackGUI(CardFrame cardFrame) {
		this.cardFrame = cardFrame;
		sumPanel = cardFrame.getCentrePanel().getSummaryPanel();
		sbPanel = cardFrame.getStatusBarPanel();
		this.cpanel = cardFrame.getCentrePanel().getCardPanel();
	}

	@Override
	public void nextCard(Player player, PlayingCard card, GameEngine engine) {
		
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				cpanel.ImageCreator(card);
				cpanel.revalidate();
				cpanel.repaint();
			}
		});
	}

	@Override
	public void bustCard(Player player, PlayingCard card, GameEngine engine) {
		
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
			
			}
		});
	}

	@Override
	public void result(Player p, int result, GameEngine engine) {
		
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
			
			}
		});
	}

	@Override
	public void nextHouseCard(PlayingCard card, GameEngine engine) {
		
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				cpanel.ImageCreator(card);
				cpanel.revalidate();
				cpanel.repaint();
			}
		});
	}

	@Override
	public void houseBustCard(PlayingCard card, GameEngine engine) {
		
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
			
			}
		});
	}

	@Override
	public void houseResult(int result, GameEngine ge) {
		
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			
			public void run() {
			

				
				sbPanel.setStatus("The HOUSE dealt " + result + ".");
				for (Player players : ge.getAllPlayers()) {

					
					sumPanel.updatePlayerPoints(players);
					sumPanel.updateBet(players);
					
					if (players.getResult() == result) {
						sumPanel.updatePlayerOutcome(players, "DREW");
						
					} else if (players.getResult() > result) {
						sumPanel.updatePlayerOutcome(players, "WON");
					}	
					  else {	
						sumPanel.updatePlayerOutcome(players, "LOST");
					
					}
				}
			}
		});
	
	}

}

