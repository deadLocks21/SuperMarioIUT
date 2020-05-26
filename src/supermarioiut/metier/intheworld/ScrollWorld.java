package supermarioiut.metier.intheworld;

import iut.BoxGameItem;
import iut.Game;
import iut.GameItem;

/**
 * Permet au monde de bouger en fonction des mouvements du joueur.
 */
public abstract class ScrollWorld extends BoxGameItem {
    /**
     * Valeur de x initiale de notre objet.
     */
    private int basePoint;
    /**
     * Valeur qui avance en même temps que le joueur.
     */
    private static int progressPoint = 0;


    /**
     * Constructeur d'un objet mouvant de notre monde.
     *
     *
     * @param g     Jeu dans lequel on se trouve.
     * @param nom   Nom de l'item.
     * @param x     Valeur ou il apparait.
     * @param y     Valeur ou il apparait.
     */
    public ScrollWorld(Game g, String nom, int x, int y) {
        super(g, nom, x, y);

        this.basePoint = x;
    }


    /**
     * Permet d'incrémenter la variable progressPoint.
     *
     *
     * @param how Valeur à ajouter.
     */
    public static void moveTheWorld(int how){
        progressPoint += how;
    }


    @Override
    public void evolve(long l) {
        // Permet de faire avancer notre sprite.
        int theoricPoint = basePoint - progressPoint;
        int moveX = theoricPoint - this.getLeft();

        moveXY(moveX, 0);
    }

    @Override
    public void collideEffect(GameItem gameItem) {

    }
}
