// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a SWEN221 assignment.
// You may not distribute it in any other way without permission.
package swen221.cards.core;

/**
 * Represents a single card in the game.
 *
 * @author David J. Pearce
 *
 */
public class Card implements Comparable<Card> {

	/**
	 * Represents a card suit.
	 *
	 * @author David J. Pearce
	 *
	 */
	public enum Suit {
		/**
		 * The suit of hearts.
		 */
		HEARTS,
		/**
		 * The suit of clubs.
		 */
		CLUBS,
		/**
		 * The suit of diamonds.
		 */
		DIAMONDS,
		/**
		 * The suit of spades.
		 */
		SPADES;
	}

	/**
	 * Represents the different card "numbers".
	 *
	 * @author David J. Pearce
	 *
	 */
	public enum Rank {
		TWO,
		THREE,
		FOUR,
		FIVE,
		SIX,
		SEVEN,
		EIGHT,
		NINE,
		TEN,
		JACK,
		QUEEN,
		KING,
		ACE;
	}

	// =======================================================
	// Card stuff
	// =======================================================

	private Suit suit; // HEARTS, CLUBS, DIAMONDS, SPADES
	private Rank rank; // 2 <= number <= 14 (ACE)

	/**
	 * Construct a card in the given suit, with a given number
	 *
	 * @param suit
	 *            --- between 0 (HEARTS) and 3 (SPADES)
	 * @param number
	 *            --- between 2 and 14 (ACE)
	 */
	public Card(Suit suit, Rank number) {
		this.suit = suit;
		this.rank = number;
	}

	/**
	 * Get the suit of this card, between 0 (HEARTS) and 3 (SPADES).
	 *
	 * @return The suite of this card.
	 */
	public Suit suit() {
		return suit;
	}

	/**
	 * Get the number of this card, between 2 and 14 (ACE).
	 *
	 * @return The rank of this card.
	 */
	public Rank rank() {
		return rank;
	}

	private static String[] suits = { "Hearts","Clubs","Diamonds","Spades"};
	private static String[] ranks = { "2 of ", "3 of ", "4 of ",
			"5 of ", "6 of ", "7 of ", "8 of ", "9 of ", "10 of ", "Jack of ",
			"Queen of ", "King of ", "Ace of " };

	@Override
	public String toString() {
		return ranks[rank.ordinal()] + suits[suit.ordinal()];
	}

	@Override
	public int compareTo(Card o) {
		int card1 = this.suit.ordinal() * 100;//int value - ordinal *100 so suit dont effect outcome
		int card2 = o.suit.ordinal() * 100;
		
		card1 = card1 + this.rank.ordinal() + 2; //increment by 2 so rank is a secondary factor
		card2 = card2 + o.rank.ordinal() + 2;
		
		if (card1 > card2) {return 1;}//if card one is greater
		if (card1 < card2) {return -1;}//if card two is greater
		else {return 0;}//if equal
	}
	
	public int hashCode() {
		int rankValue = this.rank.ordinal() * 100; // rank's ordinal value * 100
		int suitValue = this.suit.ordinal(); // Get the ordinal value of suit
		
		return rankValue + suitValue; // Add rankValue and suitValue
	}
	
	public boolean equals(Card obj) {
		if (obj != null && obj instanceof Card) {
			Card otherCard = (Card) obj;
			return this.rank == otherCard.rank && this.suit == otherCard.suit;
		}
			return false;
		}
	
	//CLONE CARD CLASS
	@Override
	public Card clone() {
		Card isCloned = new Card(this.suit, this.rank); //create new card object
		return isCloned; //return deep copy
	}
	
}
