package supermarioiut.metier.intheworld.movable;

import iut.BoxGameItem;
import iut.Game;
import supermarioiut.metier.World;
import supermarioiut.metier.intheworld.ScrollWorld;

/**
 * Class prenant en compte les collision ainsi que la gravité d'un objet.
 */
public abstract class Entity extends BoxGameItem {
    /**
     * Vitesse maximale que peut atteindre un objet.
     */
    int MAX_SPEED = 8;
    /**
     * Constante gravitationnelle de notre monde.
     */
    float G = (float)-2/5;

    // Coo des blocs occupés par notre personnage.
    /**
     * Coordonnée x du bloc en haut à gauche.
     */
    private int cooTLx;
    /**
     * Coordonnée y du bloc en haut à gauche.
     */
    private int cooTLy;
    /**
     * Coordonnée x du bloc en bas à droite.
     */
    private int cooBRx;
    /**
     * Coordonnée y du bloc en bas à droite.
     */
    private int cooBRy;

    // Variables pour la gravité.
    /**
     * Instant t pendant unt chute.
     */
    private int t;
    /**
     * Vitesse initiale lors d'une chute.
     */
    private int v0;
    /**
     * Savoir si on applique la gravité ou non.
     */
    private boolean gravity;

    // Variables pour la vitesse de déplacement.
    /**
     * Vitesse sur l'axe x.
     */
    private float Vx;
    /**
     * Vitesse sur l'axe y.
     */
    private float Vy;

    /**
     * Représente notre monde d'un point de vue théorique.
     */
    private String[][] theoricWorld;

    /**
     * Permet de savoir si le joueur est vivant.
     */
    private boolean isAlive;


    /**
     * Constructeur d'une entité.
     *
     *
     * @param g   Jeu dans lequel on se trouve.
     * @param nom Nom du sprite à utiliser.
     * @param x   Coordonnée x ou pop notre personnage.
     * @param y   Coordonnée y ou pop notre personnage.
     */
    public Entity(Game g, String nom, int x, int y) {
        super(g, nom, x, y);

        Vx = 0;
        Vy = 0;

        gravity = true;
        t = 0;
        v0 = 0;

        World world = World.getInstance();
        theoricWorld = world.getTheoricWorld();

        isAlive = true;
    }


    /**
     * Gère la vitesse de notre personnage.
     */
    protected abstract void speedGestion();

    /**
     * Gère le changement de skin.
     */
    protected abstract void skinGestion();


    /**
     * Assesseur de Vx
     *
     *
     * @return Variable Vx
     */
    public float getVx() {
        return Vx;
    }

    /**
     * Mutateur de Vx.
     *
     *
     * @param Vx Variable Vx.
     */
    protected void setVx(float Vx) {
        this.Vx = Vx;
    }

    /**
     * Permet d'indenter Vx.
     *
     *
     * @param how Nombre à ajouter.
     */
    protected void incrementVx(float how) {
        Vx += how;
    }

    /**
     * Décrémente Vx.
     *
     *
     * @param how Nombre à soustraire.
     */
    protected void decrementVx(float how) {
        Vx -= how;
    }

    /**
     * Assesseur de la variable Vy.
     *
     *
     * @return Variable Vy.
     */
    public float getVy(){
        return Vy;
    }

    /**
     * Mutateur de Vy.
     *
     *
     * @param vy Valeur de Vy.
     */
    protected void setVy(float vy) {
        Vy = vy;
    }

    /**
     * Mutateur de gravity.
     *
     *
     * @param gravity Valeur de gravity.
     */
    protected void setGravity(boolean gravity){
        this.gravity = gravity;
    }

    /**
     * Mutateur de v0.
     *
     *
     * @param v0 Valeur de v0.
     */
    protected void setV0(int v0){
        this.v0 = v0;
    }

    /**
     * Mutateur de t.
     *
     *
     * @param t Nouvelle valeur de t.
     */
    public void setT(int t){
        this.t = t;
    }

