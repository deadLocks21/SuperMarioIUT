package supermarioiut;

import iut.Game;

public class World {
    private TheoricWorld _theoricWorld;
    private int _progressPoint = 0;
    private Game _game;

    public World(TheoricWorld aTheoricWorld, Game aGame){
        this._theoricWorld = aTheoricWorld;
        this._game = aGame;
    }

    public void moveTheWorld(int how){
        this._progressPoint += how;
    }

    public int getProgressPoint(){
        return _progressPoint;
    }

    public void display(int pixelForBlock){
        int hauteurInverse = 1;
        for(int y = _theoricWorld.getSize()[1] - 1; y >= 0; y --){
            for(int x = 0; x < _theoricWorld.getSize()[0]; x ++){
                switch (_theoricWorld.compositionOfTheTile(x, y)){
                    case "":
                        break;
                    case "floor" :
                        Floor f = new Floor(_game, this, x*pixelForBlock, _game.getHeight() - hauteurInverse*pixelForBlock);
                        _game.addItem(f);
                        break;
                }
            }
            hauteurInverse++;
        }
    }
}
