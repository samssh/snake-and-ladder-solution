package ir.sharif.math.bp99_1.snake_and_ladder.logic;

import ir.sharif.math.bp99_1.snake_and_ladder.model.Board;
import ir.sharif.math.bp99_1.snake_and_ladder.model.Player;
import ir.sharif.math.bp99_1.snake_and_ladder.util.Config;

import java.io.*;
import java.util.Objects;
import java.util.Scanner;

public class ModelLoader {
    private final File boardFile, playersDirectory, archiveFile;


    public ModelLoader() {
        boardFile = Config.getConfig("mainConfig").getProperty(File.class, "board");
        playersDirectory = Config.getConfig("mainConfig").getProperty(File.class, "playersDirectory");
        archiveFile = Config.getConfig("mainConfig").getProperty(File.class, "archive");
    }

    public Board loadBord() {
        try {
            Scanner scanner = new Scanner(boardFile);
            StringBuilder boardData = new StringBuilder();
            while (scanner.hasNext()) {
                boardData.append(scanner.nextLine()).append("\n");
            }
            return new BoardBuilder(boardData.toString()).build();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.err.println("could not find board file");
            System.exit(-2);
        }

        return null;
    }

    public Player loadPlayer(String name , int playernumber) {
        // check if player exist load that or creat file for this player
        File playerFile = getPlayerFile(name);
        if (playerFile == null) {
            int id = Objects.requireNonNull(playersDirectory.list()).length;
            Player player = new Player(name,0,id,  playernumber);
            savePlayer(player);
            return player;
        }
        try {
            Scanner scanner = new Scanner(playerFile);
            scanner.next();
            scanner.next();
            int id = scanner.nextInt();
            scanner.next();
            scanner.next();
            String playerName = scanner.next();
            if (!name.equals(playerName))
                throw new IllegalArgumentException();
            scanner.next();
            scanner.next();
            int point = scanner.nextInt();
            scanner.close();
            return new Player(name, point,id , playernumber);
        } catch (FileNotFoundException | IllegalArgumentException e) {
            e.printStackTrace();
            System.err.println("could not find player file");
            System.exit(-2);
        }
        return null;
    }

    public void savePlayer(Player player) {
        File file = getPlayerFile(player.getName());
        if (file == null) {
            file = new File(playersDirectory.getPath() + "/" + player.getName() + "_" + player.getId() + ".player");
        }
        try {
            PrintWriter printWriter = new PrintWriter(file);
            printWriter.println(player.toString());
            printWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.err.println("could not find player file");
            System.exit(-2);
        }
    }

    private File getPlayerFile(String name) {
        for (String fileName : Objects.requireNonNull(playersDirectory.list())) {
            String playerName = fileName.substring(0, fileName.indexOf('_'));
            if (playerName.equals(name))
                return new File(playersDirectory.getPath() + "/" + fileName);
        }
        return null;
    }

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
