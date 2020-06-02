package supermarioiut.metier;

import iut.Game;
import iut.GameItem;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Stocke et fait marcher un Mario.
 */
public class Player extends EntityOld implements KeyListener {
    /**
     * Hauteur maximale pour le saut libre.
     */
    private int MAX_HEIGHT = 150;
    /**
     * Savoir si le joueur est en train de sauter.
     */
    private boolean jump;
    /**
     * Savoir si le joueur est en train de redescendre.
     */
    private boolean fall;
    /**
     * Savoir si le joueur a le droit de sauter.
     */
    private boolean rightToJump;
    /**
     * Numéro de la touche.
     */
    private int pressedKey;
    /**
     * Hauteur de départ d'un saut.
     */
    private int startHeight;

    private String state;


    /**
     * Constructeur de la classe Player.
     *
     *
     * @param g     Jeu dans lequel on se trouve.
     * @param state Etat du mario.
     * @param x     Variable x.
     * @param y     Variable y.
     */
    public Player(Game g, String state, int x, int y) {
        super(g, "interactive\\animated\\controlable\\" + state + "\\static", x, y);

        jump = false;
        rightToJump = false;
        fall = true;
        pressedKey = 0;
        startHeight = 0;
        this.state = state;
    }


    /**
     * Permet de lancer la redescente du joueur.
     */
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
            this.changeSprite("interactive\\animated\\controlable\\" + state + "\\jump");

        super.evolve(l);
    }

    @Override
    public void collideEffect(GameItem gameItem){
        super.collideEffect(gameItem);

        if(gameItem.getItemType().equals("FLOOR") || gameItem.getItemType().contains("PIPE") || gameItem.getItemType().equals("LUCKY_BOX") || gameItem.getItemType().equals("WALL") || gameItem.getItemType().equals("SOLID_WALL")) {
            fall = false;
            jump = false;
            this.changeSprite("interactive\\animated\\controlable\\" + state + "\\static");

            if(pressedKey != KeyEvent.VK_UP)
                rightToJump = true;

            if(super.collideLeft) {
                super.Vx = 0;
                System.out.println(gameItem.getRight()-this.getLeft());
                moveXY(gameItem.getRight()-this.getLeft(), 0);
            }
        }
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
