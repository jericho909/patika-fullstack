import java.util.Scanner;
public class Main {
    static boolean isPal(int x){
        int temp = x, reverseX = 0, lastNumber;
        while (temp!=0){
            lastNumber = temp % 10;
            reverseX = (reverseX * 10) + lastNumber;
            temp /= 10;
        }
        return x == reverseX;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Lütfen sayıyı giriniz: ");
        int a = input.nextInt();
        if (isPal(a)){
            System.out.println("Sayı palindromik bir sayıdır.");
        } else {
            System.out.println("Sayı palindromik değildir.");
        }
    }
}