import java.util.*;

public class Main {
    //asal sayı bulma işlmei için fonksiyon tanımlandı
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
        //liste ve değişken oluşturuldu
        int x;
        ArrayList<Integer> list = new ArrayList<Integer>();
        Scanner input = new Scanner(System.in);
        System.out.println("Lütfen sayıyı giriniz: ");
        x = input.nextInt();

        //döngü kuruldu bulunan asal sayılar listeye eklendi
        for(int i=2;i<=x;i++)
        {
            if(isPrime(i))
                list.add(i);
        }
        //liste yazdırıldı
        System.out.println("Asal sayılar: " + list);
    }
}
