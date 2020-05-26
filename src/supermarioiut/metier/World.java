package supermarioiut.metier;

import iut.BoxGameItem;
import iut.Game;
import iut.BoxGameItem;
import supermarioiut.metier.intheworld.backgrounds.*;
import supermarioiut.metier.intheworld.blocks.Floor;
import supermarioiut.metier.intheworld.blocks.LuckyBox;
import supermarioiut.metier.intheworld.blocks.SolidWall;
import supermarioiut.metier.intheworld.blocks.Wall;

import java.awt.*;
import java.io.*;
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
    private ArrayList<BoxGameItem> listeDesObjets;


    /**
     * Initialise la classe World.
     */
    private World(){
        setGame(null);
        setWorldName(null);
        listeDesObjets = new ArrayList<>();
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

            getObjectList();
        }
    }

    /**
     * Permet de nettoyer l'affichage du jeu.
     */
    public void clear(){
        for (BoxGameItem item : listeDesObjets)
            game.remove(item);

        listeDesObjets.clear();
    }

    /**
     * Permet d'afficher le monde worldName.
     */
    public void display(){
        for (BoxGameItem item : listeDesObjets) {
            game.addItem(item);
        }
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

    private void getObjectList(){
        File repo = new File("res\\worlds\\" + worldName + "\\items\\");
        String objectName[] = repo.list();

        if (objectName != null) {
            for (int i = 0; i < objectName.length; i++) {

                try{
                    InputStream flux=new FileInputStream("res\\worlds\\" + worldName + "\\items\\" + objectName[i]);
                    InputStreamReader lecture=new InputStreamReader(flux);
                    BufferedReader buff=new BufferedReader(lecture);
                    String ligne;
                    while ((ligne=buff.readLine())!=null){
                        // TODO Ajouter les blocs et leurs spéc.
                        String[] infos = ligne.split(" ");  // On split les coo et les paramètres.
                        int x = Integer.parseInt(infos[0]) * PIXEL_FOR_A_BLOCK;  // On récupère x
                        int y = Integer.parseInt(infos[1]) * PIXEL_FOR_A_BLOCK;  // On récupère y

                        BoxGameItem object = null;

                        switch (objectName[i]){
                            case "BUSH_1":
                                object = new Bush1(game, x, y);
                                break;
                            case "BUSH_2":
                                object = new Bush2(game, x, y);
                                break;
                            case "BUSH_3":
                                object = new Bush3(game, x, y);
                                break;
                            case "CASTLE":
                                object = new Castle(game, x, y);
                                break;
                            case "CLOUD_1":
                                object = new Cloud1(game, x, y);
                                break;
                            case "CLOUD_2":
                                object = new Cloud2(game, x, y);
                                break;
                            case "CLOUD_3":
                                object = new Cloud3(game, x, y);
                                break;
                            case "FLOOR":
                                object = new Floor(game, x, y);
                                break;
                            case "HILL_1":
                                object = new Hill1(game, x, y);
                                break;
                            case "HILL_2":
                                object = new Hill2(game, x, y);
                                break;
                            case "LUCKY_BOX":
                                object = new LuckyBox(game, x, y);
                                break;
                            case "PIPE_1":
                                object = new Pipe1(game, x, y);
                                break;
                            case "PIPE_2":
                                object = new Pipe2(game, x, y);
                                break;
                            case "PIPE_3":
                                object = new Pipe3(game, x, y);
                                break;
                            case "SOLID_WALL":
                                object = new SolidWall(game, x, y);
                                break;
                            case "WALL":
                                object = new Wall(game, x, y);
                                break;
                        }

                        if(object != null)
                            listeDesObjets.add(object);
                    }
                    buff.close();
                }
                catch (Exception e){
                    System.out.println(e.toString());
                }

                System.out.println(objectName[i]);
            }
        } else {
            System.err.println("Nom de repertoire invalide");
        }
    }
}

