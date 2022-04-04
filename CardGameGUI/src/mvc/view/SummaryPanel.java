package mvc.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.interfaces.Player;

public class SummaryPanel extends JPanel {
	private JPanel sumPanel = new JPanel();
	JTable sumTable;
	DefaultTableModel dTableModel;
	
	
	Object[] columns = {
			"ID", "Name", "Points", "Bet", "Score" ,"Outcome"
	};
	
	
	public SummaryPanel(CardFrame cardFrame) {
		
		setLayout(new BorderLayout());
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		setBorder(BorderFactory.createTitledBorder("Summary Panel"));
		sumPanel.setPreferredSize(new Dimension((int) cardFrame.getCentrePanel().getWidth(),(int) cardFrame.getCentrePanel().getHeight() / 3));
		populate();
	}
	
	public void populate () { // added helper method for readability purposes 
		
		dTableModel = new DefaultTableModel(columns, 0);
		sumTable = new JTable(dTableModel);
		JScrollPane scrollPane = new JScrollPane(sumTable); // added the Summary Table component on a JScrollPane for resizing purposes
		add(scrollPane);
		
	}
	// Reference used for the dTableModel methods below: https://stackoverflow.com/questions/18618436/java-jtable-update-row
		public void createPlayer(Player player) {
			
			Object[] playerValues = { // uses the Object array above to create columns for the DefaultTableModel
					player.getPlayerId(), player.getPlayerName(), player.getPoints(), player.getBet(), player.getResult(), "-"
			};
			
			dTableModel.addRow(playerValues);
		}
	
	// The rest of the methods below update each Player's values in specific columns after getting called.
	public void updateBet(Player player) {
		for (int i = 0; i < dTableModel.getRowCount(); i++) {
			if (player.getPlayerId().equals(dTableModel.getValueAt(i, 0)))
				dTableModel.setValueAt(player.getBet(), i, 3);
		}
	}
	
	public void removePlayer(Player player) {
		for (int i = 0; i < dTableModel.getRowCount(); i++) {
			if (player.getPlayerId().equals(dTableModel.getValueAt(i, 0)))
				dTableModel.removeRow(i);
		}
	}
	
	public void updatePlayerScore(Player player) {
		for (int i = 0; i < dTableModel.getRowCount(); i++) {
			if (player.getPlayerId().equals(dTableModel.getValueAt(i, 0)))
				dTableModel.setValueAt(player.getResult(), i, 4);
		}
	}
	
	public void updatePlayerOutcome(Player player, String string) {
		for (int i = 0; i < dTableModel.getRowCount(); i++) {
			if (player.getPlayerId().equals(dTableModel.getValueAt(i, 0)))
				dTableModel.setValueAt(string, i, 5);
		}
	}
	
	public void updatePlayerPoints(Player player) {
		for (int i = 0; i < dTableModel.getRowCount(); i++) {
			if (player.getPlayerId().equals(dTableModel.getValueAt(i, 0)))
				dTableModel.setValueAt(player.getPoints(), i, 2);
		}
	}
	
	
}
