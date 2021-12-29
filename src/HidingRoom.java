public class HidingRoom extends NormalLoc{
    HidingRoom(Player player) {
        super(player, "Hiding Room");
    }

    public boolean getLocation() {
        getPlayer().setHealthy(getPlayer().getrHealthy());
        System.out.println("Your health is healed");
        System.out.println("You are in the "+ this.getName());
        return true;
    }
}
