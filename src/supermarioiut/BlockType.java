package supermarioiut;

public enum BlockType {
    /**
     * Représente un bloc du sol.
     */
    FLOOR,
    /**
     * Sol du monde souterrain.
     */
    BLUE_FLOOR,
    /**
     * Mur du monde.
     */
    WALL,
    /**
     * Mur du monde souterrain.
     */
    BLUE_WALL,
    /**
     * Mur solide.
     */
    SOLID_WALL,
    /**
     * Boite contenant un champignon.
     */
    LUCKY_BOX,
    /**
     * LuckyBox récupérée.
     */
    OLD_LUCKY_BOX,
    /**
     * Bloc caché dans le monde.
     */
    HIDDEN_BOX,
    /**
     * Bloc d'air.
     */
    VOID
}
