package supermarioiut;

import iut.Vector;
import java.awt.Color;
import java.awt.Graphics;

public class SuperMarioIUT extends iut.Game {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SuperMarioIUT game = new SuperMarioIUT();
        game.play();
    }

    public SuperMarioIUT() {
        super(1024, 960, "Super Mario IUT");
    }

    @Override
    protected void createItems() {
        Player j = new Player(this, (this.getWidth()/2) - 16, this.getHeight()/2  - 32);
        this.addItem(j);
    }

    @Override
    protected void drawBackground(Graphics graphics) {
        graphics.setColor(new Color(92, 158, 252));
        graphics.fillRect(00, 0, getWidth(), getHeight());
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