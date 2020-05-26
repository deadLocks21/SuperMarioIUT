package supermarioiut.metier.intheworld.backgrounds;

import iut.Game;
import supermarioiut.metier.World;

/**
 * Colline dans le jeu.
 */
public class Hill2 extends Background {
    /**
     * Constructeur d'un fond de notre monde.
     *
     * @param g     Jeu dans lequel on se trouve.
     * @param x     Valeur ou il apparait.
     * @param y     Valeur ou il apparait.
     */
    public Hill2(Game g, int x, int y) {
        super(g, "nonInteractive\\hill_2", x, y);
    }

    @Override
    public String getItemType() {
        return "HILL_2";
    }
}
