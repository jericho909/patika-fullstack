import java.util.Objects;
import java.util.Scanner;

public class Player {
    private String playerName;
    private GameClasses gameClass;
    private Inventory inventory;
    private static Scanner input = new Scanner(System.in);

    public Player(String playerName, GameClasses gameClass) {
        this.playerName = playerName;
        this.gameClass = gameClass;
        this.inventory = new Inventory();
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public GameClasses getGameClass() {
        return gameClass;
    }

    public void setGameClass(GameClasses gameClass) {
        this.gameClass = gameClass;
    }

    public static Player selectClass(String playerName){

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

        return player;


    }
    public static void gameStartMsg(int classChoice, Player player){
        switch (classChoice){
            case 1:
                System.out.println("You, " + player.getPlayerName() + ", are a Samurai. Valiant in battle, chained by your honor, " +
                        "you are fast and deadly.");
                break;
            case 2:
                System.out.println("You, " + player.getPlayerName() + ", are an Archer. Quick as a fox and deadly with a bow, " +
                        "you wait for the perfect moment to strike.");
                break;
            case 3:
                System.out.println("You, " + player.getPlayerName() + ", are a Knight. Heavy as a mountain and furious as the sun, " +
                        "your enemies flee just from your righteous gaze. ");
                break;
            default:
                System.out.println("Something went wrong.");
        }
    }

    public static int getPlayerDMGwithWeapon(Player player){
        return player.gameClass.getDmg() + player.getInventory().getWeapon().getDmg();
    }




    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

}



