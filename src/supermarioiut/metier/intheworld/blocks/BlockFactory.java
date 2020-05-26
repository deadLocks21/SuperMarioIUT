package supermarioiut.metier.intheworld.blocks;

import iut.Game;
import supermarioiut.metier.intheworld.blocks.Block;

public class BlockFactory {
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
            default:
                ret = null;
        }

        return ret;
    }
}
