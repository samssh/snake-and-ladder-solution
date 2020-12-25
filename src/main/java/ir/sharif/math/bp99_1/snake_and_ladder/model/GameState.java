package ir.sharif.math.bp99_1.snake_and_ladder.model;

public class GameState {
    private final Board board;
    private final Player player1;
    private final Player player2;
    private int turn;
    private boolean finished;

    public GameState(Board board, Player player1, Player player2) {
        this.board = board;
        this.player1 = player1;
        this.player2 = player2;
        turn = 0;
        finished = false;
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
        else throw new IllegalArgumentException();
    }

    public Player getCurrentPlayer() {
        return getPlayer(turn);
    }

    public boolean isFinished() {
        return finished;
    }

    public void finish() {
        finished = true;
    }

    public void nextTurn() {
        turn = 1 - turn;
    }

    @Override
    public String toString() {
        return "GameState{" +
                "board=" + board +
                ", playerOne=" + player1 +
                ", playerTwo=" + player2 +
                ", turn=" + turn +
                ", finished=" + finished +
                '}';
    }
}
