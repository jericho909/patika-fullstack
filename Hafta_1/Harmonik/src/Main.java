import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Sayıyı giriniz: ");
        int x = input.nextInt();
        double result = 0.0;
        for (int i = 1; i <= x; i++) {
            result += ((double) 1 /i);
        }

        System.out.println("Harmonik dizi sonucu: " + result);
    }

}