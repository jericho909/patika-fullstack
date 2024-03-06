import java.util.*;
public class Main {
    static int fib(int x){
        if (x == 1 || x == 2){
        return 1;}
        return fib(x-1) + fib(x-2);
    }
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        Scanner inp = new Scanner(System.in);
        System.out.println("Kaç elemanlı Fibonacci serisi istiyorsunuz?");
        int n = inp.nextInt();
        for (int i = 1; i < n; i++){
            list.add(fib(i));
        }
        System.out.println(list);
    }
}