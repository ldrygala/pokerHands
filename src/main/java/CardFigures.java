public enum CardFigures {

    TWO('2', 2), THREE('3', 3), FOUR('4', 4), FIVE('5', 5), SIX('6', 6), SEVEN('7', 7), EIGHT('8', 8), NINE('9', 9), TEN('T', 11), JACK('J', 12), QUEEN('Q', 13), KING('K', 14), ACE('A', 15);

    private char stringRepresentation;
    private int prio;

    CardFigures(char stringRepresentation, int prio) {
        this.stringRepresentation = stringRepresentation;
        this.prio = prio;
    }

    public Card of(CardColors color) {
        return new Card(this, color);
    }

    public int getPrio() {
        return prio;
    }

    public static CardFigures parseFigure(char toParse) {
        for (CardFigures figure : CardFigures.values()) {
            if (toParse == figure.stringRepresentation) {
                return figure;
            }
        }
        throw new IllegalArgumentException();
    }

}
