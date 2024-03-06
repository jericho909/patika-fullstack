import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int x, sum = 0, c;
        Scanner input = new Scanner(System.in);

        do {
            System.out.println("Lütfen bir sayı giriniz: ");
            x = input.nextInt();
            if(x % 4 == 0){
                sum += x;
            }
        } while (x % 2 == 0);
        System.out.println("4'ün katları olan sayıları toplamı: " + sum);
    }
}