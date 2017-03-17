import org.junit.Before;
import org.junit.Test;

import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class MatchTest {
    private String player1 = "Player 1";
    private String player2 = "Player 2";
    Match match;

    @Before
    public void setUp() throws Exception {
        match = new Match(player1, player2);
    }

    @Test
    public void shouldGetRightScoreForPoint() {
        assertEquals(match.score(), "0-0, 0-0");
        match.pointWonBy(player1);
        assertEquals(match.score(), "0-0, 15-0");
        match.pointWonBy(player2);
        assertEquals(match.score(), "0-0, 15-15");
        match.pointWonBy(player1);
        assertEquals(match.score(), "0-0, 30-15");
        match.pointWonBy(player1);
        assertEquals(match.score(), "0-0, 40-15");
        match.pointWonBy(player2);
        assertEquals(match.score(), "0-0, 40-30");
        match.pointWonBy(player2);
        assertEquals(match.score(), "0-0, Deuce");
        match.pointWonBy(player1);
        assertEquals(match.score(), "0-0, Advantage " + player1);
        match.pointWonBy(player1);
        assertEquals(match.score(), "1-0");
    }

    @Test
    public void shouldHaveAdvantage() throws Exception {
        IntStream.rangeClosed(1, 3).forEach((Integer) -> {
            match.pointWonBy(player1);
        });
        IntStream.rangeClosed(1, 4).forEach((Integer) -> {
            match.pointWonBy(player2);
        });
        assertEquals(match.score(), "0-0, Advantage " + player2);
    }

    @Test
    public void shouldHaveDeuce() throws Exception {
        IntStream.rangeClosed(1, 3).forEach((Integer) -> {
            match.pointWonBy(player1);
        });
        IntStream.rangeClosed(1, 3).forEach((Integer) -> {
            match.pointWonBy(player2);
        });
        assertEquals(match.score(), "0-0, Deuce");
        match.pointWonBy(player1);
        assertNotEquals(match.score(), "0-0, Deuce");
        match.pointWonBy(player2);
        assertEquals(match.score(), "0-0, Deuce");
    }

    @Test
    public void shouldHaveWinner() throws Exception {
        IntStream.rangeClosed(1, 4).forEach((Integer) -> {
            match.pointWonBy(player1);
        });
        IntStream.rangeClosed(1, 3).forEach((Integer) -> {
            match.pointWonBy(player2);
        });
        assertNotEquals(match.score(), "1-0");
        assertNotEquals(match.score(), "0-1");
        match.pointWonBy(player1);
        assertEquals(match.score(), "1-0");
    }

}