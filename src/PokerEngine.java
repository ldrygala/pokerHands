import static java.util.Arrays.asList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PokerEngine {

	private static final Map<List<Integer>, Rank> RANKS_MAP = new HashMap<List<Integer>, Rank>();

	static {
		RANKS_MAP.put(asList(2, 1, 1, 1), Rank.ONE_PAIR);
		RANKS_MAP.put(asList(2, 2, 1), Rank.TWO_PAIRS);
		RANKS_MAP.put(asList(3, 1, 1), Rank.THREE);
		RANKS_MAP.put(asList(3, 2), Rank.FULL);
		RANKS_MAP.put(asList(4, 1), Rank.QUADS);
	}

	public static List<Integer> parse(String input) {
		String[] cards = input.split(" ");

		Map<Character, Integer> hand = new HashMap<Character, Integer>();

		for (String card : cards) {
			char figure = card.charAt(0);
			Integer count = hand.get(figure);
			if (count == null) {
				hand.put(figure, 1);
			} else {
				hand.put(figure, count + 1);
			}
		}

		List<Integer> values = new ArrayList<Integer>(hand.values());
		Collections.sort(values, Collections.reverseOrder());
		return values;
	}

	public static Rank getRank(String input) {
		List<Integer> values = parse(input);
		Rank rank = RANKS_MAP.get(values);
		if (rank != null) {
			return rank;
		} else if (values.size() == 5) {
			return Rank.STRAIGHT;
		} else {
			return null;
		}
	}
}
