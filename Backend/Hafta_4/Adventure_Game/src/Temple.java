public class Temple extends NormalLocation{
    public Temple(Player player) {
        super(player, "Temple", 7);
    }
    @Override
    boolean onLocation() {
        if (getPlayer().getInventory().isCaveLoot() && getPlayer().getInventory().isForestLoot() &&
                getPlayer().getInventory().isRiverLoot()){
            System.out.println("You survived...");
            System.out.println("Thank you for playing.");
            return false;
        } else {
            System.out.println("You see three symbols on the door. One is a rock, one is a leaf, the other is a droplet of water.");
        }
        return true;
    }
}
