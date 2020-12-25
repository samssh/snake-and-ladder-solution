package ir.sharif.math.bp99_1.snake_and_ladder.graphic.Listeners;

import ir.sharif.math.bp99_1.snake_and_ladder.graphic.GraphicalAgent;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PieceMouseListener implements MouseListener {

    private GraphicalAgent graphicalAgent;

    public PieceMouseListener(GraphicalAgent graphicalAgent) {
        this.graphicalAgent = graphicalAgent;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        try {
            String[] myColor = new String[]{"red", "blue", "green", "yello"};
            String n = "";
            while (n.equalsIgnoreCase("")) {
                n = (String) JOptionPane.showInputDialog(null, "select piece color ",
                        "select", JOptionPane.QUESTION_MESSAGE, null, myColor, myColor[0]);
            }
            /**
             *  TO DO ...
             *
             *  send request to logic to chang color of picee
             *
             *
             */
        } catch (Exception e1) {
            e1.printStackTrace();
        }
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
