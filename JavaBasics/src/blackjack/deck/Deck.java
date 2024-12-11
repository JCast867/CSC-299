package blackjack.deck;

import java.util.ArrayList;
import java.util.List;

/**
 * A model for a deck of standard playing cards
 * @author <Your Name Here>
 */
public class Deck
{
	private List<Card> cards;

	/**
	 * Creates a single deck of cards where each Card is a unique Suit and Rank
	 * based on the Enum types in this class
	 */
	public Deck(){this(1);}
	
	/**
	 * Creates more than one deck of cards as described above
	 * @param number the number of decks to include (must be positive or it throws a Runtime Exception)
	 */
	public Deck(int number)
	{
	
		if (number <= 0) { throw new RuntimeException("You can build 1 or more decks"); }
		cards = new ArrayList<>();
		for (int decksToBuild = 0; decksToBuild < number; decksToBuild++) {
			for (Suit suitToBuild : Suit.values()) {
				for (Rank rankToBuild : Rank.values()) {
					cards.add(new Card(suitToBuild, rankToBuild));
				}
			}
				
		}
		
	}
	
	/**
	 * Randomize the remaining cards in the deck
	 */
	public void shuffle()
	{
	}

	/**
	 * Remove one card from the deck and return it to the caller
	 * @return the removed card
	 */
	public Card draw()
	{
		return cards.remove(0);
	}

	/**
	 * The number of cards in the deck
	 * @return and integer
	 */
	public int getCardsRemaining()
	{
		return cards.size();
	}

	@Override
	public String toString()
	{
		return cards.toString();
	}
}