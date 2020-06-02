package supermarioiut.metier;

import iut.BoxGameItem;
import iut.Game;
import iut.GameItem;
import supermarioiut.metier.intheworld.ScrollWorld;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

// Vérifier quand je suis collé à un bloc si je peux aller dessous + appliquer la gravité en fonction.
public class Master2 extends Entity implements KeyListener {
    //**** Variables ****\\
    private boolean pressedLeft;
    private boolean pressedTop;
    private boolean pressedRight;
    private boolean pressedBottom;


    //**** Constructeur ****\\
    public Master2(Game g, String nom, int x, int y) {
        super(g, nom, x, y);

        initPressed();
    }

    //**** Méthodes ****\\
    private void initPressed(){
        pressedLeft = false;
        pressedTop = false;
        pressedRight = false;
        pressedBottom = false;
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
