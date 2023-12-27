public class Safehouse extends NormalLocation{
    public Safehouse(Player player) {
        super(player, "Safehouse", 1);
    }
    @Override
    boolean onLocation() {
        System.out.println("You are in your safehouse. You sit by the fireplace.");
        System.out.println("You feel rejuvenated. You HP have been refreshed.");
        return true;
    }

    static void refreshHP(Player player){
        if (player.getGameClass().getHealthPoint() == 21) {
            player.getGameClass().setHealthPoint(21);
        } else if (player.getGameClass().getHealthPoint() == 24) {
            player.getGameClass().setHealthPoint(24);
        } else if (player.getGameClass().getHealthPoint() == 18) {
            player.getGameClass().setHealthPoint(18);
        }

    }
}

