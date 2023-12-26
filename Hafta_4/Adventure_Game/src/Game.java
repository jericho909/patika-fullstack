import java.util.Scanner;

public class Game {
    private Scanner input = new Scanner(System.in);

    public void start(){
        System.out.println("Welcome.");
        System.out.println("What is your name, adventurer? ");
        String playerName = input.nextLine();
        System.out.println("What is your speciality? ");
        System.out.println("1 => Swords & Agility");
        System.out.println("2 => Archery");
        System.out.println("3 => Mace & Two Handed Combat");
        int classChoice = input.nextInt();
        Player player = null;
        switch (classChoice){
            case 1:
                player = new Player(playerName, new Samurai());
                break;
            case 2:
                player = new Player(playerName, new Archer());
                break;
            case 3:
                player = new Player(playerName, new Knight());
                break;
            default:
                System.out.println("Invalid choice.");
        }
        gameStartMsg(classChoice,player);

    }

    public void gameStartMsg(int classChoice, Player player){
        switch (classChoice){
            case 1:
                System.out.println("You, " + player.getPlayerName() + ", are a Samurai. Valiant in battle, chained by your honor, " +
                        "you are fast and deadly.");
                System.out.println("You have " + player.getGameClass().getHealthPoint() +
                        " HP. Your attack damages opponents for " + player.getGameClass().getDmg() +
                        " HP. You have " + player.getGameClass().getMoney() + " coins in your pocket.");
                break;
            case 2:
                System.out.println("You, " + player.getPlayerName() + ", are an Archer. Quick as a fox and deadly with a bow, " +
                        "you wait for the perfect moment to strike.");
                System.out.println("You have " + player.getGameClass().getHealthPoint() +
                        " HP. Your attack damages opponents for " + player.getGameClass().getDmg() +
                        " HP. You have " + player.getGameClass().getMoney() + " coins in your pocket.");
                break;
            case 3:
                System.out.println("You, " + player.getPlayerName() + ", are a Knight. Heavy as a mountain and furious as the sun, " +
                        "your enemies flee just from your righteous gaze. ");
                System.out.println("You have " + player.getGameClass().getHealthPoint() +
                        " HP. Your attack damages opponents for " + player.getGameClass().getDmg() +
                        " HP. You have " + player.getGameClass().getMoney() + " coins in your pocket.");
                break;
            default:
                System.out.println("Something went wrong.");
        }
    }
}
