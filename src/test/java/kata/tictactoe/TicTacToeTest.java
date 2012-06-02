/* 
 * ============================================================================ 
 * Name      : TicTacToeTest.java
 * ============================================================================
 */
package kata.tictactoe;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * a game is over when all fields are taken a game is over when all fields in a column are taken by a player a game is
 * over when all fields in a row are taken by a player a game is over when all fields in a diagonal are taken by a
 * player a player can take a field if not already taken players take turns taking fields until the game is over
 */
public class TicTacToeTest {

    private Player player1;
    private Player player2;
    private TicTacToe ttt;

    @Before
    public void setUp() {
        player1 = new Player("Player1");
        player2 = new Player("Player2");
        ttt = new TicTacToe(player1, player2);
    }

    @After
    public void tearDown() {
        player1 = null;
        player2 = null;
        ttt = null;
    }

    /**
     * 
     */
    private void giveFieldsToPlayer(Player player, int[] fieldIds) {
        for (int i = 0; i < fieldIds.length; i++) {
            ttt.playerTakesField(player,fieldIds[i]);
        }
    }

    @Test
    public void gameShouldBeOverIfAllFieldsAreTaken() {
        giveFieldsToPlayer(player1, new int[] { 2, 3, 4, 7, 8 });
        assertThat(ttt.gameOver(player1, player2), is(false));
        giveFieldsToPlayer(player2, new int[] { 0, 1, 5 });
        assertThat(ttt.gameOver(player1, player2), is(false));
        giveFieldsToPlayer(player2, new int[] { 6 });
        assertThat(ttt.gameOver(player1, player2), is(true));
    }

    @Test
    public void gameShouldBeOverIfAllFieldsInColumnAreTakenByPlayer() {
        ttt.playerTakesField(player1,1);
        ttt.playerTakesField(player1,4);
        ttt.playerTakesField(player1,7);
        assertThat(ttt.gameOver(player1, player2), is(true));
    }

    @Test
    public void gameShouldBeOverIfAllFieldsInRowAreTakenByPlayer() {
        ttt.playerTakesField(player1,1);
        ttt.playerTakesField(player1,2);
        ttt.playerTakesField(player1,3);
        assertThat(ttt.gameOver(player1, player2), is(true));
    }

    @Test
    public void playerCanTakeFieldIfNotTaken() {
        ttt.playerTakesField(player1,1);
        assertThat(player1.totalNumberOfFieldsTaken(), is(1));
        ttt.playerTakesField(player1,1);
        assertThat(player1.totalNumberOfFieldsTaken(), is(1));
    }

    @Test
    public void playersTakeTurnsUntilGameOver() {
        System.out.println("Game");
        player1 = new Player("Player1");
        player2 = new Player("Player2");
        ttt = new TicTacToe(player1, player2);
        Random randomizer = new Random();
        while (!ttt.gameOver(player1, player2)) {
            boolean success = false;
            do {
                int fieldId = randomizer.nextInt(9);
                success = ttt.playerTakesField(player1,fieldId);
            } while (!success);
            if (ttt.gameOver(player1, player2)) {
                break;
            }
            success = false;
            do {
                int fieldId = randomizer.nextInt(9);
                success = ttt.playerTakesField(player2,fieldId);
            } while (!success);
            if (ttt.gameOver(player1, player2)) {
                break;
            }
        }
    }

}
