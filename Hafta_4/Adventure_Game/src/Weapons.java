public class Weapons {
    private String name;
    private int id;
    private int dmg;
    private int price;

    public Weapons(String name, int id, int dmg, int price) {
        this.name = name;
        this.id = id;
        this.dmg = dmg;
        this.price = price;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public static Weapons[] weapons(){
     Weapons[] weaponList = new Weapons[3];
     weaponList[0] = new Weapons("Brass Knuckles", 1, 2, 25);
     weaponList[1] = new Weapons("Shiv", 2, 3, 35);
     weaponList[2] = new Weapons("Shortsword", 3, 7, 45);
     return weaponList;
    }

    public static Weapons purchaseWeaponById(int id){
        for (Weapons w: Weapons.weapons()){
            if (w.getId() == id){
                return w;
            }
        }
        return null;
    }

}
