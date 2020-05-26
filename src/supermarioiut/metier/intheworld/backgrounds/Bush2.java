package supermarioiut.metier.intheworld.backgrounds;

import iut.Game;
import supermarioiut.metier.World;

/**
 * Buisson dans le jeu.
 */
public class Bush2 extends Background {
    /**
     * Constructeur d'un fond de notre monde.
     *
     * @param g     Jeu dans lequel on se trouve.
     * @param x     Valeur ou il apparait.
     * @param y     Valeur ou il apparait.
     */
    public Bush2(Game g, int x, int y) {
        super(g, "nonInteractive\\bush_2", x, y);
    }

    @Override
    public String getItemType() {
        return "BUSH_2";
    }
}
