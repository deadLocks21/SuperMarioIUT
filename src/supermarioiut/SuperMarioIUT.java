package supermarioiut;

import iut.Vector;
import supermarioiut.metier.Player;
import supermarioiut.metier.World;
import supermarioiut.metier.intheworld.blocks.Wall;

import java.awt.*;


public class SuperMarioIUT extends iut.Game {
    public static void main(String[] args) {
        SuperMarioIUT game = new SuperMarioIUT();
        game.play();
    }


    public SuperMarioIUT() {
        super(1280, 960, "Super Mario IUT");
    }


    @Override
    protected void createItems() {
        World myWorld = World.getInstance();
        myWorld.init(this, "1-1");

        myWorld.display();


        addItem(new Player(this, 0, 512));
    }

    @Override
    protected void drawBackground(Graphics graphics) {
        graphics.setColor(new Color(92, 158, 252));
        graphics.fillRect(0, 0, getWidth(), getHeight());
    }

    @Override
    protected void lost() {

    }

    @Override
    protected void win() {

    }

    @Override
    protected boolean isPlayerWin() {
        return false;
    }

    @Override
    protected boolean isPlayerLost() {
        return false;
    }

    @Override
    public Vector getGravity() {
        return new Vector(1, 1);
    }
}
