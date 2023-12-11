// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.Scanner;
import java.lang.Math;

public class Main {
    public static void main(String[] args) {
        double a, a_sq, b, b_sq, c, c_sq, l, A;

        Scanner input = new Scanner(System.in);

        System.out.println("Lütfen üçgenin ilk dik kenarının uzunluğunu giriniz.");
        a = input.nextDouble();
        a_sq = a * a;

        System.out.println("Lütfen üçgenin ikinci dik kenarının uzunluğunu giriniz.");
        b = input.nextDouble();
        b_sq = b * b;
        c_sq = a_sq + b_sq;

        c = Math.sqrt(c_sq);

        l = a + b + c;

        A = (a*b) / 2;

        System.out.println("Üçgenin hipotenüsünün uzunluğu: " + c);
        System.out.println("Üçgenin çevresi: " + l);
        System.out.println("Üçgenin alanı: " + A);
    }
}
