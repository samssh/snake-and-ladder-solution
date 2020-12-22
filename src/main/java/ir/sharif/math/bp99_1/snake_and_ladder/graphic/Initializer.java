package ir.sharif.math.bp99_1.snake_and_ladder.graphic;

import ir.sharif.math.bp99_1.snake_and_ladder.graphic.models.GraphicalGameState;
import ir.sharif.math.bp99_1.snake_and_ladder.graphic.panel.BoardPanel;
import ir.sharif.math.bp99_1.snake_and_ladder.graphic.panel.MainPanel;
import ir.sharif.math.bp99_1.snake_and_ladder.graphic.panel.PlayerInfoPanel;

import javax.swing.*;

/**
 * this class get the config file and build graphical objects like frame and empty models
 */
public class Initializer {
//    private String player1, player2;

    public static void initializePanels(GraphicalGameState gameState, GraphicalAgent agent) {
        PlayerInfoPanel player1Info = new PlayerInfoPanel(gameState.getPlayer1(), agent, 1);
        PlayerInfoPanel player2Info = new PlayerInfoPanel(gameState.getPlayer2(), agent, 2);
        BoardPanel boardPanel = new BoardPanel(gameState.getBoard(), agent);
        MainPanel mainPanel = new MainPanel(boardPanel, player1Info, player2Info);
        Frame frame = new Frame();
        frame.setContentPane(mainPanel);

    }

}
