package model;

import model.interfaces.PlayingCard;

public class PlayingCardImpl implements PlayingCard {
	private Suit suit;
	private Value value;
	private int score;
	public static final int DECK_SIZE = Suit.values().length * Value.values().length; 
	
	
	public PlayingCardImpl(Suit suit, Value value) { // constructor used for creating playing cards
		this.suit = suit;
		this.value = value;
		if (value == Value.EIGHT)
			this.score = 8;
		else if (value == Value.NINE)
			this.score = 9;
		else if (value == Value.ACE)
			this.score = 11;
		else
			this.score = 10;
	}
	
	@Override
	public Suit getSuit() {
		
		return this.suit;
	}

	@Override
	public Value getValue() {
		
		return this.value;
	}

	@Override
	public int getScore() {
		
		return this.score;
	}

	@Override
	public String toString() { // converts variables used for each card into one string format
		return "Suit: " + suit + ", Value: " + value + ", Score: " + score;
	}
	
	@Override
	public boolean equals(PlayingCard card) { // checks if card parameter equals suit/value variables and if so, returns true 
		   	                                  // (applies to method below also instead with type Object)
		if (suit.equals(card.getSuit()) && value.equals(card.getValue())) {
			return true;
		}
		return false;
	}
	
	
	@Override
	public boolean equals(Object card) {
		if (card instanceof PlayingCard) {
			PlayingCard cardFromConstructor = (PlayingCard) card;
			return (suit.equals(cardFromConstructor.getSuit()) && value.equals(cardFromConstructor.getValue()));
		}	
		return false;
	}
	
	
	@Override
	public int hashCode() {
		return suit.hashCode() + value.hashCode();
	}
}
