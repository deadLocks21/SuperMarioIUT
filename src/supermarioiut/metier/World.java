package supermarioiut.metier;

import iut.Game;
import iut.GameItem;

import java.awt.*;
import java.util.ArrayList;

/**
 * Classe unique permettant de gérer l'affichage d'un monde.
 */
public class World {
    /**
     * Représente l'instance unique de World.
     */
    private static World instance;
    /**
     * Game ou je dois afficher le jeu.
     */
    private Game game;
    /**
     * Nom du monde à afficher.
     */
    private String worldName;
    /**
     * Nombre de pixel pour un bloc.
     */
    private final int PIXEL_FOR_A_BLOCK = 64;
    /**
     * Liste des items du jeu.
     */
    private ArrayList<GameItem> listeDesObjets;


    /**
     * Initialise la classe World.
     */
    private World(){
        setGame(null);
        setWorldName(null);
    }


    /**
     * Assesseur de l'unique instance de World.
     *
     *
     * @return Unique instance de World.
     */
    public static World getInstance(){
        if(instance == null)
            instance = new World();

        return instance;
    }

    /**
     * Mutateur de la variable game.
     *
     *
     * @param game Jeu dans lequel on affiche le monde.
     */
    public void setGame(Game game) {
        this.game = game;
    }

    /**
     * Mutateur de wolrdName.
     *
     *
     * @param worldName Nom du monde à afficher.
     */
    public void setWorldName(String worldName) {
        this.worldName = worldName;
    }


    /**
     * Permet d'initialiser les variables de la classe.
     *
     *
     * @param game      Valeur de la variable game.
     * @param worldName Valeur de la variable worldName.
     */
    public void init(Game game, String worldName){
        if(instance != null) {
            setGame(game);
            setWorldName(worldName);
        }
    }

    /**
     * Permet de nettoyer l'affichage du jeu.
     */
    public void clear(){
        for (GameItem item : listeDesObjets)
            game.remove(item);

        listeDesObjets.clear();
    }

    /**
     * Permet d'afficher le monde worldName.
     */
    public void display(){
        // TODO Affichage des contenus des fichiers.

        // Méthode d'affichage d'avant.
        /*
         * Affiche theoricWorld.
         *
         *
         * @param world         Monde dont dépendent les blocs.
         * @param pixelForBlock Nombre de pixels pour un bloc.
         */
        /*public void display(World world, int pixelForBlock){
            int hauteurInverse = 1;
            for(int y = theoricWorld.getSize()[1] - 1; y >= 0; y --){
                for(int x = 0; x < theoricWorld.getSize()[0]; x ++){
                    switch (theoricWorld.compositionOfTheTile(x, y)){
                        case "F" :
                            Floor f = new Floor(game, world, x*pixelForBlock, game.getHeight() - hauteurInverse*pixelForBlock);
                            game.addItem(f);
                            break;
                        case "L" :
                            LuckyBox l = new LuckyBox(game, world, x*pixelForBlock, game.getHeight() - hauteurInverse*pixelForBlock);
                            game.addItem(l);
                            break;
                        case "W" :
                            Wall w = new Wall(game, world, x*pixelForBlock, game.getHeight() - hauteurInverse*pixelForBlock);
                            game.addItem(w);
                            break;
                    }
                }
                hauteurInverse++;
            }
        }*/
    }

    /**
     * Permet de changer la couleur du fond de notre jeu.
     * (Utilisé notament pour les mondes souterrains.)
     *
     *
     * @param color Nouvelle couleur de background.
     */
    public void backgroundColor(Color color){
        game.setBackground(color);
    }
}

