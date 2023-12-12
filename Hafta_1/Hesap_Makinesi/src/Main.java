import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        double a,b,result;
        int op;

        Scanner input = new Scanner(System.in);
        System.out.println("Lütfen ilk rakamı giriniz: ");
        a = input.nextDouble();

        System.out.println("Lütfen ikinci rakamı giriniz: ");
        b = input.nextDouble();

        System.out.println("Lütfen yapacağınız operasyonu seçiniz.");
        System.out.println("Seçenekler 1-> Çıkarma, 2 -> Toplama, 3 -> Çarpma, 4 -> Bölme ");

        op = input.nextInt();

        switch(op){
            case 1:
                result = a - b;
                System.out.println("Yaptığınız işlemin sonucu:" + result);
                break;
            case 2:
                result = a + b;
                System.out.println("Yaptığınız işlemin sonucu:" + result);
                break;
            case 3:
                result = a * b;
                System.out.println("Yaptığınız işlemin sonucu:" + result);
                break;
            case 4:
                if (b == 0) {
                    System.out.println("Sıfıra bölme işlemi yapamazsınız.");
                    break;
                } else {
                    result = a / b;
                    System.out.println("Yaptığınız işlemin sonucu:" + result);
                    break;
                }
            default:
                System.out.println("Operasyon seçiminde hata oluştu.");

        }


    }
}