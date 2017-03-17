import org.junit.Test;

import java.util.stream.IntStream;

import static org.junit.Assert.*;

public class PlayerTest {
    @Test
    public void pointWonBy() throws Exception {
        Player player1 = new Player("player 1");
        Player player2 = new Player("player 2");
        IntStream.rangeClosed(1, 3).forEach((Integer) -> {
            player1.winPoint();
        });
        IntStream.rangeClosed(1, 4).forEach((Integer) -> {
            player2.winPoint();
        });
        assertEquals(player1.getPoint(), 3);
        assertEquals(player2.getPoint(), 4);
    }

    @Test
    public void getScore() throws Exception {
        Player player = new Player("player");
        assertEquals(player.getScore(), "0");
        player.winPoint();
        assertEquals(player.getScore(), "15");
        player.winPoint();
        assertEquals(player.getScore(), "30");
        player.winPoint();
        assertEquals(player.getScore(), "40");
    }

}