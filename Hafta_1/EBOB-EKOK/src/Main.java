import java.util.*;
public class Main {
    public static void main(String[] args) {
        int N, EBOB, EKOK;
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        System.out.println("İlk sayıyı giriniz: ");
        int n1 = input.nextInt();

        System.out.println("İkinci sayıyı giriniz: ");
        int n2 = input.nextInt();

        N = Math.max(n1, n2);

        for (int i = 1; i <= N; i++){
            if (n1 % i == 0 && n2 % i == 0){
                list1.add(i);
            }
        }

       Collections.sort(list1);
        EBOB = list1.getLast();
        EKOK = (n1 * n2) / EBOB;

        System.out.println("Girdiğiniz sayıların EBOB'u: " + EBOB + ", EKOK'u: " + EKOK);


    }
}