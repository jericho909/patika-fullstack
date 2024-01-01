import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        int result = 0;

//        try{
//            int x = input.nextInt();
//            int y = input.nextInt();
//            try {
//                result = divide(x, y);
//            } catch (Exception e){
//                System.out.println(e.toString());
//            }
//            System.out.println(result);
//        } catch(InputMismatchException e) {
//            System.out.println(e.toString());
//        }

        System.out.println(MyCalculator.power(0,-5));


    }

    public static int divide(int x, int y) throws Exception{
        if (y == 0){
            throw new Exception("Sıfıra bölemezsin!");
        }
        return x / y;
    }
}