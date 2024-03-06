import java.util.*;
public class Main {
    public static void main(String[] args) {
        int[] list = {2, 31, 46, 4, 3, 6, 6, 4, 7, 8, 8, 2, 9, 8, 6, 11, 87, 45, 44, 36, 46};
        System.out.println("Programa sağlanılan dizi: " + Arrays.toString(list));
        for (int i = 0; i < list.length; i++) {
            if (list[i] % 2 == 0) {
                int repeatingNumber = 0;
                for (int j = i + 1; j < list.length; j++) {
                    if (list[i] == list[j]) {
                        repeatingNumber++;
                    }
                }
                boolean isSame = false;
                for (int k = i - 1; k >= 0; k--) {
                    if (list[i] == list[k]) {
                        isSame = true;
                        break;
                    }
                }
                if (!isSame && repeatingNumber > 0) {
                    System.out.println(list[i] + " tekrar eden çift sayıdır ve seride " + (repeatingNumber + 1) + " kez tekrar ediyor.");
                }
            }
        }
    }
}
