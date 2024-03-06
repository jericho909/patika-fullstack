public class Inventory {
    private Weapons weapon;
    private Armors armor;

    private boolean riverLoot;
    private boolean caveLoot;
    private boolean forestLoot;



    public Weapons getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapons weapon) {
        this.weapon = weapon;
    }

    public Armors getArmor() {
        return armor;
    }

    public boolean isRiverLoot() {
        return riverLoot;
    }

    public void setRiverLoot(boolean riverLoot) {
        this.riverLoot = riverLoot;
    }

    public boolean isCaveLoot() {
        return caveLoot;
    }

    public void setCaveLoot(boolean caveLoot) {
        this.caveLoot = caveLoot;
    }

    public boolean isForestLoot() {
        return forestLoot;
    }

    public void setForestLoot(boolean forestLoot) {
        this.forestLoot = forestLoot;
    }

    public void setArmor(Armors armor) {
        this.armor = armor;
    }

    public Inventory() {
        this.weapon = new Weapons("Your Hands", 0, 1, 0);
        this.armor = new Armors("Ragged Shirt", 0, 1, 0);
        this.riverLoot = false;
        this.forestLoot = false;
        this.caveLoot = false;
    }
}
