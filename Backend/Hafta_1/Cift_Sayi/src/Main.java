import java.util.*;

public class Main {
    public static void main(String[] args) {
        //değişkenler oluşturuldu
        int x, c = 0, sum = 0;
        List<Integer> list = new ArrayList<Integer>();
        Scanner input = new Scanner(System.in);
        System.out.println("Lütfen sayıyı giriniz:");
        //veri alındı
        x = input.nextInt();
        //döngüde sayılar listeye alındı
        for (int i = 1; i < x; i++){
            if((i % 12 == 0)){
                list.add(i);
                sum += i;
                c += 1;
            }
        }
        //çıktılar yazdırılıyor
        System.out.println("Girdiğiniz " + x + "sayısına kadar 3 ve 4'e bölünebilen sayıların listesi:");
        System.out.println(list);
        System.out.println("Girdiğiniz " + x + " sayısına kadar; 3 ve 4'e bölünebilen sayıların ortalaması: " + (sum / c));
    }
}