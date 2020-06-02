package supermarioiut;

import iut.Vector;
import supermarioiut.metier.Master;
import supermarioiut.metier.Master2;
import supermarioiut.metier.Player;
import supermarioiut.metier.World;
import supermarioiut.metier.intheworld.blocks.Floor;
import supermarioiut.metier.intheworld.blocks.SolidWall;

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
        System.out.println(myWorld);

        myWorld.display();

        addItem(new Master2(this, "mario_1", 0, 0));


//         addItem(new SolidWall(this, 0, 12*64));
//         addItem(new Player(this,"mario_2", 0, 512));


//        for(int y = 13; y <= 14; y ++)
//            for(int x = 0; x <= 19; x++)
//                addItem(new Floor(this, x, y));
//
//        for(int y = 0; y <= 20; y ++)
//            for(int x = 0; x < 1; x++)
//                addItem(new Floor(this, x, y));
//
//        addItem(new Master2(this, "interactive\\inert\\solidWall", 70, 0));
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
