import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Lütfen satır sayısını girin:");
        int n = input.nextInt();
        for (int i= 0; i<= n-1; i++)
        {
            for (int j=0; j<=i; j++)
            {
                System.out.print(" ");
            }
            for (int k=0; k<=n-1-i; k++)
            {
                System.out.print("*" + " ");
            }
            System.out.println();
        }
    }
}