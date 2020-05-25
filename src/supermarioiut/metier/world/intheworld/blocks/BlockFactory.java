package supermarioiut.metier.world.intheworld.blocks;

import iut.Game;
import supermarioiut.metier.world.World;

public class BlockFactory {
    public static Block create(Game g, World world, int x, int y, String type){
        Block ret;

        switch (type){
            case "BLUE_FLOOR":
                ret = new BlueFloor(g, world, x, y);
                break;
            case "BLUE_WALL":
                ret = new BlueWall(g, world, x, y);
                break;
            case "FLOOR":
                ret = new Floor(g, world, x, y);
                break;
            case "HIDDEN_BOX":
                ret = new HiddenBox(g, world, x, y);
                break;
            case "LUCKY_BOX":
                ret = new LuckyBox(g, world, x, y);
                break;
            case "OLD_LUCKY_BOX":
                ret = new OldLuckyBox(g, world, x, y);
                break;
            case "SOLID_WALL":
                ret = new SolidWall(g, world, x, y);
                break;
            case "WALL":
                ret = new Wall(g, world, x, y);
                break;
            default:
                ret = null;
        }

        return ret;
    }
}
