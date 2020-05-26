package supermarioiut.metier.intheworld.blocks;

import iut.Game;
import supermarioiut.metier.World;

/**
 * Boite contenant un champignon.
 */
public class LuckyBox extends Block {
    int state = 1;
    int delay = 0;

    /**
     * Constructeur d'un bloc de notre monde.
     *
     * @param g     Jeu dans lequel on se trouve.
     * @param x     Valeur ou il apparait.
     * @param y     Valeur ou il apparait.
     */
    public LuckyBox(Game g, int x, int y) {
        super(g, "interactive\\animated\\immobile\\luckyBox\\state_1", x, y);
    }


    @Override
    public String getItemType() {
        return "LUCKY_BOX";
    }

    @Override
    public void evolve(long l){
        super.evolve(l);
        delay += l;

        if(state == 1){
            if(delay > 300){
                state ++;

                super.changeSprite("interactive\\animated\\immobile\\luckyBox\\state_" + state);

                delay = 0;
            }
        } else {
            if(delay > 100){
                state ++;

                if(state > 4)
                    state = 1;

                super.changeSprite("interactive\\animated\\immobile\\luckyBox\\state_" + state);

                delay = 0;
            }
        }
    }
}
