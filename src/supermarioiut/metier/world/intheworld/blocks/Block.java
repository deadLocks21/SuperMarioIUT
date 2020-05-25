package supermarioiut.metier.world.intheworld.blocks;

import iut.Game;
import supermarioiut.metier.world.World;
import supermarioiut.metier.world.intheworld.ScrollWorld;

/**
 * Représente un bloc du jeu. Un bloc ne peut pas être traversé par la gauche, la droite ou le dessus.
 */
public abstract class Block extends ScrollWorld {
    /**
     * Constructeur d'un bloc de notre monde.
     *
     * @param g     Jeu dans lequel on se trouve.
     * @param world Monde dans lequel on est.
     * @param nom   Nom de l'item.
     * @param x     Valeur ou il apparait.
     * @param y     Valeur ou il apparait.
     */
    public Block(Game g, World world, String nom, int x, int y) {
        super(g, world, nom, x, y);
    }
}
