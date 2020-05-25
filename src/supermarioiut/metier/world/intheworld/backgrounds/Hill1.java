package supermarioiut.metier.world.intheworld.backgrounds;

import iut.Game;
import supermarioiut.metier.world.World;

/**
 * Colline dans le jeu.
 */
public class Hill1 extends Background {
    /**
     * Constructeur d'un fond de notre monde.
     *
     * @param g     Jeu dans lequel on se trouve.
     * @param world Monde dans lequel on est.
     * @param x     Valeur ou il apparait.
     * @param y     Valeur ou il apparait.
     */
    public Hill1(Game g, World world, int x, int y) {
        super(g, world, "nonInteractive\\hill_1", x, y);
    }

    @Override
    public String getItemType() {
        return "HILL_1";
    }
}
