package supermarioiut.metier.intheworld.backgrounds;

import iut.Game;
import supermarioiut.metier.World;

/**
 * Chateau dans le jeu.
 */
public class Castle extends Background {
    /**
     * Constructeur d'un fond de notre monde.
     *
     * @param g     Jeu dans lequel on se trouve.
     * @param x     Valeur ou il apparait.
     * @param y     Valeur ou il apparait.
     */
    public Castle(Game g, int x, int y) {
        super(g, "nonInteractive\\castle", x, y);
    }

    @Override
    public String getItemType() {
        return "CASTLE";
    }
}
