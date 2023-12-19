import java.util.*;
public class Main {
    public static void main(String[] args) {
        int[] list = {15,12,788,1,-1,-778,2,0};
        System.out.println("Dizi: " + Arrays.toString(list));
        //minMax(list);
        Scanner input = new Scanner(System.in);
        System.out.println("Lütfen sorgu yapacağınız sayıyı giriniz: ");
        int a = input.nextInt();
        ArrayList<Integer> resultList = closest(list,a);
        int closestToMin = resultList.get(0);
        int closestToMax = resultList.get(1);
        System.out.println("Girilen Sayı : " + a);
        System.out.println("Girilen sayıdan küçük en yakın sayı :" + closestToMin);
        System.out.println("Girilen sayıdan büyük en yakın sayı :" + closestToMax);
    }
    public static void minMax(int[] arr){
        Arrays.sort(arr);
        int minOfList = arr[0];
        int maxOfList = arr[arr.length - 1];

        System.out.println("Dizideki minimum değer: " + minOfList);
        System.out.println("Dizideki maksimum değer: " + maxOfList);
    }
    public static ArrayList<Integer> closest(int[] arr, int a){
        ArrayList<Integer> results = new ArrayList<Integer>();
        Arrays.sort(arr);
        int closestToMin = Integer.MIN_VALUE;
        int closestToMax = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < a) {
                closestToMin = arr[i];
            } else if (arr[i] > a) {
                closestToMax = arr[i];
                break;
            }
        }
        results.add(closestToMin);
        results.add(closestToMax);

        return results;
    }
}