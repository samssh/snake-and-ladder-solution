package ir.sharif.math.bp99_1.snake_and_ladder.graphic;

import ir.sharif.math.bp99_1.snake_and_ladder.graphic.models.*;
import ir.sharif.math.bp99_1.snake_and_ladder.model.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GraphicalGameStateBuilder {
    private final GameState logicalGameState;

    public GraphicalGameStateBuilder(GameState gameState) {
        this.logicalGameState = gameState;
    }

    public GraphicalGameState build() {
        GraphicalPlayer p1 = createGP(logicalGameState.getPlayer(1));
        GraphicalPlayer p2 = createGP(logicalGameState.getPlayer(2));
        GraphicalBoard b = createBoard(logicalGameState.getBoard());
        return new GraphicalGameState(b, p1, p2);
    }


    private GraphicalPlayer createGP(Player p) {
        List<GraphicalPiece> gp = convertPieces(p.getPieces());
        return new GraphicalPlayer(p.getName(), p.getPoint(), gp);
    }

    private GraphicalBoard createBoard(Board b) {
        return new GraphicalBoard(convertCells(b.getCells()), convertTransmitter(b.getTransmitter()), convertWalls(b.getWalls()));
    }


    private List<GraphicalWall> convertWalls(List<Wall> list) {
        List<GraphicalWall> graphicalWalls = new LinkedList<>();
        for (Wall wall : list) {
            if (wall.getCell1().getX() < wall.getCell2().getX() && wall.getCell1().getY() == wall.getCell2().getY()) {
                graphicalWalls.add(new GraphicalWall(wall.getCell2().getY(), wall.getCell2().getX()
                        , wall.getCell2().getY() + 1, wall.getCell2().getX()));
            }
            if (wall.getCell1().getX() > wall.getCell2().getX() && wall.getCell1().getY() == wall.getCell2().getY()) {
                graphicalWalls.add(new GraphicalWall(wall.getCell1().getY(), wall.getCell1().getX()
                        , wall.getCell1().getY() + 1, wall.getCell1().getX()));
            }
            if (wall.getCell1().getX() == wall.getCell2().getX() && wall.getCell1().getY() < wall.getCell2().getY()) {
                graphicalWalls.add(new GraphicalWall(wall.getCell2().getY(), wall.getCell2().getX()
                        , wall.getCell2().getY(), wall.getCell2().getX() + 1));
            }
            if (wall.getCell1().getX() == wall.getCell2().getX() && wall.getCell1().getY() > wall.getCell2().getY()) {
                graphicalWalls.add(new GraphicalWall(wall.getCell1().getY(), wall.getCell1().getX()
                        , wall.getCell1().getY(), wall.getCell1().getX() + 1));
            }
        }
        return graphicalWalls;
    }

    private List<GraphicalCell> convertCells(List<Cell> cells) {
        List<GraphicalCell> graphicalCells = new LinkedList<>();
        for (Cell cell : cells) {
            graphicalCells.add(new GraphicalCell(getColor(cell.getColor()), convertPrize(cell.getPrize())
                    , convertPiece(cell.getPiece()), cell.getX(), cell.getY()));
        }
        return graphicalCells;
    }

    private List<GraphicalTransmitter> convertTransmitter(List<Transmitter> l) {
        List<GraphicalTransmitter> graphicalTransmitters = new LinkedList<>();
        for (Transmitter transmitter : l) {
            if (transmitter == null) {
                graphicalTransmitters.add(null);
            } else {
                int y1 = (transmitter.getFirstCell().getX() - 1) * 80 + 40;
                int x1 = (transmitter.getFirstCell().getY() - 1) * 80 + 40;
                int y2 = (transmitter.getLastCell().getX() - 1) * 80 + 40;
                int x2 = (transmitter.getLastCell().getY() - 1) * 80 + 40;
                graphicalTransmitters.add(new GraphicalTransmitter(new Snake.SnakeBuilder().setStart(x1, y1).setEnd(x2, y2).build()));
            }
        }
        return graphicalTransmitters;
    }

    private GraphicalColor getColor(Color c) {
        if (c.equals(Color.BLACK)) {
            return GraphicalColor.BLACK;
        } else if (c.equals(Color.WHITE)) {
            return GraphicalColor.WHITE;
        } else if (c.equals(Color.RED)) {
            return GraphicalColor.RED;
        } else if (c.equals(Color.BLUE)) {
            return GraphicalColor.BLUE;
        } else if (c.equals(Color.GREEN)) {
            return GraphicalColor.GREEN;
        } else {
            return GraphicalColor.YELLOW;
        }
    }

    private GraphicalCell convertCell(Cell cell) {
        if (cell == null) {
            return null;
        }
        return new GraphicalCell(getColor(cell.getColor()), convertPrize(cell.getPrize()), convertPiece(cell.getPiece())
                , cell.getX(), cell.getY());
    }

    private GraphicalPiece convertPiece(Piece piece) {
        if (piece == null) {
            return null;
        }
        return new GraphicalPiece(getColor(piece.getColor()));
    }

    private GraphicalPrize convertPrize(Prize prize) {
        if (prize == null) {
            return new GraphicalPrize(null);
        }
        return new GraphicalPrize("prize");
    }

    private List<GraphicalPiece> convertPieces(List<Piece> l) {
        List<GraphicalPiece> pi = new ArrayList<>();
        for (Piece a : l) {
            if (a == null) {
                pi.add(null);
            } else
                pi.add(new GraphicalPiece(getColor(a.getColor())));
        }
        return pi;
    }
}
