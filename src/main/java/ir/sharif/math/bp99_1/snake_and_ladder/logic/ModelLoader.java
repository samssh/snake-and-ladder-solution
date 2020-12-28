package ir.sharif.math.bp99_1.snake_and_ladder.logic;

import ir.sharif.math.bp99_1.snake_and_ladder.model.Board;
import ir.sharif.math.bp99_1.snake_and_ladder.model.Player;
import ir.sharif.math.bp99_1.snake_and_ladder.util.Config;

import java.io.*;
import java.util.Objects;
import java.util.Scanner;

public class ModelLoader {
    private final File boardFile, playersDirectory, archiveFile;


    /**
     * DO NOT CHANGE ANYTHING IN CONSTRUCTOR.
     */
    public ModelLoader() {
        boardFile = Config.getConfig("mainConfig").getProperty(File.class, "board");
        playersDirectory = Config.getConfig("mainConfig").getProperty(File.class, "playersDirectory");
        archiveFile = Config.getConfig("mainConfig").getProperty(File.class, "archive");
    }


    /**
     * read file "boardFile" and craete a Board
     *
     * you can use "BoardBuilder" class for this purpose.
     *
     * pay attention add your codes in "try".
     */
    // ***
    public Board loadBord() {
        try {
            Scanner scanner = new Scanner(boardFile);

            // Code Here


            return null;
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
            System.err.println("could not find board file");
            System.exit(-2);
        }
        return null;
    }

    /**
     * load player.
     * if no such a player exist, create an account(file) for him/her.
     *
     * you can use "savePlayer" method of this class for that purpose.
     *
     * add your codes in "try" block .
     */
    //***
    public Player loadPlayer(String name, int playerNumber) {
        try {


            // Code in this part

            File playerFile = getPlayerFile(name);
            Scanner scanner = new Scanner(playerFile);





            return null;

        }

        catch (FileNotFoundException | IllegalArgumentException e) {
            e.printStackTrace();
            System.err.println("could not find player file");
            System.exit(-2);
        }
        return null;
    }

    /**
     * if player does not have a file, create one.
     *
     * else update his/her file.
     *
     * add your codes in "try" block .
     *
     */
    //***
    public void savePlayer(Player player) {
        try {
            // add your codes in this part

            File file = getPlayerFile(player.getName());

            PrintWriter printWriter = new PrintWriter(file);



        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
            System.err.println("could not find player file");
            System.exit(-2);
        }
    }

    /**
     *
     * give you a name (player name), search for its file.
     * return the file if exist.
     * return null if not.
     *
     */
    //***
    private File getPlayerFile(String name) {




        return null;
    }

    //***
    public void archive(Player player1, Player player2) {
        try {
            PrintStream printStream = new PrintStream(new FileOutputStream(archiveFile, true));
            printStream.println("\n" + player1.getName() + " : " + player1.getScore());
            printStream.println(player2.getName() + " : " + player2.getScore());
            printStream.flush();
            printStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
