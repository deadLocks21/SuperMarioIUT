package supermarioiut;

import iut.Game;
import iut.GameItem;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Player extends iut.BoxGameItem implements KeyListener{

    public Player(Game g, int x, int y) {
        super(g, "mario", x, y);
    }

    @Override
    public boolean isCollide(GameItem o) {
        return super.isCollide(o);
    }

    @Override
    public void collideEffect(GameItem o) {

    }

    @Override
    public String getItemType() {
        return "mario_2";
    }

    @Override
    public void evolve(long dt) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode())
        {
            case KeyEvent.VK_RIGHT:
                if(this.getRight()<this.getGame().getWidth())
                    this.moveXY(+10, 0);
                break;
            case KeyEvent.VK_LEFT:
                if(this.getLeft()>0)
                    this.moveXY(-10, 0);
                break;
            case KeyEvent.VK_UP:
                if(this.getRight()<this.getGame().getWidth())
                    this.moveXY(0, -10);
                break;
            case KeyEvent.VK_DOWN:
                if(this.getLeft()>0)
                    this.moveXY(0, +10);
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
