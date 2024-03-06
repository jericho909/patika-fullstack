import java.util.*;
public class Main {
    public static void main(String[] args) {
        int i;
        double d;
        Scanner input = new Scanner(System.in);
        System.out.println("Lütfen bir tam sayı giriniz: ");
        i = input.nextInt();
        System.out.println("Lütfen bir ondalıklı sayı giriniz: ");
        d = input.nextDouble();
        //explicit narrowing
        int d2i = (int) d;
        //auto widening
        double i2d = i;

        System.out.println("Girdiğiniz " + i + " tam sayısı explicit narrowing ile, " + i2d + "  ondalık sayısına dönüştürüldü.");
        System.out.println("Girdiğiniz " + d + " ondalık sayısı auto widening ile, " + d2i + " tam sayısına sayısına dönüştürüldü.");
    }
}