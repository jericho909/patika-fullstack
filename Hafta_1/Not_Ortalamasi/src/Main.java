import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        double mat, fiz, tur, kim, muz;
        double ort = 0;
        int c = 0;


        Scanner input = new Scanner(System.in);

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


        Double[] notlar = {mat, fiz, tur, kim, muz};

        for (Double i : notlar){
            if (i >= 0 && i <= 100) {
                ort += i;
                c++;
            }
        }

        if (c == 0) {
           System.out.println("Geçerli not ortalaması oluşturulamadı. Lütfen bir daha deneyin.");
        } else {
            ort = ort / c;
        }

        System.out.println("Öğrencinin not ortalaması: " + ort);
        if (ort > 55) {
            System.out.println("Öğrenci sınıfı geçti.");
        } else {
            System.out.println("Oğrenci sınıfta kaldı.");
        }
    }
}