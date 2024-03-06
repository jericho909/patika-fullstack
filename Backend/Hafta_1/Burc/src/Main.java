import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        //değişkenler hazırlandı
        int ay = 0, gun = 0, ayListe = 0;
        boolean ayIsValid = false;
        boolean gunIsValid = false;
        String[] Aylar = {"Ocak", "Şubat", "Mart", "Nisan", "Mayıs", "Haziran", "Temmuz", "Ağustos", "Eylül", "Ekim", "Kasım", "Aralık"};
        //veri alındı
        Scanner input = new Scanner(System.in);
        System.out.println("Lütfen doğum ayınızı giriniz: (1-12 sayıları arasından seçim yapınız)");
        while (!ayIsValid){
            if (input.hasNextInt()){
                ay = input.nextInt();
                while(!ayIsValid){
                    if (ay <13) {
                        ayIsValid = true;
                    } else {
                        System.out.println("Ay değeri 12'den büyük olamaz. Lütfen tekrardan deneyin.");
                        System.out.println("Lütfen doğum ayınızı giriniz: (1-12 sayıları arasından seçim yapınız)");
                        break;
                    }
                }
            } else {
                String invalidInput = input.next();
                System.out.println("Hatalı veri girişi yaptınız. Lütfen tekrardan deneyin.");
                System.out.println("Lütfen doğum ayınızı giriniz: (1-12 sayıları arasından seçim yapınız)");
            }
        }

        ayListe = ay - 1;

        System.out.println("Lütfen doğum gününüzü giriniz: (1-31 sayıları arasından seçim yapınız)");
        while (!gunIsValid){
            if (input.hasNextInt()){
                gun = input.nextInt();
                while(!gunIsValid){
                    if (gun <32) {
                        gunIsValid = true;
                    } else {
                        System.out.println("Gün değeri 31'den büyük olamaz. Lütfen tekrardan deneyin.");
                        System.out.println("Lütfen doğum gününüzü giriniz: (1-31 sayıları arasından seçim yapınız)");
                        break;
                    }
                }
            } else {
                String invalidInput = input.next();
                System.out.println("Hatalı veri girişi yaptınız. Lütfen tekrardan deneyin.");
                System.out.println("Lütfen doğum gününüzü giriniz: (1-31 sayıları arasından seçim yapınız)");
            }
        }
        String burc = "";
        //koşullar uygulandı
        System.out.println("Doğum gününüz: " + gun + ", Doğum ayınız: " + Aylar[ayListe]);
        if(ay == 1) {
            if (gun <= 22) {
                burc = "Kova Burcu";
            } else {
                burc = "Oğlak Burcu";
            }
        } else if (ay == 2) {
            if (gun <= 20) {
                burc = "Balık Burcu";
            } else {
                burc = "Kova Burcu";
            }
        } else if (ay == 3) {
            if (gun <= 20) {
                burc = "Balık Burcu";
            } else {
                burc = "Koç Burcu";
            }
        } else if (ay == 4) {
            if (gun <= 20) {
                burc = "Koç Burcu";
            } else {
                burc = "Boğa Burcu";
            }
        } else if (ay == 5) {
            if (gun <= 21) {
                burc = "Boğa Burcu";
            } else {
                burc = "İkizler Burcu";
            }
        } else if (ay == 6) {
            if (gun <= 22) {
                burc = "İkizler Burcu";
            } else {
                burc = "Yengeç Burcu";
            }
        } else if (ay == 7) {
            if (gun <= 22) {
                burc = "Yengeç Burcu";
            } else {
                burc = "Aslan Burcu";
            }
        } else if (ay == 8) {
            if (gun <= 22) {
                burc = "Aslan Burcu";
            } else {
                burc = "Başak Burcu";
            }
        } else if (ay == 9) {
            if (gun <= 22) {
                burc = "Başak Burcu";
            } else {
                burc = "Terazi Burcu";
            }
        } else if (ay == 10) {
            if (gun <= 22) {
                burc = "Terazi Burcu";
            } else {
                burc = "Akrep Burcu";
            }
        } else if (ay == 11) {
            if (gun <= 23) {
                burc = "Akrep Burcu";
            } else {
                burc = "Yay Burcu";
            }
        } else if (ay == 12) {
            if (gun <= 21) {
                burc = "Yay Burcu";
            } else {
                burc = "Oğlak Burcu";
            }
        }

        System.out.println("Burcunuz: " + burc);
    }
}

