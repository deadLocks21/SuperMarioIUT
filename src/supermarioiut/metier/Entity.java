package supermarioiut.metier;

import iut.BoxGameItem;
import iut.Game;
import iut.GameItem;

/**
 * Stocke un objet mouvant et soumis à la gravité.
 */
public abstract class Entity extends BoxGameItem {
    /**
     * Constante gravitationnelle du jeu.
     */
    float G = (float)-40/100;  // Constante G dans MarigameItem.
    /**
     * Activation ou non de la gravité le tour d'avant.
     */
    boolean oldGravity;
    /**
     * Activation ou non de la gravité.
     */
    boolean gravity;
    /**
     * Instant t qui s'incrémente.
     */
    int t;
    /**
     * Vitesse initiale.
     */
    int v0;
    /**
     * Vitesse sur l'axe x.
     */
    double Vx;
    /**
     * Vitesse sur l'axe y.
     */
    double Vy;
    /**
     * Collide avec le sol.
     */
    boolean collideBottom;
    /**
     * Collide avec la gauche.
     */
    boolean collideLeft;
    /**
     * Collide avec la droite.
     */
    boolean collideRight;
    /**
     * Collide avec le haut.
     */
    boolean collideTop;


    /**
     * Constructeur de la classe Entity.
     *
     *
     * @param g   Jeu dans lequel on se trouve.
     * @param nom Nom de notre entité.
     * @param x     Variable x.
     * @param y     Variable y.
     */
    public Entity(Game g, String nom, int x, int y) {
        super(g, nom, x, y);
        gravity = true;
        oldGravity = false;
        t = 0;
        v0 = 0;
        Vx = 0;
        Vy = 0;
    }


    /**
     * Applique la gravité.
     */
    public void gravity(){
        if (gravity){
            if (!oldGravity){
                t = 1;
                oldGravity = true;
            }
            Vy = -G * t + v0;
            t++;
        }
    }

    /**
     * Actualise la position de l'entité en fonction des vitesses.
     */
    public void refreshPosition(){
        moveXY(Vx, Vy);
    }

    /**
     * Initialise les variables de collisions.
     */
    private void initCollide(){
        collideBottom = true;
        collideLeft = false;
        collideRight = false;
        collideTop = false;
    }


    @Override
    public void evolve(long l) {
        initCollide();
        gravity();
        refreshPosition();


        gravity = true;
    }

