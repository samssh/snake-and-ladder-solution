package ir.sharif.math.bp99_1.snake_and_ladder.graphic;

import ir.sharif.math.bp99_1.snake_and_ladder.graphic.panel.BoardPanel;
import ir.sharif.math.bp99_1.snake_and_ladder.graphic.panel.MainPanel;
import ir.sharif.math.bp99_1.snake_and_ladder.graphic.panel.PlayerInfoPanel;
import ir.sharif.math.bp99_1.snake_and_ladder.util.Loop;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {

    static Frame myFrame = new Frame();

    private int fps;
    MainPanel m ;

    private Frame() {
        this.config();
        setLayout(null);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        new Loop(fps, this::update).start();

        initialize();

    }

    public static Frame getInstance(){
        return myFrame;
    }

    private void initialize(){
        String player1 = JOptionPane.showInputDialog(this , "Enter first player name ");
        while (player1 == null){
            player1 = JOptionPane.showInputDialog(this , "Enter first player name ");
        }
        String player2 = JOptionPane.showInputDialog(this , "Enter second player name ");
        while (player2 == null){
            player2 = JOptionPane.showInputDialog(this , "Enter second player name ");
        }

        /**
         *  WE SHOULD CREATE A METHOD TO LOAD THE DATA FROM FILES
         **/
        m =new MainPanel(player1,player2,1024,1024);
        m.setBounds(0,0,1280,720);
        add(m);
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
