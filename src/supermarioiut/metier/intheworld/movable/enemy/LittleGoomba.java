package supermarioiut.metier.intheworld.movable.enemy;

import iut.Game;

/**
 * Stocke un littleGoomba.
 */
public class LittleGoomba extends Enemy {
    /**
     * Skin de notre personnage.
     */
    String skin;
    /**
     * Nombre d'image pour les animations.
     */
    int nbImg;
    /**
     * TRUE si l'enemy est mort.
     */
    boolean dead;

    /**
     * Constructeur d'un littleGoomba.
     *
     * @param g   Jeu dans lequel on se trouve.
     * @param x   Coordonnée x ou pop notre personnage.
     * @param y   Coordonnée y ou pop notre personnage.
     */
    public LittleGoomba(Game g, int x, int y) {
        super(g, "interactive\\animated\\mobile\\littleGoomba\\walk_1", x, y);

        skin = "walk_2";
        nbImg = 10;
        dead = false;
    }


    @Override
    protected void skinGestion() {
        if (!dead) {
            if (getIsAlive()) {
                if (nbImg == 30) {
                    nbImg = 0;

                    if (skin == "walk_1")
                        skin = "walk_2";
                    else
                        skin = "walk_1";
                }
            }
            else {
                dead = true;
                skin = "death";
            }
        }
        else {
            if (nbImg == 60)
                moveXY(0, 960);
        }

        nbImg ++;
        changeSprite("interactive\\animated\\mobile\\littleGoomba\\" + skin);
    }
}
