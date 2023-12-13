import java.util.Scanner;
public class Main {
    static int factorial(int x) {
        int total = 1;
        for(int i = 1; i<=x; i++){
           total *= i;
        }
        return total;
    }
    public static void main(String[] args) {
        int N, r, C;
        Scanner input = new Scanner(System.in);
        System.out.println("N sayısını giriniz:");
        N = input.nextInt();

        System.out.println("r sayısını giriniz:");
        r = input.nextInt();

        C = (factorial(N)) / (factorial(r) * factorial(N-r));

        System.out.println("Girdiğiniz " + N + " sayısının " + r + "'li kombinasyonu: " + C);

    }
}