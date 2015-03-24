import java.util.HashMap;
import java.util.Map;

public enum CardColors {
	CLUBS, DIAMONDS, SPADES, HEARTS;
	private static Map<Character, CardColors> cardsColorMap;

	static {
		cardsColorMap = new HashMap<Character, CardColors>();
		cardsColorMap.put('C', CLUBS);
		cardsColorMap.put('D', DIAMONDS);
		cardsColorMap.put('S', SPADES);
		cardsColorMap.put('H', HEARTS);
	}

	public static CardColors parseColor(char charAt) {
		return cardsColorMap.get(charAt);
	}

}
