package model;

import model.interfaces.Player;

public class SimplePlayer implements Player {

	private String id;
	private String playerName;
	private int initialPoints;
	private int bet;
	private int results;

	public SimplePlayer(String id, String playerName, int initialPoints) { // constructor used for creating players
		this.id = id;
		this.playerName = playerName;
		this.initialPoints = initialPoints;
	}

	@Override
	public String getPlayerName() {
		
		return this.playerName;
	}

	@Override
	public void setPlayerName(String playerName) {
		
		this.playerName = playerName;
	}

	@Override
	public int getPoints() {
		
		return this.initialPoints;
	}

	@Override
	public void setPoints(int points) {
		
		this.initialPoints = points;
	}

	@Override
	public String getPlayerId() {
		
		return this.id;
	}

	@Override
	public boolean setBet(int bet) { 
		
		if (bet > 0 && this.getPoints() - bet >= 0) {  
			this.bet = bet;
			return true;
		}
		else {
			resetBet();
			return false;
		}
	}

	@Override
	public int getBet() {
		
		return this.bet;
	}

	@Override
	public void resetBet() {
		
		this.bet = 0;
	}

	@Override
	public int getResult() {
		
		return this.results;
	}

	@Override
	public void setResult(int result) {
		
		this.results = result;
	}

	@Override
	public boolean equals(Player player) { // checks if player parameter equals id/playerName variables and if so, returns true 
										   // (applies to method below also instead with type Object)
		if(id.equals(player.getPlayerId())) {
			return true;
		}
		return false;
	}
			
	@Override
	public boolean equals(Object player) {
		if (player instanceof Player) {
			Player playerFromConstructor = (Player) player;
			return (id.equals(playerFromConstructor.getPlayerId()));
		}	
		return false;
	}
	
	@Override
	public int hashCode() {
		return id.hashCode() + playerName.hashCode();	
	}	
		
	@Override
	public int compareTo(Player player) {
		return Integer.parseInt(this.id) - Integer.parseInt(player.getPlayerId());
	}
	
	
	@Override
	public String toString() { // converts variables used for each player into one string format
		return "Player: id=" + id +", name=" + playerName + ", bet=" + this.bet + ", points=" + getPoints() + ", RESULTS .. " + getResult() + "";
	}
	
	
}
