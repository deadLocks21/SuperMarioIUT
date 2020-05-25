package supermarioiut.metier.world.theoricWorld;

/**
 * Classe permettant de savoir de quoi est composé un monde.
 */
public class TheoricWorld {
    /**
     * Tableau à deux dimensions permettant de stocker la composition d'un monde.
     */
    private String[][] compisitionOfTheWorld;
    /**
     * Nom du monde.
     */
    private String worldName;


    /**
     * Initialise un monde de taille width par heigth en fonction du type.
     *
     *
     * @param worldName Nom du monde.
     * @param width     Largeur du monde.
     * @param height    Hauteur du monde.
     * @param type      Type du monde.
     */
    public TheoricWorld(String worldName, int width, int height, TheoricWorldType type) {
        this.worldName = worldName;
        create(width, height, type);
    }

    /**
     * Récupére un monde à partir du fichier worldName.
     *
     *
     * @param worldName Nom du monde à récupérer.
     */
    public TheoricWorld(String worldName) {
        this.worldName = worldName;
        getFromFile();
    }


    /**
     * Assesseur variable worldName.
     *
     *
     * @return Variable worldName.
     */
    public String getWorldName() {
        return this.worldName;
    }

    /**
     * Assesseur de la variable compisitionOfTheWorld.
     *
     *
     * @return Variable compisitionOfTheWorld
     */
    public String[][] getCompisitionOfTheWorld() {
        return this.compisitionOfTheWorld;
    }

    /**
     * Assesseur de la taille de notre monde.
     *
     *
     * @return Tableau représentant {width, height}.
     */
    public int[] getSize() {
        return new int[]{compisitionOfTheWorld[0].length, compisitionOfTheWorld.length};
    }

    /**
     * Mutateur de worldName.
     *
     *
     * @param worldName Nouvelle valeur de worldName.
     */
    public void setWorldName(String worldName) {
        this.worldName = worldName;
    }


    /**
     * Change le carreau (x, y) en tile de notre monde.
     *
     *
     * @param x         Valeur x de la case à changer.
     * @param y         Valeur y de la case à changer.
     * @param blockName Case à changer.
     */
    private void changeATile(int x, int y, String blockName) {
        compisitionOfTheWorld[y][x] = blockName;
    }

    /**
     * Retourne le nom du bloc présent aux coordonnées (x, y)
     */
    public String compositionOfTheTile(int x, int y) {
        return compisitionOfTheWorld[y][x];
    }

    /**
     * Génère un monde de la taille souhaité et du type demandé.
     */
    private void create(int width, int height, TheoricWorldType type) {
        compisitionOfTheWorld = TheoricWorldFactory.create(width, height, type);
    }

    /**
     * Récupère le contenu du fichier texte passé en paramètre et initialise le monde avec ces infos.
     */
    private void getFromFile() {
        // TODO Récupérer les infos dans un fichiers.
        throw new UnsupportedOperationException();
    }

    /**
     * Sauvegarde le monde dans un fichier texte au nom du monde.
     */
    public void save() {
        // TODO Sauvegarde le contenu du fichier.
        throw new UnsupportedOperationException();
    }


    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder();

        for(int y = 0; y < compisitionOfTheWorld.length; y ++){
            for(int x = 0; x < compisitionOfTheWorld[y].length;x ++){
                switch (compositionOfTheTile(x, y)){
                    /*case "":
                        ret.append("0");
                        break;
                    case "floor" :
                        ret.append("F");
                        break;*/
                    default:
                        ret.append("V");
                    // TODO Ajouter les nouveaux blocks.
                }
            }
            ret.append("\n");
        }

        return ret.toString();
    }
}
