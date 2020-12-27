package ir.sharif.math.bp99_1.snake_and_ladder.model.prizes;

import ir.sharif.math.bp99_1.snake_and_ladder.model.Cell;
import ir.sharif.math.bp99_1.snake_and_ladder.model.pieces.Piece;

public class Prize {
    private final Cell cell;
    private final int point;
    private final int chance, chanceNumber;
    private final String name;


    public Prize(Cell cell, int point, int chance, int chanceNumber, String name) {
        this.cell = cell;
        this.point = point;
        this.chance = chance;
        this.chanceNumber = chanceNumber;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPoint() {
        return point;
    }

    public Cell getCell() {
        return cell;
    }

    public int getChance() {
        return chance;
    }

    public int getChanceNumber() {
        return chanceNumber;
    }

    public void using(Piece piece) {
        piece.getPlayer().usePrize(this);
    }

}
