package supermarioiut.metier.world;

import iut.Game;
import supermarioiut.metier.world.theoricWorld.TheoricWorld;

/**
 * Permet d'afficher un monde.
 */
public class DisplayWorld {
    /**
     * Stocke la partie
     */
    Game game;
    /**
     * Stocke le monde à afficher.
     */
    TheoricWorld theoricWorld;


    /**
     * Constructeur qui permet d'initialiser les variables.
     *
     *
     * @param game         Partie à affecter.
     * @param theoricWorld TheoricWorld à afficher.
     */
    public DisplayWorld(Game game, TheoricWorld theoricWorld){
        this.game = game;
        this.theoricWorld = theoricWorld;
    }


    /**
     * Affiche theoricWorld.
     *
     *
     * @param pixelForBlock Taille d'un bloc en pixel.
     */
    public void display(int pixelForBlock){
        // TODO Implémenter l'affichage du monde. Nécessite d'avoir les blocs ...
    }
}
