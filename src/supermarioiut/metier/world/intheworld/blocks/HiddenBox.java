package supermarioiut.metier.world.intheworld.blocks;

import iut.Game;
import supermarioiut.metier.world.World;

/**
 * Bloc caché dans le monde.
 */
public class HiddenBox extends Block {
    /**
     * Constructeur d'un bloc de notre monde.
     *
     * @param g     Jeu dans lequel on se trouve.
     * @param world Monde dans lequel on est.
     * @param x     Valeur ou il apparait.
     * @param y     Valeur ou il apparait.
     */
    public HiddenBox(Game g, World world, int x, int y) {
        super(g, world, "interactive\\animated\\immobile\\hiddenBox", x, y);
    }


    @Override
    public String getItemType() {
        return "HIDDEN_BOX";
    }
}