    @Override
    public void collideEffect(GameItem gameItem) {
//        boolean left = this.getLeft() <= gameItem.getRight() && this.getLeft() > gameItem.getRight() + Vx;
//        boolean right = this.getRight() >= gameItem.getLeft() && this.getRight() < gameItem.getLeft() + Vx;
//        boolean top = this.getTop() <= gameItem.getBottom() && this.getTop() > gameItem.getBottom() + Vy;
//        boolean bottom = this.getBottom() >= gameItem.getTop() && this.getBottom() < gameItem.getTop() + Vy;
        boolean touchsTheBlocks = gameItem.getItemType().equals("FLOOR") || gameItem.getItemType().equals("PIPE") || gameItem.getItemType().equals("LUCKY_BOX") || gameItem.getItemType().equals("WALL") || gameItem.getItemType().equals("SOLID_WALL");
//
//        // Left Collide
//        if(left && !top && !bottom) {
//            // System.out.println("Left Touch " + gameItem.getItemType());
//            collideLeft = true;
//            this.moveXY(gameItem.getRight() - this.getLeft(), 0);
//        }
//
//        // Right Collide
//        if(right && !top && !bottom) {
//            // System.out.println("Right Touch " + gameItem.getItemType());
//            collideRight = true;
//            this.moveXY(gameItem.getLeft() - this.getRight(), 0);
//        }
//
//        // Top Collide
//        if(top && !right && !left) {
//            // System.out.println("Top Touch " + gameItem.getItemType());
//            collideTop = true;
//            this.moveXY(0, gameItem.getBottom() - this.getTop());
//        }
//
//        // Bottom Collide
//        if(bottom && !right && !left) {
//            // System.out.println("Bottom Touch " + gameItem.getItemType());
//            collideBottom = true;
//            this.moveXY(0, gameItem.getTop() - this.getBottom());
//        }

//        if(Vx != 0 && Vy == 0){
//            if(Vx > 0)
//                collideLeft = true;
//
//            if(Vx < 0)
//                collideRight = true;
//        }
//
//        if(Vx == 0 && Vy != 0){
//            if(Vy > 0)
//                collideBottom = true;
//
//            if(Vy < 0)
//                collideTop = true;
//        }





        if(touchsTheBlocks){
            gravity = false;
            oldGravity = false;
            t = 0;
            v0 = 0;
            Vy = 0;

            // Si LEFT/RIGHT
            if(Vx != 0 && Vy == 0){
                if(Vx > 0 && gameItem.getBottom() != this.getTop() && this.getBottom() != gameItem.getTop()) {
                    collideRight = true;
                    System.out.println("RIGHT");
                    moveXY(gameItem.getLeft() - this.getRight(), 0);
                }

                if(Vx < 0 && gameItem.getBottom() != this.getTop() && this.getBottom() != gameItem.getTop()) {
                    collideLeft = true;
                    System.out.println("LEFT");
                    moveXY(gameItem.getRight() - this.getLeft(), 0);
                }
            }

            // Si TOP/BOTTOM
            if(Vx == 0 && Vy != 0){
                if(Vy > 0 && gameItem.getLeft() != this.getRight() && gameItem.getRight() != this.getLeft()) {
                    collideBottom = true;
                    System.out.println("BOTTOM");
                    moveXY(0, gameItem.getTop() - this.getBottom());
                }

                if(Vy < 0 && gameItem.getLeft() != this.getRight() && gameItem.getRight() != this.getLeft()) {
                    collideTop = true;
                    System.out.println("TOP");
                    moveXY(0, gameItem.getBottom() - this.getTop());
                }
            }

            // Diagonale BOTTOM/RIGHT
            if(Vx > 0 && Vy > 0){
                int dV = getBottom() - gameItem.getTop();
                int dH = getRight() - gameItem.getLeft();

                if(dV >= dH) {
                    collideRight = true;
                    System.out.println("RIGHT");
                    moveXY(gameItem.getLeft() - this.getRight(), 0);
                } else {
                    collideBottom = true;
                    System.out.println("BOTTOM");
                    moveXY(0, gameItem.getTop() - this.getBottom());
                }
            }

            // Diagonale BOTTOM/LEFT
            if(Vx < 0 && Vy > 0){
                int dV = getBottom() - gameItem.getTop();
                int dH = gameItem.getRight() - getLeft();

                if(dV > dH) {
                    collideLeft = true;
                    System.out.println("LEFT");
                    moveXY(gameItem.getRight() - this.getLeft(), 0);
                } else {
                    collideBottom = true;
                    System.out.println("BOTTOM");
                    moveXY(0, gameItem.getTop() - this.getBottom());
                }
            }

            // Diagonale TOP/LEFT
            if(Vx < 0 && Vy < 0){
                int dV = gameItem.getBottom() - getTop();
                int dH = gameItem.getRight() - getLeft();

                if(dV >= dH) {
                    collideLeft = true;
                    System.out.println("LEFT");
                    moveXY(gameItem.getRight() - this.getLeft(), 0);
                } else {
                    collideTop = true;
                    System.out.println("TOP");
                    moveXY(0, gameItem.getBottom() - this.getTop());
                }
            }

            // Diagonale TOP/RIGHT
            if(Vx > 0 && Vy < 0){
                int dV = gameItem.getBottom() - getTop();
                int dH = getRight() - gameItem.getLeft();

                if(dV >= dH) {
                    collideRight = true;
                    System.out.println("RIGHT");
                    moveXY(gameItem.getLeft() - this.getRight(), 0);
                } else {
                    collideTop = true;
                    System.out.println("TOP");
                    moveXY(0, gameItem.getBottom() - this.getTop());
                }
            }

            // moveXY(0, gameItem.getTop()-this.getBottom());
        }
    }
}
