import java.util.*;
public class Main {
    public static void main(String[] args) {
        int number;
        int newNumber;
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(0);
        list.add(1);
        int size = list.size();
        System.out.println(size);
        Scanner input = new Scanner(System.in);

        System.out.print("Lütfen serinin eleman sayısını giriniz: ");
        number= input.nextInt();

        for (int i = 0; i <= number - 2; i++){
            newNumber = list.get(size - 2) + list.get(size - 1);
            list.add(newNumber);
            size = list.size();
        }

        System.out.println(list);
    }
}