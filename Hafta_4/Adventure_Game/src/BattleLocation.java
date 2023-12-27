public class BattleLocation extends Location{
    private Enemy enemy;
    private String locationAward;
    public BattleLocation(Player player, String name, int id, Enemy enemy, String locationAward) {
        super(player, name, id);
        this.enemy = enemy;
        this.locationAward = locationAward;
    }

    public Enemy getEnemy() {
        return enemy;
    }

    public void setEnemy(Enemy enemy) {
        this.enemy = enemy;
    }

    public String getLocationAward() {
        return locationAward;
    }

    public void setLocationAward(String locationAward) {
        this.locationAward = locationAward;
    }

    @Override
    boolean onLocation() {
        return false;
    }
}
