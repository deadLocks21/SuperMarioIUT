package supermarioiut.metier.intheworld;

import iut.Game;
import iut.GameItem;
import supermarioiut.metier.intheworld.backgrounds.BackgroundFactory;
import supermarioiut.metier.intheworld.blocks.BlockFactory;
import supermarioiut.metier.intheworld.movable.enemy.LittleGoomba;

public class InTheWorldFactory {
    public static GameItem create(Game g, int x, int y, String type){
        GameItem ret = null;

        ret = BackgroundFactory.create(g, x, y, type);

        if (ret == null)
            ret = BlockFactory.create(g, x, y, type);

        // TODO Implémenter une fabrique à objet prenant en compt
        if (type.equals("LITTLE_GOOMBA"))
            ret = new LittleGoomba(g, x, y);

        return ret;
    }
}
