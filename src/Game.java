import java.util.HashMap;
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

            if (player.getBag().contains(GameUtils.getElixer())
                    && player.getBag().contains(GameUtils.getExcalibur())
                    && player.getBag().contains(GameUtils.getStaf())
                    && player.getBag().contains(GameUtils.getSanta())
                    && player.getBag().contains(GameUtils.getWing())) {
                System.out.println("Congratulations you collect all the special items and \n     " +
                        " You WIN the game !");
                break;
            }

            Location current = player.getCurrentLocation();
            HashMap<String, Location> exits = current.getExits();


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
                    System.out.println("0. Quit");

                    for (int i = 0; i < player.getBag().size(); i++) {
                        System.out.print((i + 1) + ". " + player.getBag().get(i).getItemName() + "\n");
                    }

                    System.out.println("Enter the number of item you want to equip ! ");

                    Scanner scanner = new Scanner(System.in);
                    int number = scanner.nextInt();

                    try {
                        if (player.getBag().get(number - 1).getItemType().equals("Armor")) {
                            player.setCurrentArmor(player.getBag().get(number - 1));
                        }  else if (player.getBag().get(number - 1).getItemType().equals("Weapon")){
                            player.setCurrentWeapon(player.getBag().get(number - 1));
                        }else{
                            System.out.println("You can not equip special items");
                        }
                    }catch (Exception e ){
                        System.out.println("Exiting inventory...");
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
