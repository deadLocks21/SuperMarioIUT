package supermarioiut.metier;

import iut.BoxGameItem;
import iut.Game;
import iut.GameItem;
import supermarioiut.metier.intheworld.ScrollWorld;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Master2 extends Entity implements KeyListener {
    //**** Constante ****\\
    private int MAX_HEIGHT_JUMP = 150;

    //**** Variables ****\\
    private boolean pressedLeft;
    private boolean pressedTop;
    private boolean pressedRight;
    private boolean pressedBottom;

    // Jump var
    private boolean jump;
    private boolean fall;
    private boolean rightToJump;
    private int startHeightJump;

    private String skin;
    private String state;


    //**** Constructeur ****\\
    public Master2(Game g, String state, int x, int y) {
        super(g, "interactive\\animated\\controlable\\" + state + "\\static", x, y);

        skin = "static";
        this.state = state;

        initPressed();
        initJumpVar();
    }

    //**** Méthodes ****\\
    private void initPressed(){
        pressedLeft = false;
        pressedTop = false;
        pressedRight = false;
        pressedBottom = false;
    }

    private void initJumpVar(){
        jump = false;
        fall = false;
        rightToJump = false;
        startHeightJump = 0;
    }

    protected void speedGestion(){
        // LEFT
        if(getVx() < 0 && !pressedLeft)
            incrementVx(PIXEL);

        if(getVx() > -MAX_SPEED && pressedLeft)
            decrementVx(I_SPEED);

        if(this.getLeft() <= 0) {
            setVx(0);
            moveXY(-this.getLeft(), 0);
        }


        // RIGHT
        if(getVx() > 0 && !pressedRight)
            decrementVx(PIXEL);

        if(getVx() < MAX_SPEED && pressedRight)
            incrementVx(I_SPEED);


        // TOP & BOTTOM
        int actualHeight = this.getTop();

        // System.out.println("pressedTop " + pressedTop + "    rightToJump " + rightToJump + "    jump " + jump + "    Vy " + super.getVy());

        // Vérifie si le joueur veut et peut sauter
        if(pressedTop && rightToJump) {
            jump = true;
            startHeightJump = getTop();
        }

        if (jump) {
            System.out.println("Jump");

            super.gravity = false;
            setVy(-10);
            skin = "jump";
        }

        if (jump && (!pressedTop || startHeightJump - actualHeight >= MAX_HEIGHT_JUMP)){
            System.out.println("Fall");

            jump = false;
            fall = true;
            v0 = -10;
            t = 0;
        }

        rightToJump = !pressedTop && blockBottom();

        if (fall && blockBottom()){
            jump = false;
            fall = false;
            v0 = 0;
            skin = "static";
        }
    }

    @Override
    protected void skinGestion() {
        changeSprite("interactive\\animated\\controlable\\" + state + "\\" + skin);
    }


    //**** Override ****\\
    @Override
    public void collideEffect(GameItem gameItem) {

    }

    @Override
    public String getItemType() {
        return "MASTER_2";
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()){
            // LEFT
            case 37:
                pressedLeft = true;
                break;

            // TOP
            case 38:
                pressedTop = true;
                break;

            // RIGHT
            case 39:
                pressedRight = true;
                break;

            // BOTTOM
            case 40:
                pressedBottom = true;
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()){
            // LEFT
            case 37:
                pressedLeft = false;
                break;

            // TOP
            case 38:
                pressedTop = false;
                break;

            // RIGHT
            case 39:
                pressedRight = false;
                break;

            // BOTTOM
            case 40:
                pressedBottom = false;
                break;
        }
    }
}
