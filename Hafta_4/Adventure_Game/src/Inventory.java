public class Inventory {
    private Weapons weapon;
    private Armors armor;

    private String riverLoot;
    private String caveLoot;
    private String forestLoot;

    public String getRiverLoot() {
        return riverLoot;
    }

    public void setRiverLoot(String riverLoot) {
        this.riverLoot = riverLoot;
    }

    public String getCaveLoot() {
        return caveLoot;
    }

    public void setCaveLoot(String caveLoot) {
        this.caveLoot = caveLoot;
    }

    public String getForestLoot() {
        return forestLoot;
    }

    public void setForestLoot(String forestLoot) {
        this.forestLoot = forestLoot;
    }

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
