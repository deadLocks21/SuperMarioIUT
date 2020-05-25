package supermarioiut.metier.menus;

import iut.Game;
import supermarioiut.metier.world.DisplayWorld;
import supermarioiut.metier.world.theoricWorld.TheoricWorld;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Menu de démarage du jeu.
 */
public class BaseMenu extends DisplayWorld implements KeyListener {
    /**
     * Constructeur de BaseMenu qui permet d'initialiser les variables.
     *
     * @param game         Partie à affecter.
     * @param theoricWorld TheoricWorld à afficher.
     */
    public BaseMenu(Game game, TheoricWorld theoricWorld) {
        super(game, theoricWorld);
    }


    // TODO Gérer les touches pour le menu.
    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {

    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }
}
