import java.util.*;
public class Main {
    public static void main(String[] args) {
        int divider, number, sum = 0;
        ArrayList<Integer> list = new ArrayList<Integer>();
        Scanner input = new Scanner(System.in);
        System.out.println("Lütfen sayıyı giriniz:");
        number = input.nextInt();

        for(int i = 1; i <= (number / 2); i++){
            if (number % i == 0) {
                list.add(i);
            }
        }
        for(Integer i: list) {
            sum += i;
        }

        if (sum == number){
            System.out.println(number + " mükemmel sayıdır.");
        } else {
            System.out.println(number + " mükemmel sayı değildir.");
        }
    }
}