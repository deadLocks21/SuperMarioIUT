package supermarioiut.metier.intheworld.backgrounds;

import iut.Game;
import supermarioiut.metier.World;

/**
 * Buisson dans le jeu.
 */
public class Bush1 extends Background {
    /**
     * Constructeur d'un fond de notre monde.
     *
     * @param g     Jeu dans lequel on se trouve.
     * @param x     Valeur ou il apparait.
     * @param y     Valeur ou il apparait.
     */
    public Bush1(Game g, int x, int y) {
        super(g, "nonInteractive\\bush_1", x, y);
    }

    @Override
    public String getItemType() {
        return "BUSH_1";
    }
}
