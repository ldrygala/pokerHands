import java.util.HashMap;
import java.util.Map;

public enum CardFigures {
	TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE;

	private static Map<Character, CardFigures> cardsFiguresMap;

	static {
		cardsFiguresMap = new HashMap<Character, CardFigures>();
		cardsFiguresMap.put('2', TWO);
		cardsFiguresMap.put('3', THREE);
		cardsFiguresMap.put('4', FOUR);
		cardsFiguresMap.put('5', FIVE);
		cardsFiguresMap.put('6', SIX);
		cardsFiguresMap.put('7', SEVEN);
		cardsFiguresMap.put('8', EIGHT);
		cardsFiguresMap.put('9', NINE);
		cardsFiguresMap.put('T', TEN);
		cardsFiguresMap.put('J', JACK);
		cardsFiguresMap.put('Q', QUEEN);
		cardsFiguresMap.put('K', KING);
		cardsFiguresMap.put('A', ACE);
	}

	public Card of(CardColors color) {
		return new Card(this, color);
	}

	public static CardFigures parseFigure(char charAt) {
		return cardsFiguresMap.get(charAt);
	}

}
