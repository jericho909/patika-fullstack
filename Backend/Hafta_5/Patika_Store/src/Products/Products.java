package Products;

public abstract class Products {
    private int id;
    private String name;
    private Double price;
    private String brand;
    private int memory;
    private Double screenSize;
    private int ram;
    private int stock;

    public Products(int id, String name, Double price, String brand, int memory, Double screenSize, int ram, int stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.brand = brand;
        this.memory = memory;
        this.screenSize = screenSize;
        this.ram = ram;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public Double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(Double screenSize) {
        this.screenSize = screenSize;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
