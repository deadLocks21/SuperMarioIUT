package supermarioiut.metier.intheworld.backgrounds;

import iut.Game;
import iut.GameItem;
import iut.Sprite;
import supermarioiut.metier.intheworld.ScrollWorld;

/**
 * Représente un décor du jeu.
 */
public class Background extends GameItem {
    /**
     * Valeur de x initiale de notre objet.
     */
    private int basePoint;


    /**
     * Constructeur d'un bloc mouvant de notre monde.
     * @param g     Jeu dans lequel on se trouve.
     * @param nom   Nom de l'item.
     * @param x     Valeur ou il apparait.
     * @param y     Valeur ou il apparait.
     */
    public Background(Game g, String nom, int x, int y) {
        super(g, nom, x*64, y*64);

        basePoint = x*64;
    }

    @Override
    public boolean isCollide(GameItem gameItem) {
        return false;
    }

    @Override
    public void collideEffect(GameItem gameItem) {

    }

    @Override
    public String getItemType() {
        return "BACKGROUND";
    }

    @Override
    public void evolve(long l) {
        // Permet de faire avancer notre sprite.
        float theoricPoint = basePoint - ScrollWorld.getProgressPoint();
        float moveX = theoricPoint - this.getLeft();

        moveXY(moveX, 0);
    }
}
