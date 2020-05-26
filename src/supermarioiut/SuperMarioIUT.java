package supermarioiut;

import iut.Vector;
import java.awt.*;


public class SuperMarioIUT extends iut.Game {
    public static void main(String[] args) {
        SuperMarioIUT game = new SuperMarioIUT();
        game.play();
    }


    public SuperMarioIUT() {
        super(1280, 960, "Super Mario IUT");
        // System.out.println(String.valueOf("Hello World\nTim".charAt(12)).equals("T"));
    }


    @Override
    protected void createItems() {
        // TheoricWorld theoricWorld = new TheoricWorld("", 14, 14, VOID);
//        TheoricWorld theoricWorld = new TheoricWorld("test");
//        World world = new World(theoricWorld, this);
//        world.display(64);
//        Master master = new Master(world, this);
//
//        addItem(new LuckyBox(this, world, 0, 0));
//        addItem(master);

        // System.out.println(theoricWorld.toString());
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
