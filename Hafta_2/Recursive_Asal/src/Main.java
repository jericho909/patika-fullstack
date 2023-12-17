import java.util.Scanner;
public class Main {
    public static void asal(int a, int i){

        if (a % i == 0){
            System.out.print("Asal sayı değildir.");
        } else if (i > a / 2){
            System.out.print("Asal sayıdır.");
        } else {
            asal(a, i + 1);
        }
    }
    public static void main(String[] args) {
        int a;
        Scanner input = new Scanner(System.in);
        System.out.print("Lütfen sayıyı giriniz:");
        a = input.nextInt();
        asal(a, 2);
    }
}

