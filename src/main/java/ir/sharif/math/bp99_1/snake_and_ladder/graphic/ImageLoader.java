package ir.sharif.math.bp99_1.snake_and_ladder.graphic;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ImageLoader {
     final static ImageLoader instance = new ImageLoader();
    private final Map<String, BufferedImage> imageMap;
    private final Map<Integer, Icon> diceNumber;

    public static BufferedImage getImage(String name) {
        return instance.imageMap.get(name);
    }

    public static Icon getIcon(int dice){
        System.out.println(dice);
        return instance.diceNumber.get(dice);
    }
    private ImageLoader() {
        imageMap = new HashMap<>();
        diceNumber=new HashMap<>();
        load();
    }

    private void load() {
//        Config config = Config.getConfig("images");
//        for (Map.Entry<Object, Object> k : config.entrySet()) {
//            String key = (String) k.getKey();
//            File file = new File((String) k.getValue());
//            try {
//                BufferedImage image = ImageIO.read(file);
//                String name = key.replace('-', ' ');
//                imageMap.put(name, image);
//            } catch (IOException e) {
//                System.err.println(file.toString());
//                throw new RuntimeException("image file not exist", e);
//            }
//        }
        Config config = Config.getConfig("dice");
        for (Map.Entry<Object, Object> k : config.entrySet()) {
            String key = (String) k.getKey();
            String value =(String) k.getValue();
            System.out.println(key);
            Icon icon = new ImageIcon(value);
            System.out.println("********" + icon);
            diceNumber.put(Integer.parseInt(key), icon);
        }
        System.out.println(diceNumber.toString());
    }

}
