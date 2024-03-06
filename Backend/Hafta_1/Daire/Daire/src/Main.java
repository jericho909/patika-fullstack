// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.Scanner;
import java.lang.Math;

public class Main {
    public static void main(String[] args) {
        int r, a;
        double L, A, R;

        Scanner input = new Scanner(System.in);

        System.out.println("Lütfen dairenin yarıçapını giriniz:");
        r = input.nextInt();

        L = Math.PI * 2 * r;
        A = r * r * Math.PI;

        System.out.println("Lütfen merkez açısı ölçüsünü giriniz:");
        a = input.nextInt();

        R = (Math.PI * (r * r) * a) / 360;

        System.out.println("Girdiğiniz dairenin yarıçapı: " + r + "\n" + "Çevresi: " + L + "\n" + "Alanı: " + A);

        System.out.println("Merkez açısı ölçüsü: " + a + "\n" + "Bu bölgenin alanı: " + R);
    }

}