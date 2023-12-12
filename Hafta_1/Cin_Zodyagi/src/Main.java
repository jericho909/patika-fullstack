import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        //değişkenler oluşturuldu
        int yil, kalan;
        String zodyak = "";

        Scanner input = new Scanner(System.in);
        //veri alındı
        System.out.println("Lütfen doğum yılınızı giriniz:");
        yil = input.nextInt();

        kalan = yil % 12;
        //switch ile kalan sayı zodyak ile eşleştirildi
        switch (kalan) {
            case 0:
                zodyak = "Maymun";
                break;
            case 1:
                zodyak = "Horoz";
                break;
            case 2:
                zodyak = "Köpek";
                break;
            case 3:
                zodyak = "Domuz";
                break;
            case 4:
                zodyak = "Fare";
                break;
            case 5:
                zodyak = "Öküz";
                break;
            case 6:
                zodyak = "Kaplan";
                break;
            case 7:
                zodyak = "Tavşan";
                break;
            case 8:
                zodyak = "Ejderha";
                break;
            case 9:
                zodyak = "Yılan";
                break;
            case 10:
                zodyak = "At";
                break;
            case 11:
                zodyak = "Koyun";
                break;
            default:
                System.out.println("Bilinmeyen hata.");
        }

        System.out.println("Çin zodyağınız: " + zodyak );


    }
}