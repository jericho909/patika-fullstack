import java.util.Objects;
import java.util.Scanner;

public class Game {
    private Scanner input = new Scanner(System.in);

    public void start(){
        System.out.println("Welcome.");
        System.out.println("What is your name, adventurer? ");
        String playerName = input.nextLine();
        Player player = Player.selectClass(playerName);
        Location location = new StartLocation(player);
        Location currentLocation = location;
        do {
            if (Objects.equals(currentLocation.getName(),"Campfire")){
                System.out.println("You open your eyes. There is a campfire near you that is keeping you warm.");
                System.out.println("You get up, take a look around.");
                System.out.println("You see a map on the ground. There are several locations that are marked.");
            } else if (Objects.equals(currentLocation.getName(), "Safehouse")) {
                System.out.println("You are in your safehouse.");
            } else if (Objects.equals(currentLocation.getName(), "Store")) {
                System.out.println("You are in the store.");
            }

            boolean locationSelectIsValid = false;
            do {
                System.out.println("============================");
                System.out.println("You have " + player.getGameClass().getHealthPoint() +
                        " HP. Your equipped weapon is " + player.getInventory().getWeapon().getName() +
                        " and it deals " +player.getInventory().getWeapon().getDmg() + " damage. You are wearing " +
                        player.getInventory().getArmor().getName() + ". You have " +
                        player.getGameClass().getMoney() + " coins.");
                System.out.println("Where would you like to go?");
                System.out.println("1 => House \n2 => Store");
                System.out.println("============================");
                int locationSelect = input.nextInt();
                if (locationSelect != currentLocation.getId()) {
                    switch (locationSelect){
                        case 0:
                            System.out.println("Goodbye.");
                            locationSelectIsValid = true;
                            break;
                        case 1:
                            location = new Safehouse(player);
                            currentLocation = location;
                            locationSelectIsValid = true;
                            Safehouse.refreshHP(player);
                            break;
                        case 2:
                            location = new Toolstore(player);
                            currentLocation = location;
                            locationSelectIsValid = true;
                            break;
                        default:
                    }
                    location.onLocation();
                }
                else {
                    System.out.println("You are already here.");
                }
            } while (!locationSelectIsValid);

        } while (player.getGameClass().getHealthPoint() > 0);

    }



}
