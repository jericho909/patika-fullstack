public class Inventory {
    private Weapons weapon;

    public Weapons getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapons weapon) {
        this.weapon = weapon;
    }

    public Inventory() {
        this.weapon = new Weapons("Your Hands", 0, 1, 0);
    }
}
