import com.google.common.collect.ImmutableMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;

public enum Ranks {
    HIGH_CARD(0), ONE_PAIR(1), TWO_PAIRS(2), THREE_OF_KIND(3), STRAIGHT(4), FLUSH(5), FULL_OF_HOUSE(6), FOUR_OF_KIND(7), STRAIGHT_FLUSH(8), ROYAL_FLUSH(9);
    private static final Map<List<Integer>, Ranks> pattern2Rank = ImmutableMap.<List<Integer>, Ranks>builder()
            .put(asList(2, 1, 1, 1), ONE_PAIR) //
            .put(asList(2, 2, 1), TWO_PAIRS) //
            .put(asList(3, 1, 1), THREE_OF_KIND) //
            .put(asList(4, 1), FOUR_OF_KIND) //
            .put(asList(3, 2), FULL_OF_HOUSE).build();
    public static final int FIRST = 0;
    public static final int LAST = 4;

    private int rank;

    Ranks(int rank) {
        this.rank = rank;
    }

    public int getRank() {
        return rank;
    }

    public static Ranks getRank(Hand hand) {
        Map<CardFigures, Integer> occurrence = hand.buildSortedOccurrenceMap();
        List<Integer> occurrencePattern = new ArrayList(occurrence.values());
        Ranks ranks = pattern2Rank.get(occurrencePattern);
        if (ranks == null) {
            List<CardFigures> cardFigures = new ArrayList(occurrence.keySet());
            if (cardFigures.get(FIRST).getPrio() - cardFigures.get(LAST).getPrio() == 4) {
                if (hand.isColor()) {
                    if (cardFigures.get(0) == CardFigures.ACE) {
                        ranks = ROYAL_FLUSH;
                    } else {
                        ranks = STRAIGHT_FLUSH;
                    }
                } else {
                    ranks = STRAIGHT;
                }
            } else if (hand.isColor()) {
                ranks = FLUSH;
            } else {
                ranks = HIGH_CARD;
            }
        }
        return ranks;
    }
}
