import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        //değişkenler oluşturuldu
        double mat, fiz, tur, kim, muz;
        double ort = 0;
        int c = 0;


        Scanner input = new Scanner(System.in);
        //veri alınıyor
        System.out.println("Lütfen Matematik notunu giriniz: ");
        mat = input.nextDouble();

        System.out.println("Lütfen Fizik notunu giriniz: ");
        fiz = input.nextDouble();

        System.out.println("Lütfen Türkçe notunu giriniz: ");
        tur = input.nextDouble();

        System.out.println("Lütfen Kimya notunu giriniz: ");
        kim = input.nextDouble();

        System.out.println("Lütfen Müzik notunu giriniz: ");
        muz = input.nextDouble();

        //veriler listeye alındı
        Double[] notlar = {mat, fiz, tur, kim, muz};
        //eğer koşul sağlanmıyorsa veri işleme alınmadı
        for (Double i : notlar){
            if (i >= 0 && i <= 100) {
                ort += i;
                c++;
            }
        }
        //sıfıra bölme ihtimaline karşı koruma koyuldu
        if (c == 0) {
           System.out.println("Geçerli not ortalaması oluşturulamadı. Lütfen bir daha deneyin.");
        } else {
            ort = ort / c;
        }
        //çıktı verildi
        System.out.println("Öğrencinin not ortalaması: " + ort);
        if (ort > 55) {
            System.out.println("Öğrenci sınıfı geçti.");
        } else {
            System.out.println("Oğrenci sınıfta kaldı.");
        }
    }
}