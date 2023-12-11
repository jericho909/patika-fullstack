import java.util.*;
public class Main {
    public static void main(String[] args) {
        int mesafe = 0;
        int yas = 0;
        int yolculukTipi = 3;
        double ucret;
        boolean mesafeIsValid = false;
        boolean yasIsValid = false;
        boolean yolculukTipiIsValid = false;


        Scanner input = new Scanner(System.in);

        while ( !mesafeIsValid ) {
            System.out.println("Lütfen gideceğiniz mesafeyi KM bazında yazınız: ");
            if (input.hasNextInt()) {
                mesafe = input.nextInt();
                if (mesafe > 0) {
                    System.out.println("Gideceğiniz mesafe: " + mesafe + " KM");
                    mesafeIsValid = true;
                } else {
                    System.out.println("Hatalı veri girişi yaptınız. Mesafe sadece pozitif tam sayıdan oluşabilir. Lütfen tekrardan deneyin.");
                }

            } else {
                String invalidInput = input.next();
                System.out.println("Hatalı veri girişi yaptınız. Mesafe sadece pozitif tam sayıdan oluşabilir. Lütfen tekrardan deneyin.");
            }
        }


        while (!yasIsValid) {
            System.out.println("Lütfen yaşınızı girin: ");
            if (input.hasNextInt()) {
                yas = input.nextInt();
                if (yas > 0){
                    System.out.println("Yaşınız:" + yas);
                    yasIsValid = true;
                } else {
                    System.out.println("Hatalı veri girişi yaptınız. Yaş sadece pozitif tam sayıdan oluşabilir. Lütfen tekrardan deneyin.");
                }
            } else {
                String invalidInput = input.next();
                System.out.println("Hatalı veri girişi yaptınız. Yaş sadece pozitif tam sayıdan oluşabilir. Lütfen tekrardan deneyin.");
            }
        }

        while (!yolculukTipiIsValid) {
            System.out.println("Lütfen yolculuk tipini seçiniz. (1 => Tek Yön , 2 => Gidiş Dönüş ) ");
            if (input.hasNextInt()) {
                yolculukTipi = input.nextInt();
                if (yolculukTipi == 1 || yolculukTipi == 2) {
                    System.out.println("Seçtiğiniz yolculuk tipi: " + yolculukTipi);
                    yolculukTipiIsValid = true;
                } else {
                    System.out.println("Hatalı veri girişi yaptınız. Yolculuk tipi sadece 1 veya 2 olabilir. Lütfen tekrardan deneyin.");
                }
            } else {
                String invalidInput = input.next();
                System.out.println("Hatalı veri girişi yaptınız. Yolculuk tipi sadece 1 veya 2 olabilir. Lütfen tekrardan deneyin.");
            }
        }

        ucret = mesafe * 0.10;
        double indirim;

        if (yas <= 12 ){
            ucret /= 2;
            System.out.println("Yolcu 12 yaşından küçük olduğu için %50 indirim uygulanıyor.");
        } else if (yas <24) {
            System.out.println("Yolcu 12-24 yaş arasında olduğu için %10 indirim uygulanıyor.");
            System.out.println("İndirimsiz tutar: " + ucret);
            indirim = ucret * 0.1;
            System.out.println("İndirim miktarı: " + indirim);
            ucret = ucret - indirim;
            System.out.println("Yeni ücret: " + ucret);
        } else if (yas > 65) {
            System.out.println("65 yaş üstü olduğunuz için %30 indirim uygulanıyor.");
            System.out.println("İndirimsiz tutar: " + ucret);
            indirim = ucret * 0.3;
            System.out.println("İndirim miktarı: " + indirim);
            ucret = ucret - indirim;
            System.out.println("Yeni ücret: " + ucret);
        }

        if (yolculukTipi == 2) {
            ucret *=2;
            System.out.println("Gidiş-dönüş bileti aldığınız için %20 indirim uygulanıyor.");
            System.out.println("İndirimsiz tutar: " + ucret);
            indirim = ucret * 0.2;
            System.out.println("İndirim miktarı: " + indirim);
            ucret = ucret - indirim;
            System.out.println("Yeni ücret: " + ucret);
        }

        System.out.println("Toplam tutar: " + ucret);

    }
}