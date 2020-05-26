package supermarioiut.metier.intheworld.backgrounds;

import iut.Game;
import supermarioiut.metier.World;

/**
 * Tuyau dans le jeu.
 */
public class Pipe3 extends Background {
    /**
     * Constructeur d'un fond de notre monde.
     *
     * @param g     Jeu dans lequel on se trouve.
     * @param x     Valeur ou il apparait.
     * @param y     Valeur ou il apparait.
     */
    public Pipe3(Game g, int x, int y) {
        super(g, "interactive\\inert\\pipe_3", x, y);
    }

    @Override
    public String getItemType() {
        return "PIPE_3";
    }
}
