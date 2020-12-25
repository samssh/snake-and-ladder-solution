package ir.sharif.math.bp99_1.snake_and_ladder.graphic.panel;

import ir.sharif.math.bp99_1.snake_and_ladder.graphic.GraphicalAgent;
import ir.sharif.math.bp99_1.snake_and_ladder.graphic.ImageLoader;
import ir.sharif.math.bp99_1.snake_and_ladder.graphic.Listeners.DiceMouseListener;
import ir.sharif.math.bp99_1.snake_and_ladder.graphic.Listeners.PieceMouseListener;
import ir.sharif.math.bp99_1.snake_and_ladder.graphic.Listeners.ReadyButtonListener;
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
    private int startX, startY;
    private int turnX, diceNX, diceX, pieceX, commonY, size;
    private JLabel name;
    private JLabel score;
    private JLabel dice;
    private JLabel diceNumber;
    private JButton whosTurn;
    private JButton startGame;
    private boolean isPieceEditable = true;
    private ArrayList<JLabel> pieces;


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
        startX = config.getProperty(Integer.class, "startX");
        startY = config.getProperty(Integer.class, "startY");
        turnX = config.getProperty(Integer.class, "turnX");
        diceNX = config.getProperty(Integer.class, "diceNX");
        diceX = config.getProperty(Integer.class, "diceX");
        pieceX = config.getProperty(Integer.class, "pieceX");
        commonY = config.getProperty(Integer.class, "commonY");
        size = config.getProperty(Integer.class, "size");
    }

    private void initialPieceLable() {
        pieces = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            Icon s = ImageLoader.getIcon(player.getPieces().get(i).getColor().name().toLowerCase());
            JLabel label = new JLabel(s);
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

        startGame = new JButton("READY");
        startGame.setFont(startGame.getFont().deriveFont(20.0f));
        startGame.setFocusable(false);
        startGame.addActionListener(new ReadyButtonListener(startGame , agent , player ,id));

        dice = new JLabel(ImageLoader.getIcon("diceGif"));
        dice.setFocusable(false);

        diceNumber = new JLabel();
        diceNumber.setFocusable(false);

        whosTurn = new JButton();
        whosTurn.setFocusable(false);
        whosTurn.setEnabled(false);

        this.initialPieceLable();
        this.positioning();
        this.addElements();
        coloring();
    }

    private void coloring() {
        if (this.id == 1) {
            setBackground(new Color(221, 110, 245, 243));
        } else {
            setBackground(new Color(94, 180, 246, 243));
        }
        diceNumber.setBackground(Color.YELLOW);
        whosTurn.setBackground(Color.red);
    }

    private void positioning() {
        name.setBounds(nameX, nameY, componentWidth, componentHeight);
        score.setBounds(scoreX, scoreY, componentWidth, componentHeight);
        startGame.setBounds(startX , startY , componentWidth , componentHeight);
        diceNumber.setBounds(diceNX, commonY, size, size);
        whosTurn.setBounds(turnX , commonY , size, size);
        dice.setBounds(diceX, commonY, size, size);
        dice.addMouseListener(new DiceMouseListener(agent ,id));
        int i = 0;
        for (JLabel l : pieces) {
            l.addMouseListener(new PieceMouseListener(agent,id , i+1));
            l.setBounds(pieceX , commonY, size, size);
            pieceX +=55;
            i++;
        }
    }

    private void addElements() {
        add(name);
        add(score);
        add(diceNumber);
        add(dice);
        add(startGame);
        add(whosTurn);
        for (JLabel piece : pieces) {
            piece.setVisible(true);
            piece.setText("sds");
            add(piece);
        }
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        synchronized (agent.getPaintLock()) {
            player.paint((Graphics2D) g);
            score.setText(player.getScore()+"");
            diceNumber.setIcon(ImageLoader.getIcon(player.getDiceNumber()+""));

            if (player.isItsTurn()){
                whosTurn.setBackground(Color.green);
            }else {
                whosTurn.setBackground(Color.RED);
            }
        }
    }
}
