package supermarioiut.metier.world.intheworld.blocks;

import iut.Game;
import supermarioiut.metier.world.World;

/**
 * Boite contenant un champignon.
 */
public class LuckyBox extends Block {
    /**
     * Constructeur d'un bloc de notre monde.
     *
     * @param g     Jeu dans lequel on se trouve.
     * @param world Monde dans lequel on est.
     * @param x     Valeur ou il apparait.
     * @param y     Valeur ou il apparait.
     */
    public LuckyBox(Game g, World world, int x, int y) {
        super(g, world, "interactive\\animated\\immobile\\luckyBox\\state_1", x, y);
    }


    @Override
    public String getItemType() {
        return "LUCKY_BOX";
    }
}
