package ir.sharif.math.bp99_1.snake_and_ladder.graphic.panel;

import ir.sharif.math.bp99_1.snake_and_ladder.util.Config;

import javax.swing.*;

public class MainPanel extends JPanel {
    private final BoardPanel boardPanel;
    private final PlayerInfoPanel player1InfoPanel, player2InfoPanel;

    public MainPanel(BoardPanel boardPanel, PlayerInfoPanel player1InfoPanel, PlayerInfoPanel player2InfoPanel) {
        this.boardPanel = boardPanel;
        this.player1InfoPanel = player1InfoPanel;
        this.player2InfoPanel = player2InfoPanel;
        initialize();
    }

    private void initialize() {
        config();
        this.add(boardPanel);
        this.add(player1InfoPanel);
        this.add(player2InfoPanel);
    }

    private void config() {
        Config config = Config.getConfig("mainPanel");
        setBounds(config.getProperty(Integer.class, "x"), config.getProperty(Integer.class, "y")
                , config.getProperty(Integer.class, "width"), config.getProperty(Integer.class, "height"));
        setLayout(null);
    }


}