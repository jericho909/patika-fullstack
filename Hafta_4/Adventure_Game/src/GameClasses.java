public abstract class GameClasses {
    private int dmg;
    private int healthPoint;
    private int money;

    public int getDmg() {
        return dmg;
    }

    public void setDmg(int dmg) {
        this.dmg = dmg;
    }

    public int getHealthPoint() {
        return healthPoint;
    }

    public void setHealthPoint(int healthPoint) {
        this.healthPoint = healthPoint;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public GameClasses(int dmg, int healthPoint, int money) {
        this.dmg = dmg;
        this.healthPoint = healthPoint;
        this.money = money;
    }
}
