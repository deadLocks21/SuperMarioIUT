package supermarioiut;

import iut.Game;
import iut.GameItem;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class OldPlayer extends OldBackground implements KeyListener{
    boolean gravityEffect = true;
    boolean collideLeft = false;
    boolean collideRight = false;
    boolean collideTop = false;
    int walkspeed = 32;

    public OldPlayer(Game g, int x, int y) {
        super(g, "mario", 80, y);
    }


    private void initCollide(){
        gravityEffect = true;
        collideLeft = false;
        collideRight = false;
        collideTop = false;
    }


    @Override
    public boolean isCollide(GameItem o) {
        return super.isCollide(o);
    }

    @Override
    public void collideEffect(GameItem o) {
        boolean left = this.getLeft() <= o.getRight() && this.getLeft() > o.getRight() - walkspeed;
        boolean right = this.getRight() >= o.getLeft() && this.getRight() < o.getLeft() + walkspeed;
        boolean top = this.getTop() <= o.getBottom() && this.getTop() > o.getBottom() - walkspeed;
        boolean bottom = this.getBottom() >= o.getTop() && this.getBottom() < o.getTop() + walkspeed;

        // Left Collide
        if(left && !top && !bottom) {
            System.out.println("Left Touch");
            collideLeft = true;
            this.moveXY(o.getRight() - this.getLeft(), 0);
        }

        // Right Collide
        if(right && !top && !bottom) {
            System.out.println("Right Touch");
            collideRight = true;
            this.moveXY(o.getLeft() - this.getRight(), 0);
        }

        // Top Collide
        if(top && !right && !left) {
            System.out.println("Top Touch");
            collideTop = true;
            this.moveXY(0, o.getBottom()-this.getTop());
        }

        // Bottom Collide
        if(bottom && !right && !left) {
            System.out.println("Bottom Touch");
            gravityEffect = false;
            this.moveXY(0, o.getTop()-this.getBottom());
        }


//        switch (o.getItemType()){
//            case "floor":
//                gravityEffect = false;
//                break;
//            default:gravityEffect = true;
//        }
    }

    @Override
    public String getItemType() {
        return "mario_2";
    }

    @Override
    public void evolve(long dt) {
        initCollide();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode())
        {
            case KeyEvent.VK_RIGHT:
                if(this.getRight()<this.getGame().getWidth() && !collideRight) {
                    if(this.getRight() > this.getGame().getWidth()/2){
                        super.moveTheWorld(walkspeed);
                    } else this.moveXY(+walkspeed, 0);
                }
                break;
            case KeyEvent.VK_LEFT:
                if(this.getLeft()>0 && !collideLeft)
                    this.moveXY(-walkspeed, 0);
                break;
            case KeyEvent.VK_UP:
                if(this.getBottom()>0 && !collideTop)
                    this.moveXY(0, -walkspeed);
                break;
            case KeyEvent.VK_DOWN:
                if(this.getTop()<this.getGame().getHeight() && gravityEffect)
                    this.moveXY(0, +walkspeed);
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
