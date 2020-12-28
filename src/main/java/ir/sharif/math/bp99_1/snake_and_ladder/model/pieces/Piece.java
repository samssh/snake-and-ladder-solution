package ir.sharif.math.bp99_1.snake_and_ladder.model.pieces;

import ir.sharif.math.bp99_1.snake_and_ladder.model.Cell;
import ir.sharif.math.bp99_1.snake_and_ladder.model.Color;
import ir.sharif.math.bp99_1.snake_and_ladder.model.Player;

public class Piece {
    private Cell currentCell;
    private final Color color;
    private final Player player;
    private boolean isSelected;

    public Piece(Player player, Color color) {
        this.color = color;
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    public Color getColor() {
        return color;
    }

    public Cell getCurrentCell() {
        return currentCell;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public void setCurrentCell(Cell currentCell) {
        this.currentCell = currentCell;
    }

    /**
     * @param destination
     * @param diceNumber
     * @return "true" if your movement is valid  , else return " false"
     *
     * In this method, you should check if the movement is valid of not.
     *
     * You can use some methods ( they are recomendded )
     *
     * 1) "canEnter" method in class "Cell"
     *
     * if your movement is valid, return "true" , else return " false"
     */
    //***
    public boolean isValidMove(Cell destination, int diceNumber) {






        return false;
    }

    /**
     * @param destination
     *
     * move selected piece from "currentCell" to "destination"
     *
     */
    public void moveTo(Cell destination) {

    }
}
