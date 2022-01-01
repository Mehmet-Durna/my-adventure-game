
public class ToolStore extends NormalLoc {

    ToolStore(Player player) {
        super(player, "Store");
    }

    public boolean getLocation() {
        System.out.println("You are in the " + this.getName());
        System.out.println("Balance : " + getPlayer().getMoney());
        System.out.println("1. Weapons");
        System.out.println("2. Armors");
        System.out.println("3. Potions");
        System.out.println("4. Quit");
        System.out.print("Your choice : ");
        int selTool = scan.nextInt();
        int selItemID;
        switch (selTool) {
            case 1:
                selItemID = weaponMenu();
                buyWeapon(selItemID);
                break;
            case 2:
                selItemID = armorMenu();
                buyArmor(selItemID);
                break;
            case 3:
                selItemID = potionMenu();
                buyPotion(selItemID);
                break;
            default:
                break;
        }

        return true;
    }

    public int armorMenu() {
        System.out.println("1. Light Armor \t <Price : 15 - Damage : 1>");
        System.out.println("2. Normal Armor \t <Price : 25 - Damage : 3>");
        System.out.println("3. Heavy Armor \t <Price : 40 - Damage : 5>");
        System.out.println("4. Quit");
        System.out.print("Your choice : ");
        int selArmorID = scan.nextInt();
        return selArmorID;
    }

    public void buyArmor(int itemID) {
        Item item = null;
        int price = 0;
        Item lightArmor = new Item("Light Armor", "Armor", 0, 1, 2);
        Item normalArmor = new Item("Normal Armor", "Armor", 0, 1, 3);
        Item heavyArmor = new Item("Heavy Armor", "Armor", 0, 1, 3.7);
        switch (itemID) {
            case 1:
                item = lightArmor;
                price = 15;
                break;
            case 2:
                item = normalArmor;
                price = 25;
                break;
            case 3:
                item = heavyArmor;
                price = 40;
                break;
            case 4:
                System.out.println("Quitting.");
                break;
            default:
                System.out.println("Invalid entry !");
                break;
        }

        if (price > 0) {
            if (getPlayer().getMoney() >= price) {
                getPlayer().setMoney(getPlayer().getMoney() - price);
                System.out.println("You bought " + item.getItemName() + ".");
                System.out.println("Remaining Money :" + getPlayer().getMoney());
                getPlayer().getBag().add(item);
            } else {
                System.out.println("Not enough money. !");
            }
        }
    }

    public int weaponMenu() {
        System.out.println("1. Sword\t<Price : 25 - Damage : 2>");
        System.out.println("2. Bow\t<Price : 35 - Damage : 3>");
        System.out.println("3. Glaiwe\t<Price : 45 - Damage : 7>");
        System.out.println("4. Quit");
        System.out.print("Your choice : ");
        int selWeaponID = scan.nextInt();
        return selWeaponID;
    }

    public void buyWeapon(int itemID) {
        Item item = null;
        int price = 0;
        Item sword = new Item("Sword", "Weapon", 2, 0, 1.5);
        Item bow = new Item("Bow", "Weapon", 2, 0, 2);
        Item glaiwe = new Item("Glaiwe", "Weapon", 2, 0, 2.1);


        switch (itemID) {
            case 1:
                item = sword;
                price = 25;
                break;
            case 2:
                item = bow;
                price = 35;
                break;
            case 3:
                item = glaiwe;
                price = 45;
                break;
            case 4:
                System.out.println("Quitting");
                break;
            default:
                System.out.println("Invalid entry !");
                break;
        }

        if (price > 0) {
            if (getPlayer().getMoney() > price) {

                getPlayer().setMoney(getPlayer().getMoney() - price);
                System.out.println("You bought a" + item.getItemName());
                System.out.println("Remaining money :" + getPlayer().getMoney());
                getPlayer().getBag().add(item);
            } else {
                System.out.println("Not enough money. !");
            }
        }
    }

    public int potionMenu() {
        System.out.println("1. Health Potion\t<Price : 15 ");
        System.out.println("2. Strength Potion\t<Price : 55 - Strength Increase : 6 >");
        System.out.println("3. Magical Capacity Potion\t<Price : 40 - It increase the capacity of your bag 3 more >");
        System.out.println("4. Quit");
        System.out.print("Your choice : ");
        int selPotionID = scan.nextInt();
        return selPotionID;
    }

    public void buyPotion(int itemID) {
        Item item = null;
        int price = 0;
        Item healthPotion = new Item("Health Potion", "Potion", 0, 0, 1);
        Item strengthPotion = new Item("Strength Potion", "Potion", 0, 0, 1);

        switch (itemID) {
            case 1:
                item = healthPotion;
                price = 15;
                break;

            case 2:
                item = strengthPotion;
                price = 55;
                break;
            case 3:
                getPlayer().setBagCapacity(getPlayer().getBagCapacity()+3);
                System.out.println("Your new capacity is: "+getPlayer().getBagCapacity());
                price = 40;
                break;
            case 4:
                System.out.println("Quitting");
                break;
            default:
                System.out.println("Invalid entry !");
                break;
        }
        if (price > 0) {
            if (getPlayer().getMoney() > price) {

                getPlayer().setMoney(getPlayer().getMoney() - price);
                System.out.println("You bought a" + item.getItemName());
                System.out.println("Remaining money :" + getPlayer().getMoney());

            }
            getPlayer().getBag().add(item);
        } else {
            System.out.println("Not enough money. !");
        }


    }

}
