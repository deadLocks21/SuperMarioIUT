package supermarioiut;

import iut.BoxGameItem;
import iut.Game;
import iut.GameItem;

public class BackgroundBlock extends BoxGameItem {
    private int _basePoint;
    private World _world;

    public BackgroundBlock(Game g, World aWorld, String nom, int x, int y) {
        super(g, nom, x, y);

        this._basePoint = x;
        this._world = aWorld;
    }

    @Override
    public void collideEffect(GameItem gameItem) {

    }

    @Override
    public String getItemType() {
        return null;
    }

    @Override
    public void evolve(long l) {
        int theoricPoint = _basePoint - _world.getProgressPoint();
        int moveX = theoricPoint - this.getLeft();

        moveXY(moveX, 0);
    }
}
