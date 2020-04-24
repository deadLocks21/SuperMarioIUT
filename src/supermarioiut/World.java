package supermarioiut;

public class World {
    private int width;
    private int height;
    private String[][] compisitionOfTheWorld;

    public World(int width, int height) {
        this.height = height;
        this.width = width;

        compisitionOfTheWorld = new String[height][width];

        System.out.println(compisitionOfTheWorld[0].length);
        initTheWorld();

        System.out.println(toString());
    }


    public String[][] getWorld(){
        return compisitionOfTheWorld;
    }

    public int[] getSize(){
        return new int[]{width, height};
    }


    private void changeTileOfTheWorld(int x, int y, String what){
        this.compisitionOfTheWorld[y][x] = what;
    }

    private void initTheWorld(){
        for(int y = 0; y < compisitionOfTheWorld.length; y ++){
            for(int x = 0; x < compisitionOfTheWorld[y].length;x ++){
                changeTileOfTheWorld(x, y, "");
            }
        }

        addFloor();
        addWalls();
        addCeiling();

        changeTileOfTheWorld(1, 9, "floor");
        changeTileOfTheWorld(1, 9, "floor");
    }

    public String compositionOfTheTile(int x, int y){
        return this.compisitionOfTheWorld[y][x];
    }

    private void addFloor(){
        for(int y = compisitionOfTheWorld.length - 2; y < compisitionOfTheWorld.length; y ++){
            for(int x = 0; x < compisitionOfTheWorld[y].length;x ++){
                changeTileOfTheWorld(x, y, "floor");
            }
        }
    }

    private void addWalls(){
        for(int y = 0; y < compisitionOfTheWorld.length; y ++){
            changeTileOfTheWorld(0, y, "floor");
        }

        for(int y = 0; y < compisitionOfTheWorld.length; y ++){
            changeTileOfTheWorld(width-1, y, "floor");
        }
    }

    private void addCeiling(){
        for(int x = 0; x < compisitionOfTheWorld[0].length;x ++){
            changeTileOfTheWorld(x, 0, "floor");
        }
    }


    @Override
    public String toString(){
        StringBuilder ret = new StringBuilder();

        for(int y = 0; y < compisitionOfTheWorld.length; y ++){
            for(int x = 0; x < compisitionOfTheWorld[y].length;x ++){
                switch (compositionOfTheTile(x, y)){
                    case "":
                        ret.append("0");
                        break;
                    case "floor" :
                        ret.append("F");
                       break;
                }
            }
            ret.append("\n");
        }


        return ret.toString();
    }
}
