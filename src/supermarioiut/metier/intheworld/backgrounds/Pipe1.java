package supermarioiut.metier.intheworld.backgrounds;

import iut.Game;
import supermarioiut.metier.World;

/**
 * Tuyau dans le jeu.
 */
public class Pipe1 extends Background {
    /**
     * Constructeur d'un fond de notre monde.
     *
     * @param g     Jeu dans lequel on se trouve.
     * @param x     Valeur ou il apparait.
     * @param y     Valeur ou il apparait.
     */
    public Pipe1(Game g, int x, int y) {
        super(g, "interactive\\inert\\pipe_1", x, y);
    }

    @Override
    public String getItemType() {
        return "PIPE_1";
    }
}
