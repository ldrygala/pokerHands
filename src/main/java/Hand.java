import java.util.*;

public class Hand {
    private List<Card> cards;

    public Hand(Card... cards) {
        this.cards = Arrays.asList(cards);
    }

    public Hand(List<Card> cards) {
        this.cards = cards;
    }

    public static Hand parseHand(String hand) {
        String[] cardsString = hand.split(" ");
        List<Card> tmpCards = new ArrayList<Card>();
        for (String card : cardsString) {
            tmpCards.add(Card.parseCard(card));
        }
        return new Hand(tmpCards);
    }

    public Map<CardFigures, Integer> buildSortedOccurrenceMap() {
        Map<CardFigures, Integer> occurrenceMap = buildOccurrenceMap();
        return sortOccurrenceMap(occurrenceMap);
    }

    public boolean isBetterThen(Hand other) {
        int thisRank = Ranks.getRank(this).getRank();
        int otherRank = Ranks.getRank(other).getRank();
        if (thisRank > otherRank) {
            return true;
        } else if (thisRank == otherRank) {
            return isHighCardBetterThen(other);
        } else {
            return false;
        }
    }

    private boolean isHighCardBetterThen(Hand other) {
        Iterator<CardFigures> thisFigures = this.buildSortedOccurrenceMap().keySet().iterator();
        Iterator<CardFigures> otherFigures = other.buildSortedOccurrenceMap().keySet().iterator();
        while (thisFigures.hasNext() && otherFigures.hasNext()) {
            int thisPrio = thisFigures.next().getPrio();
            int otherPrio = otherFigures.next().getPrio();
            if (thisPrio != otherPrio) {
                return thisPrio > otherPrio;
            }
        }
        throw new IllegalArgumentException("hands are equal");
    }

    public boolean isColor() {
        Set<CardColors> colors = new HashSet<CardColors>();
        for (Card card : cards) {
            colors.add(card.getColor());
        }
        return colors.size() == 1;
    }

    private Map<CardFigures, Integer> buildOccurrenceMap() {
        Map<CardFigures, Integer> occurrenceMap = new HashMap<CardFigures, Integer>();
        for (Card card : cards) {
            Integer occurrence = occurrenceMap.get(card.getCardFigures());
            if (occurrence == null) {
                occurrenceMap.put(card.getCardFigures(), 1);
            } else {
                occurrenceMap.put(card.getCardFigures(), occurrence + 1);
            }
        }
        return occurrenceMap;
    }

    private TreeMap<CardFigures, Integer> sortOccurrenceMap(Map<CardFigures, Integer> occurrenceMap) {
        TreeMap<CardFigures, Integer> sortedMap = new TreeMap<CardFigures, Integer>(new OccurrenceComparator(occurrenceMap));
        sortedMap.putAll(occurrenceMap);
        return sortedMap;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Hand hand = (Hand) o;

        if (cards != null ? !cards.equals(hand.cards) : hand.cards != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return cards != null ? cards.hashCode() : 0;
    }
}
