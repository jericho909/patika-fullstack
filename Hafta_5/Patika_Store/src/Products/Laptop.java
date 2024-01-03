package Products;

import java.util.ArrayList;
import java.util.Scanner;

public class Laptop extends Products{
    public Laptop(int id, String name, Double price, String brand, int memory, Double screenSize, int ram, int stock) {
        super(id, name, price, brand, memory, screenSize, ram, stock);
    }

    static Scanner input = new Scanner(System.in);

    static ArrayList<Laptop> laptops = new ArrayList<>();

    static {
        laptops.add(new Laptop(1, "HUAWEI Matebook 14", 7000.0, "Huawei", 512,
                14.0, 16, 15));
        laptops.add(new Laptop(2, "LENOVO V14 IGL", 3699.0, "Lenovo", 1024,
                14.0, 8, 10));
        laptops.add(new Laptop(3, "ASUS Tuf Gaming", 8199.0, "Asus", 2048,
                15.6, 32, 8));
    }


    public static void showLaptops(){
        System.out.format("%-8s %-25s %-12s %-16s %-10s %-6s %-6s %-6s", "ID", "Ürün Adı", "Fiyat", "Marka", "Depolama",
                "Ekran", "RAM", "Stok");
        System.out.println();
        for (Laptop laptop: laptops) {
            System.out.format("%-8s %-25s %-12s %-16s %-10s %-6s %-6s %-6s", laptop.getId(), laptop.getName(),
                    laptop.getPrice(), laptop.getBrand(), laptop.getMemory(), laptop.getScreenSize(), laptop.getRam(),
                    laptop.getStock());
            System.out.println();
        }

    }

    public static void showLaptopMenu(){
        boolean isActive = true;

        do {
            int menuSelection = Integer.MIN_VALUE;
            System.out.println("=======LAPTOP OPERATIONS=======");
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
                    showLaptops();
                    break;
                case 2:
                    addLaptop(laptops);
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

    public static void addLaptop(ArrayList<Laptop> laptop){
        ArrayList<Integer> laptopIDList = new ArrayList<>();
        for (Laptop laptops: laptop) {
            laptopIDList.add(laptops.getId());
        }
        System.out.println("Please enter new ID: ");
        int newLaptopID = input.nextInt();
        input.nextLine();
        if (!laptopIDList.contains(newLaptopID)) {
            System.out.println("Please enter the name: ");
            String newLaptopName = input.nextLine();

            System.out.println("Please enter the price: ");
            Double newLaptopPrice = Double.parseDouble(input.nextLine());

            System.out.println("Please enter the brand: ");
            String newLaptopBrand = input.nextLine();

            System.out.println("Please enter the size of the memory: ");
            int newLaptopMemory = Integer.parseInt(input.nextLine());

            System.out.println("Please enter the size of the screen: ");
            Double newLaptopScreenSize = Double.parseDouble(input.nextLine());

            System.out.println("Please enter the RAM: ");
            int newLaptopRAM = Integer.parseInt(input.nextLine());

            System.out.println("Please enter the stock: ");
            int newLaptopStock = Integer.parseInt(input.nextLine());

            laptops.add(new Laptop(newLaptopID, newLaptopName, newLaptopPrice, newLaptopBrand, newLaptopMemory,
                    newLaptopScreenSize, newLaptopRAM, newLaptopStock));

            System.out.println("New laptop added.");
            System.out.println("================");
            showLaptops();
        }
        else {
            System.out.println("ID already exists. Please try again.");

        }

    }

}
