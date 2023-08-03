// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a SWEN221 assignment.
// You may not distribute it in any other way without permission.
package swen221.cards.variations;

import java.util.List;

import swen221.cards.core.Card;
import swen221.cards.core.Player;
import swen221.cards.util.AbstractCardGame;

/**
 * An implementation of the "classical" rules of Whist.
 *
 * @author David J. Pearce
 *
 */
public class ClassicWhist extends AbstractCardGame {

	/**
	 * Construct a new game of classic whist.
	 */
	public ClassicWhist() {

	}

	@Override
	public String getName() {
		return "Classic Whist";
	}

	@Override
	public boolean isGameFinished() {
		for (Player.Direction d : Player.Direction.values()) {
			if (scores.get(d) == 5) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void deal(List<Card> deck) {
		currentTrick = null;
		for (Player.Direction d : Player.Direction.values()) {
			players.get(d).getHand().clear();
		}
		Player.Direction d = Player.Direction.NORTH;
		for (int i = 0; i < deck.size(); ++i) {
			Card card = deck.get(i);
			players.get(d).getHand().add(card);
			d = d.next();
		}
	}
	
	public ClassicWhist clone() {
		ClassicWhist isCloned = new ClassicWhist(); //create instance

		for(Player p : players.values()) { //iterate through player
			Player play = new Player(p.direction); //create new player
			play.hand = p.hand.clone(); //create clone of player hand
			isCloned.players.put(p.direction,play);
		}

		isCloned.tricks.putAll(tricks); //clone tricks
		isCloned.scores.putAll(scores); //clone scores
		isCloned.trumps = trumps; //clone trumps
		isCloned.currentTrick = currentTrick.clone(); //clone current tricks

	    return isCloned;
	}
	
}
