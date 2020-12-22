package ir.sharif.math.bp99_1.snake_and_ladder.model;

public class Prize {
    private final Cell cell;
    private final int point;
    private final int chance,chanceNumber;

    public Prize(Cell cell,int point,int chance,int chanceNumber){
        this.cell = cell;
        this.point = point;
        this.chance = chance;
        this.chanceNumber = chanceNumber;
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

    public void using(Piece piece){
        piece.getPlayer().usePrize(this);
    }

}
