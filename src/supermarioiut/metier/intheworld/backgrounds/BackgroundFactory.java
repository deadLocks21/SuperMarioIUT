package supermarioiut.metier.intheworld.backgrounds;

import iut.Game;
import supermarioiut.metier.World;

/**
 * Fabrique à background.
 */
public class BackgroundFactory {
    /**
     * Méthode static pour créer des backgrounds.
     *
     *
     * @param g    Instance du jeu.
     * @param x    Coordonnée x du bloc.
     * @param y    Coordonnée y du bloc.
     * @param type Type du bloc à créer.
     *
     * @return Background créé.
     */
    public static Background create(Game g, int x, int y, String type){
        Background ret;

        switch (type){
            case "BUSH_1":
                ret = new Background(g, "nonInteractive\\bush_1", x, y);
                break;
            case "BUSH_2":
                ret = new Background(g, "nonInteractive\\bush_2", x, y);
                break;
            case "BUSH_3":
                ret = new Background(g, "nonInteractive\\bush_3", x, y);
                break;
            case "CASTLE":
                ret = new Background(g, "nonInteractive\\castle", x, y);
                break;
            case "CLOUD_1":
                ret = new Background(g, "nonInteractive\\cloud_1", x, y);
                break;
            case "CLOUD_2":
                ret = new Background(g, "nonInteractive\\cloud_2", x, y);
                break;
            case "CLOUD_3":
                ret = new Background(g, "nonInteractive\\cloud_3", x, y);
                break;
            case "HILL_1":
                ret = new Background(g, "nonInteractive\\hill_1", x, y);
                break;
            case "HILL_2":
                ret = new Background(g, "nonInteractive\\hill_2", x, y);
                break;
            default:
                ret = null;
        }

        return ret;
    }
}
