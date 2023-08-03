// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a SWEN221 assignment.
// You may not distribute it in any other way without permission.
package swen221.cards.util;

import java.util.Iterator;

import swen221.cards.core.Card;
import swen221.cards.core.Player;
import swen221.cards.core.Trick;

/**
 * Implements a simple computer player who plays the highest card available when
 * the trick can still be won, otherwise discards the lowest card available. In
 * the special case that the player must win the trick (i.e. this is the last
 * card in the trick), then the player conservatively plays the least card
 * needed to win.
 *
 * @author David J. Pearce
 *
 */
public class SimpleComputerPlayer extends AbstractComputerPlayer {

	/**
	 * Construct a new (simple) computer player with the given player information.
	 *
	 * @param player Key player informmation.
	 */
	public SimpleComputerPlayer(Player player) {
		super(player);
	}

	//METHODS TO FIND HIGHEST AND SMALLEST CARD FOR AI
	//get method for highest card 
	public Card getHighest(Iterable<Card> cards, Trick trick) {
		Card highestCard = null; //store highest card
		boolean isFirstCard = true; //first card
		for (Card card : cards) {
		    if (isFirstCard) {
		        highestCard = card; //first card initial highest
		        isFirstCard = false; //set false after first card gone
		    } else {
		        highestCard = findHighest(highestCard, card, trick); //compare current with current  highest
		    }
		}
		return highestCard;
	}

	//find highest card
	public Card findHighest(Card firstC, Card secondC, Trick t) { 
		int one = firstC.hashCode();//first card
		int two = secondC.hashCode();//second card
		int highest = 2000;
		
		if (t.getTrumps() != null) { //compare cards to get the highest
			if (firstC.suit().equals(t.getTrumps())) {one += highest;}
			if (secondC.suit().equals(t.getTrumps())) {two += highest;}
		}
		
		if (one > two){return firstC;}//if first card higher than second -> return first
		else{return secondC;} //if not -> return second
	}
	
	//get method for smallest card
	public Card getSmallest(Iterable<Card> cards, Trick trick) {
		Card smallestCard = null; //store smallest
		boolean isFirstCard = true; //first card
		
		for (Card card : cards) {
		    if (isFirstCard) {
		        smallestCard = card; //first card initial smallest
		        isFirstCard = false; //set false after first card gone
		    } else {
		        smallestCard = findSmallest(smallestCard, card, trick); //compare current with current highest
		    }
		}

		return smallestCard;
	}

	//find smallest card
	public Card findSmallest(Card firstC, Card secondC, Trick t) { 
		int one = firstC.hashCode(); //first card
		int two = secondC.hashCode(); //second card
		int highest = 2000;
		
		if (t.getTrumps() != null) { //compare cards to get the highest
			if (firstC.suit().equals(t.getTrumps())) {one += highest;}
			if (secondC.suit().equals(t.getTrumps())) {two += highest;}
		}
		
		//if first card is smaller than the second -> return first 
		if (one < two){return firstC;}
		else {return secondC;} //if not -> return second
	}
	
	//AI GET CARD METHOD 
	@Override
	public Card getNextCard(Trick trick) {
		Card startC = null; 
		Card followingC = null; 
		Card highC = null; //current highest card
		
		int otherP = 3;
		
		Iterable<Card> nextCards;//cards not played yet
		
		///////////////////
		if(trick.getCardsPlayed().isEmpty()) { //check for first card
			nextCards = this.player.getHand(); 
			followingC = getHighest(nextCards, trick); //get highest card within hand
		
		///////////////////	
		} else if(trick.getCardsPlayed().size() == otherP) {//last card -> been played
			startC = trick.getCardsPlayed().get(0);
			highC = getHighest(trick.getCardsPlayed(), trick);
			
			if(!this.player.getHand().matches(startC.suit()).isEmpty()) { //check card -> suit played 
				nextCards = this.player.hand.matches(startC.suit());
				
				for(Card card : nextCards) { //check to win
					if (findHighest(card, highC, trick).equals(card)) {followingC = card; break;}
				}
				
				followingC = getSmallest(nextCards, trick); //cant win -> discard smallest
				
			} else {
				nextCards = this.player.getHand();
				followingC = getHighest(nextCards, trick); //highest card of suit 
				
				if(findHighest(followingC, highC, trick).equals(followingC)) {
					for(Card card : nextCards) {
						if(findHighest(card, highC, trick).equals(card)){followingC = card; break;}
					}
					
				} else {followingC = getSmallest(nextCards, trick);} //cant win -> discard smallest
			}
		
		///////////////////	
		} else { 
			startC = trick.getCardsPlayed().get(0); //get last card played
			
			if (!this.player.hand.matches(startC.suit()).isEmpty()) { //check hand -> card matches suit
				nextCards = this.player.hand.matches(startC.suit());
				followingC = getHighest(nextCards, trick); //highest card of matched suit
				highC = getHighest(trick.getCardsPlayed(), trick);
				
				if(findHighest(followingC, highC, trick).equals(highC) ||
				  (findHighest(followingC, highC, trick).hashCode() < highC.hashCode())) 
				   		{followingC = getSmallest(nextCards, trick);} //if highest matches currhighest -> discard lowest matched
			
			} else { //no matched cards
				nextCards = this.player.getHand(); //choose highest card from hand
				followingC = getHighest(nextCards, trick);
				highC = getHighest(trick.getCardsPlayed(), trick);
				
				if(findHighest(followingC,highC,trick).equals(highC)|| 
				  (findHighest(followingC,highC,trick).hashCode() < highC.hashCode())) 
				  		{followingC = getSmallest(nextCards, trick);}
			}
		}
		return followingC;
	}
}