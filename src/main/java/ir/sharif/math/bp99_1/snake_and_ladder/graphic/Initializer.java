package ir.sharif.math.bp99_1.snake_and_ladder.graphic;

import javax.swing.*;

/**
 * this class get the config file and build graphical objects like frame and empty models
 */
public class Initializer {

    public static void main(String[] args) {
        String player1 = JOptionPane.showInputDialog( "Enter first player name ");
        while (player1 == null) {
            player1 = JOptionPane.showInputDialog( "Enter first player name ");
        }
        String player2 = JOptionPane.showInputDialog( "Enter second player name ");
        while (player2 == null) {
            player2 = JOptionPane.showInputDialog("Enter second player name ");
        }

        /**
         *  WE SHOULD TRANSFER PLAYER NAMES TO LOGIC , THEN LOGIC LOAD THE DATAS ,
         *  THEN RETURN BACK STH AND AFTER THAT THE FRAME AND ITS COMPONENTS WILL BE COMPLETELY INITIALIZE
         *
         *
         *  FOR NOW ( FOR TEST ) WE CREATE THE FRAME WITH CONSTANT VALUES
         *
         **/

        new Frame(player1 , player2);
    }

}
