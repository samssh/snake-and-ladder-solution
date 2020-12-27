package ir.sharif.math.bp99_1.snake_and_ladder.graphic.Listeners;

import ir.sharif.math.bp99_1.snake_and_ladder.graphic.GraphicalAgent;
import ir.sharif.math.bp99_1.snake_and_ladder.graphic.models.GraphicalCell;

import java.awt.event.MouseEvent;

public class BoardMouseListener implements DummyListener {
    private final GraphicalAgent graphicalAgent;

    public BoardMouseListener(GraphicalAgent graphicalAgent) {
        this.graphicalAgent = graphicalAgent;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        int xa = e.getX();
        int ya = e.getY();
        graphicalAgent.clickRequest((ya / GraphicalCell.CELL_SIZE) + 1, (xa / GraphicalCell.CELL_SIZE) + 1);
        /**   TO DO ...
         *     try to send xa and ya to logic .
         *     if these cordinates are valid :
         *
         *     a) if there is no selected pawn, select a pawn
         *     b) if there is a selected pawn , try to move the pawn to the destination
         *
         *
         *
         */

    }
}
