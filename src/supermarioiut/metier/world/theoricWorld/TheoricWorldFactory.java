package supermarioiut.metier.world.theoricWorld;

/**
 * Fabrique à monde.
 */
public class TheoricWorldFactory {
    public static String[][] create(int width, int height, TheoricWorldType type){
        String[][] ret = new String[height][width];

        // TODO Implémenter la fabrique.
        switch (type){
            case BOX:
                break;
            case FLAT:
                ret = addFloor(ret);
                break;
            default:
                for (int y = 0; y < height; y++){
                    for (int x = 0; x < height; x++){
                        ret[y][x] = "VOID";
                    }
                }
        }

        return ret;
    }

    private static String[][] addFloor(String[][] world){
        return world;
    }
}
