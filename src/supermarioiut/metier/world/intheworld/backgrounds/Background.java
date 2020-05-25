package supermarioiut.metier.world.intheworld.backgrounds;

import iut.Game;
import supermarioiut.metier.world.World;
import supermarioiut.metier.world.intheworld.ScrollWorld;

public abstract class Background extends ScrollWorld {
    /**
     * Constructeur d'un bloc mouvant de notre monde.
     *
     * @param g     Jeu dans lequel on se trouve.
     * @param world Monde dans lequel on est.
     * @param nom   Nom de l'item.
     * @param x     Valeur ou il apparait.
     * @param y     Valeur ou il apparait.
     */
    public Background(Game g, World world, String nom, int x, int y) {
        super(g, world, nom, x, y);
    }
}
