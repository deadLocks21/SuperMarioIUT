package supermarioiut.metier.world.intheworld.backgrounds;

import iut.Game;
import supermarioiut.metier.world.World;

public class Bush1 extends Background {
    /**
     * Constructeur d'un bloc mouvant de notre monde.
     *
     * @param g     Jeu dans lequel on se trouve.
     * @param world Monde dans lequel on est.
     * @param x     Valeur ou il apparait.
     * @param y     Valeur ou il apparait.
     */
    public Bush1(Game g, World world, int x, int y) {
        super(g, world, "nonInteractive\\bush_1", x, y);
    }

    @Override
    public String getItemType() {
        return "BUSH_1";
    }
}
