package supermarioiut.metier.intheworld.backgrounds;

import iut.Game;
import supermarioiut.metier.intheworld.ScrollWorld;

public abstract class Background extends ScrollWorld {
    /**
     * Constructeur d'un bloc mouvant de notre monde.
     *  @param g     Jeu dans lequel on se trouve.
     * @param nom   Nom de l'item.
     * @param x     Valeur ou il apparait.
     * @param y     Valeur ou il apparait.
     */
    public Background(Game g, String nom, int x, int y) {
        super(g, nom, x, y);
    }
}
