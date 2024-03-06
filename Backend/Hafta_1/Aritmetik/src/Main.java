import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        double a,b,c;
        double result;

        Scanner input = new Scanner(System.in);
        System.out.println("Lütfen ilk rakamı girin: ");
        a = input.nextInt();

        System.out.println("Lütfen ikinci rakamı girin: ");
        b = input.nextInt();

        System.out.println("Lütfen üçüncü rakamı girin: ");
        c = input.nextInt();

        result = a + (b * c) - b;

        System.out.println("İşlemlerin sonucu: " + result);
    }
}