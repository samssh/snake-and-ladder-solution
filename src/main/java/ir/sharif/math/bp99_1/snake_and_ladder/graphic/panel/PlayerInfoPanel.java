package ir.sharif.math.bp99_1.snake_and_ladder.graphic.panel;

import ir.sharif.math.bp99_1.snake_and_ladder.graphic.GraphicalAgent;
import ir.sharif.math.bp99_1.snake_and_ladder.graphic.ImageLoader;
import ir.sharif.math.bp99_1.snake_and_ladder.graphic.Listeners.DiceMouseListener;
import ir.sharif.math.bp99_1.snake_and_ladder.graphic.Listeners.PieceMouseListener;
import ir.sharif.math.bp99_1.snake_and_ladder.graphic.models.GraphicalPiece;
import ir.sharif.math.bp99_1.snake_and_ladder.graphic.models.GraphicalPlayer;
import ir.sharif.math.bp99_1.snake_and_ladder.util.Config;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PlayerInfoPanel extends JPanel {
    private final int id;
    protected final GraphicalPlayer player;
    protected final GraphicalAgent agent;
    private int componentWidth, componentHeight;
    private int nameX, nameY;
    private int scoreX, scoreY;
    private int turnX, diceNX, diceX, commonY, size;
    private JLabel name;
    private JLabel score;
    private JLabel dice;
    private JLabel diceNumber;
    private JButton whoseTurn;
    private boolean  isPieceEditable=true;
    ArrayList<JLabel> pieces;



    public PlayerInfoPanel(GraphicalPlayer player, GraphicalAgent agent, int id) {
        this.id = id;
        this.player = player;
        this.agent = agent;
        this.initialize();
        this.setFocusable(false);
    }

    private void config() {
        Config config = Config.getConfig("infoPanel");
        setBounds(config.getProperty(Integer.class, "x" + id), config.getProperty(Integer.class, "y")
                , config.getProperty(Integer.class, "width"), config.getProperty(Integer.class, "height"));
        setLayout(null);
        componentHeight = config.getProperty(Integer.class, "componentHeight");
        componentWidth = config.getProperty(Integer.class, "componentWidth");
        nameX = config.getProperty(Integer.class, "nameX");
        nameY = config.getProperty(Integer.class, "nameY");
        scoreX = config.getProperty(Integer.class, "scoreX");
        scoreY = config.getProperty(Integer.class, "scoreY");
        turnX = config.getProperty(Integer.class, "turnX");
        diceNX = config.getProperty(Integer.class, "diceNX");
        diceX = config.getProperty(Integer.class, "diceX");
        commonY = config.getProperty(Integer.class, "commonY");
        size = config.getProperty(Integer.class, "size");
    }
    private void initialPieceLable(){
        pieces=new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            JLabel label=new JLabel((Icon) ImageLoader.getImage(player.getPieces().get(i).getColor().name()+"Pawn"));
            pieces.add(label);
        }
    }
    private void initialize() {
        this.config();
        this.setVisible(true);

        name = new JLabel("Name :  " + player.getName());
        name.setFocusable(false);
        name.setFont(name.getFont().deriveFont(20.0f));

        score = new JLabel("Score :  " + player.getScore());
        score.setFont(score.getFont().deriveFont(20.0f));
        score.setFocusable(false);

        dice = new JLabel(ImageLoader.getIcon("diceGif"));
        dice.setFocusable(false);

        diceNumber = new JLabel();
        diceNumber.setFocusable(false);
        whoseTurn = new JButton();
        whoseTurn.setFocusable(false);

//        coloring(color, turn);
        this.positioning();
        this.addElements();
    }

//    private void coloring(int color, int turn) {
//        if (color == 1) {
//            setBackground(Color.CYAN);
//        } else {
//            setBackground(Color.yellow);
//        }
//        if (turn % 2 == 0) {
//            whoseTurn.setBackground(Color.green);
//        } else {
//            whoseTurn.setBackground(Color.red);
//        }
//        whoseTurn.setEnabled(false);
//    }

    private void positioning() {
        name.setBounds(nameX, nameY, componentWidth, componentHeight);
        score.setBounds(scoreX, scoreY, componentWidth, componentHeight);
        whoseTurn.setBounds(turnX, commonY, size, size);
        diceNumber.setBounds(diceNX, commonY, size, size);
        dice.setBounds(diceX, commonY, size, size);
        dice.addMouseListener(new DiceMouseListener());
        int i=1;
        for (JLabel l: pieces ) {
            l.addMouseListener(new PieceMouseListener());
            l.setBounds(nameX+i*80, nameY,size,size);
        }
    }

    private void addElements() {
        add(name);
        add(score);
        add(whoseTurn);
        add(diceNumber);
        add(dice);
    }

//    void turn(int i, int r) {
//        if (i == 1) whoseTurn.setBackground(Color.green);
//        else {
//            whoseTurn.setBackground(Color.red);
//            Icon s = ImageLoader.getIcon(r);
//            diceNumber.setIcon(s);
//        }
//        revalidate();
//    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        synchronized (agent.getPaintLock()) {
            player.paint((Graphics2D) g);
            // update this panel
        }
    }
}
