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
        player.getGameClass().setHealthPoint(player.getGameClass().getDefaultHealth());

    }
}

