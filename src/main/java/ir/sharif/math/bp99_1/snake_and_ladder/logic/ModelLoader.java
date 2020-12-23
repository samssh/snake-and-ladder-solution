package ir.sharif.math.bp99_1.snake_and_ladder.logic;

import ir.sharif.math.bp99_1.snake_and_ladder.model.Board;
import ir.sharif.math.bp99_1.snake_and_ladder.model.Player;
import ir.sharif.math.bp99_1.snake_and_ladder.util.Config;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

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
        File playerFile = getPlayerFile(name);
        try {
            Scanner scanner = new Scanner(playerFile);

            scanner.next();
            scanner.next();
            int id = scanner.nextInt();

            scanner.next();
            scanner.next();
            String playerName = scanner.next(); //  name

            scanner.next();
            scanner.next();
            int point = scanner.nextInt();

            scanner.close();

            return new Player(id,name,point);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (NullPointerException e){
            return null;
        }
        return null;
    }

    public void savePlayer(Player player){
        // save player at the end of the game
        File file = getPlayerFile(player.getName());
        try {
            PrintWriter printWriter = new PrintWriter(file);
            printWriter.println(player.toString());
            printWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private File getPlayerFile(String name){
        for(String fileName : playersDirectory.list()){
            String playerName = fileName.substring(0,fileName.indexOf('_'));
            if(playerName.equals(name))
                return new File(playersDirectory.getPath()+fileName);
        }
        return null;
    }

}
