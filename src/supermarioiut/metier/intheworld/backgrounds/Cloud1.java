package supermarioiut.metier.intheworld.backgrounds;

import iut.Game;
import supermarioiut.metier.World;

/**
 * Nuage dans le jeu.
 */
public class Cloud1 extends Background {
    /**
     * Constructeur d'un fond de notre monde.
     *
     * @param g     Jeu dans lequel on se trouve.
     * @param x     Valeur ou il apparait.
     * @param y     Valeur ou il apparait.
     */
    public Cloud1(Game g, int x, int y) {
        super(g, "nonInteractive\\cloud_1", x, y);
    }

    @Override
    public String getItemType() {
        return "CLOUD_1";
    }
}

