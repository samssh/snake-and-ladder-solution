package ir.sharif.math.bp99_1.snake_and_ladder.model;

public class GameState {
    private final Board board;
    private final Player player1;
    private final Player player2;
    private int turn;

    public GameState(Board board, Player player1, Player player2) {
        this.board = board;
        this.player1 = player1;
        this.player2 = player2;
        turn = 0;
    }

    public Board getBoard() {
        return board;
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public Player getPlayer(int i) {
        if (i == 1) return player1;
        else if (i == 2) return player2;
        else return null;
    }

    public Player getCurrentPlayer() {
        if (turn == 0)
            return null;
        return getPlayer(2 - turn % 2);
    }

    public boolean isStarted() {
        return turn != 0;
    }

    public int getTurn() {
        return turn;
    }

    public void start() {
        turn = 1;
    }

    public void nextTurn() {
        getCurrentPlayer().endTurn();
        turn++;
    }

    @Override
    public String toString() {
        return "GameState{" +
                "board=" + board +
                ", playerOne=" + player1 +
                ", playerTwo=" + player2 +
                ", turn=" + turn +
                '}';
    }
}
