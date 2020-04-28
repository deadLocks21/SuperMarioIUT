package supermarioiut;

/**
 * Classe permettant de savoir de quoi est composé un monde.
 * Elle recupère le contenu d'un fichier de texte et l'analyse pour en déduire l'apparence d'une monde.
 * On ne fait ici que stocker la place des blocs dans le monde, rien de plus.
 *
 * Cette classe permet aussi de généré un monde pour tester les différentes fonctionnalités de notre jeu.
 */
public class TheoricWorld {
    /**
     * Tableau à deux dimensions permettant de stocker la composition d'un monde.
     */
    private String[][] _compisitionOfTheWorld;
    private String _worldName;

    /**
     * Initialise un monde de 0x0 vide.
     */
    public TheoricWorld(String aName, int aWidth, int aHeight, WorldType aType) {
        this._worldName = aName;

        generate(aWidth, aHeight, aType);
    }

    public TheoricWorld(String aWorldName) {
        throw new UnsupportedOperationException();
    }

    public String getWorldName() {
        return this._worldName;
    }

    public void setWorldName(String aWorldName) {
        this._worldName = aWorldName;
    }

    /**
     * Permet de récupérer les infos du monde sous une forme simplifié.
     *
     * Exemple:
     * 0000
     * 0000
     * 0000
     * FFFF
     *
     * (monde de 4x4 blocs avec seulement un sol)
     */
    public String[][] getComposition() {
        return _compisitionOfTheWorld;
    }

    /**
     * Retourne la taille du monde sous la forme d'un tableau de deux entiers.
     */
    public int[] getSize() {
        int height = _compisitionOfTheWorld.length;
        int width = height > 0 ? _compisitionOfTheWorld[0].length : 0;

        return new int[]{width, height};
    }

    /**
     * Sauvegarde le monde dans un fichier texte au nom du monde.
     */
    public void save() {
        throw new UnsupportedOperationException();
    }

    /**
     * Version affichable de notre monde.
     */
    public String toString() {
        StringBuilder ret = new StringBuilder();

        for(int y = 0; y < _compisitionOfTheWorld.length; y ++){
            for(int x = 0; x < _compisitionOfTheWorld[y].length;x ++){
                switch (compositionOfTheTile(x, y)){
                    case "":
                        ret.append("0");
                        break;
                    case "floor" :
                        ret.append("F");
                        break;
                }
            }
            ret.append("\n");
        }


        return ret.toString();
    }

    /**
     * Initialise un monde vide de la taille spécifié.
     */
    private void init(int aWidth, int aHeight) {
        _compisitionOfTheWorld = new String[aHeight][aWidth];

        for(int y = 0; y < _compisitionOfTheWorld.length; y ++){
            for(int x = 0; x < _compisitionOfTheWorld[y].length;x ++){
                changeATile(x, y, "");
            }
        }
    }

    /**
     * Change le carreau (x, y) en what de notre monde.
     */
    private void changeATile(int aX, int aY, String aWhat) {
        this._compisitionOfTheWorld[aY][aX] = aWhat;
    }

    /**
     * Retourne le nom du bloc présent aux coordonnées (x, y)
     */
    public String compositionOfTheTile(int aX, int aY) {
        return this._compisitionOfTheWorld[aY][aX];
    }

    /**
     * Génère un monde de la taille souhaité et du type demandé.
     */
    private void generate(int aWidth, int aHeight, WorldType aType) {
        init(aWidth, aHeight);

        switch (aType){
            case VOID:
                break;
            case FLAT:
                addFloor();
                break;
            case BOX:
                addFloor();
                addCeiling();
                addWalls();
                break;

        }
    }

    /**
     * Récupère le contenu du fichier texte passé en paramètre et initialise le monde avec ces infos.
     */
    private void getFromFile(String aWorldName) {
        throw new UnsupportedOperationException();
    }


    private void addFloor(){
        for(int y = _compisitionOfTheWorld.length - 2; y < _compisitionOfTheWorld.length; y ++){
            for(int x = 0; x < _compisitionOfTheWorld[y].length;x ++){
                changeATile(x, y, "floor");
            }
        }
    }

    private void addWalls(){
        for(int y = 0; y < _compisitionOfTheWorld.length; y ++){
            changeATile(0, y, "floor");
        }

        for(int y = 0; y < _compisitionOfTheWorld.length; y ++){
            changeATile(_compisitionOfTheWorld[y].length-1, y, "floor");
        }
    }

    private void addCeiling(){
        for(int x = 0; x < _compisitionOfTheWorld[0].length;x ++){
            changeATile(x, 0, "floor");
        }
    }
}
