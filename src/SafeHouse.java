
public class SafeHouse extends NormalLoc {

	SafeHouse(Player player) {
		super(player, "Safe House");
	}
	
	public boolean getLocation() {
		getPlayer().setHealthy(getPlayer().getrHealthy());
		System.out.println("Your health is healed");
		System.out.println("You are in the safe house.");
		return true;
	}

}
