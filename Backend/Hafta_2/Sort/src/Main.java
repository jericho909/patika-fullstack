import java.util.*;
public class Main {
    public static void main(String[] args) {
        int n;
        Scanner input = new Scanner(System.in);
        System.out.println("Lütfen dizinin boyutunu giriniz: ");
        n = input.nextInt();
        int[] list = new int[n];
        System.out.println("Lütfen dizinin elemanlarını giriniz: ");
        for (int i = 0; i < list.length; i++){
            System.out.println((i + 1) + ". eleman:" );
            list[i] = input.nextInt();
        }
        sort(list);
    }
    public static void sort(int[] arr){
        Arrays.sort(arr);
        System.out.println("Sıralama: " + Arrays.toString(arr));
    }
}