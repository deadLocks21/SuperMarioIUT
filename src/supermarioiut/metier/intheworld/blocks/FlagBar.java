package supermarioiut.metier.intheworld.blocks;

import iut.Game;

public class FlagBar extends Block {
    /**
     * Constructeur d'un bloc de notre monde.
     *
     * @param g   Jeu dans lequel on se trouve.
     * @param x   Valeur ou il apparait.
     * @param y   Valeur ou il apparait.
     */
    public FlagBar(Game g, int x, int y) {
        super(g, "interactive\\inert\\flagBar", x, y);
    }

    @Override
    public String getItemType() {
        return "FLAG_BAR";
    }
}
