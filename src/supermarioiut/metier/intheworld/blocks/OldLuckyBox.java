package supermarioiut.metier.intheworld.blocks;

import iut.Game;
import supermarioiut.metier.World;

/**
 * LuckyBox récupérée.
 */
public class OldLuckyBox extends Block {
    /**
     * Constructeur d'un bloc de notre monde.
     *
     * @param g     Jeu dans lequel on se trouve.
     * @param x     Valeur ou il apparait.
     * @param y     Valeur ou il apparait.
     */
    public OldLuckyBox(Game g, int x, int y) {
        super(g, "interactive\\animated\\immobile\\oldLuckyBox", x, y);
    }


    @Override
    public String getItemType() {
        return "OLD_LUCKY_BOX";
    }
}
