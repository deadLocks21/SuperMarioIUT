package supermarioiut.metier.world.intheworld.backgrounds;

import iut.Game;
import supermarioiut.metier.world.World;

/**
 * Nuage dans le jeu.
 */
public class Cloud3 extends Background {
    /**
     * Constructeur d'un fond de notre monde.
     *
     * @param g     Jeu dans lequel on se trouve.
     * @param world Monde dans lequel on est.
     * @param x     Valeur ou il apparait.
     * @param y     Valeur ou il apparait.
     */
    public Cloud3(Game g, World world, int x, int y) {
        super(g, world, "nonInteractive\\cloud_3", x, y);
    }

    @Override
    public String getItemType() {
        return "CLOUD_3";
    }
}
