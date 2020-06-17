package supermarioiut.metier.intheworld.movable;

import iut.Game;
import iut.GameItem;
import supermarioiut.metier.intheworld.ScrollWorld;
import supermarioiut.metier.intheworld.blocks.Block;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


/**
 * Permet d'afficher et de déplacer notre joueur.
 */
public class Player extends Entity implements KeyListener {
    /**
     * Hauteur maximale ou le joueur peut sauter en pixel.
     */
    int MAX_HEIGHT_JUMP = 150;
    /**
     * Incrémentation de la vitesse.
     */
    int I_SPEED = 1;
    /**
     * Valeur d'un pixel de bloc en pixel.
     */
    int PIXEL = 1;

    /**
     * TRUE si la flèche LEFT est pressée.
     */
    private boolean pressedLeft;
    /**
     * TRUE si la flèche TOP est pressée.
     */
    private boolean pressedTop;
    /**
     * TRUE si la flèche RIGHT est pressée.
     */
    private boolean pressedRight;
    /**
     * TRUE si la flèche BOTTOM est pressée.
     */
    private boolean pressedBottom;

    /**
     * TRUE si le joueur est en phase de montée.
     */
    private boolean jump;
    /**
     * TRUE si le joueur est en descente.
     */
    private boolean fall;
    /**
     * TRUE si le joueur a le droit de sauter.
     */
    private boolean rightToJump;
    /**
     * Hauteur de départ lors d'un saut du joueur.
     */
    private int startHeightJump;

    /**
     * Skin qui change en fonction de si le joueur saute ou va à gauche ou à droite.
     */
    private String skin;
    /**
     * Etait 1, 2 ou 3 de notre joueur.
     */
    private String state;

    /**
     * Permet de savoir si le joueur à gagné ou non.
     */
    private boolean win;


    /**
     * Constructeur de la classe Player.
     *
     *
     * @param g     Jeu dans auquel appartient notre joueur.
     * @param state Etat de notre joueur ("mario_1" par exemple).
     * @param x     Point x ou pop le joueur.
     * @param y     Point y ou pop le joueur.
     */
    public Player(Game g, String state, int x, int y) {
        super(g, "interactive\\animated\\controlable\\" + state + "\\static", x*64, y*64);

        skin = "static";
        this.state = state;

        pressedLeft = false;
        pressedTop = false;
        pressedRight = false;
        pressedBottom = false;

        jump = false;
        fall = false;
        rightToJump = false;
        startHeightJump = 0;

        win = false;
    }


    /**
     * Assesseur de win.
     *
     *
     * @return Valeur de win.
     */
    public boolean getWin(){
        return win;
    }


    @Override
    protected void refreshPosition(){
        if(this.getRight() > this.getGame().getWidth()/2 && super.getVx() > 0){  // Fait avancer le monde.
            ScrollWorld.moveTheWorld(super.getVx());
            moveXY(0, super.getVy());
        } else {
            moveXY(super.getVx(), super.getVy());
        }
    }

    @Override
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

        // Vérifie si le joueur veut et peut sauter
        if(pressedTop && rightToJump) {
            jump = true;
            startHeightJump = getTop();
        }

        if (jump) {
            setGravity(false);
            setVy(-10);
        }

        if (jump && (!pressedTop || startHeightJump - actualHeight >= MAX_HEIGHT_JUMP || super.blockTop() || super.collideTop())){
            jump = false;
            fall = true;
            setT(0);

            if (super.blockTop() || super.collideTop())
                setV0(0);
            else
                setV0(-10);
        }

        rightToJump = !pressedTop && blockBottom();

        if (fall && blockBottom()){
            jump = false;
            fall = false;
            setV0(0);
        }
    }

    @Override
    protected void skinGestion() {
        if(jump || fall) {
            skin = "jump";
        } else {
            if(super.getVx() != 0)
                switch (skin){
                    case "walk_1":
                        skin = "walk_2";
                        break;
                    case "walk_2":
                        skin = "walk_3";
                        break;
                    default:
                        skin = "walk_1";
                }
            else
                skin = "static";
        }

        changeSprite("interactive\\animated\\controlable\\" + state + "\\" + skin);
    }


    @Override
    public void collideEffect(GameItem gameItem) {
        if ((gameItem.getItemType().equals("WALL") || gameItem.getItemType().equals("LUCKY_BOX")) && blockTop()) {
            Block block = (Block) gameItem;
            block.die();
        }

        if(gameItem.getItemType().equals("FLAG_BAR"))
            win = true;
    }

    @Override
    public String getItemType() {
        return "PLAYER";
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
