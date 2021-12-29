import java.util.HashMap;
import java.util.Scanner;

public abstract class Location {
    private Player player;
    private String name;
    private HashMap<String, Location> exits;

    Scanner scan = new Scanner(System.in);

    Location(Player player, String name) {
        this.player = player;
        this.name = name;
        exits = new HashMap<>();
    }

    public void putExit(String direction, Location location) {
        exits.put(direction, location);
    }

    public HashMap<String, Location> getExits() {
        return exits;
    }

    public abstract boolean getLocation();

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
