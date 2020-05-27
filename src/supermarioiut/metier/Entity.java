package supermarioiut.metier;

import iut.BoxGameItem;
import iut.Game;
import iut.GameItem;

public abstract class Entity extends BoxGameItem {
    float G = (float)-20/100;  // Constante G dans Mario.
    boolean oldGravity;
    boolean gravity;
    int t;
    float v0;


    public Entity(Game g, String nom, int x, int y) {
        super(g, nom, x, y);
        gravity = true;
        oldGravity = false;
        v0 = 0;
    }


    public void gravity(){
        moveXY(0, -G * t  + v0);
        t++;
    }

    public void theGravity(){
        if (gravity){
            if (!oldGravity){
                t = 1;
                oldGravity = true;
            }
            gravity();
        }
    }

    public void printGI(){
        System.out.println("G = " + gravity + "    oG = " + oldGravity + "    t = " + t + "    v0 = " + v0 + "    v = " + (G * 2 * t  + v0*2));
    }


    @Override
    public void evolve(long l) {
        printGI();
    }

    @Override
    public void collideEffect(GameItem gameItem) {
        if(gameItem.getItemType().equals("FLOOR") || gameItem.getItemType().equals("PIPE") || gameItem.getItemType().equals("LUCKY_BOX") || gameItem.getItemType().equals("WALL")){
            gravity = false;
            oldGravity = false;
            t = 0;
            v0 = 0;
            moveXY(0, gameItem.getTop()-this.getBottom());
        }
    }
}
