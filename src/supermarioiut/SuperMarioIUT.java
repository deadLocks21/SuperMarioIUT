package supermarioiut;

import iut.Vector;
import supermarioiut.metier.ModuleMemoire;
import supermarioiut.metier.intheworld.movable.Player;
import supermarioiut.metier.World;

import javax.swing.*;
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
        // myWorld.init(this, "box");
        System.out.println(myWorld);

        myWorld.display();

//        addItem(new LittleGoomba(this, 21, 12, 21));
//        addItem(new LittleGoomba(this, 42, 12, 41));
//        addItem(new LittleGoomba(this, 52, 12, 51));
//        addItem(new LittleGoomba(this, 54, 12, 53));

        ModuleMemoire.setPlayer(new Player(this, "mario_1", 5, 9));
        addItem(ModuleMemoire.getPlayer());
    }

    @Override
    protected void drawBackground(Graphics graphics) {
        graphics.setColor(new Color(92, 158, 252));
        graphics.fillRect(0, 0, getWidth(), getHeight());
    }

    @Override
    protected void lost() {
        JOptionPane.showMessageDialog(this, "Vous avez perdu !!");
    }

    @Override
    protected void win() {
        JOptionPane.showMessageDialog(this, "Vous avez gagné !!");
    }

    @Override
    protected boolean isPlayerWin() {
        return ModuleMemoire.getPlayer().getWin();
    }

    @Override
    protected boolean isPlayerLost() {
        return !ModuleMemoire.getPlayer().getIsAlive();
    }

    @Override
    public Vector getGravity() {
        return new Vector(1, 1);
    }
}
