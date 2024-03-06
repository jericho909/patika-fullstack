import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        //değişkenler oluşturuldu
       int sicaklik = 0, c;
       boolean inputIsValid = false;
       //veri alındı
       Scanner input = new Scanner(System.in);
       System.out.println("Lütfen hava sıcaklığını Celcius cinsinden giriniz: ");
       //yazı ile veri girilmemesi için while döngüsü oluşturuldu
       while(!inputIsValid) {
           if (input.hasNextInt()){
               sicaklik = input.nextInt();
               inputIsValid = true;
               break;
           } else {
               String invalidInput = input.next();
               System.out.println("Hatalı veri girişi yaptınız. Lütfen tekrardan deneyin.");
           }
       }
       System.out.println("Hava sıcaklığı: " + sicaklik + " Celcius.");
        //çıktı verildi
        if (sicaklik < 5) {
            System.out.println("Sıcaklık 5'den düşük, 'Kayak' yapmayı öneririm.");
        } else if (sicaklik >= 5 && sicaklik <= 15) {
            System.out.println("Sıcaklık 5 ile 15 arasında, 'Sinema' etkinliğini öneririm.");
        } else if (sicaklik > 15 && sicaklik <= 25) {
            System.out.println("Sıcaklık 15 ile 25 arasında, 'Piknik' etkinliğini öneririm.");
        } else {
            System.out.println("Sıcaklık 25'ten büyük, 'Yüzme' etkinliğini öneririm.");
        }
    }
}