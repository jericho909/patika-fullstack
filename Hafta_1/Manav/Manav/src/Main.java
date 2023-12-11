import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        double armut = 2.14;
        double elma = 3.67;
        double domates = 1.11;
        double muz = 0.95;
        double patlican = 5.0;
        double toplam = 0.0;
        double a;

        Scanner input = new Scanner(System.in);

        System.out.println("Kaç kilo Armut?");
        a = input.nextInt();
        a = a * armut;
        toplam +=a;

        System.out.println("Kaç kilo Elma?");
        a = input.nextInt();
        a = a * elma;
        toplam +=a;

        System.out.println("Kaç kilo Domates?");
        a = input.nextInt();
        a = a * domates;
        toplam +=a;

        System.out.println("Kaç kilo Muz?");
        a = input.nextInt();
        a = a * muz;
        toplam +=a;

        System.out.println("Kaç kilo Patlıcan?");
        a = input.nextInt();
        a = a * patlican;
        toplam +=a;

        System.out.println("Toplam Tutar: " + toplam + " TL");

    }
}