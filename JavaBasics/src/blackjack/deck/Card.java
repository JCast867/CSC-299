package blackjack.deck;

public class Card
{
	private Suit suit;
	private Rank rank;
	
	public Card(Suit suit, Rank rank)
	{
		super();
		this.suit = suit;
		this.rank = rank;
	}

	@Override
	public String toString()
	{
		return rank + " of " + suit;
	}

	public Suit getSuit()
	{
		return suit;
	}

	public Rank getRank()
	{
		return rank;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((rank == null) ? 0 : rank.hashCode());
		result = prime * result + ((suit == null) ? 0 : suit.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		if (rank != other.rank)
			return false;
		if (suit != other.suit)
			return false;
		return true;
	}
}