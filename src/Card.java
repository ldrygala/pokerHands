public class Card {

	private final CardColors color;
	private final CardFigures cardFigures;

	public Card(CardFigures cardFigures, CardColors color) {
		this.cardFigures = cardFigures;
		this.color = color;
	}

	public CardFigures getCardFigures() {
		return cardFigures;
	}

	public CardColors getColor() {
		return color;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((cardFigures == null) ? 0 : cardFigures.hashCode());
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		if (cardFigures != other.cardFigures)
			return false;
		if (color != other.color)
			return false;
		return true;
	}

}
