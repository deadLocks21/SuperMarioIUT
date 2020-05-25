package supermarioiut.metier.world.intheworld.backgrounds;

import iut.Game;
import supermarioiut.metier.world.World;

/**
 * Chateau dans le jeu.
 */
public class Castle extends Background {
    /**
     * Constructeur d'un fond de notre monde.
     *
     * @param g     Jeu dans lequel on se trouve.
     * @param world Monde dans lequel on est.
     * @param x     Valeur ou il apparait.
     * @param y     Valeur ou il apparait.
     */
    public Castle(Game g, World world, int x, int y) {
        super(g, world, "nonInteractive\\castle", x, y);
    }

    @Override
    public String getItemType() {
        return "CASTLE";
    }
}
