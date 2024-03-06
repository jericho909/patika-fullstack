import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    double boy, VKE;
    int kilo;

    Scanner input = new Scanner(System.in);
    System.out.println("Lütfen kilonuzu kg cinsinden giriniz: ");
    kilo = input.nextInt();

    System.out.println("Lütfen boyunuzu metre cinsinden giriniz: ");
    boy = input.nextDouble();

    VKE = kilo / (boy * boy);

    System.out.println("Vücüt kitle endeksiniz: " + VKE);
    }
}