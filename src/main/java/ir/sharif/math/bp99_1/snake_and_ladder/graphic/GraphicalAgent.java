package ir.sharif.math.bp99_1.snake_and_ladder.graphic;


import ir.sharif.math.bp99_1.snake_and_ladder.model.GameState;
import ir.sharif.math.bp99_1.snake_and_ladder.model.Player;

import java.util.List;

/**
 * this class is a connection between the graphic and logics
 */
public class GraphicalAgent {


    /**
     * this method get game state and build or update a graphical models
     * and save this models somewhere
     *
     *
     */
    public void update(GameState gameState){
        throw new RuntimeException("implement me");
    }

    public void loadFirstPlayer(String name){

    }

    public void loadSecondPlayer(String name){

    }

    public void diceRequest(Player p){

    }

    public void move(Player p , int startX , int startY , int endX , int endY){

    }
}
