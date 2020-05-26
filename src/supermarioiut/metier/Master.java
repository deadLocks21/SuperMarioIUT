package supermarioiut.metier;

import iut.BoxGameItem;
import iut.Game;
import iut.GameItem;
import supermarioiut.metier.intheworld.ScrollWorld;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Class de player fictif permettant de se déplacer dans le monde.
 */
public class Master extends BoxGameItem implements KeyListener {
    public Master(Game g){
        super(g, "nonInteractive\\hill_1", 0, 0);
    }


    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == KeyEvent.VK_P){
            World myWorld = World.getInstance();
            myWorld.init(getGame(), "1-1");

            myWorld.display();
        }

        if (keyEvent.getKeyCode() == KeyEvent.VK_LEFT){
            ScrollWorld.moveTheWorld(-20);
        }
        if (keyEvent.getKeyCode() == KeyEvent.VK_RIGHT){
            ScrollWorld.moveTheWorld(20);
        }


        // TODO Gestion des touches
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

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

    }
}
