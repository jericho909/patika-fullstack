import java.util.Random;
import java.util.Scanner;

public class Mine extends BattleLocation{
    Random rand = new Random();
    Scanner input = new Scanner(System.in);

    public Mine(Player player) {
        super(player, "Mine", 6, new Goblin(), "Roll the dice!", 6);


    }


    public static void getLoot(Player player){
        Random rand = new Random();
        Scanner input = new Scanner(System.in);
        int randomLootCategory = rand.nextInt(100);
        int randomLoot = rand.nextInt();
        Weapons[] lootedWeapon = Weapons.weapons();
        Armors[] lootedArmor = Armors.armors();
        if (randomLootCategory <= 15){
            if (randomLoot <= 50){ //weapon loots
                System.out.println("You looted: " + lootedWeapon[0].getName() + ". It has a damage of: " + lootedWeapon[0].getDmg());
                System.out.println("Do you want to equip it? \n <Y>es or <N>o?");
                String selection = input.nextLine().toUpperCase();
                if (selection.equals("Y")){
                    player.getInventory().setWeapon(lootedWeapon[0]);
                }
                else {
                    System.out.println("You left the loot behind!");
                }
            } else if ( randomLoot <= 80){
                System.out.println("You looted: " + lootedWeapon[1].getName() + ". It has a damage of: " + lootedWeapon[1].getDmg());
                System.out.println("Do you want to equip it? \n <Y>es or <N>o?");
                String selection = input.nextLine().toUpperCase();
                if (selection.equals("Y")){
                    player.getInventory().setWeapon(lootedWeapon[1]);
                }
                else {
                    System.out.println("You left the loot behind!");
                }
            } else if (randomLoot <= 100) {
                System.out.println("You looted: " + lootedWeapon[2].getName() + ". It has a damage of: " + lootedWeapon[2].getDmg());
                System.out.println("Do you want to equip it? \n <Y>es or <N>o?");
                String selection = input.nextLine().toUpperCase();
                if (selection.equals("Y")){
                    player.getInventory().setWeapon(lootedWeapon[2]);
                }
                else {
                    System.out.println("You left the loot behind!");
                }
            }
        } else if (randomLootCategory <= 30) {
            if (randomLoot <= 50){ //armor loots
                System.out.println("You looted: " + lootedArmor[0].getName() + ". It has a block rate of: " + lootedArmor[0].getBlock());
                System.out.println("Do you want to equip it? \n <Y>es or <N>o?");
                String selection = input.nextLine().toUpperCase();
                if (selection.equals("Y")){
                    player.getInventory().setArmor(lootedArmor[0]);
                }
                else {
                    System.out.println("You left the loot behind!");
                }
            } else if ( randomLoot <= 80){
                System.out.println("You looted: " + lootedArmor[1].getName() + ". It has a block rate of: " + lootedArmor[1].getBlock());
                System.out.println("Do you want to equip it? \n <Y>es or <N>o?");
                String selection = input.nextLine().toUpperCase();
                if (selection.equals("Y")){
                    player.getInventory().setArmor(lootedArmor[1]);
                }
                else {
                    System.out.println("You left the loot behind!");
                }
            } else if (randomLoot <= 100) {
                System.out.println("You looted: " + lootedArmor[2].getName() + ". It has a block rate of: " + lootedArmor[2].getBlock());
                System.out.println("Do you want to equip it? \n <Y>es or <N>o?");
                String selection = input.nextLine().toUpperCase();
                if (selection.equals("Y")){
                    player.getInventory().setArmor(lootedArmor[2]);
                }
                else {
                    System.out.println("You left the loot behind!");
                }
            }
        } else if (randomLootCategory <= 55){
            if (randomLoot <= 50){
                System.out.println("You looted 1 coin!");
                player.getGameClass().setMoney(player.getGameClass().getMoney() + 1);
            } else if (randomLoot <= 80) {
                System.out.println("You looted 5 coins!");
                player.getGameClass().setMoney(player.getGameClass().getMoney() + 5);
            } else if (randomLoot <= 100) {
                System.out.println("You looted 10 coins!");
                player.getGameClass().setMoney(player.getGameClass().getMoney() + 10);
            }
        }
        else {
            System.out.println("You didn't get any treasures. Maybe next time... ");
        }
    }
}
