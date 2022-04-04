package mvc.view;

import javax.swing.JOptionPane;
import javax.swing.JTextField;




public class AddPlayerPane extends JOptionPane {
	
	JTextField pname = new JTextField();
	JTextField pid = new JTextField();
	JTextField ppoints = new JTextField();
	
	Object[] fields = { // used to accept multiple inputs in the option pane.
			"Enter Player Name", pname,
			"Enter Player ID", pid,
			"Enter Player Points", ppoints
	};
	
	
	
	public AddPlayerPane(){
		
		JOptionPane.showConfirmDialog(null,fields, "Add Player", JOptionPane.OK_CANCEL_OPTION);
		
			
	}
	 
	public String getPlayerName() {
		
		return pname.getText();
	}
	
	public String getPlayerID() {
		
		
		return pid.getText();
	}
	
	public int getPlayerPoints() {
		
		int points = Integer.parseInt(ppoints.getText());
		
		return points;
	}
	
	
}
