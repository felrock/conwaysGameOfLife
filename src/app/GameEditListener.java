package app;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import logic.State;

public class GameEditListener implements MouseListener{
    final GameWindow jp;
    public GameEditListener(final GameWindow jp){
        this.jp = jp;
    }
    @Override
    public void mouseClicked(MouseEvent e) {

    }
    @Override
    public void mouseEntered(MouseEvent e) {  
    }
    @Override
    public void mouseExited(MouseEvent e) { 
    }
    @Override
    public void mousePressed(MouseEvent e) { 
        if(!jp.getSim()){
            int x = e.getX()/jp.getGame().getOrganismSize();
            int y = e.getY()/jp.getGame().getOrganismSize();
            if(jp.getGame().getStateAt(x, y) == State.ALIVE){
                jp.getGame().setStateAt(x, y, State.DEAD);
            }
            else{
                jp.getGame().setStateAt(x, y, State.ALIVE);
            }
            jp.repaint();
        }
    }
    @Override
    public void mouseReleased(MouseEvent e) {  
    }
}
