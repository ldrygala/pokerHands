import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by ldrygala on 2015-03-26.
 */
public class CardColorsTest {
    @Test
    public void shouldParseColor() {
        assertThat(CardColors.parseColor('H')).isEqualTo(CardColors.HEARTS);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenColorIsUnknown() {
        CardColors.parseColor('Z');
    }

}
