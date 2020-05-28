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
    private boolean rightToJump;
    private boolean holdUpKey;
    private int pressedKey;
    private int startHeight;
    private int MAX_HEIGHT = 150;



    public Player(Game g, int x, int y) {
        super(g, "interactive\\animated\\controlable\\mario_1\\static", x, y);

        jump = false;
        // jumpWithKey = false;
        rightToJump = false;
        fall = true;
        holdUpKey = false;
        pressedKey = 0;
        startHeight = 0;
    }


    public void goToFall(){
        super.Vy = 0;
        super.gravity = true;
        super.t = 0;
        super.v0 = -10;
        jump = false;
        fall = true;
        rightToJump = false;
    }


    @Override
    public String getItemType() {
        return "PLAYER";
    }

    @Override
    public void evolve(long l){
        int actualHeight = this.getTop();

        // Permet de stopper le monté si je suis à la hauteur max et que je saute ou appyue toujours.
        if((pressedKey == KeyEvent.VK_UP) && jump && startHeight - actualHeight >= MAX_HEIGHT && !fall)
            goToFall();

        if((pressedKey == KeyEvent.VK_UP) && jump && startHeight - actualHeight < MAX_HEIGHT && !fall)
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

            if(pressedKey != KeyEvent.VK_UP)
                rightToJump = true;
        }

        super.collideEffect(gameItem);
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        pressedKey = keyEvent.getKeyCode();

        // Permet de lancer le saut
        if(pressedKey == KeyEvent.VK_UP && !jump && !fall && rightToJump) {
            super.Vy = -10;
            super.gravity = false;
            jump = true;
            fall = false;
            startHeight = this.getTop();
            rightToJump = false;
        }

        // if(pressedKey == KeyEvent.VK_UP && fall)

        if(keyEvent.getKeyCode() == KeyEvent.VK_LEFT)
            super.Vx = -4;

        if(keyEvent.getKeyCode() == KeyEvent.VK_RIGHT)
            super.Vx = 4;

        refreshPosition();
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        if(keyEvent.getKeyCode() == KeyEvent.VK_UP && jump) {
            goToFall();
        }

        if(keyEvent.getKeyCode() == KeyEvent.VK_UP && !jump && !fall)
            rightToJump = true;

        if(keyEvent.getKeyCode() == KeyEvent.VK_LEFT)
            super.Vx = 0;

        if(keyEvent.getKeyCode() == KeyEvent.VK_RIGHT)
            super.Vx = 0;

        pressedKey = 0;
    }
}
