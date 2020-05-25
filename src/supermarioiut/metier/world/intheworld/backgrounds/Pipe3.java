package supermarioiut.metier.world.intheworld.backgrounds;

import iut.Game;
import supermarioiut.metier.world.World;

/**
 * Tuyau dans le jeu.
 */
public class Pipe3 extends Background {
    /**
     * Constructeur d'un fond de notre monde.
     *
     * @param g     Jeu dans lequel on se trouve.
     * @param world Monde dans lequel on est.
     * @param x     Valeur ou il apparait.
     * @param y     Valeur ou il apparait.
     */
    public Pipe3(Game g, World world, int x, int y) {
        super(g, world, "interactive\\inert\\pipe_3", x, y);
    }

    @Override
    public String getItemType() {
        return "PIPE_3";
    }
}
