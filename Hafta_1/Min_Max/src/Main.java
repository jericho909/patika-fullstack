import java.util.*;
public class Main {
    public static void main(String[] args) {
        //değişkenler ve liste oluşturuldu
        int a = 1 , b,c;
        ArrayList<Integer> list = new ArrayList<Integer>();

        Scanner input = new Scanner(System.in);
        System.out.println("Kaç tane sayı gireceksiniz:");
        c = input.nextInt();
        //girilen rakama kadar döngü devam etmesi istendiği için do-while kullanıldı
        do {
            System.out.println(a + ". sayıyı giriniz: ");
            b = input.nextInt();
            list.add(b);
            a++;
        }
        while (a <= c);
        //ArrayList metodları ile liste sıralandı ve istenilen elemanlar yazdırıldı
        Collections.sort(list);
        System.out.println("Minimum değerli sayı: " + list.getFirst());
        System.out.println("Maximum değerli sayı: " +list.getLast());
    }
}