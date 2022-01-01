import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Player {
    private int damage, healthy, money, rHealthy,bagCapacity;
    private String name, cName;
    private Location currentLocation,previousLocation;
    Scanner scan = new Scanner(System.in);
    private ArrayList<Item> bag;
    private Item currentWeapon;
    private Item currentArmor;



    public Player(String name) {
        this.name = name;
        bag = new ArrayList<>();
        bagCapacity = 10;
        currentArmor = new Item("tshirt", "armor", 0, 1,1);
        currentWeapon = new Item("Stick", "Weapon", 1, 0,0.5);
    }

    public ArrayList<Item> getBag() {
        return bag;
    }
    public int getBagCapacity() {
        return bagCapacity;
    }

    public void setBagCapacity(int bagCapacity) {
        this.bagCapacity = bagCapacity;
    }

    public void addBag(Item item) {
        bag.add(item);
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
    }

    public void selectCha() {
        switch (chaMenu()) {
            case 2:
                initPlayer("Archer", 7, 18, 20);
                break;
            case 3:
                initPlayer("Knight", 8, 24, 5);
                break;
            default:
                initPlayer("Samurai", 5, 21, 15);
                break;
        }
        System.out.println("Character type: " + getcName() + "\n Damage= " + getDamage() + ", Health= "
                + getHealthy() + ", Money= " + getMoney());
    }

    public int chaMenu() {
        System.out.println("Please choose your character : ");
        System.out.println("1- Samurai \t Damage : 5 \t Health :21 \t Money :15");
        System.out.println("2- Archer \t Damage : 7 \t Health :18 \t Money :20");
        System.out.println("3- Knight \t Damage : 8 \t Health :24 \t Money :5");
        System.out.print("Your decision is : ");
        int chaID = 0;

        try {
            chaID = scan.nextInt();
            if (chaID < 1 || chaID > 3) {
                throw new IllegalArgumentException("Character id should be between 1-3 inclusive!");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input type!!");
            scan.next(); //to flush scanner buffer
            chaMenu();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            chaMenu();
        } catch (Exception e) {
            e.printStackTrace();
            chaMenu();
        }

        return chaID;
    }


    public int getTotalDamage() {
        return this.getDamage() + getCurrentWeapon().getDamage();
    }

    public int getTotalHealth() {
        return this.getHealthy() + getCurrentArmor().getBlock();
    }


    public void initPlayer(String cName, int dmg, int hlthy, int mny) {
        setcName(cName);
        setDamage(dmg);
        setHealthy(hlthy);
        setMoney(mny);
        setrHealthy(hlthy);
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealthy() {
        return healthy;
    }

    public void setHealthy(int healthy) {
        this.healthy = healthy;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }


    public int getrHealthy() {
        return rHealthy;
    }

    public void setrHealthy(int rHealthy) {
        this.rHealthy = rHealthy;
    }

    public Item getCurrentWeapon() {
        return currentWeapon;
    }

    public void setCurrentWeapon(Item currentWeapon) {
        this.currentWeapon = currentWeapon;
    }

    public Item getCurrentArmor() {
        return currentArmor;
    }

    public void setCurrentArmor(Item currentArmor) {
        this.currentArmor = currentArmor;
    }

    public Location getPreviousLocation() {
        return previousLocation;
    }

    public void setPreviousLocation(Location previousLocation) {
        this.previousLocation = previousLocation;
    }

    public void playerStats() {
        System.out.println("Player Stats\n--------------");
        System.out.println("Health:" + getHealthy());
        System.out.println("Damage:" + getTotalDamage());
        System.out.println("Money:" + getMoney());
        if (getCurrentWeapon().getDamage() > 0) {
            System.out.println("Weapon:" + getCurrentWeapon().getItemName());
        }
        if (getCurrentArmor().getBlock() > 0) {
            System.out.println("Armor:" + getCurrentArmor().getItemName());
        }
    }

    public double getBagCurrentWeight(){
        double weight =0;
        for (Item item : bag){
            weight += item.getWeight();
        }
        return weight;
    }
}
