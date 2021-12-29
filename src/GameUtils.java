import java.util.Random;

public class GameUtils {


    public static Item getGun() {
        Item gun = new Item("Gun", "Weapon", 2, 0);
        return gun;
    }

    public static Item getKatana() {
        Item katana = new Item("Katana", "Weapon", 4, 0);
        return katana;
    }

    public static Item getAxe() {
        Item axe = new Item("Axe", "Weapon", 6, 0);
        return axe;
    }

    public static Item getSpike() {
        Item spike = new Item("Spike", "Weapon", 8, 0);
        return spike;
    }

    public static Item getWoodArmor() {
        Item woodArmor = new Item("\tWood Armor", "Armor", 0, 3);
        return woodArmor;
    }

    public static Item getNinjaArmor() {
        Item ninjaArmor = new Item("\tNinja Armor", "Armor", 0, 5);
        return ninjaArmor;
    }

    public static Item getKnightArmor() {
        Item knightArmor = new Item("\tKnight Armor", "Armor", 0, 7);
        return knightArmor;
    }


    public static void createMap(Player player) {


        Location cave = new BattleLoc(player, "Cave", getZombie(), getGun());
        Location forest = new BattleLoc(player, "Forest", getWolf(), getAxe());
        Location finalRoom = new BattleLoc(player, "Final Room", getBoss(), getKnightArmor());
        Location cemetery = new BattleLoc(player, "Cemetery", getSkeleton(), getWoodArmor());
        Location vampireTown = new BattleLoc(player, "Vampire Town", getVampire(), getSpike());
        Location tigerMountain = new BattleLoc(player, "Tiger Mountain", getTiger(), getNinjaArmor());
        Location valley = new BattleLoc(player, "Valley", getSnake(), getSpike());
        Location bonusRoom1 = new BattleLoc(player, "Bonus Room1", getTiger(), getKnightArmor());
        Location bonusRoom2 = new BattleLoc(player, "Bonus Room2", getVampire(), getGun());
        Location bonusRoom3 = new BattleLoc(player, "Bonus Room3", getSnake(), getSpike());

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


        return (int)(Math.random()*13)+3;
    }



    public static Obstacle getTiger() {
        Obstacle tiger = new Obstacle("Tiger", 8, 20, getAward(), 3);
        return tiger;
    }

    public static Obstacle getVampire() {
        Obstacle vampire = new Obstacle("Vampire", 10, 25, getAward(), 3);
        return vampire;
    }

    public static Obstacle getWolf() {
        Obstacle wolf = new Obstacle("Wolf", 5, 13, getAward(), 3);
        return wolf;
    }

    public static Obstacle getZombie() {
        Obstacle zombie = new Obstacle("Zombie", 7, 16, getAward(), 3);
        return zombie;
    }

    public static Obstacle getSkeleton() {
        Obstacle skeleton = new Obstacle("Skeleton", 8, 20, getAward(), 3);
        return skeleton;
    }

    public static Obstacle getSnake() {
        Obstacle snake = new Obstacle("Snake", 6, 14, getAward(), 3);
        return snake;
    }

    public static Obstacle getBoss() {
        Obstacle boss = new Obstacle("Boss", 20, 40, getAward(), 2);
        return boss;
    }


}
