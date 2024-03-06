// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        int matematik, fizik, kimya, turkce, tarih, muzik;
        double ortalama;

        Scanner input = new Scanner(System.in);

        System.out.println("Lütfen Matematik notunuzunu girin:");
        matematik = input.nextInt();

        System.out.println("Lütfen Fizik notunuzunu girin:");
        fizik = input.nextInt();

        System.out.println("Lütfen Kimya notunuzunu girin:");
        kimya = input.nextInt();

        System.out.println("Lütfen Türkçe notunuzunu girin:");
        turkce = input.nextInt();

        System.out.println("Lütfen Tarih notunuzunu girin:");
        tarih = input.nextInt();

        System.out.println("Lütfen Müzik notunuzunu girin:");
        muzik = input.nextInt();

        ortalama = (matematik + fizik + kimya + turkce + tarih + muzik) / 6.0;

        System.out.println("Not ortalamanız: " + ortalama);

        System.out.println(ortalama < 60.0 ? "Sınıfta Kaldı" : "Sınıfı Geçti");

    }
}
