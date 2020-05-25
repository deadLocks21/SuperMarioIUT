package supermarioiut.metier.world;

import iut.Game;
import supermarioiut.metier.world.theoricWorld.TheoricWorld;

// TODO Implémenter classe World.
public class World extends DisplayWorld {
    private int progressPoint = 0;
    private Game game;

    public World(TheoricWorld theoricWorld, Game game){
        super(game, theoricWorld);
        this.theoricWorld = theoricWorld;
        this.game = game;
    }

    public void moveTheWorld(int how){
        this.progressPoint += how;
    }

    public int getProgressPoint(){
        return progressPoint;
    }

    public void display(int pixelForBlock){
        int hauteurInverse = 1;
        for(int y = theoricWorld.getSize()[1] - 1; y >= 0; y --){
            for(int x = 0; x < theoricWorld.getSize()[0]; x ++){
                switch (theoricWorld.compositionOfTheTile(x, y)){
//                    case "":
//                        break;
                    case "floor" :
//                        Floor f = new Floor(game, this, x*pixelForBlock, game.getHeight() - hauteurInverse*pixelForBlock);
//                        game.addItem(f);
//                        break;
                }
            }
            hauteurInverse++;
        }
    }
}

