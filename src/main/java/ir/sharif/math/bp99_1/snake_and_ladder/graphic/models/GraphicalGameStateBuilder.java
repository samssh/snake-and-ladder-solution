package ir.sharif.math.bp99_1.snake_and_ladder.graphic.models;

import ir.sharif.math.bp99_1.snake_and_ladder.model.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GraphicalGameStateBuilder {

    public static GraphicalGameState build(GameState g) {
        GraphicalGameState gss;
        GraphicalPlayer p1 = createGP(g.getPlayer(1));
        GraphicalPlayer p2 = createGP(g.getPlayer(2));
        GraphicalBoard b = createBoard(g.getBoard());
        gss = new GraphicalGameState(b, p1, p2);
        return gss;
    }


    private static GraphicalPlayer createGP(Player p) {
        ArrayList<GraphicalPiece> gp = convertPieces((ArrayList<Piece>) p.getPieces());
        return new GraphicalPlayer(p.getName(), p.getPoint(), gp);
    }

    private static GraphicalBoard createBoard(Board b) {
        GraphicalBoard gb = new GraphicalBoard(convertCells(b.getCells()), convertTransmitter(b.getTransmitter()) , convertWalls(b.getWalls()));
        return gb;
    }


    private static LinkedList<GraphicalWall> convertWalls(List<Wall> list){
        System.out.println("++++++++++++++++++++" + list);
        LinkedList<GraphicalWall> gw = new LinkedList<>();
        for (Wall wall : list) {
            if (wall.getCell1().getX() < wall.getCell2().getX() && wall.getCell1().getY() == wall.getCell2().getY()){
                gw.add(new GraphicalWall(wall.getCell2().getY() , wall.getCell2().getX() , wall.getCell2().getY()+1, wall.getCell2().getX()));

            }
            if (wall.getCell1().getX() > wall.getCell2().getX() && wall.getCell1().getY() == wall.getCell2().getY()){
                gw.add(new GraphicalWall(wall.getCell1().getY() , wall.getCell1().getX() , wall.getCell1().getY() +1, wall.getCell1().getX()));
            }
            if (wall.getCell1().getX() == wall.getCell2().getX() && wall.getCell1().getY() < wall.getCell2().getY()){
                gw.add(new GraphicalWall(wall.getCell2().getY(), wall.getCell2().getX() , wall.getCell2().getY() , wall.getCell2().getX()+1));
            }
            if (wall.getCell1().getX() == wall.getCell2().getX() && wall.getCell1().getY() > wall.getCell2().getY()){
                gw.add(new GraphicalWall(wall.getCell1().getY() , wall.getCell1().getX() , wall.getCell1().getY() , wall.getCell1().getX()+1));
            }
        }



        return gw;
    }
    private static LinkedList<GraphicalCell> convertCells(List<Cell> cells) {
        LinkedList<GraphicalCell> gc = new LinkedList<>();

        for (Cell cell : cells) {
            gc.add(new GraphicalCell(getColer(cell.getColor()), convertPrize(cell.getPrize()), convertPiece(cell.getPiece()), cell.getX(), cell.getY()));
        }
        return gc;
    }

    private static LinkedList<GraphicalTransmitter> convertTransmitter(List<Transmitter> l) {
        LinkedList<GraphicalTransmitter> gtl = new LinkedList<>();
        for (Transmitter transmitter : l) {
            if (transmitter == null){
                gtl.add(null);
            }else {
//            gtl.add(new GraphicalTransmitter(convertCell(transmitter.getFirstCell()),
//                    convertCell(transmitter.getLastCell()), transmitter.getName()));
                int y1 = transmitter.getFirstCell().getX();
                int x1 = transmitter.getFirstCell().getY();
                int y2 = transmitter.getLastCell().getY();
                int x2 = transmitter.getLastCell().getX();

                gtl.add(new GraphicalTransmitter(new Snake.SnakeBuilder().setStart(x1,y1).setEnd(x2,y2).build()));

            }
        }
        return gtl;
    }

    private static GraphicalColor getColer(Color c) {
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


    private static GraphicalCell convertCell(Cell cell) {
        System.out.println(cell);
        if (cell == null){
            return null;
        }
        GraphicalCell gc = new GraphicalCell(getColer(cell.getColor()), convertPrize(cell.getPrize()), convertPiece(cell.getPiece()), cell.getX(), cell.getY());
        return gc;
    }

    private static GraphicalPiece convertPiece(Piece piece) {
        if (piece == null){
            return null;
        }
        GraphicalPiece gp = new GraphicalPiece(getColer(piece.getColor()));
        return gp;

    }

    private static GraphicalPrize convertPrize(Prize prize) {
        if (prize == null){
            return new GraphicalPrize(null);
        }
        return new GraphicalPrize("prize");
    }


    private static ArrayList<GraphicalPiece> convertPieces(ArrayList<Piece> l) {
        ArrayList<GraphicalPiece> pi = new ArrayList<>();
        for (Piece a : l) {
            if (a == null){
                pi.add(null);
            }else
            pi.add(new GraphicalPiece(getColer(a.getColor())));
        }
        return pi;
    }


}
