package supermarioiut.metier.intheworld;

import iut.BoxGameItem;
import iut.Game;
import iut.GameItem;

/**
 * Permet au monde de bouger en fonction des mouvements du joueur.
 */
public class ScrollWorld {
    /**
     * Valeur qui avance en même temps que le joueur.
     */
    private static float progressPoint = 0;


    /**
     * Assesseur de la variable progressPoint.
     *
     *
     * @return ProgressPoint
     */
    public static float getProgressPoint(){
        return progressPoint;
    }


    /**
     * Permet d'incrémenter la variable progressPoint.
     *
     *
     * @param how Valeur à ajouter.
     */
    public static void moveTheWorld(float how){
        progressPoint += how;
    }
}
