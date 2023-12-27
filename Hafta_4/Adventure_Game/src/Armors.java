public class Armors {
    private String name;
    private int id;
    private int block;
    private int price;

    public Armors(String name, int id, int block, int price) {
        this.name = name;
        this.id = id;
        this.block = block;
        this.price = price;
    }

    public static Armors[] armors(){
        Armors[] armorList = new Armors[3];
        armorList[0] = new Armors("Leather Armor", 1, 1, 15);
        armorList[1] = new Armors("Chainmail", 2, 3, 25);
        armorList[2] = new Armors("Plate Armor", 3, 5, 40);
        return armorList;
    }

    public static Armors getArmorById(int id){
        for (Armors a: Armors.armors()){
            if (a.getId() == id){
                return a;
            }
        }
        return null;
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

    public int getBlock() {
        return block;
    }

    public void setBlock(int block) {
        this.block = block;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
