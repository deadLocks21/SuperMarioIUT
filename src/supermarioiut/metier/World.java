package supermarioiut.metier;

import iut.Game;
import iut.GameItem;
import supermarioiut.metier.intheworld.backgrounds.*;
import supermarioiut.metier.intheworld.blocks.*;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

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
     * Stocke les données du monde.
     */
    private HashMap<String, Object> data;
    /**
     * Nombre de pixel pour un bloc.
     */
    private int PIXEL_FOR_A_BLOCK = 64;
    /**
     * Liste des items du jeu.
     */
    private ArrayList<GameItem> listeDesObjets;
    /**
     * Permet de stocker le monde de manière théorique et de gérer les collisions.
     */
    private String[][] theoricWorld;


    /**
     * Initialise la classe World.
     */
    private World(){
        setGame(null);
        setWorldName(null);
        listeDesObjets = new ArrayList<>();
        data = new HashMap<>();
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

    public String[][] getTheoricWorld(){
        return theoricWorld;
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

            getData();

            String size = (String) data.get("size");
            String[] wh = size.split("x");

            int w = Integer.parseInt(wh[0]);
            int h = Integer.parseInt(wh[1]);

            theoricWorld = new String[h][w];

            getObjectList();
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
        for (GameItem item : listeDesObjets) {
            game.addItem(item);
        }
    }

    /**
     * Permet de récupérer le contenu du monde et de le stocker dans la liste.
     */
    private void getObjectList(){
        File repo = new File("res\\worlds\\" + worldName + "\\items\\");
        String[] objectName = repo.list();

        if (objectName != null) {
            for (String s : objectName) {

                try {
                    InputStream flux = new FileInputStream("res\\worlds\\" + worldName + "\\items\\" + s);
                    InputStreamReader lecture = new InputStreamReader(flux);
                    BufferedReader buff = new BufferedReader(lecture);
                    String ligne;
                    while ((ligne = buff.readLine()) != null) {
                        // TODO Ajouter les blocs et leurs spéc.
                        String[] infos = ligne.split(" ");  // On split les coo et les paramètres.
                        int x = Integer.parseInt(infos[0]);  // On récupère x
                        int y = Integer.parseInt(infos[1]);  // On récupère y

                        GameItem object = null;

                        switch (s) {
                            case "FLOOR":
                                object = new Floor(game, x, y);
                                break;
                            case "LUCKY_BOX":
                                object = new LuckyBox(game, x, y);
                                break;
                            case "SOLID_WALL":
                                object = new SolidWall(game, x, y);
                                break;
                            case "WALL":
                                object = new Wall(game, x, y);
                                break;
                            case "PIPE_2":
                                 object = new Pipe(game, x, y, 2);
                                 break;
                            case "PIPE_3":
                                object = new Pipe(game, x, y, 3);
                                break;
                            case "PIPE_4":
                                object = new Pipe(game, x, y, 4);
                                break;
                            default:
                                object = BackgroundFactory.create(game, x, y, s);
                        }

                        if (object != null) {
                            listeDesObjets.add(object);

                            if(!object.getItemType().equals("BACKGROUND")) {
                                theoricWorld[y][x] = object.getItemType();

                                if(object.getItemType().contains("PIPE")){
                                    theoricWorld[y][x] = object.getItemType();

                                    if (object.getItemType().equals("PIPE_2"))
                                        theoricWorld[y + 1][x] = object.getItemType();

                                    if (object.getItemType().equals("PIPE_3")) {
                                        theoricWorld[y + 1][x] = object.getItemType();
                                        theoricWorld[y + 2][x] = object.getItemType();
                                    }

                                    if (object.getItemType().equals("PIPE_4")) {
                                        theoricWorld[y + 1][x] = object.getItemType();
                                        theoricWorld[y + 2][x] = object.getItemType();
                                        theoricWorld[y + 3][x] = object.getItemType();
                                    }
                                }
                            }
                        }
                    }
                    buff.close();
                } catch (Exception e) {
                    System.out.println(e.toString());
                }
            }
        } else {
            System.err.println("Nom de repertoire invalide");
        }
    }

    /**
     * Permet de récupérer les datas du monde.
     */
    private void getData(){
        try {
            InputStream flux = new FileInputStream("res\\worlds\\" + worldName + "\\data");
            InputStreamReader lecture = new InputStreamReader(flux);
            BufferedReader buff = new BufferedReader(lecture);

            String ligne;
            while ((ligne = buff.readLine()) != null) {
                System.out.println(ligne);
                String[] d = ligne.split(" : ");
                data.put(d[0], d[1]);
            }

            buff.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        String size = (String) data.get("size");
        String[] wh = size.split("x");

        data.put("w", Integer.parseInt(wh[0]));
        data.put("h", Integer.parseInt(wh[1]));
    }


     @Override
    public String toString(){
         int w = (int) data.get("w");
         int h = (int) data.get("h");
         String ret = "";

         System.out.println("\nTheoricWorld :");

         for(int y = 0; y < h; y ++) {
             for (int x = 0; x < w; x++) {
                 // Un SWITCH/CASE fait planter le jeu ...
                 try{
                     if ("FLOOR".equals(theoricWorld[y][x])) {
                         ret += "F";
                     } else if ("LUCKY_BOX".equals(theoricWorld[y][x])) {
                         ret += "L";
                     } else if ("SOLID_WALL".equals(theoricWorld[y][x])) {
                         ret += "S";
                     } else if ("WALL".equals(theoricWorld[y][x])) {
                         ret += "W";
                     } else if ("PIPE_2".equals(theoricWorld[y][x])) {
                         ret += "P";
                     }  else if ("PIPE_3".equals(theoricWorld[y][x])) {
                         ret += "P";
                     }  else if ("PIPE_4".equals(theoricWorld[y][x])) {
                         ret += "P";
                     }  else {
                         ret += " ";
                     }
                 } catch (IndexOutOfBoundsException err){
                     // Quand je demande un mauvais index, ce qui arrive de manière courante
                 }
             }
             ret += "\n";
         }

         return ret;
    }
}

