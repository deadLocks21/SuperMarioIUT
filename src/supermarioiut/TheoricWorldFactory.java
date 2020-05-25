package supermarioiut;

/**
 * Fabrique à monde.
 */
public class TheoricWorldFactory {
    public static String[][] create(int width, int height, TheoricWorldType type){
        String[][] ret = new String[height][width];

        /*switch (type){
            case BOX:
                break;
            case FLAT:
                ret = this.addFloor(ret);
                break;
            default:
        }*/

        return ret;
    }

    private static  String[][] addFloor(String[][] world){
        return world;
    }
}
