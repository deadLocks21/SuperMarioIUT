package supermarioiut;

import iut.Game;
import iut.GameItem;

public class ZOldFloor extends ZOldBackground {
    public ZOldFloor(Game g, int x, int y) {
        super(g, "floor", x, y);
    }

    @Override
    public void collideEffect(GameItem gameItem) {

    }

    @Override
    public String getItemType() {
        return "floor";
    }

    @Override
    public void evolve(long l) {
        int oPW = super.getOldPointWorld();
        int pW = super.getPointWorld();

        if(oPW != pW){
            // this.moveXY();
        }
    }
}
