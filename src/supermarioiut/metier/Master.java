package supermarioiut.metier;

import iut.BoxGameItem;
import iut.Game;
import iut.GameItem;
import supermarioiut.metier.intheworld.ScrollWorld;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Master extends BoxGameItem implements KeyListener {
    //**** Variables ****\\
    int MAX_SPEED = 12;
    int I_SPEED = 1;
    private int PIXEL = 1;
    private float Vx;
    private float Vy;
    private boolean pressedLeft;
    private boolean pressedTop;
    private boolean pressedRight;
    private boolean pressedBottom;
    private long millis;

    boolean collideBottom;
    boolean collideLeft;
    boolean collideRight;
    boolean collideTop;

    float G = (float)-40/100;
    int t;
    int v0;


    //**** Constructeur ****\\
    public Master(Game g, String nom, int x, int y) {
        super(g, nom, x, y);
        Vx = 0;
        Vy = 0;
        pressedLeft = false;
        pressedTop = false;
        pressedRight = false;
        pressedBottom = false;
        initCollide();
    }


    //**** Méthodes ****\\
    private void initCollide(){
        collideBottom = false;
        collideLeft = false;
        collideRight = false;
        collideTop = false;
    }

    private void speedGestion(){
        // LEFT
        if(Vx < 0 && !pressedLeft)
            Vx += PIXEL;

        if(Vx > -MAX_SPEED && pressedLeft)
            Vx -= I_SPEED;

        if(this.getLeft() <= 0) {
            Vx = 0;
            moveXY(-this.getLeft(), 0);
        }


        // RIGHT
        if(Vx > 0 && !pressedRight)
            Vx -= PIXEL;

        if(Vx < MAX_SPEED && pressedRight)
            Vx += I_SPEED;


//        // TOP
//        if(Vy < 0 && !pressedTop)
//            Vy += PIXEL;
//
//        if(Vy > -MAX_SPEED && pressedTop)
//            Vy -= I_SPEED;
//
//
//        // BOTTOM
//        if(Vy > 0 && !pressedBottom)
//            Vy -= PIXEL;
//
//        if(Vy < MAX_SPEED && pressedBottom)
//            Vy += I_SPEED;
    }

    private void refreshPosition(){
        if(this.getRight() > this.getGame().getWidth()/2 && Vx > 0){  // Fait avancer le monde.
            ScrollWorld.moveTheWorld(Vx);
            moveXY(0, Vy);
        } else {
            moveXY(Vx, Vy);
        }
    }

    private void gravity(){
        float v = -G * t;

        if(v > MAX_SPEED)
            Vy = MAX_SPEED;
        else
            Vy = v;

        t++;
    }


    //**** Override ****\\
    @Override
    public void collideEffect(GameItem o) {
        if(Vx != 0 && Vy == 0){  // AXE LEFT/RIGHT
            // RIGHT
            if(Vx > 0 && o.getBottom() != this.getTop() && this.getBottom() != o.getTop()) {
                collideRight = true;
                System.out.println("RIGHT");
                moveXY(o.getLeft() - this.getRight(), 0);
            }

            // LEFT
            if(Vx < 0 && o.getBottom() != this.getTop() && this.getBottom() != o.getTop()) {
                collideLeft = true;
                System.out.println("LEFT");
                moveXY(o.getRight() - this.getLeft(), 0);
            }
        } else if(Vx == 0 && Vy != 0){  // AXE TOP/BOTTOM
            // BOTTOM
            if(Vy > 0 && o.getLeft() != this.getRight() && o.getRight() != this.getLeft()) {
                collideBottom = true;
                System.out.println("BOTTOM");
                moveXY(0, o.getTop() - this.getBottom());
            }

            // TOP
            if(Vy < 0 && o.getLeft() != this.getRight() && o.getRight() != this.getLeft()) {
                collideTop = true;
                System.out.println("TOP");
                moveXY(0, o.getBottom() - this.getTop());
            }
        } else {
            // Diagonale BOTTOM/RIGHT
            if(Vx > 0 && Vy > 0){
                int dV = getBottom() - o.getTop();
                int dH = getRight() - o.getLeft();

                if(dV >= dH) {
                    collideRight = true;
                    System.out.println("RIGHT");
                    moveXY(o.getLeft() - this.getRight(), 0);
                } else {
                    collideBottom = true;
                    System.out.println("BOTTOM");
                    moveXY(0, o.getTop() - this.getBottom());
                }
            }

            // Diagonale BOTTOM/LEFT
            if(Vx < 0 && Vy > 0){
                int dV = getBottom() - o.getTop();
                int dH = o.getRight() - getLeft();

                if(dV > dH) {
                    collideLeft = true;
                    System.out.println("LEFT");
                    moveXY(o.getRight() - this.getLeft(), 0);
                } else {
                    collideBottom = true;
                    System.out.println("BOTTOM");
                    moveXY(0, o.getTop() - this.getBottom());
                }
            }

            // Diagonale TOP/LEFT
            if(Vx < 0 && Vy < 0){
                int dV = o.getBottom() - getTop();
                int dH = o.getRight() - getLeft();

                if(dV >= dH) {
                    collideLeft = true;
                    System.out.println("LEFT");
                    moveXY(o.getRight() - this.getLeft(), 0);
                } else {
                    collideTop = true;
                    System.out.println("TOP");
                    moveXY(0, o.getBottom() - this.getTop());
                }
            }

            // Diagonale TOP/RIGHT
            if(Vx > 0 && Vy < 0){
                int dV = o.getBottom() - getTop();
                int dH = getRight() - o.getLeft();

                if(dV >= dH) {
                    collideRight = true;
                    System.out.println("RIGHT");
                    moveXY(o.getLeft() - this.getRight(), 0);
                } else {
                    collideTop = true;
                    System.out.println("TOP");
                    moveXY(0, o.getBottom() - this.getTop());
                }
            }
        }


        if(collideBottom && !collideLeft && !collideRight)
            t = 0;
    }

    @Override
    public String getItemType() {
        return "MASTER";
    }

    @Override
    public void evolve(long l) {
        gravity();

        if(this.getTop() > 576)
            System.out.println("test");

        speedGestion();

        refreshPosition();
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
