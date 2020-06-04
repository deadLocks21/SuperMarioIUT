package supermarioiut.metier;

import supermarioiut.metier.intheworld.movable.Player;

public class ModuleMemoire {
    private static Player player;

    public static void setPlayer(Player p){
        player = p;
    }

    public static Player getPlayer(){
        return player;
    }
}
