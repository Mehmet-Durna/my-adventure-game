import java.util.Map;
import java.util.Scanner;

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

            if (player.getBag().contains(GameUtils.getGun())
                    && player.getBag().contains(GameUtils.getAxe())) {
                System.out.println("Congratulations you win the game !");
                break;
            }

            Location current = player.getCurrentLocation();
            Map<String, Location> exits = current.getExits();


            System.out.println("\n=================================================\n");


            player.playerStats();
            System.out.println("\n\n");
            System.out.println("What is your next move: ");
            for (String direction : exits.keySet()) {
                System.out.println("Go to " + exits.get(direction).getName());
            }

            System.out.println("<Look> what you have in your bag");

            System.out.print("Your decision is: ");
            String selLoc = scan.nextLine();
            selLoc = selLoc.replaceAll("\\s", "").toLowerCase();


            while (!exits.containsKey(selLoc)) {


                if (selLoc.equals("look")) {
                    if (player.getBag().isEmpty()) {
                        System.out.println("Bag is empty");
                    } else
                        System.out.println("-------------Bag List -------------");

                    for (int i = 0; i < player.getBag().size(); i++) {
                        System.out.print((i + 1) + ". " + player.getBag().get(i).getItemName() + "\n");
                    }

                    System.out.println("Press number of item you want to equip ! ");
                    Scanner scanner = new Scanner(System.in);
                    int number = scanner.nextInt();

                    if (player.getBag().get(number - 1).getItemType().equals("Armor")) {
                        player.setCurrentArmor(player.getBag().get(number - 1));
                    } else {
                        player.setCurrentWeapon(player.getBag().get(number - 1));
                    }

                    System.out.println("Your current weapon is " + player.getCurrentWeapon().getItemName());
                    System.out.println("Your current armor is " + player.getCurrentArmor().getItemName());

                    System.out.println("\n\n-----------------------------------");
                    for (String direction : exits.keySet()) {
                        System.out.println("Go to " + exits.get(direction).getName());
                    }
                    System.out.println("<Look> what you have in your bag");
                } else
                    System.out.print("Please enter a valid location name : ");
                selLoc = scan.nextLine();
            }


            Location currentLocation = exits.get(selLoc);
            player.setCurrentLocation(currentLocation);


            if (!currentLocation.getLocation()) {
                System.out.println("Game over !");
                break;
            }

        }
    }
}
