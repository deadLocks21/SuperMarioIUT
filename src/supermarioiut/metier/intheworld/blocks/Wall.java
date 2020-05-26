package supermarioiut.metier.intheworld.blocks;

import iut.Game;
import supermarioiut.metier.World;

/**
 * Bloc de mur du monde.
 */
public class Wall extends Block {
    /**
     * Constructeur d'un bloc de notre monde.
     *
     * @param g     Jeu dans lequel on se trouve.
     * @param x     Valeur ou il apparait.
     * @param y     Valeur ou il apparait.
     */
    public Wall(Game g, int x, int y) {
        super(g, "interactive\\animated\\immobile\\wall", x, y);
    }


    @Override
    public String getItemType() {
        return "WALL";
    }
}
