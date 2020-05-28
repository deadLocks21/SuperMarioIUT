package supermarioiut.metier;

import iut.Game;
import iut.GameItem;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.Key;

public class Player extends Entity implements KeyListener {
    private boolean jump;
    // private boolean jumpWithKey;
    private boolean fall;
    private boolean holdKey;
    private int pressedKey;
    private int startHeight;
    private int MAX_HEIGHT = 150;



    public Player(Game g, int x, int y) {
        super(g, "interactive\\animated\\controlable\\mario_1\\static", x, y);

        jump = false;
        // jumpWithKey = false;
        fall = true;
        holdKey = false;
        pressedKey = 0;
        startHeight = 0;
    }


    @Override
    public String getItemType() {
        return "PLAYER";
    }

    @Override
    public void evolve(long l){
        if(pressedKey == KeyEvent.VK_UP || jump)
            super.gravity = false;

        if(jump || fall)
            this.changeSprite("interactive\\animated\\controlable\\mario_1\\jump");

        super.evolve(l);
    }

    @Override
    public void collideEffect(GameItem gameItem){
        if(gameItem.getItemType().equals("FLOOR") || gameItem.getItemType().equals("PIPE") || gameItem.getItemType().equals("LUCKY_BOX") || gameItem.getItemType().equals("WALL")) {
            fall = false;
            jump = false;
            this.changeSprite("interactive\\animated\\controlable\\mario_1\\static");
        }

        super.collideEffect(gameItem);
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        pressedKey = keyEvent.getKeyCode();
        holdKey = keyEvent.getKeyCode() == pressedKey;

        if(keyEvent.getKeyCode() == KeyEvent.VK_UP && !jump && !fall) {
            super.Vy = -8;
            super.gravity = false;
            jump = false;
            fall = true;
            startHeight = this.getTop();
        }

        if(keyEvent.getKeyCode() == KeyEvent.VK_LEFT)
            super.Vx = -4;

        if(keyEvent.getKeyCode() == KeyEvent.VK_RIGHT)
            super.Vx = 4;

        refreshPosition();
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        if(keyEvent.getKeyCode() == KeyEvent.VK_UP) {
            super.Vy = 0;
            super.gravity = true;
            super.t = 0;
            super.v0 = -10;
        }

        if(keyEvent.getKeyCode() == KeyEvent.VK_LEFT)
            super.Vx = 0;

        if(keyEvent.getKeyCode() == KeyEvent.VK_RIGHT)
            super.Vx = 0;

        pressedKey = 0;
    }
}
