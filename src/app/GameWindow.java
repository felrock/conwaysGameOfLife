package app;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

import logic.*;

public class GameWindow extends JPanel implements ActionListener{

    /**
     * 
     */
    private static final long serialVersionUID = 8547502244165436543L;
    private static final int organismSize = 5;
    private int GAME_HEIGHT;
    private int GAME_WIDTH;
    private int WINDOW_HEIGHT;
    private int WINDOW_WIDTH;
    private Grid game;
    private boolean simulate;
    
    public GameWindow(int width, int height){
        setBackground(Color.GRAY);
        WINDOW_HEIGHT = height;
        WINDOW_WIDTH = width;
        GAME_HEIGHT = height/organismSize;
        GAME_WIDTH = width/organismSize;
        game = new Grid(GAME_HEIGHT, GAME_WIDTH, organismSize);
        addMouseListener(new GameEditListener(this));
        simulate = false;
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(int y = 0; y < WINDOW_HEIGHT; y+=organismSize){
            for(int x = 0; x < WINDOW_WIDTH; x += organismSize){
                if(game.getStateAt(x/organismSize, y/organismSize) == State.ALIVE){
                    g.setColor(Color.GREEN);
                }else{
                    g.setColor(Color.BLACK);
                }
                g.fillRect(x, y, organismSize, organismSize);
            }
        }
    }
    protected boolean getSim() {
        return simulate;
    }
    protected Grid getGame() {
        return game;
    }
    @Override
    public void actionPerformed(ActionEvent arg0) {
        if(simulate){
            simulate = false;
        }
        else{
            simulate = true;
        }
    }
    public void simulateIteration() {
        Grid nGame = new Grid(GAME_HEIGHT, GAME_WIDTH, organismSize);
        for(int y = 0; y < GAME_HEIGHT; y++){
            for(int x = 0; x < GAME_WIDTH; x++){
                if(game.check(x, y) == State.ALIVE){
                    nGame.setStateAt(x, y, State.ALIVE);
                }else{
                    nGame.setStateAt(x, y, State.DEAD);
                }
            }
        }
        this.game = nGame;
        repaint();
    }
}
