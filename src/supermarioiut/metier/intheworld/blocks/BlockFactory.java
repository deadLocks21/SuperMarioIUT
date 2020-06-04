package supermarioiut.metier.intheworld.blocks;

import iut.Game;
import supermarioiut.metier.intheworld.blocks.Block;

/**
 * Fabrique à bloc.
 */
public class BlockFactory {
    /**
     * Méthode static pour créer des blocs.
     *
     *
     * @param g    Instance du jeu.
     * @param x    Coordonnée x du bloc.
     * @param y    Coordonnée y du bloc.
     * @param type Type du bloc à créer.
     *
     * @return Bloc créé.
     */
    public static Block create(Game g, int x, int y, String type){
        Block ret;

        switch (type){
            case "BLUE_FLOOR":
                ret = new BlueFloor(g, x, y);
                break;
            case "BLUE_WALL":
                ret = new BlueWall(g, x, y);
                break;
            case "FLOOR":
                ret = new Floor(g, x, y);
                break;
            case "HIDDEN_BOX":
                ret = new HiddenBox(g, x, y);
                break;
            case "LUCKY_BOX":
                ret = new LuckyBox(g, x, y);
                break;
            case "OLD_LUCKY_BOX":
                ret = new OldLuckyBox(g, x, y);
                break;
            case "SOLID_WALL":
                ret = new SolidWall(g, x, y);
                break;
            case "WALL":
                ret = new Wall(g, x, y);
                break;
            case "FLAG_BAR":
                ret = new FlagBar(g, x, y);
                break;
            case "PIPE_2":
                ret = new Pipe(g, x, y, 2);
                break;
            case "PIPE_3":
                ret = new Pipe(g, x, y, 3);
                break;
            case "PIPE_4":
                ret = new Pipe(g, x, y, 4);
                break;
            default:
                ret = null;
        }

        return ret;
    }
}
