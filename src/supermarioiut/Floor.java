package supermarioiut;

import iut.Game;
import iut.GameItem;

public class Floor extends iut.BoxGameItem {
    public Floor(Game g, int x, int y) {
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

    }
}
