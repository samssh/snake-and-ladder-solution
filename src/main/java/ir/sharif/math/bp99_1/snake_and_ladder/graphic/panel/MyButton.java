package ir.sharif.math.bp99_1.snake_and_ladder.graphic.panel;

import ir.sharif.math.bp99_1.snake_and_ladder.graphic.Frame;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class MyButton extends JButton implements ActionListener {

    InputStream is;
    private BufferedImage img ;
    public MyButton() {
        setLayout(null);
        setBorderPainted(false);
        setContentAreaFilled(false);
        addActionListener(this);
        try {
            img = ImageIO.read(new File("src/dice.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.fillRect(5,5,5,5);
        g.drawImage(img,5,5,80,80,null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        Frame.getInstance().b.color++;
    }
}
