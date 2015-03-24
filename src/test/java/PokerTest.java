import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

public class PokerTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void shouldParseOnePair() {
		String input = "8C 8S KC 9H 4S";
		Rank rank = PokerEngine.getRank(input);

		assertThat(rank).isEqualTo(Rank.ONE_PAIR);
	}

	@Test
	public void shouldParseTwoPairs() {
		String input = "8C 8S KC KH 4S";
		Rank rank = PokerEngine.getRank(input);

		assertThat(rank).isEqualTo(Rank.TWO_PAIRS);
	}

	@Test
	public void shouldParseThree() {
		String input = "8C 8S 8H KH 4S";
		Rank rank = PokerEngine.getRank(input);

		assertThat(rank).isEqualTo(Rank.THREE);
	}

	@Test
	public void shouldParseFull() {
		String input = "8C 8S 8H 6D 6S";
		Rank rank = PokerEngine.getRank(input);

		assertThat(rank).isEqualTo(Rank.FULL);
	}

	@Test
	public void shouldParseQuads() {
		String input = "8C 8S 8H 8D 6S";
		Rank rank = PokerEngine.getRank(input);

		assertThat(rank).isEqualTo(Rank.QUADS);
	}

	@Test
	public void shouldParseStraight() {
		String input = "8C 9S TH JD QS";
		Rank rank = PokerEngine.getRank(input);

		assertThat(rank).isEqualTo(Rank.STRAIGHT);
	}

}
