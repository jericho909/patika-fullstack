package Products;

import java.util.ArrayList;
import java.util.Scanner;

public class Phones extends Products {
    private int batterySize;
    private int cameraMP;
    private String color;
    static Scanner input = new Scanner(System.in);


    public Phones(int id, String name, Double price, String brand, int memory, Double screenSize, int ram, int stock,
                  int batterySize, int cameraMP, String color) {
        super(id, name, price, brand, memory, screenSize, ram, stock);
        this.batterySize = batterySize;
        this.cameraMP = cameraMP;
        this.color = color;
    }

    public int getBatterySize() {
        return batterySize;
    }

    public void setBatterySize(int batterySize) {
        this.batterySize = batterySize;
    }

    public int getCameraMP() {
        return cameraMP;
    }

    public void setCameraMP(int cameraMP) {
        this.cameraMP = cameraMP;
    }
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    static ArrayList<Phones> phones = new ArrayList<>();

    static {
        phones.add(new Phones(1, "SAMSUNG GALAXY A51", 3199.0, "Samsung", 128,
                6.5, 6, 10, 4000,32, "Siyah"));
        phones.add(new Phones(2, "iPhone 11 64GB", 7379.0, "Apple", 64,
                6.1, 6, 15, 3046,5, "Mavi"));
        phones.add(new Phones(3, "Redmi Note 10 Pro 8GB", 4012.0, "Xiaomi", 128,
                6.5, 12, 10, 4000,35, "Beyaz"));
    }

    public static void showPhoneMenu(){
        boolean isActive = true;

        do {
            int menuSelection = Integer.MIN_VALUE;
            System.out.println("=======PHONE OPERATIONS=======");
            System.out.println("1 - Show all products");
            System.out.println("2 - Add new product");
            System.out.println("0 - Previous Menu");
            try {
                menuSelection = input.nextInt();
            } catch (Exception e){
                System.out.println(e.toString());
            }
            switch (menuSelection){
                case 1:
                    showPhones();
                    break;
                case 2:
                    addPhone(phones);
                    break;
                case 0:
                    System.out.println("Exiting to previous menu.");
                    isActive = false;
                    break;
                default:
                    System.out.println("Invalid selection.");
            }
        }while (isActive);

    }

    public static void showPhones(){
        System.out.format("%-8s %-25s %-12s %-16s %-10s %-6s %-6s %-6s %-6s %-6s %-6s", "ID", "Ürün Adı", "Fiyat",
                "Marka", "Depolama", "Ekran", "RAM", "Pil", "Kamera", "Renk", "Stok");
        System.out.println();
        for (Phones phone: phones) {
            System.out.format("%-8s %-25s %-12s %-16s %-10s %-6s %-6s %-6s %-6s %-6s %-6s", phone.getId(), phone.getName(),
                    phone.getPrice(), phone.getBrand(), phone.getMemory(), phone.getScreenSize(), phone.getRam(),
                    phone.getBatterySize(), phone.getCameraMP(), phone.getColor(), phone.getStock());
            System.out.println();
        }
    }

    public static void addPhone(ArrayList<Phones> phone){
        ArrayList<Integer> phoneIDList = new ArrayList<>();
        for (Phones phones: phone) {
            phoneIDList.add(phones.getId());
        }
        System.out.println("Please enter new ID: ");
        int newPhoneID = input.nextInt();
        input.nextLine();
        if (!phoneIDList.contains(newPhoneID)) {
            System.out.println("Please enter the name: ");
            String newPhoneName = input.nextLine();

            System.out.println("Please enter the price: ");
            Double newPhonePrice = Double.parseDouble(input.nextLine());

            System.out.println("Please enter the brand: ");
            String newPhoneBrand = input.nextLine();

            System.out.println("Please enter the size of the memory: ");
            int newPhoneMemory = Integer.parseInt(input.nextLine());

            System.out.println("Please enter the size of the screen: ");
            Double newPhoneScreenSize = Double.parseDouble(input.nextLine());

            System.out.println("Please enter the RAM: ");
            int newPhoneRAM = Integer.parseInt(input.nextLine());

            System.out.println("Please enter the size of the battery: ");
            int newPhoneBatterySize = Integer.parseInt(input.nextLine());

            System.out.println("Please enter the camera MP: ");
            int newPhoneCameraMP = Integer.parseInt(input.nextLine());

            System.out.println("Please enter the color: ");
            String newPhoneColor = input.nextLine();

            System.out.println("Please enter the stock: ");
            int newPhoneStock = Integer.parseInt(input.nextLine());

            phones.add(new Phones(newPhoneID, newPhoneName, newPhonePrice, newPhoneBrand, newPhoneMemory,
                    newPhoneScreenSize, newPhoneRAM, newPhoneStock, newPhoneBatterySize, newPhoneCameraMP, newPhoneColor));

            System.out.println("New phone added.");
            System.out.println("================");
            showPhones();
        }
        else {
            System.out.println("ID already exists. Please try again.");

        }

    }


}
