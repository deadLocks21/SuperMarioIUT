package supermarioiut.metier.intheworld.blocks;

import iut.Game;

/**
 * Représente un tuyau.
 */
public class Pipe extends Block {
    /**
     * Taille du tuyau.
     */
    private int size;

    /**
     * Constructeur d'un bloc de notre monde.
     *
     * @param g   Jeu dans lequel on se trouve.
     * @param x   Valeur ou il apparait.
     * @param y   Valeur ou il apparait.
     */
    public Pipe(Game g, int x, int y, int size) {
        super(g, "interactive\\inert\\pipe_" + size, x, y);

        this.size = size;
    }


    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }


    @Override
    public String getItemType() {
        return "PIPE_" + size;
    }
}
