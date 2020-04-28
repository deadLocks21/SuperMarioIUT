package supermarioiut;

import iut.Game;

public class Floor extends BackgroundBlock {
    public Floor(Game g, World aWorld, int x, int y) {
        super(g, aWorld, "floor", x, y);
    }

    @Override
    public String getItemType(){
        return "floor";
    }
}
