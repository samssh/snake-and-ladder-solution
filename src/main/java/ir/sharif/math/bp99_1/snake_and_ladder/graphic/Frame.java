package ir.sharif.math.bp99_1.snake_and_ladder.graphic;

import ir.sharif.math.bp99_1.snake_and_ladder.graphic.panel.MainPanel;
import ir.sharif.math.bp99_1.snake_and_ladder.model.GameState;
import ir.sharif.math.bp99_1.snake_and_ladder.util.Loop;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {

    private MainPanel m;
    private int fps;

    public Frame(String p1 , String p2) {              // this constructor is just for test
        this.config();
        new Loop(fps, this::update).start();
        initialize(p1,p2);
    }


/*    public Frame(GameState gs)  { */

/*    }        */                                               /** this is the main constructor
                                                            it should get sth like GameState, and then
                                                            create the graphic part of the project */




    private void initialize(String player1 , String player2) {          /** this func is also need GmaeState , for test i use two string */

        m = new MainPanel(player1, player2, 1024, 1024);        //
        m.setBounds(0, 0, 1280, 720);
        setContentPane(m);

//
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
        super.repaint();
    }

    private void update() {
        super.revalidate();
        super.repaint();
    }
}
