import java.util.*;
public class Main {

    static void isPalindrome(String str) {
        int i = 0, j = str.length() - 1;
        boolean isPalindrome = true;

        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                isPalindrome = false;
                break;
            }
            i++;
            j--;
        }

        if (isPalindrome) {
            System.out.println("Kelime palindromiktir.");
        } else {
            System.out.println("Kelime palindromik değildir.");
        }
    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String a;
        System.out.println("Lütfen denenecek kelimeyi yazınız: ");
        a = input.nextLine();
        a = a.trim();
        isPalindrome(a);
    }
}