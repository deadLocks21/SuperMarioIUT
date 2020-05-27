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
                ret = new Bush1(g, x, y);
                break;
            case "BUSH_2":
                ret = new Bush2(g, x, y);
                break;
            case "BUSH_3":
                ret = new Bush3(g, x, y);
                break;
            case "CASTLE":
                ret = new Castle(g, x, y);
                break;
            case "CLOUD_1":
                ret = new Cloud1(g, x, y);
                break;
            case "CLOUD_2":
                ret = new Cloud2(g, x, y);
                break;
            case "CLOUD_3":
                ret = new Cloud3(g, x, y);
                break;
            case "HILL_1":
                ret = new Hill1(g, x, y);
                break;
            case "HILL_2":
                ret = new Hill2(g, x, y);
                break;
            case "PIPE_1":
                ret = new Pipe1(g, x, y);
                break;
            case "PIPE_2":
                ret = new Pipe2(g, x, y);
                break;
            case "PIPE_3":
                ret = new Pipe3(g, x, y);
                break;
            default:
                ret = null;
        }

        return ret;
    }
}
