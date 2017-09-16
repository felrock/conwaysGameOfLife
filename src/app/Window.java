package app;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

import javax.swing.*;

public class Window{
    private static final String TITLE = "Conway's game of life";
    private static final int WINDOW_HEIGHT = 600;
    private static final int WINDOW_WIDTH = 600;
    private static final int GAME_HEIGHT = 400;
    private static final int GAME_WIDTH = 400;
    
    public static void main(String[] args) throws InterruptedException{
        JFrame window = new JFrame(TITLE);
        window.setBackground(Color.WHITE);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
        window.setLayout(new FlowLayout());
        JButton sim = new JButton("Sim");
        GameWindow gameWindow = new GameWindow(GAME_WIDTH, GAME_HEIGHT);
        JPanel container = new JPanel();
        gameWindow.setPreferredSize(new Dimension(GAME_WIDTH, GAME_HEIGHT));
        gameWindow.setBackground(Color.BLACK);
        sim.addActionListener((ActionListener) gameWindow);
        container.setBorder(BorderFactory.createEmptyBorder(75,0,0,0));
        container.add(gameWindow);
        container.add(sim);
        window.getContentPane().add(container);
        window.pack();
        window.setVisible(true);
        while(true){
            if(gameWindow.getSim()){
                gameWindow.simulateIteration();
            }
            TimeUnit.MILLISECONDS.sleep(200);
        }
    }
}
