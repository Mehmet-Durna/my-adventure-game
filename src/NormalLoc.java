
public abstract class NormalLoc extends Location{

	NormalLoc(Player player,String name) {
		super(player,name);

	}


	public boolean getLocation() {
		getPlayer().setHealthy(getPlayer().getrHealthy());
		System.out.println("Your are healed");
		System.out.println("You are in the "+ this.getName());
		return true;
	}


}
