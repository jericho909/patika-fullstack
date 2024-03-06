import java.util.Objects;
import java.util.Random;

public abstract class BattleLocation extends Location{
    Random rand = new Random();
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
                this.getPlayer().getGameClass().setMoney(this.getPlayer().getGameClass().getMoney() +
                        numberOfEnemies * this.getEnemy().getLoot());
                if (Objects.equals(this.getName(), "Mine")){
                    Mine.getLoot(this.getPlayer());
                }
                if (Objects.equals(this.getName(), "Cave")){
                    int locationAwardRoll = rand.nextInt(100);
                    if (locationAwardRoll > 65 && !this.getPlayer().getInventory().isCaveLoot() ){
                        this.getPlayer().getInventory().setCaveLoot(true);
                        System.out.println("You received the award for this location! " +
                                "Your characters maximum health is raised by 3!");
                        this.getPlayer().getGameClass().setDefaultHealth(this.getPlayer().getGameClass().getDefaultHealth() + 3);
                    } else if (this.getPlayer().getInventory().isCaveLoot()) {
                        System.out.println("You already have the location award. You will just receive the monster loot.");
                    } else {
                        System.out.println("You feel there is an object here that you need to return for...");
                    }
                }
                if (Objects.equals(this.getName(), "Forest")){
                    int locationAwardRoll = rand.nextInt(100);
                    if (locationAwardRoll > 75 && !this.getPlayer().getInventory().isForestLoot()){
                        this.getPlayer().getInventory().setForestLoot(true);
                        System.out.println("You received the award for this location! " +
                                "Your character is now faster!");
                        this.getPlayer().getGameClass().setInitiative(this.getPlayer().getGameClass().getInitiative() + 2);
                    } else if (this.getPlayer().getInventory().isForestLoot()){
                        System.out.println("You already have the location award. You will just receive the monster loot.");
                    } else {
                        System.out.println("You feel there is an object here that you need to return for...");
                    }
                }
                if (Objects.equals(this.getName(), "River")){
                    int locationAwardRoll = rand.nextInt(100);
                    if (locationAwardRoll > 80 && !this.getPlayer().getInventory().isRiverLoot()){
                        this.getPlayer().getInventory().setRiverLoot(true);
                        System.out.println("You received the award for this location! " +
                                "Your characters damage is raised by 3!");
                        this.getPlayer().getGameClass().setDmg(this.getPlayer().getGameClass().getDmg() + 3);
                    } else if (this.getPlayer().getInventory().isRiverLoot()){
                        System.out.println("You already have the location award. You will just receive the monster loot.");
                    } else {
                        System.out.println("You feel there is an object here that you need to return for...");
                    }
                }
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
        System.out.println("========BEGIN COMBAT========");
        for (int i = 0; i < numberOFEnemies; i++){
            enemyStats(c);
            this.getEnemy().setHP(this.getEnemy().getDefaultHealth());
            while(player.getGameClass().getHealthPoint() > 0 && this.getEnemy().getHP() > 0){
                if (rollInit()){
                    System.out.println("You attack first!");
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
                }else {
                    System.out.println("The enemy attacks first!");
                    int enemyDamageWithBlock = this.getEnemy().getDmg() - player.getInventory().getArmor().getBlock();
                    if (enemyDamageWithBlock < 0){
                        enemyDamageWithBlock = 0;
                    }
                    System.out.println("You get hit for: " + enemyDamageWithBlock);
                    player.getGameClass().setHealthPoint(this.getPlayer().getGameClass().getHealthPoint() - enemyDamageWithBlock);
                    afterHitPlayerStats();
                    System.out.println("You strike the foul beast!");
                    this.getEnemy().setHP(this.getEnemy().getHP() - Player.getPlayerDMGwithWeapon(player));
                    afterHitEnemyStats();
                }
            }
            this.getEnemy().setHP(this.getEnemy().getDefaultHealth());
            c++;
        }
        return true;
    }

    public boolean rollInit(){
        int enemyInit = this.enemy.getInitiative() + rand.nextInt(20);
        int playerInit = this.getPlayer().getGameClass().getInitiative() + rand.nextInt(20);

        return playerInit >= enemyInit;
    }

    public void playerStats(Player player){
        System.out.println("============YOU============");
        System.out.println("HP: " + player.getGameClass().getHealthPoint());
        System.out.println("Equipped Weapon: " + player.getInventory().getWeapon().getName());
        System.out.println("Damage: " + Player.getPlayerDMGwithWeapon(player));
        System.out.println("Block Rate: " + player.getInventory().getArmor().getBlock());
        System.out.println("===========================");
    }

    public void enemyStats(int i){
        System.out.println("===========ENEMY===========");
        System.out.println("Enemy Number " + i + " HP: " + this.getEnemy().getHP());
        System.out.println("Enemy Number " + i + " Damage: " + this.getEnemy().getDmg());
        System.out.println("===========================");
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