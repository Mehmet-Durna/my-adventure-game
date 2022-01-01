
public class BattleLoc extends Location {
    protected Obstacle obstacle;
    protected Item dropItem;

    BattleLoc(Player player, String name, Obstacle obstacle, Item dropItem) {
        super(player, name);
        this.obstacle = obstacle;
        this.dropItem = dropItem;
    }



    public boolean getLocation() {
        int obsCount = obstacle.count();
        System.out.println("\n\nYou are in the : " + this.getName());
        System.out.println("Be aware! Here lives " + obsCount + " " + obstacle.getName());
        System.out.print("<F>ight or <E>scape :");
        String selCase = scan.nextLine();
        selCase = selCase.toUpperCase();
        if (selCase.equals("F") || selCase.equals("E")) {
            if (selCase.equals("F")) {
                if (combat(obsCount)) {
                    System.out.println("You killed all the monsters in the " + this.getName());
                    System.out.println("You find a "+ getDropItem().getItemName() + "\n Dou you want to add it to your bag? ");
                    System.out.println("Yes or No");
                    itemDecision();
                    return true;
                }
            }

            if (selCase.equals("E")) {
                getPlayer().setHealthy(getPlayer().getHealthy()/2);
                getPlayer().setMoney(getPlayer().getMoney()/2);
                return true;
            }


            if (getPlayer().getHealthy() <= 0) {
                System.out.println("You are DEAD !");
                return false;
            }

        }

        return true;
    }

    public boolean combat(int obsCount) {
        for (int i = 0; i < obsCount; i++) {
            int defObsHealth = obstacle.getHealth();
            getPlayer().playerStats();
            enemyStats();
            while (getPlayer().getHealthy() > 0 && obstacle.getHealth() > 0) {
                System.out.print("<A>ttack or <R>un :");
                String selCase = scan.nextLine();
                selCase = selCase.toUpperCase();
                if (selCase.equals("A")) {
                    System.out.println("You Hit !");
                    obstacle.setHealth(obstacle.getHealth() - getPlayer().getTotalDamage());
                    afterHit();
                    if (obstacle.getHealth() > 0) {
                        System.out.println();
                        System.out.println(obstacle.getName() + "Hit !");
                        getPlayer().setHealthy(getPlayer().getHealthy() - (obstacle.getDamage() - getPlayer().getCurrentArmor().getBlock()));
                        afterHit();
                    }
                } else if (selCase.equals("R")){
                    getPlayer().setHealthy(getPlayer().getHealthy()/2);
                    getPlayer().setMoney(getPlayer().getMoney()/2);
                    return false;
                }
                else {
                    System.out.println("Please press <A> to attack or press <R> to run ");
                }
            }

            if (obstacle.getHealth() < getPlayer().getHealthy()) {
                System.out.println("You killed one of the " + obstacle.getName());
                getPlayer().setMoney(getPlayer().getMoney() + obstacle.getAward());
                System.out.println("Now you have : " + getPlayer().getMoney());
                obstacle.setHealth(defObsHealth);
            } else {
                return false;
            }
            System.out.println("-------------------");
        }
        return true;
    }


public void itemDecision(){
    String choice = scan.nextLine();
    choice.toLowerCase();
    if (choice.equals("yes")){
        if (getPlayer().getBagCurrentWeight()+getDropItem().getWeight()<=getPlayer().getBagCapacity()){
            getPlayer().addBag(getDropItem());
            System.out.println( getDropItem().getItemName() + " is added to your bag");
        }
        else{
            System.out.println("Not enough space in the bag!");
        }


    }else if (!choice.equals("no")){
        System.out.println("Not valid entry");
        itemDecision();
    }

}

    public void enemyStats() {
        System.out.println("\n" + obstacle.getName() + " Stats\n--------------");
        System.out.println("Health: " + obstacle.getHealth());
        System.out.println("Damage: " + obstacle.getDamage());
        System.out.println("Award: " + obstacle.getAward());
    }

    public void afterHit() {
        System.out.println("Player health: " + getPlayer().getHealthy());
        System.out.println(obstacle.getName() + " Health: " + obstacle.getHealth());
        System.out.println();
    }
    public Item getDropItem() {
        return dropItem;
    }

    public void setDropItem(Item dropItem) {
        this.dropItem = dropItem;
    }

}
