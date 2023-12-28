import java.util.Random;

public abstract class BattleLocation extends Location{
    private Enemy enemy;
    private String locationAward;
    private int maxNumberOfEnemies;


    public BattleLocation(Player player, String name, int id, Enemy enemy, String locationAward, int maxNumberOfEnemies) {
        super(player, name, id);
        this.enemy = enemy;
        this.locationAward = locationAward;
        this.maxNumberOfEnemies = maxNumberOfEnemies;
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
        String enemyName = this.getEnemy().getName();
        int numberOfEnemies = numberOfEnemies();
        System.out.println("You are now approaching: " + this.getName());
        System.out.println("These lands are plagued by: " + this.getEnemy().getName());
        if (numberOfEnemies > 1) {
            enemyName +=  "s";
        }
        System.out.println("You have " + numberOfEnemies + " " + enemyName + " attacking you!");
        System.out.println("<R>un or <B>attle!");
        String battleSelection = input.nextLine().toUpperCase();
        if (battleSelection.equals("B")){
            if (beginCombat(numberOfEnemies, this.getPlayer())){
                System.out.println("You win the battle!");
                System.out.println("You gained " + numberOfEnemies * this.getEnemy().getLoot() + " coins for the " +
                        numberOfEnemies + " beasts you slain!");
                this.getPlayer().getGameClass().setMoney(this.getPlayer().getGameClass().getMoney() + numberOfEnemies * this.getEnemy().getLoot());
                return true;
            }
        }
        if (this.getPlayer().getGameClass().getHealthPoint() < 0){
            System.out.println("You died!");
            return false;
        }
        return true;
    }

    public boolean beginCombat(int numberOFEnemies, Player player){
        int c = 1;
        playerStats(player);
        for (int i = 0; i < numberOFEnemies; i++){
            enemyStats(c);
            this.getEnemy().setHP(this.getEnemy().getDefaultHealth());
            while(player.getGameClass().getHealthPoint() > 0 && this.getEnemy().getHP() > 0){
                System.out.println("You strike the foul beast!");
                this.getEnemy().setHP(this.getEnemy().getHP() - Player.getPlayerDMGwithWeapon(player));
                if (this.getEnemy().getHP() > 0){
                    afterHitEnemyStats();
                    System.out.println("The enemy attacks you!");
                    int enemyDamageWithBlock = this.getEnemy().getDmg() - player.getInventory().getArmor().getBlock();
                    if (enemyDamageWithBlock < 0){
                        enemyDamageWithBlock = 0;
                    }
                    System.out.println("You get hit for: " + enemyDamageWithBlock);
                    player.getGameClass().setHealthPoint(this.getPlayer().getGameClass().getHealthPoint() - enemyDamageWithBlock);
                    afterHitPlayerStats();
                }
            }
            this.getEnemy().setHP(this.getEnemy().getDefaultHealth());
            c++;
        }
        return true;
    }

    public void playerStats(Player player){
        System.out.println("==========================");
        System.out.println("HP: " + player.getGameClass().getHealthPoint());
        System.out.println("Equipped Weapon: " + player.getInventory().getWeapon().getName());
        System.out.println("Damage: " + Player.getPlayerDMGwithWeapon(player));
        System.out.println("Block Rate: " + player.getInventory().getArmor().getBlock());
        System.out.println("==========================");
    }

    public void enemyStats(int i){
        System.out.println("==========================");
        System.out.println("Enemy Number " + i + " HP: " + this.getEnemy().getHP());
        System.out.println("Enemy Number " + i + " Damage: " + this.getEnemy().getDmg());
        System.out.println("==========================");
    }

    public void afterHitEnemyStats(){
        System.out.println("============");
        System.out.println("The enemy HP: " + this.getEnemy().getHP());
        System.out.println("============");
    }

    public void afterHitPlayerStats(){
        System.out.println("============");
        System.out.println("Your HP: " + this.getPlayer().getGameClass().getHealthPoint());
        System.out.println("============");
    }

    public int getMaxNumberOfEnemies() {
        return maxNumberOfEnemies;
    }

    public void setMaxNumberOfEnemies(int maxNumberOfEnemies) {
        this.maxNumberOfEnemies = maxNumberOfEnemies;
    }

    public int numberOfEnemies(){
        Random r = new Random();
        return r.nextInt(getMaxNumberOfEnemies()) + 1;
    }
}
