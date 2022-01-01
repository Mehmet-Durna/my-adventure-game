

public class GameUtils {
    Game game = new Game();


    public static Item getElixer() {
        return new Item("Elixer", "Special", 0, 0, 0);
    }

    public static Item getWing() {
        return new Item("Wing", "Special", 0, 0, 0);
    }

    public static Item getSanta() {
        return new Item("Santa", "Special", 0, 0, 0);
    }

    public static Item getExcalibur() {
        return new Item("Excalibur", "Special", 0, 0, 0);
    }

    public static Item getStaf() {
        return new Item("Staf", "Special", 0, 0, 0);
    }

    public static Item getGun() {
        return new Item("Gun", "Weapon", 2, 0, 1.2);
    }

    public static Item getKatana() {
        return new Item("Katana", "Weapon", 4, 0, 1.5);
    }

    public static Item getAxe() {
        return new Item("Axe", "Weapon", 6, 0, 2);
    }


    public static Item getNinjaArmor() {
        return new Item("\tNinja Armor", "Armor", 0, 5, 3);
    }

    public static Item getKnightArmor() {
        return new Item("\tKnight Armor", "Armor", 0, 7, 3);
    }




    public static void createMap(Player player) {


        Location cave = new BattleLoc(player, "Cave", getZombie(), getGun());
        Location forest = new BattleLoc(player, "Forest", getWolf(), getAxe());
        Location finalRoom = new BattleLoc(player, "Final Room", getBoss(), getExcalibur());
        Location cemetery = new BattleLoc(player, "Cemetery", getSkeleton(), getStaf());
        Location vampireTown = new BattleLoc(player, "Vampire Town", getVampire(), getKatana());
        Location tigerMountain = new BattleLoc(player, "Tiger Mountain", getTiger(), getNinjaArmor());
        Location valley = new BattleLoc(player, "Valley", getSnake(), getElixer());
        Location bonusRoom1 = new BattleLoc(player, "Bonus Room1", getTiger(), getKnightArmor());
        Location bonusRoom2 = new BattleLoc(player, "Bonus Room2", getVampire(), getSanta());
        Location bonusRoom3 = new BattleLoc(player, "Bonus Room3", getSnake(), getWing());

        Location toolStore = new ToolStore(player);
        Location hidingRoom = new HidingRoom(player);
        Location safeHouse = new SafeHouse(player);

        player.setCurrentLocation(safeHouse);

        safeHouse.putExit("forest", forest);
        safeHouse.putExit("store", toolStore);

        toolStore.putExit("safehouse", safeHouse);
        toolStore.putExit("forest", forest);
        toolStore.putExit("finalroom", finalRoom);
        toolStore.putExit("tigermountain", tigerMountain);
        toolStore.putExit("valley", valley);

        forest.putExit("store", toolStore);
        forest.putExit("safehouse", safeHouse);
        forest.putExit("cave", cave);
        forest.putExit("finalroom", finalRoom);

        cave.putExit("cemetery", cemetery);
        cave.putExit("forest", forest);

        cemetery.putExit("finalroom", finalRoom);
        cemetery.putExit("hidingroom", hidingRoom);
        cemetery.putExit("cave", cave);
        cemetery.putExit("vampiretown", vampireTown);

        finalRoom.putExit("forest", forest);
        finalRoom.putExit("store", toolStore);
        finalRoom.putExit("tigermountain", tigerMountain);
        finalRoom.putExit("cemetery", cemetery);

        hidingRoom.putExit("cemetery", cemetery);
        hidingRoom.putExit("vampiretown", vampireTown);
        hidingRoom.putExit("bonusroom1", bonusRoom1);

        vampireTown.putExit("cemetery", cemetery);
        vampireTown.putExit("hidingroom", hidingRoom);
        vampireTown.putExit("tigermountain", tigerMountain);

        tigerMountain.putExit("valley", valley);
        tigerMountain.putExit("bonusroom3", bonusRoom3);
        tigerMountain.putExit("store", toolStore);
        tigerMountain.putExit("finalroom", finalRoom);
        tigerMountain.putExit("vampiretown", vampireTown);

        valley.putExit("tigermountain", tigerMountain);
        valley.putExit("store", toolStore);

        bonusRoom1.putExit("hidingroom", hidingRoom);
        bonusRoom1.putExit("bonusroom2", bonusRoom2);
        bonusRoom1.putExit("bonusroom3", bonusRoom3);

        bonusRoom2.putExit("bonusroom1", bonusRoom1);
        bonusRoom2.putExit("bonusroom3", bonusRoom3);

        bonusRoom3.putExit("tigermountain", tigerMountain);
        bonusRoom3.putExit("bonusroom1", bonusRoom1);
        bonusRoom3.putExit("bonusroom2", bonusRoom2);


    }

    public static int getAward() {


        return (int) (Math.random() * 13) + 3;
    }


    public static Obstacle getTiger() {
        return new Obstacle("Tiger", 8, 20, getAward(), 3);
    }

    public static Obstacle getVampire() {
        return new Obstacle("Vampire", 10, 25, getAward(), 3);
    }

    public static Obstacle getWolf() {
        return new Obstacle("Wolf", 5, 13, getAward(), 3);
    }

    public static Obstacle getZombie() {
        return new Obstacle("Zombie", 7, 16, getAward(), 3);
    }

    public static Obstacle getSkeleton() {
        return new Obstacle("Skeleton", 8, 20, getAward(), 3);
    }

    public static Obstacle getSnake() {
        return new Obstacle("Snake", 6, 14, getAward(), 3);
    }

    public static Obstacle getBoss() {
        return new Obstacle("Boss", 20, 40, getAward(), 2);
    }


}
