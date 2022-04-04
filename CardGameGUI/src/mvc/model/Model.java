package mvc.model;

public class Model {

	
	public enum Button
	{
		Deal, PlaceBet, RemoveBet
		, AddPlayer, RemovePlayer
	};
	
	public String getStringOfButton(Button button){
		String bt = null;
		switch(button)
		{
			case Deal: 
				bt = "Deal";
				break;
			case PlaceBet: 
				bt = "Place Bet";
				break;
			case RemoveBet: 
				bt = "Remove Bet";
				break;
			case AddPlayer: 
				bt = "Add Player";
				break;
			case RemovePlayer: 
				bt = "Remove Player";
				break;
			default: System.out.println("Button not found");
		}
		return bt;
		
	}
	
}
