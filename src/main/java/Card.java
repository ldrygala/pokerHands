public class Card {

    public static final int FIGURE_INDEX = 0;
    public static final int COLOR_INDEX = 1;
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

    public static Card parseCard(String toParse) {
        return CardFigures.parseFigure(toParse.charAt(FIGURE_INDEX)).of(CardColors.parseColor(toParse.charAt(COLOR_INDEX)));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Card card = (Card) o;

        if (cardFigures != card.cardFigures) return false;
        if (color != card.color) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = color != null ? color.hashCode() : 0;
        result = 31 * result + (cardFigures != null ? cardFigures.hashCode() : 0);
        return result;
    }

}
