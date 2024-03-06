import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] array = new int[]{5, 10, 23, 7, 14, 30, 18, 42, 9, 11};

        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the index number: ");
        int a = input.nextInt();

        try{
            System.out.println(fetch(a, array));
        } catch (Exception e){
            System.out.println(e.toString());
        }
    }

    public static int fetch(int i, int[] array) throws Exception{
        try{
            return array[i];
        } catch (Exception e){
            System.out.println(e.toString());
        }
        return -1;
    }
}