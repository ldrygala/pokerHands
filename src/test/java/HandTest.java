import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class HandTest {

    @Test
    public void shouldParseHand() throws Exception {
        assertThat(Hand.parseHand("7H 7D 2H 3H 4H")).isEqualTo(new Hand(CardFigures.SEVEN.of(CardColors.HEARTS), CardFigures.SEVEN.of(CardColors.DIAMONDS), CardFigures.TWO.of(CardColors.HEARTS), CardFigures.THREE.of(CardColors.HEARTS), CardFigures.FOUR.of(CardColors.HEARTS)));
    }

    @Test
    public void shouldCountOccurrenceForHand() throws Exception {
        Map<CardFigures, Integer> expectedMap = new HashMap<CardFigures, Integer>();
        expectedMap.put(CardFigures.SEVEN, 2);
        expectedMap.put(CardFigures.FOUR, 1);
        expectedMap.put(CardFigures.THREE, 1);
        expectedMap.put(CardFigures.TWO, 1);

        assertThat(Hand.parseHand("7H 7D 2H 3H 4H").buildSortedOccurrenceMap()).isEqualTo(expectedMap);
    }

    @Test
    public void shouldRecognizeColorWhenIsDefine() throws Exception {
        assertThat(Hand.parseHand("2D 3D 4D 5D 6D").isColor()).isTrue();
    }

    @Test
    public void shouldRecognizeColorWhenIsNotDefine() throws Exception {
        assertThat(Hand.parseHand("2D 3D 4H 5D 6D").isColor()).isFalse();
    }

    @Test
    public void shouldGetRankOfHand() throws Exception {
        assertThat(Ranks.getRank(Hand.parseHand("7H 7D 2H 3H 4H"))).isEqualTo(Ranks.ONE_PAIR);
    }

}
