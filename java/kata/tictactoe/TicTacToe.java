/* 
 * ============================================================================ 
 * Name      : TicTacToe.java
 * ============================================================================
 */
package kata.tictactoe;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 
 *
 */
public class TicTacToe {

    private static final int NUMBER_OF_FIELDS_TAKEN_REQUIRED_FOR_GAME_OVER = 9;
    private static final int NUMBER_OF_FIELDS_TAKEN_IN_COLUMN_REQUIRED_FOR_GAME_OVER = 3;
    private static final int NUMBER_OF_FIELDS_TAKEN_IN_ROW_REQUIRED_FOR_GAME_OVER = 3;

    private Map<Integer, Field> fields = new LinkedHashMap<Integer, Field>();

    /**
     * @param fields
     */
    public TicTacToe(Player player1, Player player2) {
        super();
        prepareGame();
    }

    /**
     * 
     */
    private void prepareGame() {
        for (int i = 0; i < 9; i++) {
            Field field = new Field(i);
            fields.put(i, field);
        }
    }

    /**
     * @return
     */
    public Boolean gameOver(Player player1, Player player2) {
        boolean gameOver = false;
        int takenFields = player1.totalNumberOfFieldsTaken() + player2.totalNumberOfFieldsTaken();
        if (takenFields >= TicTacToe.NUMBER_OF_FIELDS_TAKEN_REQUIRED_FOR_GAME_OVER) {
            gameOver = true;
            System.out.println("Game Over - draw");
        }
        if (player1.hasTakenColumn()) {
            gameOver = true;
            System.out.println("Game Over - column taken by " + player1.getName());
        } else if (player2.hasTakenColumn()) {
            gameOver = true;
            System.out.println("Game Over - column taken by " + player2.getName());
        } else if (player1.hasTakenRow()) {
            gameOver = true;
            System.out.println("Game Over - row taken by " + player1.getName());
        } else if ( player2.hasTakenRow()) {
            gameOver = true;
            System.out.println("Game Over - row taken by " + player2.getName());
        }
        return gameOver;
    }

    /**
     * @param field
     * @param player
     * @return
     */
    public boolean playerTakesField(Player player, int fieldId) {
        Field field = fields.remove(fieldId);
        if (field != null) {
            System.out.println(player.getName() + " takes field " + fieldId);
            return player.take(field);
        }
        return false;
    }

}
