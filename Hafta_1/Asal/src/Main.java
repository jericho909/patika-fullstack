import java.util.*;

public class Main {
    static boolean isPrime(int num) {
        if(num<=1) {
            return false;
        }
        for(int i=2;i<=num/2;i++) {
            if((num%i)==0)
                return  false;
        }
        return true;
    }
    public static void main(String[] args) {
        int x;
        Scanner input = new Scanner(System.in);
        System.out.println("Lütfen sayıyı giriniz: ");
        x = input.nextInt();
        ArrayList<Integer> list = new ArrayList<Integer>();

        for(int i=2;i<=x;i++)
        {
            if(isPrime(i))
                list.add(i);
        }
        System.out.println("Asal sayılar: " + list);
    }
}
