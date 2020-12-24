package ir.sharif.math.bp99_1.snake_and_ladder.model;

import ir.sharif.math.bp99_1.snake_and_ladder.util.ThreadColor;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Board {
    private List<Cell> cells;
    private List<Transmitter> transmitters;
    private List<Wall> walls;
    private List<Cell> startingCells;

    public Board(String boardDate){

        cells = new LinkedList<>();
        transmitters = new LinkedList<>();
        walls = new LinkedList<>();
        startingCells = new LinkedList<>();

        System.out.println(boardDate);

        Scanner scanner = new Scanner(boardDate);

        scanner.next();
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();

        for(int i=1;i<=n;++i){
            for(int j=1;j<=m;++j){
                Cell cell = new Cell(Color.valueOf(scanner.next()),i,j);
                cells.add(cell);
            }
        }

        for(int i=1;i<=n;++i){
            for(int j=1;j<=m;++j){
                Cell cell = getCell(i,j);

                if(i>1){
                    Cell cell1 = getCell(i-1,j);
                    cell.getAdjacentCells().add(cell1);
                    cell.getAdjacentOpenCells().add(cell1);
                }

                if(j>1){
                    Cell cell1 = getCell(i,j-1);
                    cell.getAdjacentCells().add(cell1);
                    cell.getAdjacentOpenCells().add(cell1);
                }

                if(i<n){
                    Cell cell1 = getCell(i+1,j);
                    cell.getAdjacentCells().add(cell1);
                    cell.getAdjacentOpenCells().add(cell1);
                }

                if(j<m){
                    Cell cell1 = getCell(i,j+1);
                    cell.getAdjacentCells().add(cell1);
                    cell.getAdjacentOpenCells().add(cell1);
                }

            }
        }

        scanner.next();
        int sc = scanner.nextInt();
        scanner.nextLine();

        for(int i=0;i<sc;++i){
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            startingCells.add(getCell(x,y));
        }

        scanner.next();
        int w = scanner.nextInt();
        scanner.nextLine();

        for(int i=0;i<w;++i){
            int x1 = scanner.nextInt();
            int y1 = scanner.nextInt();
            Cell cell1 = getCell(x1,y1);

            int x2 = scanner.nextInt();
            int y2 = scanner.nextInt();
            Cell cell2 = getCell(x2,y2);

            Wall wall = new Wall(cell1,cell2);
            walls.add(wall);

            cell1.getAdjacentOpenCells().remove(cell2);
            cell2.getAdjacentOpenCells().remove(cell1);

        }

        scanner.next();
        int t = scanner.nextInt();
        scanner.nextLine();

        for(int i=0;i<t;++i){
            int x1 = scanner.nextInt();
            int y1 = scanner.nextInt();
            Cell cell1 = getCell(x1,y1);

            int x2 = scanner.nextInt();
            int y2 = scanner.nextInt();
            Cell cell2 = getCell(x2,y2);

            Transmitter transmitter = new Transmitter(cell1,cell2,"snake");
            transmitters.add(transmitter);

            cell1.setTransmitter(transmitter);
        }

        scanner.next();
        int p = scanner.nextInt();
        scanner.nextLine();

        for(int i=0;i<p;++i){
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int point = scanner.nextInt();
            int chance = scanner.nextInt();
            int chanceNumber = scanner.nextInt();

            Cell cell = getCell(x,y);
            cell.setPrize(new Prize(cell,point,chance,chanceNumber,"prize"));
        }
        System.out.println("finish");
    }

    public List<Cell> getCells() {
        return cells;
    }

    public List<Wall> getWalls() {
        return walls;
    }

    public List<Cell> getStartingCells() {
        return startingCells;
    }

    public List<Transmitter> getTransmitter() {
        return transmitters;
    }

    public void setTransmitter(List<Transmitter> transmitters) {
        this.transmitters = transmitters;
    }

    public void setCells(List<Cell> cells) {
        this.cells = cells;
    }

    public void setWalls(List<Wall> walls) {
        this.walls = walls;
    }

    public void setStartingCells(List<Cell> startingCells) {
        this.startingCells = startingCells;
    }

    public Cell getCell(int X, int Y){
        System.out.println(ThreadColor.ANSI_CYAN + cells.toString() + ThreadColor.ANSI_RESET);
        for(Cell cell : cells){
            if(cell.getX() == X && cell.getY() == Y)
                return cell;
        }
        return null;
    }

    @Override
    public String toString() {
        return "Board{" +
                ", transmitters=" + transmitters +
                '}';
    }
}
