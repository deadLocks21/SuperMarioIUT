package supermarioiut.metier.intheworld.blocks;

import iut.BoxGameItem;
import iut.Game;
import iut.GameItem;
import supermarioiut.metier.World;
import supermarioiut.metier.intheworld.ScrollWorld;

/**
 * Représente un bloc du jeu. Un bloc ne peut pas être traversé par la gauche, la droite ou le dessus.
 */
public abstract class Block extends BoxGameItem {
    /**
     * Valeur de x initiale de notre objet.
     */
    private int basePoint;
    /**
     * Ordonée du bloc.
     */
    private int x;
    /**
     * Abscisse du bloc.
     */
    private int y;


    /**
     * Constructeur d'un bloc de notre monde.
     *
     * @param g     Jeu dans lequel on se trouve.
     * @param nom   Nom de l'item.
     * @param x     Valeur ou il apparait.
     * @param y     Valeur ou il apparait.
     */
    public Block(Game g, String nom, int x, int y) {
        super(g, nom, x*64, y*64);

        basePoint = x*64;
        this.x = x;
        this.y = y;
    }


    public void die(){
        World world = World.getInstance();

        world.changeTile(x, y, null);

        getGame().remove(this);
    }


    @Override
    public void evolve(long l) {
        // Permet de faire avancer notre sprite.
        float theoricPoint = basePoint - ScrollWorld.getProgressPoint();
        float moveX = theoricPoint - this.getLeft();

        moveXY(moveX, 0);
    }

    @Override
    public void collideEffect(GameItem gameItem) {

    }
}
