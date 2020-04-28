package supermarioiut;

import iut.Game;
import iut.Vector;

import java.awt.*;
import java.time.chrono.ThaiBuddhistEra;
import java.util.ArrayList;

public class SuperMarioIUT extends iut.Game {
    public static void main(String[] args) {
        SuperMarioIUT game = new SuperMarioIUT();
        game.play();
    }


    public SuperMarioIUT() {
        super(1024, 960, "Super Mario IUT");

    }


    @Override
    protected void createItems() {
        TheoricWorld tW = new TheoricWorld("1-1", 200, 14, WorldType.FLAT);
        World world = new World(tW, this);

        world.display(64);
        this.addItem(new Player(this, world, 128, 256));
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
        return new Vector();
    }
}
