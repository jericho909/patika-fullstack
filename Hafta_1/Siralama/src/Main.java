import java.util.*;
public class Main {
    public static void main(String[] args) {
        //değişkenler oluşturuldu
        int a = 0,b = 0,c = 0;
        boolean firstNumberIsValid = false;
        boolean secondNumberIsValid = false;
        boolean thirdNumberIsValid = false;

        Scanner input = new Scanner(System.in);
        System.out.println("Lütfen ilk sayıyı giriniz.");
        //sayı dışında herhangi bir veri girişi olmaması için while döngüsü kuruldu
        while (!firstNumberIsValid){
            if (input.hasNextInt()){
                a = input.nextInt();
                firstNumberIsValid = true;
            } else {
                String invalidInput = input.next();
                System.out.println("Hatalı veri girişi yaptınız. Lütfen tekrardan deneyin.");
            }
        }

        System.out.println("Lütfen ikinci sayıyı giriniz.");
        while (!secondNumberIsValid){
            if (input.hasNextInt()){
                b = input.nextInt();
                secondNumberIsValid = true;
            } else {
                String invalidInput = input.next();
                System.out.println("Hatalı veri girişi yaptınız. Lütfen tekrardan deneyin.");
            }
        }

        System.out.println("Lütfen üçüncü sayıyı giriniz.");
        while (!thirdNumberIsValid){
            if (input.hasNextInt()){
                c = input.nextInt();
                thirdNumberIsValid = true;
            } else {
                String invalidInput = input.next();
                System.out.println("Hatalı veri girişi yaptınız. Lütfen tekrardan deneyin.");
            }
        }
        //alınan verilen array'e atıldı
        Integer[] Numbers = {a,b,c};
        System.out.println("Küçükten büyüğe sıralanmış rakamlar şunlardır:");
        //Sort metoduyla sayılar sıralanıp yazdırıldı
        Arrays.sort(Numbers);
        for (Integer number : Numbers) {
            System.out.println(number);
        }
    }


}