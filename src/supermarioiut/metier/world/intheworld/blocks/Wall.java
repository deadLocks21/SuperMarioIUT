package supermarioiut.metier.world.intheworld.blocks;

import iut.Game;
import supermarioiut.metier.world.World;

/**
 * Bloc de mur du monde.
 */
public class Wall extends Block {
    /**
     * Constructeur d'un bloc de notre monde.
     *
     * @param g     Jeu dans lequel on se trouve.
     * @param world Monde dans lequel on est.
     * @param x     Valeur ou il apparait.
     * @param y     Valeur ou il apparait.
     */
    public Wall(Game g, World world, int x, int y) {
        super(g, world, "interactive\\animated\\immobile\\wall", x, y);
    }


    @Override
    public String getItemType() {
        return "WALL";
    }
}
