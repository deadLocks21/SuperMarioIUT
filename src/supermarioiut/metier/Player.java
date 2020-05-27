package supermarioiut.metier;

import iut.Game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Player extends Entity implements KeyListener {
    int pressedKey = 0;
    int oldPressedKey = 0;
    int c = 0;

    public Player(Game g, int x, int y) {
        super(g, "interactive\\animated\\controlable\\mario_1\\static", x, y);
        World myWorld = World.getInstance();
        myWorld.init(g, "1-1");

        myWorld.display();
    }


    @Override
    public String getItemType() {
        return "PLAYER";
    }

    @Override
    public void evolve(long l){
        System.out.println("pressedKey " + pressedKey + "     oldPressedKey " + oldPressedKey + "     super.v0 " + super.v0 + "     c " + c);


        if (pressedKey == KeyEvent.VK_UP && oldPressedKey ==0 && !super.gravity && !super.oldGravity){
            super.v0 = (float) -11;
            super.t = 1;
            super.gravity = true;
            super.oldGravity = true;
        }


        if(pressedKey == KeyEvent.VK_UP)
            super.gravity();
        else
            super.theGravity();


         super.gravity = true;


        oldPressedKey = pressedKey;
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        pressedKey = keyEvent.getKeyCode();

        if (keyEvent.getKeyCode() == 40){
            moveXY(0, 20);
        }
        if (keyEvent.getKeyCode() == 37){
            moveXY(-20, 0);
        }
        if (keyEvent.getKeyCode() == 39){
            moveXY(20, 0);
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        if(KeyEvent.VK_UP == keyEvent.getKeyCode()){
            pressedKey = 0;
            // super.v0 = 0;

            if(super.t < 31)
                super.t = 0;
        }
    }
}
