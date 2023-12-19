import java.util.*;
public class Main {
    public static void main(String[] args) {
        int randomNumber, guess, lifeCounter, counter = 0, upperLimit = 101;
        ArrayList<Integer> list = new ArrayList<Integer>();
        boolean gameStarted = true;
        Scanner input = new Scanner(System.in);
        Random rand = new Random();
        System.out.println("Oyun başlatılıyor.");
        randomNumber = rand.nextInt(upperLimit);
        System.out.println("Kaç tane tahmin hakkınız olsun istersiniz?");
        lifeCounter = input.nextInt();
        while (gameStarted && lifeCounter > 0){
        System.out.println("Lütfen tahminizi yapın: ");
        guess = input.nextInt();
        counter++;
        if (guess == randomNumber){
            System.out.println("Doğru tahmin! Tebrikler! Doğru sayıyı bulmak için " + counter + " tahminde bulundunuz.");
            list.add(guess);
            System.out.println("Tahminleriniz: " + list);
            gameStarted = false;
        } else if (guess < randomNumber) {
            System.out.println("Tahmininiz doğru sayıdan daha küçük. Lütfen tekrardan deneyin. Tahmin sayısı: " + counter);
            list.add(guess);
            lifeCounter--;
            System.out.println("Kalan hak sayısı: " + lifeCounter);
        } else {
            System.out.println("Tahmininiz doğru sayıdan daha büyük. Lütfen tekrardan deneyin. Tahmin sayısı: " + counter);
            list.add(guess);
            lifeCounter--;
            System.out.println("Kalan hak sayısı: " + lifeCounter);
        }
        }
        if (lifeCounter == 0){
            System.out.println("Oyunu kaybettiniz :(");
            System.out.println("Doğru sayı: " + randomNumber);
            System.out.println("Tahminleriniz: " + list);
        }

    }
}