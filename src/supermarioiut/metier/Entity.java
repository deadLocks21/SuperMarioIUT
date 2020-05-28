package supermarioiut.metier;

import iut.BoxGameItem;
import iut.Game;
import iut.GameItem;

public abstract class Entity extends BoxGameItem {
    float G = (float)-40/100;  // Constante G dans Mario.
    boolean oldGravity;
    boolean gravity;
    int t;
    int v0;
    double Vx;
    double Vy;


    public Entity(Game g, String nom, int x, int y) {
        super(g, nom, x, y);
        gravity = true;
        oldGravity = false;
        t = 0;
        v0 = 0;
        Vx = 0;
        Vy = 0;
    }


    public void gravity(){
        if (gravity){
            if (!oldGravity){
                t = 1;
                oldGravity = true;
            }
            Vy = -G * t + v0;
            t++;
        }
    }

    public void refreshPosition(){
        System.out.println("Vy " + Vy);
        moveXY(Vx, Vy);
    }


    @Override
    public void evolve(long l) {
        gravity();
        refreshPosition();

        gravity = true;
    }

    @Override
    public void collideEffect(GameItem gameItem) {
        if(gameItem.getItemType().equals("FLOOR") || gameItem.getItemType().equals("PIPE") || gameItem.getItemType().equals("LUCKY_BOX") || gameItem.getItemType().equals("WALL")){
            gravity = false;
            oldGravity = false;
            t = 0;
            v0 = 0;
            Vy = 0;

            moveXY(0, gameItem.getTop()-this.getBottom());
        }
    }
}
