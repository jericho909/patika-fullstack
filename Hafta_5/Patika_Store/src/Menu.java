import Products.Brands;
import Products.Laptop;
import Products.Phones;

import java.util.Scanner;
import java.util.TreeSet;

public class Menu {
    public static void showMenu(){
        boolean isActive = true;
        Scanner input = new Scanner(System.in);

        do {
            int menuSelection = Integer.MIN_VALUE;
            System.out.println("=======CONTROL PANEL=======");
            System.out.println("1 - Show Brands");
            System.out.println("2 - Laptop Operations");
            System.out.println("3 - Phone Operations");
            System.out.println("0 - Exit Program");
            System.out.println("Please select your operation: ");
            try {
                menuSelection = input.nextInt();
            } catch (Exception e){
                System.out.println(e.toString());
            }
            switch (menuSelection){
                case 1:
                    TreeSet<String> brands = Brands.generateBrands();
                    Brands.showBrands(brands);
                    break;
                case 2:
                    Laptop.showLaptopMenu();
                    break;
                case 3:
                    Phones.showPhoneMenu();
                    break;
                case 0:
                    System.out.println("Closing program.");
                    isActive = false;
                    break;
                default:
                    System.out.println("Invalid selection.");
            }
        } while (isActive);

    }
}
