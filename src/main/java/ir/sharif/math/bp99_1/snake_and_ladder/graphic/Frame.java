package ir.sharif.math.bp99_1.snake_and_ladder.graphic;

import ir.sharif.math.bp99_1.snake_and_ladder.util.Loop;

import javax.swing.*;
import java.awt.*;

/**
 * contains <code> javax.swing.JFrame </code>
 * tasks:
 * add some timer to update frame automatically
 * building frame by configuration attributes
 */
public class Frame extends JFrame {

    private int fps;

    public Frame() {
        this.config();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        new Loop(fps, this::update).start();
    }

    private void config() {

    }

    @Override
    public void setContentPane(Container contentPane) {
        super.setContentPane(contentPane);
        super.revalidate();
        super.repaint();
    }

    private void update() {
        super.revalidate();
        super.repaint();
    }
}
