import java.util.Objects;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        //değişkenler oluşturuldu
        String userName, password, answer, newPassword;

        Scanner input = new Scanner(System.in);
        //kullanıcıdan veriler alınıyor
        System.out.println("Lütfen kullanıcı isminizi giriniz: ");
        userName = input.nextLine();

        System.out.println("Lütfen şifrenizi giriniz: ");
        password = input.nextLine();
        //programın ana mantık döngüsü oluşturuldu
        if (Objects.equals(userName, "patika")) {
            if (Objects.equals(password, "java")){
                System.out.println("Kullanıcı girişi başarılı.");
            } else {
                System.out.println("Hatalı şifre girişi yaptınız. Lütfen tekrar deneyin.");
                System.out.println("Şifrenizi sıfırlamak istiyor musunuz? (y/n) ");
                answer = input.nextLine();

                switch (answer){
                    case "y":
                        System.out.println("Lütfen yeni şifrenizi giriniz:");
                        newPassword = input.nextLine();
                        //kullanıcı eski şifresinden farklı yeni bir şifre girene kadar
                        // süreci devam ettirmek için while kullandım
                        while (Objects.equals(newPassword, "java")){
                            System.out.println("Şifreniz bir önceki şifrenizle aynı olamaz. Lütfen tekrardan deneyin.");
                            System.out.println("Lütfen yeni şifrenizi giriniz:");
                            newPassword = input.nextLine();
                        }
                        System.out.println("Şifreniz başarıyla değiştirildi.");
                        break;
                    case "n":
                        System.out.println("Çıkış yapılıyor.");
                        break;
                    default:
                        System.out.println("Komut tanınmadı. Program kapatılıyor.");
                }
            }
        } else {
            System.out.println("Kullanıcı ismi bulunamadı. Lütfen tekrardan deneyin.");
        }
    }
}