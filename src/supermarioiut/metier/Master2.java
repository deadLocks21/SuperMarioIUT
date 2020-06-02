package supermarioiut.metier;

import iut.BoxGameItem;
import iut.Game;
import iut.GameItem;
import supermarioiut.metier.intheworld.ScrollWorld;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

// Vérifier quand je suis collé à un bloc si je peux aller dessous + appliquer la gravité en fonction.
public class Master2 extends BoxGameItem implements KeyListener {
    //**** Variables ****\\
    int MAX_SPEED = 12;
    int I_SPEED = 4;
    private int PIXEL = 4;

    private float Vx;
    private float Vy;

    private boolean pressedLeft;
    private boolean pressedTop;
    private boolean pressedRight;
    private boolean pressedBottom;

    int cooTLx;
    int cooTLy;

    int cooBRx;
    int cooBRy;


    float G = (float)-40/100;
    int t;
    int v0;

    String[][] theoricWorld;


    //**** Constructeur ****\\
    public Master2(Game g, String nom, int x, int y) {
        super(g, nom, x, y);

        initPressed();

        Vx = 0;
        Vy = 0;

        World world = World.getInstance();
        theoricWorld = world.getTheoricWorld();

//        initCollide();
    }

    //**** Méthodes ****\\
    private void initPressed(){
        pressedLeft = false;
        pressedTop = false;
        pressedRight = false;
        pressedBottom = false;
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

        moveXY(0, 1);
        whereIAm();

        if(!collideBottom()){
            if(v > MAX_SPEED)
                Vy = MAX_SPEED;
            else
                Vy = v;

            t++;
        } else {
            Vy = 0;
            v0 = 0;
            t = 0;
        }

        moveXY(0, -1);
        whereIAm();
    }

    private void whereIAm(){
        int x = getLeft();
        int y = getTop();

        int w = getWidth();
        int h = getHeight();


        cooTLx = (int) ((x + ScrollWorld.getProgressPoint()) / 64);
        cooTLy = y / 64;

        cooBRx = (int) (((x + w - 1 + ScrollWorld.getProgressPoint()) / 64) + 1);
        cooBRy = ((y + h - 1) / 64) + 1;

        // System.out.println("cooTLx " + cooTLx + "    cooTLy " + cooTLy + "    cooBRx " + cooBRx + "    cooBRy " + cooBRy);
    }

    // Ces fonctions permettent de vérifier si je suis à l'intérieur d'un bloc.
    private boolean collideLeft(){
        boolean res = false;

        try {
            for(int i = cooTLy; i < cooBRy; i ++)
                if (theoricWorld[i][cooTLx] != null)
                    res = true;
        } catch (ArrayIndexOutOfBoundsException err){
            // Nothing, ca veut dire qu'on est null part.
        }

        return res;
    }

    private boolean collideTop(){
        boolean res = false;

        try {
            for(int i = cooTLx; i < cooBRx; i ++)
                if (theoricWorld[cooTLy][i] != null)
                    res = true;
        } catch (ArrayIndexOutOfBoundsException err){
            // Nothing, ca veut dire qu'on est null part.
        }

        return res;
    }

    private boolean collideRight(){
        boolean res = false;

        try {
            for(int i = cooTLy; i < cooBRy; i ++)
                if(theoricWorld[i][cooBRx - 1] != null)
                    res = true;
        } catch (ArrayIndexOutOfBoundsException err){
            // Nothing, ca veut dire qu'on est null part.
        }

        return res;
    }

    private boolean collideBottom(){
        boolean res = false;

        try {
            for(int i = cooTLx; i < cooBRx; i ++)
                if (theoricWorld[cooBRy - 1][i] != null)
                    res = true;
        } catch (ArrayIndexOutOfBoundsException err){
            // Nothing, ca veut dire qu'on est null part.
        }

        return res;
    }

    private void collide(){
        System.out.println("Vx " + Vx + "    Vy " + Vy + "    position " + getPosition().getY());


        // Déplacement du sprite
        refreshPosition();

        // Je regarde ou il est
        whereIAm();


        // BOTTOM
        if(Vy > 0 && collideBottom()) {
            moveXY(0, ((cooBRy - 1) * 64) - (getPosition().getY() + getHeight()));
            Vy = 0;
            t = 0;
        }

        // LEFT
        if(Vx < 0 && collideLeft()) {
            moveXY((((cooTLx + 1) * 64) - getPosition().getX()) - ScrollWorld.getProgressPoint(), 0);
            Vx = 0;
        }

        // RIGHT
        if(Vx > 0 && collideRight()) {
            moveXY((((cooBRx - 1) * 64) - (getPosition().getX() + getWidth())) - ScrollWorld.getProgressPoint(), 0);
            Vx = 0;
        }

        // TOP
        if(Vy < 0 && collideTop()) {
            moveXY(0, ((cooTLy + 1) * 64) - getPosition().getY());
            Vy = 0;
        }


        /*// BOTTOM/RIGHT
        if(Vy > 0 && Vx > 0)
            System.out.println("BOTTOM/RIGHT");

        // BOTTOM/LEFT
        if(Vy > 0 && Vx > 0)
            System.out.println("BOTTOM/LEFT");

        // TOP/RIGHT
        if(Vy > 0 && Vx > 0)
            System.out.println("TOP/RIGHT");

        // TOP/LEFT
        if(Vy > 0 && Vx > 0)
            System.out.println("TOP/LEFT");*/
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
    public void evolve(long l) {
        gravity();

        speedGestion();
        collide();

        // refreshPosition();
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
