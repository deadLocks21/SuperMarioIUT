package supermarioiut.metier.intheworld.blocks;

import iut.Game;
import supermarioiut.metier.World;

/**
 * Bloc de sol du monde souterrain.
 */
public class BlueFloor extends Block {
    /**
     * Constructeur d'un bloc de notre monde.
     *
     * @param g     Jeu dans lequel on se trouve.
     * @param x     Valeur ou il apparait.
     * @param y     Valeur ou il apparait.
     */
    public BlueFloor(Game g, int x, int y) {
        super(g, "interactive\\inert\\blueFloor", x, y);
    }


    @Override
    public String getItemType() {
        return "BLUE_FLOOR";
    }
}
