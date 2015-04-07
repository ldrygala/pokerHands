public enum CardColors {
    CLUBS('C'), DIAMONDS('D'), SPADES('S'), HEARTS('H');

    private char stringRepresentation;

    CardColors(char stringRepresentation) {
        this.stringRepresentation = stringRepresentation;
    }


    public static CardColors parseColor(char toParse) {
        for (CardColors color : CardColors.values()) {
            if (toParse == color.stringRepresentation) {
                return color;
            }
        }
        throw new IllegalArgumentException();
    }

}
