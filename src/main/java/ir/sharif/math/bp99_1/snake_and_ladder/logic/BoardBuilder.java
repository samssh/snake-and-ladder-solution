package ir.sharif.math.bp99_1.snake_and_ladder.logic;

import ir.sharif.math.bp99_1.snake_and_ladder.model.Board;
import ir.sharif.math.bp99_1.snake_and_ladder.model.Cell;
import ir.sharif.math.bp99_1.snake_and_ladder.model.Color;
import ir.sharif.math.bp99_1.snake_and_ladder.model.Wall;
import ir.sharif.math.bp99_1.snake_and_ladder.model.prizes.Prize;
import ir.sharif.math.bp99_1.snake_and_ladder.model.transmitters.Transmitter;

import java.util.Scanner;

// ***
public class BoardBuilder {
    private final Scanner scanner;

    public BoardBuilder(String src) {
        scanner = new Scanner(src);
    }

    public Board build() {
        Board board = new Board();
        buildCells(board);
        addStartingCells(board);
        buildWalls(board);
        buildTransmitters(board);
        addPrizes(board);
        return board;
    }

    // //

    private void buildCells(Board board) {
        scanner.next();
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= m; ++j) {
                Cell cell = new Cell(Color.valueOf(scanner.next()), i, j);
                board.getCells().add(cell);
            }
        }
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= m; ++j) {
                Cell cell = board.getCell(i, j);
                if (i > 1) {
                    Cell cell1 = board.getCell(i - 1, j);
                    cell.getAdjacentCells().add(cell1);
                    cell.getAdjacentOpenCells().add(cell1);
                }
                if (j > 1) {
                    Cell cell1 = board.getCell(i, j - 1);
                    cell.getAdjacentCells().add(cell1);
                    cell.getAdjacentOpenCells().add(cell1);
                }
                if (i < n) {
                    Cell cell1 = board.getCell(i + 1, j);
                    cell.getAdjacentCells().add(cell1);
                    cell.getAdjacentOpenCells().add(cell1);
                }
                if (j < m) {
                    Cell cell1 = board.getCell(i, j + 1);
                    cell.getAdjacentCells().add(cell1);
                    cell.getAdjacentOpenCells().add(cell1);
                }
            }
        }
    }

    private void addStartingCells(Board board) {
        scanner.next();
        int startingCellsNumber = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < startingCellsNumber; ++i) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            board.getStartingCells().put(board.getCell(x, y), scanner.nextInt());
        }
    }

    private void buildWalls(Board board) {
        scanner.next();
        int wallNumber = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < wallNumber; ++i) {
            Cell cell1 = getCell(board);
            Cell cell2 = getCell(board);
            Wall wall = new Wall(cell1, cell2);
            board.getWalls().add(wall);
            cell1.getAdjacentOpenCells().remove(cell2);
            cell2.getAdjacentOpenCells().remove(cell1);
        }
    }

    private void buildTransmitters(Board board) {
        scanner.next();
        int transmittersNumber = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < transmittersNumber; ++i) {
            Cell cell1 = getCell(board);
            Cell cell2 = getCell(board);
            Transmitter transmitter = new Transmitter(cell1, cell2);
            board.getTransmitters().add(transmitter);
            cell1.setTransmitter(transmitter);
        }
    }

    private void addPrizes(Board board) {
        scanner.next();
        int prizeNumber = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < prizeNumber; ++i) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int point = scanner.nextInt();
            int chance = scanner.nextInt();
            int chanceNumber = scanner.nextInt();
            Cell cell = board.getCell(x, y);
            cell.setPrize(new Prize(cell, point, chance, chanceNumber));
        }
    }

    private Cell getCell(Board board) {
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        return board.getCell(x, y);
    }
}
