import java.util.*;
import java.lang.Math;
public class Main {
    static int pow(int a, int b){
        if (b != 0){
            return (a * pow(a , b-1));
        } else {
            return 1;
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Taban sayısını giriniz: ");
        int a = input.nextInt();
        System.out.print("Kuvvetini giriniz: ");
        int b = input.nextInt();

        System.out.println("Sonuç: " + pow(a,b));


    }
}