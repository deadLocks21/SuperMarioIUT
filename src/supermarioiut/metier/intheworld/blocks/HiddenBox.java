package supermarioiut.metier.intheworld.blocks;

import iut.Game;
import supermarioiut.metier.World;

/**
 * Bloc caché dans le monde.
 */
public class HiddenBox extends Block {
    /**
     * Constructeur d'un bloc de notre monde.
     *
     * @param g     Jeu dans lequel on se trouve.
     * @param x     Valeur ou il apparait.
     * @param y     Valeur ou il apparait.
     */
    public HiddenBox(Game g, int x, int y) {
        super(g, "interactive\\animated\\immobile\\hiddenBox", x, y);
    }


    @Override
    public String getItemType() {
        return "HIDDEN_BOX";
    }
}
