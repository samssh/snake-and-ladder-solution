package ir.sharif.math.bp99_1.snake_and_ladder.graphic;

import ir.sharif.math.bp99_1.snake_and_ladder.graphic.panel.MainPanel;
import ir.sharif.math.bp99_1.snake_and_ladder.util.Config;
import ir.sharif.math.bp99_1.snake_and_ladder.util.Loop;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {
    private int fps;
    private final MainPanel mainPanel;

    public Frame(MainPanel mainPanel) {
        this.mainPanel = mainPanel;
        this.config();
        initialize();
        new Loop(fps, this::update).start();
    }

    private void initialize() {
        this.setContentPane(mainPanel);
    }

    private void config() {
        Config frameConfig = Config.getConfig("frame");
        setSize(new Dimension(frameConfig.getProperty(Integer.class, "width")
                , frameConfig.getProperty(Integer.class, "height")));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(frameConfig.getProperty(Boolean.class, "resizable"));
        setUndecorated(frameConfig.getProperty(Boolean.class, "undecorated"));
        setTitle(frameConfig.getProperty(String.class, "title"));
        fps = frameConfig.getProperty(Integer.class, "fps");
        this.setLayout(null);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    @Override
    public void setContentPane(Container contentPane) {
        super.setContentPane(contentPane);
        super.revalidate();
        super.repaint(1L);
        super.pack();
    }

    private void update() {
        super.revalidate();
        super.repaint();
    }
}
