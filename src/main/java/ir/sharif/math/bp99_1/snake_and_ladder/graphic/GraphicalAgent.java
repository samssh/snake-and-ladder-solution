package ir.sharif.math.bp99_1.snake_and_ladder.graphic;


import ir.sharif.math.bp99_1.snake_and_ladder.graphic.models.GraphicalGameState;
import ir.sharif.math.bp99_1.snake_and_ladder.graphic.panel.BoardPanel;
import ir.sharif.math.bp99_1.snake_and_ladder.graphic.panel.MainPanel;
import ir.sharif.math.bp99_1.snake_and_ladder.graphic.panel.PlayerInfoPanel;
import ir.sharif.math.bp99_1.snake_and_ladder.logic.LogicalAgent;
import ir.sharif.math.bp99_1.snake_and_ladder.model.GameState;
import ir.sharif.math.bp99_1.snake_and_ladder.model.Player;

import javax.swing.*;

/**
 * this class is a connection between the graphic and logics
 */
public class GraphicalAgent {
    private final LogicalAgent logicalAgent; // maybe deleted
    private final Object paintLock;
    private GraphicalGameState graphicalGameState;
    private Frame frame;

    public GraphicalAgent(LogicalAgent logicalAgent) {
        this.logicalAgent = logicalAgent;
        this.paintLock = new Object();
    }

    /**
     * this method get game state and build or update a graphical models
     * and save this models somewhere
     */
    public void update(GameState gameState) {
        synchronized (paintLock) {
            new GraphicalGameStateBuilder(gameState).update(this.graphicalGameState);
        }
    }

    public void initialize(GameState gameState) {
        this.graphicalGameState = new GraphicalGameStateBuilder(gameState).build();
        this.frame = initializePanels();
    }

    private Frame initializePanels() {
        PlayerInfoPanel player1Info = new PlayerInfoPanel(graphicalGameState.getPlayer1(), this, 1);
        PlayerInfoPanel player2Info = new PlayerInfoPanel(graphicalGameState.getPlayer2(), this, 2);
        BoardPanel boardPanel = new BoardPanel(graphicalGameState.getBoard(), this);
        MainPanel mainPanel = new MainPanel(boardPanel, player1Info, player2Info);
        return new Frame(mainPanel);
    }

    public void loadFirstPlayer(String name) {

    }

    public void loadSecondPlayer(String name) {

    }

    public void diceRequest(int player) {
        /**
         *  TO DO
         *  SEND REQUEST TO LOGIC , TO ROLL A DICE FOR THIS PLAYER;
         *
         *  THEN SEND NUMBER ON THE DICE TO GRAPHIC, SO WE CAN SHOW THAT.
         *
         *  DON'T FORGET TO UPDATE GRAPHICAL GAMESTATE AND SPECIALLY
         *  GRAPHICAL PLAYER ( diceNumber field )
         *
         */
    }

    public void clickRequest(int x , int y){
        /**
         *  TO DO
         *  WE SEND X , Y TO LOGIC, LOGIC SHOULD DECIDE WEATHER WE CHOOSE
         *  A PIECE , OR WE WANT TO MOVE A (ALREADY) CHOSEN PIECE TO A NEW CORDINATES.
         *
         *  I SUGGEST LOGIC SEND BACK A BOOLEAN (OR STRING ), SO WE UNDERSTAND IF
         *  OUR REQUEST IS DONE OR NOT .
         *
         *
         */
    }

    public void changecolorRequest(int player , int piece , String color){

        /**
         * TO DO
         * SEND A REQUEST TO LOGIC THAT PLAYER # WANT TO CHANGE THE COLOR OF
         * ONE OF HIS PIECES .
         *
         *
         * NOT FORGOT TO UPDATE THE GRAPHIC AFTER THIS REQUEST.
         */

    }

    public boolean requestStart(int player){

        /**
         *
         * TO DO
         * SEND A REQUEST TO LOGIC THAT PLAYER # IS READY .
         *
         * IF PLAYER SEND THIS REQUEST TWICE, HIS READYNESS WILL BE CANCLED .
         *
         *  I SUGGEST LOGIC SEND BACK A BOOLEAN (OR STRING ), SO WE UNDERSTAND IF
         *  OUR REQUEST IS DONE OR NOT .
         *
         *  I ALSO SUGGEST AFTER THE GAME IS START , THE START BUTTON DEACTIVATE
         *  AND LISTENERS FROM PIECE LABELS, REMOVE( SO PLAYER CAN'T  CHANGE THEM
         *  DURING GAME )
         *
         * NOT FORGOT TO UPDATE THE GRAPHIC AFTER THIS REQUEST.
         */

        return true;
    }


    public void move(Player p, int startX, int startY, int endX, int endY) {

    }

    public Object getPaintLock() {
        return paintLock;
    }

    public String getPlayerNames(int number) {
        String[] s = new String[]{"first", "second"};
        String result;
        do {
            result = JOptionPane.showInputDialog(frame, "Enter " + s[number - 1] + " player name ");
        } while (result == null);
        return result;
    }
}
