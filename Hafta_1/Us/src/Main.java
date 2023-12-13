import java.util.Scanner;
import java.lang.Math;

public class Main {
    public static void main(String[] args) {
        double a,b,c;
        Scanner input = new Scanner(System.in);

        System.out.println("Üssü alınaacak sayı: ");
        a = input.nextDouble();
        System.out.println("Üs olacak sayı: ");
        b = input.nextDouble();

        c = Math.pow(a,b);

        System.out.println("İstediğiniz üslü sayı: " + c);
    }
}