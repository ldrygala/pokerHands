import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by ldrygala on 2015-03-26.
 */
public class CardFiguresTest {
    @Test
    public void shouldParseFigure() {
        assertThat(CardFigures.parseFigure('7')).isEqualTo(CardFigures.SEVEN);
    }


    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenFigureIsUnknown() {
        CardColors.parseColor('Z');
    }

}
