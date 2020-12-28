package ir.sharif.math.bp99_1.snake_and_ladder.model;

import java.util.Map;

public class Dice {

    /**
     * add some fields to store :
     * 1) chance of each dice number ( primary chance of each number, should be 1 )
     *      currently our dice has 1 to 6.
     * 2) generate a random number
     *
     */


    /**
     * initialize the fields.
     */
    public Dice() {


    }

    /**
     * create an algorithm generate a random number(between 1 to 6) according to the
     * chance of each dice number( you store them somewhere)
     *
     * return the generated number
     */
    //***
    public int roll() {



        return 0;
    }

    /**
     *
     * give a dice number and a chance, you should UPDATE chance
     * of that number.
     *
     * pay attention chance of none of the numbers must not be negetive(it can be zero)
     *
     */
    public void addChance(int number, int chance) {

    }

    //***
    public String getDetails() {
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<Integer, Integer> entry : chances.entrySet()) {
            builder.append(entry.getKey());
            builder.append(" with ");
            builder.append(entry.getValue());
            builder.append(" chance\n");
        }
        return builder.toString();
    }
}
