import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        //değişkenler oluşturuldu
        int yil;
        Scanner input = new Scanner(System.in);
        //veri alındı
        System.out.println("Lütfen yılı giriniz:");
        yil = input.nextInt();
        //mantık koşulları yazıldı
        if (((yil % 4 == 0) && (yil % 400 == 0)) || ((yil % 100 == 0) && (yil % 400 == 0))){
            System.out.println("Girdiğiniz " + yil + " yılı artık yıldır.");
        } else {
            System.out.println("Girdiğiniz " + yil + " yılı artık yıl değildir.");
        }
    }
}