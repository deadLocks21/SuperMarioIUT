package supermarioiut.metier.intheworld.blocks;

import iut.Game;
import iut.GameItem;
import supermarioiut.metier.World;

/**
 * Bloc de mur du monde souterrain.
 */
public class BlueWall extends Block {
    /**
     * Constructeur d'un bloc de notre monde.
     *
     * @param g     Jeu dans lequel on se trouve.
     * @param x     Valeur ou il apparait.
     * @param y     Valeur ou il apparait.
     */
    public BlueWall(Game g, int x, int y) {
        super(g, "interactive\\inert\\blueWall", x, y);
    }

    @Override
    public String getItemType() {
        return "BLUE_WALL";
    }
}
