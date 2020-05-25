package supermarioiut.metier.world.blocks;

import iut.BoxGameItem;
import iut.Game;
import supermarioiut.metier.world.World;

/**
 * Permet au monde de bouger en fonction des mouvements du joueur.
 */
public abstract class ScrollWorld extends BoxGameItem {
    /**
     * Point de référence du monde. Il ne fait que avancer en fonction du joueur.
     */
    private int basePoint;
    /**
     * Monde dans lequel on évolue.
     */
    private World world;


    /**
     * Constructeur d'un bloc mouvant de notre monde.
     *
     *
     * @param g     Jeu dans lequel on se trouve.
     * @param world Monde dans lequel on est.
     * @param nom   Nom de l'item.
     * @param x     Valeur ou il apparait.
     * @param y     Valeur ou il apparait.
     */
    public ScrollWorld(Game g, World world, String nom, int x, int y) {
        super(g, nom, x, y);

        this.basePoint = x;
        this.world = world;
    }


    /**
     * Méthode abstraite permettant de récupérer le type du block.
     *
     *
     * @return Type du block.
     */
    public abstract String getItemType();


    @Override
    public void evolve(long l) {
        int theoricPoint = basePoint - world.getProgressPoint();
        int moveX = theoricPoint - this.getLeft();

        moveXY(moveX, 0);
    }
}
