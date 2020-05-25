package supermarioiut.metier.world.intheworld.blocks;

import iut.Game;
import iut.GameItem;
import supermarioiut.metier.world.World;

/**
 * Bloc de sol de notre monde.
 */
public class Floor extends Block {
    /**
     * Constructeur d'un bloc de notre monde.
     *
     * @param g     Jeu dans lequel on se trouve.
     * @param world Monde dans lequel on est.
     * @param x     Valeur ou il apparait.
     * @param y     Valeur ou il apparait.
     */
    public Floor(Game g, World world, int x, int y) {
        super(g, world, "interactive\\inert\\floor", x, y);
    }


    @Override
    public String getItemType() {
        return "FLOOR";
    }
}
