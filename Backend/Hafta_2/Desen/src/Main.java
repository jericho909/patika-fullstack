import java.util.*;
public class Main {
    public static void desen(int a){

        if (a <= 0) {
            System.out.print(a + " ");
            return;
        }

        System.out.print(a + " ");
        desen(a - 5);
        System.out.print(a + " ");
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Lütfen sayıyı girin: ");
        int a = input.nextInt();
        desen(a);
    }
}