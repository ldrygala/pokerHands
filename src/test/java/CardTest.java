import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by ldrygala on 2015-03-26.
 */
public class CardTest {

    @Test
    public void shouldParseCard() throws Exception {
        assertThat(Card.parseCard("7H")).isEqualTo(CardFigures.SEVEN.of(CardColors.HEARTS));
    }
}
