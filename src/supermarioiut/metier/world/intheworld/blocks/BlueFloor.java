package supermarioiut.metier.world.intheworld.blocks;

import iut.Game;
import supermarioiut.metier.world.World;

/**
 * Bloc de sol du monde souterrain.
 */
public class BlueFloor extends Block {
    /**
     * Constructeur d'un bloc de notre monde.
     *
     * @param g     Jeu dans lequel on se trouve.
     * @param world Monde dans lequel on est.
     * @param x     Valeur ou il apparait.
     * @param y     Valeur ou il apparait.
     */
    public BlueFloor(Game g, World world, int x, int y) {
        super(g, world, "interactive\\inert\\blueFloor", x, y);
    }


    @Override
    public String getItemType() {
        return "BLUE_FLOOR";
    }
}
