package ir.sharif.math.bp99_1.snake_and_ladder.graphic.models;

import java.awt.*;

public class GraphicalWall extends GraphicalModel {
    private int startX , startY, endX , endY;

    public GraphicalWall(int startX, int startY, int endX, int endY) {
        this.startX = (startX-1)*80;
        this.startY = (startY-1)*80;
        this.endX = (endX-1)*80;
        this.endY = (endY-1)*80;
    }

    @Override
    public void paint(Graphics2D graphics2D) {
        Stroke s = graphics2D.getStroke();
        graphics2D.setColor(Color.black.darker());
        graphics2D.setStroke(new BasicStroke(6));
        graphics2D.drawLine(startX, startY, endX,endY);
        graphics2D.setStroke(s);
        graphics2D.setColor(Color.BLACK);
    }
}
