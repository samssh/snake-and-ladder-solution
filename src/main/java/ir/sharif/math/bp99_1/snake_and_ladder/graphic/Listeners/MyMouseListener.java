package ir.sharif.math.bp99_1.snake_and_ladder.graphic.Listeners;

import ir.sharif.math.bp99_1.snake_and_ladder.graphic.panel.MainPanel;
import ir.sharif.math.bp99_1.snake_and_ladder.graphic.panel.PlayerInfoPanel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

public class MyMouseListener implements MouseListener{

    private MainPanel p ;
    private PlayerInfoPanel pi;

    public MyMouseListener(MainPanel p, PlayerInfoPanel pi) {
        this.p = p;
        this.pi = pi;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Random r = new Random();
        int ra = r.nextInt(10);
        p.changeTurn(pi , ra);
    }

    @Override
    public void mousePressed(MouseEvent e) {

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
