public class Inventory {
    private Weapons weapon;
    private Armors armor;

    public Weapons getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapons weapon) {
        this.weapon = weapon;
    }

    public Armors getArmor() {
        return armor;
    }

    public void setArmor(Armors armor) {
        this.armor = armor;
    }

    public Inventory() {
        this.weapon = new Weapons("Your Hands", 0, 1, 0);
        this.armor = new Armors("Ragged Shirt", 0, 1, 0);
    }
}
