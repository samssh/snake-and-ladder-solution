package ir.sharif.math.bp99_1.snake_and_ladder.model;

public class GameState {
    private final Board board;
    private final Player playerOne;
    private final Player playerTwo;
    private int turn;
    private boolean finished;

    public GameState(Board board,Player playerOne,Player playerTwo){
        this.board = board;
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        turn = 0;
        finished = false;
    }

    public Board getBoard() {
        return board;
    }

    public Player getPlayerOne() {
        return playerOne;
    }

    public Player getPlayerTwo() {
        return playerTwo;
    }

    public Player getPlayer(int i){
        if(i==0) return playerOne;
        else return playerTwo;
    }

    public Player getCurrentPlayer(){
        return getPlayer(turn);
    }

    public boolean isFinished() {
        return finished;
    }

    public void finish(){
        finished = true;
    }

    public void nextTurn(){
        turn = 1 - turn;

    }


}
