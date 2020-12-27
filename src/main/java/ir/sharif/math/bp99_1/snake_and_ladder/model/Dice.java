package ir.sharif.math.bp99_1.snake_and_ladder.model;

import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

public class Dice {
    private final TreeMap<Integer, Integer> chances;
    private final Random random;

    public Dice() {
        random = new Random();
        chances = new TreeMap<>();

        for (int i = 1; i <= 6; ++i)
            chances.put(i, 1);
    }

    public int roll() {
        int total = 0;
        for (int i : chances.values())
            total += i;
        int pick = random.nextInt(total);
        for (int a : chances.keySet()) {
            pick -= chances.get(a);
            if (pick < 0)
                return a;
        }
        return -1;
    }

    public void addChance(int number, int chance) {
        int newChance = chance;
        if (chances.containsKey(number))
            newChance += chances.get(number);
        if (newChance < 0)
            newChance = 0;
        chances.put(number, newChance);
    }

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
