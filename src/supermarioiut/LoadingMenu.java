package supermarioiut;

import iut.Game;

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
