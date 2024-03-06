// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int mesafe;
        double min = 10.0;
        double ucret;

        Scanner input = new Scanner(System.in);

        System.out.println("Lütfen gidilen mesafeyi KM bazında giriniz:");
        mesafe = input.nextInt();

        ucret = mesafe * 2.20;
        ucret += min;


        if (ucret < 20.0) {
            ucret = 20.0;
        }

        //floating point error çözümüne baktım ama bu proje bağlamında scope'u baya büyütüyordu. O yüzden entegre etmedim.


        System.out.println("Taksi ücreti: " + ucret + " TL");

    }
}