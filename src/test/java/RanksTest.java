import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RanksTest {

    @Test
    public void shouldRankHandAsHeightCard() throws Exception {
        assertThat(Ranks.getRank(Hand.parseHand("2H 4D 7D JD AH"))).isEqualTo(Ranks.HIGH_CARD);
    }

    @Test
    public void shouldRankHandAsOnePair() throws Exception {
        assertThat(Ranks.getRank(Hand.parseHand("7H 8D 2D 7D 4H"))).isEqualTo(Ranks.ONE_PAIR);
    }

    @Test
    public void shouldRankHandAsTwoPairs() throws Exception {
        assertThat(Ranks.getRank(Hand.parseHand("7H 8D 8D 7D 4H"))).isEqualTo(Ranks.TWO_PAIRS);
    }

    @Test
    public void shouldRankHandAsThreeOfKind() throws Exception {
        assertThat(Ranks.getRank(Hand.parseHand("7H 7D 8D 7D 4H"))).isEqualTo(Ranks.THREE_OF_KIND);
    }

    @Test
    public void shouldRankHandAsFourOfKind() throws Exception {
        assertThat(Ranks.getRank(Hand.parseHand("7H 7D 7D 7D 4H"))).isEqualTo(Ranks.FOUR_OF_KIND);
    }

    @Test
    public void shouldRankHandAsFullOfHouse() throws Exception {
        assertThat(Ranks.getRank(Hand.parseHand("7H 7D 7D 4D 4H"))).isEqualTo(Ranks.FULL_OF_HOUSE);
    }

    @Test
    public void shouldRankHandAsStraight() throws Exception {
        assertThat(Ranks.getRank(Hand.parseHand("2H 3D 4D 5D 6H"))).isEqualTo(Ranks.STRAIGHT);
    }

    @Test
    public void shouldRankHandAsFlush() throws Exception {
        assertThat(Ranks.getRank(Hand.parseHand("2D 3D 4D 5D 8D"))).isEqualTo(Ranks.FLUSH);
    }

    @Test
    public void shouldRankHandAsStraightFlush() throws Exception {
        assertThat(Ranks.getRank(Hand.parseHand("2D 3D 4D 5D 6D"))).isEqualTo(Ranks.STRAIGHT_FLUSH);
    }

    @Test
    public void shouldRankHandAsRoyalFlush() throws Exception {
        assertThat(Ranks.getRank(Hand.parseHand("TD JD QD KD AD"))).isEqualTo(Ranks.ROYAL_FLUSH);
    }

    @Test
    public void twoPairsShouldBeBetterThenOnePair() throws Exception {
        assertThat(Hand.parseHand("7H 8D 8D 7D 4H").isBetterThen(Hand.parseHand("7H 8D 2D 7D 4H"))).isTrue();
    }

    @Test
    public void fullOfHouseWithTreeFoursShouldBeBetterThenFullOfHouseWithThreeThrees() throws Exception {
        assertThat(Hand.parseHand("2H 2D 4C 4D 4S").isBetterThen(Hand.parseHand("3C 3D 3S 9S 9D"))).isTrue();
    }
}