package model;

import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;

import model.interfaces.GameEngine;
import model.interfaces.Player;
import model.interfaces.PlayingCard;
import model.interfaces.PlayingCard.Suit;
import model.interfaces.PlayingCard.Value;
import view.interfaces.GameEngineCallback;

public class GameEngineImpl implements GameEngine {
	LinkedList<Player> players = new LinkedList<Player>();
	LinkedList<PlayingCard> deck = new LinkedList<PlayingCard>();
	LinkedList<GameEngineCallback> gameengine = new LinkedList<GameEngineCallback>();
	public static final int BUST_LEVEL = 42;
	Deque<PlayingCard> deckused = getShuffledHalfDeck(); 
	
	@Override
	public void dealPlayer(Player player, int delay) throws IllegalArgumentException { // deals cards to player for 1 round unless called again 
		int totalscore = 0;
		int playerResults = 0;
		PlayingCard cardDealt = null;
		//Deque<PlayingCard> deckused = getShuffledHalfDeck(); 
		while (playerResults < BUST_LEVEL) { // will continue to loop until the player's results has reached BUST_LEVEL (42)
			if (deck.size() == 0) {
				deckused =	 getShuffledHalfDeck(); // if deckused runs out of cards, call the method again to re-populate deck
				
			}
			
			for (int index = 0; index < gameengine.size(); index++) { // iterates through the elements of gameengine LinkedList when dealing cards/getting result
				cardDealt = deck.remove();
				totalscore += cardDealt.getScore(); // score is added from the dealt card's score
				
				try{   
					if (delay < 0 || delay > 1000) 
						throw new IllegalArgumentException ("Used Illegal Argument");
					else
						Thread.sleep(delay);
					}
					catch(Exception e) {
						
					}
					
	
				if (totalscore <= BUST_LEVEL) {
					gameengine.get(index).nextCard(player, cardDealt, this);
				}
				playerResults = totalscore; // breaks the while loop when total score > BUST_LEVEL
				
				if (totalscore > BUST_LEVEL) {
					totalscore -= cardDealt.getScore(); // bust card's score is subtracted from total score
					gameengine.get(index).bustCard(player, cardDealt, this);
				}
				player.setResult(totalscore); // player's final results are set 
				
				if (playerResults > BUST_LEVEL) {
					gameengine.get(index).result(player, totalscore, this);
				}
				
			}
		}
		
	
	}
	@Override
	public void dealHouse(int delay) throws IllegalArgumentException { // deals cards to House for 1 round unless called again
		int houseResults = 0;
		int totalscore = 0;
		PlayingCard cardDealt = null;
		
		
		
		while (houseResults <= BUST_LEVEL) {
			if (deck.size() == 0) {
				deckused = getShuffledHalfDeck();
			}
			
					
			for (int index = 0; index < gameengine.size(); index++) {
				cardDealt = deck.remove();
				totalscore += cardDealt.getScore();
				try{ 
					if (delay < 0 || delay > 1000) 
						throw new IllegalArgumentException ("Used Illegal Argument");
					else
						Thread.sleep(delay);
					}
					catch(Exception e) {
						
					}
				
				if (totalscore <= BUST_LEVEL) {
					gameengine.get(index).nextHouseCard(cardDealt, this);
				}
				houseResults = totalscore;
				
				if (totalscore > BUST_LEVEL) {
					totalscore -= cardDealt.getScore();
					gameengine.get(index).houseBustCard(cardDealt, this);	
				}	
			}
		}
		for (int k = 0; k < players.size(); k++) { // iterates through LinkedList of players and applies winloss method on them
			applyWinLoss(players.get(k) , totalscore);
		}
		
		
		for (int index = 0; index < gameengine.size(); index++) { 
			if (houseResults > BUST_LEVEL) {
				gameengine.get(index).houseResult(totalscore, this);
			}
		}
		
		
		for (int k = 0; k < players.size(); k++) { // loops through the players to resetBet for all of them
			players.get(k).resetBet();
		}
	}

	@Override
	public void applyWinLoss(Player player, int houseResult) { // applies the outcome of game on player parameter
		
		if (player.getResult() > houseResult) { // win situation (player's points adding his bet)
			int win = player.getPoints() + player.getBet(); 
			player.setPoints(win);
		}
		
		else if (player.getResult() < houseResult) { // loss situation (player's points subtracting his bet)
			int loss = player.getPoints() - player.getBet();
			player.setPoints(loss);
		}
		// 
		else 
			player.setPoints(player.getPoints()); // draw situation (sets the player's unchanged points)
		// ^^ else statement used for readability ^^
	}

	@Override
	public void addPlayer(Player player) { // used to add player parameter to LinkedList players
		boolean foundPlayer = false;
		for (int index = 0; index < players.size(); index++) // iterates through the players by index 
			
			if (players.get(index).equals(player)) {
				players.set(index, player);
				foundPlayer = true; // if a player's id is found to equal the parameter player's id then it is replaced rather than added
			}
		if (foundPlayer == false)
			players.add(player);
	}

	@Override
	public Player getPlayer(String id) { // used to check if parameter id is equal to any of the LinkedList players' id 
		Player retVal = null;
		
		for (int i = 0; i < players.size(); i++) { // iterates through the players by i (index) 
			if (players.get(i).getPlayerId() == id) { 
				retVal = players.get(i); // if a player's id is found to equal the parameter id then return it using retVal
			}
		}	
		return retVal;
	}

	@Override
	public boolean removePlayer(Player player) {
		
		return players.remove(player);
	}

	@Override
	public boolean placeBet(Player player, int bet) { 
	
		return player.setBet(bet);
		
	}

	@Override
	public void addGameEngineCallback(GameEngineCallback gameEngineCallback) {
		
		gameengine.add(gameEngineCallback);
	}

	@Override
	public boolean removeGameEngineCallback(GameEngineCallback gameEngineCallback) {
		
		return gameengine.remove(gameEngineCallback);
	}

	@Override
	public Collection<Player> getAllPlayers() { // sorts the players in LinkedList players by their player id in ascending order
		Collections.sort(players);
		return players;
		
		
	}

	@Override
	public Deque<PlayingCard> getShuffledHalfDeck() { // used to populate LinkedList deck with cards created in method
		for (int indexOfSuit = 0; indexOfSuit < Suit.values().length; indexOfSuit++) 
			for (int indexOfValue = 0; indexOfValue < Value.values().length; indexOfValue++) // iterates through the Suit Enum and assigns each Suit element all the Value elements 
				deck.add(new PlayingCardImpl(Suit.values()[indexOfSuit], Value.values()[indexOfValue])); // adds the card created to the deck 
		Collections.shuffle(deck);
		return deck;
	}

}
