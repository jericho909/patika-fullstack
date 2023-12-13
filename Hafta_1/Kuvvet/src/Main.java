import java.util.*;
import java.lang.Math;
public class Main {
    public static void main(String[] args) {
        int a, c = 1, d = 1;
        ArrayList<Double> list4 = new ArrayList<Double>();
        ArrayList<Double> list5 = new ArrayList<Double>();

        Scanner input = new Scanner(System.in);
        System.out.println("Lütfen sayıyı giriniz: ");
        a = input.nextInt();

        for(int i = 0; i <= a; i++){
            if(Math.pow(4, c) < a){
                list4.add(Math.pow(4, c));
            }
            c++;
            if(Math.pow(5, d) < a){
                list5.add(Math.pow(5, d));
            }
            d++;
        }
        System.out.println("4'ün kuvvetleri:");
        System.out.println(list4);
        System.out.println("5'in kuvvetleri:");
        System.out.println(list5);
    }
}