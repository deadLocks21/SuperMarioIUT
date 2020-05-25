package supermarioiut;

import iut.Vector;
import supermarioiut.metier.world.World;
import supermarioiut.metier.world.intheworld.backgrounds.Bush1;
import supermarioiut.metier.world.intheworld.blocks.Floor;
import supermarioiut.metier.world.theoricWorld.TheoricWorld;
import supermarioiut.metier.world.theoricWorld.TheoricWorldFactory;

import java.awt.*;

import static supermarioiut.metier.world.theoricWorld.TheoricWorldType.FLAT;
import static supermarioiut.metier.world.theoricWorld.TheoricWorldType.VOID;

public class SuperMarioIUT extends iut.Game {
    public static void main(String[] args) {
        SuperMarioIUT game = new SuperMarioIUT();
        game.play();
    }


    public SuperMarioIUT() {
        super(1280, 960, "Super Mario IUT");
        TheoricWorldFactory.create(10, 10, FLAT);
    }


    @Override
    protected void createItems() {
        TheoricWorld theoricWorld = new TheoricWorld("", 10, 10, VOID);
        World world = new World(theoricWorld, this);

        addItem(new Bush1(this, world, 0, 0));
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
