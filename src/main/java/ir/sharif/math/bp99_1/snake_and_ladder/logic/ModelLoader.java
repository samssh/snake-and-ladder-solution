package ir.sharif.math.bp99_1.snake_and_ladder.logic;

import ir.sharif.math.bp99_1.snake_and_ladder.model.Board;
import ir.sharif.math.bp99_1.snake_and_ladder.model.Player;
import ir.sharif.math.bp99_1.snake_and_ladder.util.Config;

import java.io.File;

public class ModelLoader {
    private final File boardFile, playersDirectory;


    public ModelLoader() {
        boardFile = Config.getConfig("mainConfig").getProperty(File.class,"board");
        playersDirectory = Config.getConfig("mainConfig").getProperty(File.class,"playersDirectory");
    }

    public Board loadBord(){

        // load board from file

        return null;
    }

    public Player loadPlayer(String name){

        // check if player exist load that or creat file for this player

        return null;
    }

    public void savePlayer(Player player){
        // save player at the end of the game
    }


}
