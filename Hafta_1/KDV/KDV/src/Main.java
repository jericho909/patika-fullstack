// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double para, KDV, KDV_Tutar, toplamTutar;


        Scanner input = new Scanner(System.in);
        System.out.println("Lütfen para değerini giriniz:");
        para = input.nextDouble();

        if(para > 1000){
            KDV = 0.08;
        } else {
            KDV = 0.18;
        }

        KDV_Tutar = para * KDV;
        toplamTutar = para + KDV_Tutar;

        System.out.println("Girdiğiniz tutar üzerinden KDV oranı: %" + KDV*100);
        System.out.println("Girdiğiniz tutar: " + para + " TL");
        System.out.println("Girdiğiniz tutar üzerinden hesaplanan Katma Değer Vergisi: " + KDV_Tutar + " TL");
        System.out.println("Girdiğiniz tutar ile KDV toplamı: " + toplamTutar + " TL");


        }
    }
