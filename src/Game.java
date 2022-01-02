import java.util.*;

public class Game {
    Player player;
    Scanner scan = new Scanner(System.in);


    public void login() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to Sro adventure game !");
        System.out.println("Tell your name before starting");
        String playerName = scan.nextLine();
        player = new Player(playerName);
        player.selectCha();
        GameUtils.createMap(player);

        start();
    }

    public void start() {

        while (true) {

            if (player.getBag().contains(GameUtils.getElixer())
                    && player.getBag().contains(GameUtils.getExcalibur())
                    && player.getBag().contains(GameUtils.getStaf())
                    && player.getBag().contains(GameUtils.getSanta())
                    && player.getBag().contains(GameUtils.getWing())) {
                System.out.println("Congratulations you collect all the special items and \n     " +
                        " You WIN the game !");
                break;
            }

            HashMap<String, Location> exits = player.getCurrentLocation().getExits();
            System.out.println("\n=================================================\n");
            player.playerStats();
            System.out.println("\n\n");
            System.out.println("Available Locations: ");
            menu();
            System.out.print("Your decision is: ");
            String selLoc = scan.nextLine();
            selLoc = selLoc.replaceAll("\\s", "").toLowerCase();
            Location temp;


            while (!exits.containsKey(selLoc) && !selLoc.equals("back")) {

                if (selLoc.equals("look")) {
                    look();
                    menu();
                } else
                    System.out.print("Please enter a valid location name : ");
                selLoc = scan.nextLine();
            }
            if (selLoc.equals("back")) {
                temp = player.getPreviousLocation();
                player.setPreviousLocation(player.getCurrentLocation());
                player.setCurrentLocation(temp);

            } else {
                player.setPreviousLocation(player.getCurrentLocation());
                player.setCurrentLocation(exits.get(selLoc));
            }


            if (!player.getCurrentLocation().getLocation()) {
                System.out.println("Game over !");
                break;
            }

        }
    }

    public void look() {
        if (player.getBag().isEmpty()) {
            System.out.println("Bag is empty");
        } else
            System.out.println("-------------Bag List -------------");
        System.out.println("0. Quit");

        for (int i = 0; i < player.getBag().size(); i++) {
            System.out.print((i + 1) + ". " + player.getBag().get(i).getItemName() + "\n");
        }
        System.out.println("Bag current weight: " + player.getBagCurrentWeight() + "/" + player.getBagCapacity());
        System.out.println("Enter the number of item you want to equip ! ");

        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();


        if (number == 0) {
            System.out.println("Exiting inventory");
        } else {
            Item item = (player.getBag().get(number - 1));

            if (item.getItemType().equals("Armor")) {
                player.getBag().add(player.getCurrentArmor());
                player.setCurrentArmor(item);
                player.getBag().remove(player.getCurrentArmor());
            } else if (item.getItemType().equals("Weapon")) {
                player.getBag().add(player.getCurrentWeapon());
                player.setCurrentWeapon(item);
                player.getBag().remove(player.getCurrentWeapon());

            } else if (item.getItemType().equals("Potion")) {
                if (item.getItemName().equals("Health Potion")) {
                    player.setHealthy(player.getrHealthy());
                } else {
                    player.setDamage(player.getDamage() + 6);
                }
            } else {
                System.out.println("You can not equip special items");
            }
        }

        System.out.println("Your current weapon is " + player.getCurrentWeapon().getItemName());
        System.out.println("Your current armor is " + player.getCurrentArmor().getItemName());

        System.out.println("\n\n-----------------------------------");
    }

    public void menu() {

        Location currentLocation = player.getCurrentLocation();
        HashMap<String, Location> exits = currentLocation.getExits();
        for (String direction : exits.keySet()) {
            System.out.println("Go to " + exits.get(direction).getName());
        }

        System.out.println("<Look> what you have in your bag");
        System.out.println("Back");
    }


}
