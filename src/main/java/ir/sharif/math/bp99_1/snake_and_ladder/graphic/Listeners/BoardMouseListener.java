package ir.sharif.math.bp99_1.snake_and_ladder.graphic.Listeners;

import ir.sharif.math.bp99_1.snake_and_ladder.graphic.GraphicalAgent;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class BoardMouseListener implements MouseListener {
    private final GraphicalAgent graphicalAgent;

    public BoardMouseListener(GraphicalAgent graphicalAgent) {
        this.graphicalAgent = graphicalAgent;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        int xa = e.getX();
        int ya = e.getY();

        graphicalAgent.clickRequest((ya/80)+1 , (xa/80)+1);


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

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
