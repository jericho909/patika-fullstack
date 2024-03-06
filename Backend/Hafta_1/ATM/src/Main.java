import java.util.*;
public class Main {
    public static void main(String[] args) {
        String username, password;
        int loginCounter = 3;
        int balance = 1500;
        int selection, deposit, withdrawal;
        boolean valid = true;
        Scanner input = new Scanner(System.in);


        while (loginCounter > 0){
            System.out.println("Lütfen kullanıcı adınızı giriniz: ");
            username = input.nextLine();
            System.out.println("Lütfen şifrenizi giriniz: ");
            password = input.nextLine();
            if (username.equals("patika") && password.equals("dev123")){
                System.out.println("Sisteme giriş yapıldı.");
                while(valid) {
                    System.out.println("Lütfen yapmak istediğiniz işlemi seçiniz:");
                    System.out.println("1 - PARA YATIRMA\n" +
                            "2 - PARA ÇEKME\n" +
                            "3 - BAKİYE SORGULAMA\n" +
                            "4 - ÇIKIŞ YAP");
                    selection = input.nextInt();
                    switch (selection) {
                        case 1:
                            System.out.println("Yatıracağınız para miktarı: ");
                            deposit = input.nextInt();
                            balance += deposit;
                            System.out.println("Yeni bakiyeniz: " + balance);
                            break;
                        case 2:
                            System.out.println("Çekeceğiniz para miktarı");
                            withdrawal = input.nextInt();
                            if (withdrawal > balance) {
                                System.out.println("Bakiye miktarınızdan daha fazla para çekemezsiniz.");
                            } else {
                                balance -= withdrawal;
                                System.out.println("Yeni bakiyeniz: " + balance);
                            }
                            break;
                        case 3:
                            System.out.println("Bakiyeniz: " + balance);
                            break;
                        case 4:
                            valid = false;
                            break;
                        default:
                            System.out.println("Hatalı giriş.");
                    }
                }
                break;
            } else {
                loginCounter--;
                System.out.println("Hatalı kullanıcı girişi. Tekrar deneyiniz.");
                if (loginCounter == 0) {
                    System.out.println("Hesabınız bloke edilmiştir.");
                }
                else {System.out.println("Kalan hakkınız: " + loginCounter);
                }
            }
        }
    }
}