    /**
     * Permet de récupérer la variable isAlive.
     *
     *
     * @return Variable isAlive.
     */
    public boolean getIsAlive(){
        return isAlive;
    }

    /**
     * Tue notre entité.
     */
    public void die(){
        isAlive = false;
    }


    /**
     * Permet de mettre ma position à jour avec les vitesses et de mettre le WorldPoint à jour.
     */
    protected abstract void refreshPosition();

    /**
     * Application de la gravité sur le sprite.
     */
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

    /**
     * Permet de déterminer ou je suis dans l'espace.
     */
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
    /**
     * Est-ce que je suis dans un bloc à gauche.
     *
     *
     * @return TRUE si je suis dans un bloc.
     */
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

    /**
     * Est-ce que je suis dans un bloc en haut.
     *
     *
     * @return TRUE si je suis dans un bloc.
     */
    protected boolean collideTop(){
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

    /**
     * Est-ce que je suis dans un bloc à droite.
     *
     *
     * @return TRUE si je suis dans un bloc.
     */
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

    /**
     * Est-ce que je suis dans un bloc en bas.
     *
     *
     * @return TRUE si je suis dans un bloc.
     */
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

    /**
     * Est-ce que je suis sur un bloc à gauche.
     *
     *
     * @return TRUE si je suis contre un bloc.
     */
    protected boolean blockLeft(){
        boolean res;

        moveXY(-1, 0);
        whereIAm();

        res = collideLeft();

        moveXY(1, 0);
        whereIAm();

        return res;
    }

    /**
     * Est-ce que je suis contre un bloc en haut.
     *
     *
     * @return TRUE si je suis contre un bloc.
     */
    protected boolean blockTop(){
        boolean res;

        moveXY(0, -1);
        whereIAm();

        res = collideTop();

        moveXY(0, 1);
        whereIAm();

        return res;
    }

    /**
     * Est-ce que je suis contre un bloc à droite.
     *
     *
     * @return TRUE si je suis contre un bloc.
     */
    protected boolean blockRight(){
        boolean res;

        moveXY(1, 0);
        whereIAm();

        res = collideRight();

        moveXY(-1, 0);
        whereIAm();

        return res;
    }

    /**
     * Est-ce que je suis sur un bloc en bas.
     *
     *
     * @return TRUE si je suis sur un bloc.
     */
    protected boolean blockBottom(){
        boolean res;

        moveXY(0, 1);
        whereIAm();

        res = collideBottom();

        moveXY(0, -1);
        whereIAm();

        return res;
    }

    /**
     * Gère les collisions avec les blocs.
     */
    private void collide(){
        // Déplacement du sprite
        refreshPosition();

        // Je regarde ou il est
        whereIAm();


        // BOTTOM
        if(Vy > 0 && collideBottom()) {
            moveXY(0, ((cooBRy - 1) * 64) - (getPosition().getY() + getHeight()));
            Vy = 0;
            t = 0;
            whereIAm();
        }

        // TOP
        if(Vy < 0 && collideTop()) {
            moveXY(0, ((cooTLy + 1) * 64) - getPosition().getY());
            Vy = 0;
            whereIAm();
        }

        // LEFT
        if(Vx < 0 && collideLeft()) {
            moveXY((((cooTLx + 1) * 64) - getPosition().getX()) - ScrollWorld.getProgressPoint(), 0);
            if (!gravity)
                Vx = 0;
            whereIAm();
        }

        // RIGHT
        if(Vx > 0 && collideRight()) {
            moveXY((((cooBRx - 1) * 64) - (getPosition().getX() + getWidth())) - ScrollWorld.getProgressPoint(), 0);
            if (!gravity)
                Vx = 0;
            whereIAm();
        }
    }


    @Override
    public void evolve(long l) {
        World world = World.getInstance();
        theoricWorld = world.getTheoricWorld();

        speedGestion();
        gravity();
        collide();
        gravity = !blockBottom();
        skinGestion();

        if (getBottom() > 960)
            isAlive = false;
    }
}
