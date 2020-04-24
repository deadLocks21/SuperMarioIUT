package supermarioiut;

import iut.Game;
import iut.Vector;
import java.awt.Color;
import java.awt.Graphics;

public class SuperMarioIUT extends iut.Game {
    private World world = new World(14, 14);
    private int pixelForBlock = 64;

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


    private void drawTheWorld(Game g){
        int hauteurInverse = 1;
        for(int y = world.getSize()[1] - 1; y >= 0; y --){
            for(int x = 0; x < world.getSize()[0];x ++){
                switch (world.compositionOfTheTile(x, y)){
                    case "":
                        break;
                    case "floor" :
                        Floor f = new Floor(this, x*pixelForBlock, this.getHeight() - hauteurInverse*pixelForBlock);
                        g.addItem(f);
                        break;
                }
            }
            hauteurInverse++;
        }
    }


    @Override
    protected void createItems() {
        drawTheWorld(this);
        Player j = new Player(this, (this.getWidth()/2) - 16, this.getHeight()/2  - 32);
        this.addItem(j);
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