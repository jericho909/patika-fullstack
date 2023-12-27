public class Enemy {
    private String name;
    private int id;
    private int dmg;
    private int HP;

    public Enemy(String name, int id, int dmg, int HP) {
        this.name = name;
        this.id = id;
        this.dmg = dmg;
        this.HP = HP;
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
        this.HP = HP;
    }
}
