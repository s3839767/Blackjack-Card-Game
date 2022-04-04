package mvc.view;

import javax.swing.JOptionPane;

public class AddBetPane extends JOptionPane {
	private int bet;
	
	public AddBetPane() {
		bet = Integer.parseInt(JOptionPane.showInputDialog(null ,"Enter Bet Amount", "Add Bet", JOptionPane.INFORMATION_MESSAGE));
		
	}


	public int getBet() {
		
		return bet;
	}
	
	
}
