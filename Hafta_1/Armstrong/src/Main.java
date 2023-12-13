import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        int a , b = 0, c = 0, d, e, sum = 0;
        Scanner input = new Scanner(System.in);

        System.out.println("Lütfen sayıyı giriniz:");
        a = input.nextInt();
        d = a;

        while( d!=0 ){
            d = d / 10;
            b++;
        }

        d = a;

        while( d!=0 ){
            e = d % 10;
            d = d / 10;
            sum += e;

        }

        System.out.println("Basamakların toplamı: " + sum);
    }
}