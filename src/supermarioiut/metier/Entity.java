package supermarioiut.metier;

import iut.BoxGameItem;
import iut.Game;
import supermarioiut.metier.intheworld.ScrollWorld;

/**
 * Class prenant en compte les collision ainsi que la gravité.
 */
public abstract class Entity extends BoxGameItem {
    // Constantes vitesse du personnage.
    int MAX_SPEED = 12;
    int I_SPEED = 4;
    int PIXEL = 4;
    // Constante pour la gravité.
    float G = (float)-40/100;

    // Coo du perso
    int cooTLx;
    int cooTLy;
    int cooBRx;
    int cooBRy;

    // Variables pour la gravité.
    int t;
    int v0;
    boolean gravity;

    // Variables pour la vitesse de déplacement.
    private float Vx;
    private float Vy;

    String[][] theoricWorld;


    public Entity(Game g, String nom, int x, int y) {
        super(g, nom, x, y);

        Vx = 0;
        Vy = 0;

        gravity = true;
        t = 0;
        v0 = 0;

        World world = World.getInstance();
        theoricWorld = world.getTheoricWorld();
    }


    protected abstract void speedGestion();

    protected abstract void skinGestion();


    public float getVx() {
        return Vx;
    }

    public void setVx(float vx) {
        Vx = vx;
    }

    public void incrementVx(float vx) {
        Vx += vx;
    }

    public void decrementVx(float vx) {
        Vx -= vx;
    }

    public float getVy() {
        return Vy;
    }

    public void setVy(float vy) {
        Vy = vy;
    }

    public void incrementVy(float vy) {
        Vy += vy;
    }

    public void decrementVy(float vy) {
        Vy -= vy;
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
        float v = -G * t + v0;

        if(gravity){
            if(v > MAX_SPEED)
                Vy = MAX_SPEED;
            else
                Vy = v;

            t++;
        } /*else {
            Vy = 0;
            v0 = 0;
            t = 0;
        }*/
    }

    protected void whereIAm(){
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

    protected boolean blockBottom(){
        boolean res;

        moveXY(0, 1);
        whereIAm();

        res = collideBottom();

        moveXY(0, -1);
        whereIAm();

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


    @Override
    public void evolve(long l) {
        speedGestion();
        gravity();
        collide();
        gravity = !blockBottom();
        skinGestion();
    }
}
