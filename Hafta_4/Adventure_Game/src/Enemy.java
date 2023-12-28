public class Enemy {
    private String name;
    private int id;
    private int dmg;
    private int HP;
    private int loot;

    private int defaultHealth;
    public Enemy(String name, int id, int dmg, int HP, int loot) {
        this.name = name;
        this.id = id;
        this.dmg = dmg;
        this.HP = HP;
        this.defaultHealth = HP;
        this.loot = loot;
    }

    public int getLoot() {
        return loot;
    }

    public void setLoot(int loot) {
        this.loot = loot;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDmg() {
        return dmg;
    }

    public void setDmg(int dmg) {
        this.dmg = dmg;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        if (HP == 0){
            HP = 0;
        }
        this.HP = HP;
    }

    public int getDefaultHealth() {
        return defaultHealth;
    }

    public void setDefaultHealth(int defaultHealth) {
        this.defaultHealth = defaultHealth;
    }
}
