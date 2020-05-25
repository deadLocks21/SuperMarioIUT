package supermarioiut.metier.menus;

import iut.Game;
import supermarioiut.metier.world.DisplayWorld;
import supermarioiut.metier.world.theoricWorld.TheoricWorld;

/**
 * Menu de chargement du jeu.
 */
public class LoadingMenu extends DisplayWorld {
    /**
     * Constructeur de LoadingMenu qui permet d'initialiser les variables.
     *
     * @param game         Partie à affecter.
     * @param theoricWorld TheoricWorld à afficher.
     */
    public LoadingMenu(Game game, TheoricWorld theoricWorld) {
        super(game, theoricWorld);
    }
}
