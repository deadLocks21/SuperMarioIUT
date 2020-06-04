package supermarioiut.metier.intheworld.movable.enemy;

import iut.Game;
import iut.GameItem;
import supermarioiut.metier.ModuleMemoire;
import supermarioiut.metier.intheworld.ScrollWorld;
import supermarioiut.metier.intheworld.movable.Entity;

/**
 * Classe abstraite qui représente un enemy.
 */
public abstract class Enemy extends Entity {
    /**
     * Vitesse.
     */
    int SPEED = 1;
    /**
     * Orientation pour savoir dans quel sens marche le joueur.
     */
    private String orientation;
    /**
     * Ancien progressPoint.
     */
    private float oldProgressPoint;
    /**
     * Permet de savoir à quelle valeur de progressPoint notre ennemie peut commencer à marcher.
     */
    private float whenIWalk;

    /**
     * Constructeur d'une entité.
     *
     * @param g   Jeu dans lequel on se trouve.
     * @param nom Nom du sprite à utiliser.
     * @param x   Coordonnée x ou pop notre personnage.
     * @param y   Coordonnée y ou pop notre personnage.
     */
    public Enemy(Game g, String nom, int x, int y) {
        super(g, nom, x*64, y*64);

        orientation = "LEFT";
        whenIWalk = (x - 21) * 64;
    }


    /**
     * Assesseur de la variable orientation.
     *
     *
     * @return Variable orientation.
     */
    protected String getOrientation(){
        return orientation;
    }


    @Override
    protected void refreshPosition(){
        moveXY(super.getVx(), super.getVy());
    }

    @Override
    protected void speedGestion() {
        float how = ScrollWorld.getProgressPoint() - oldProgressPoint;
        oldProgressPoint = ScrollWorld.getProgressPoint();
        moveXY(-how, 0);

        if(oldProgressPoint > whenIWalk) {
            if (getIsAlive()){
                if (super.blockLeft())
                    orientation = "RIGHT";

                if (super.blockRight())
                    orientation = "LEFT";

                switch (orientation){
                    case "LEFT":
                        super.setVx(-SPEED);
                        break;
                    case "RIGHT":
                        super.setVx(SPEED);
                        break;
                }
            } else {
                setVx(0);
            }
        }
        /*if (getIsAlive()){
            if (super.blockLeft())
                orientation = "RIGHT";

            if (super.blockRight())
                orientation = "LEFT";

            switch (orientation){
                case "LEFT":
                    super.setVx(-SPEED - how);
                    break;
                case "RIGHT":
                    super.setVx(SPEED - how);
                    break;
            }
        } else {
            setVx(0);
        }*/
    }


    @Override
    public void collideEffect(GameItem gameItem) {
        if (gameItem.getItemType().equals("PLAYER") && ModuleMemoire.getPlayer().getVx() == 0 && ModuleMemoire.getPlayer().getVy() == 0 && this.getIsAlive())
            ModuleMemoire.getPlayer().die();

        if (gameItem.getItemType().equals("PLAYER") && ModuleMemoire.getPlayer().getVy() != 0 && this.getIsAlive()) {
            die();
            ModuleMemoire.getPlayer().setT(0);
        }
    }

    @Override
    public String getItemType() {
        return "ENEMY";
    }
}
