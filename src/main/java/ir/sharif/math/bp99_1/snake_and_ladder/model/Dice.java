package ir.sharif.math.bp99_1.snake_and_ladder.model;

import java.util.Random;
import java.util.TreeMap;

public class Dice {
    private TreeMap<Integer,Integer> chances;
    private Random random;

    public Dice(){
        random = new Random();
        chances = new TreeMap<>();

        for (int i=1;i<=6;++i)
            chances.put(i,1);
    }

    public int getRandom(){
        int total = 0;
        for(int i: chances.values())
            total+=i;
        int pick = random.nextInt(total);
        for(int a: chances.keySet()){
            pick -= chances.get(a);
            if(pick < 0)
                return a;
        }
        return -1;
    }

    public void addChance(int number,int chance){
        int newChance = chance;
        if(chances.containsKey(number))
            newChance += chances.get(number);
        if(newChance < 0)
            newChance = 0;
        chances.put(number,newChance);
    }
}
