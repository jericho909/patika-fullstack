import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        Printer<Integer> printerForInt = new Printer<>(42);
        Printer<String> printerForStr = new Printer<>("Forty-Two");
        Printer<Double> printerForDouble = new Printer<>(4.2);
        Printer<Boolean> printerForBool = new Printer<>(true);
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            list.add(i);
        }

        Printer<ArrayList> printerForList = new Printer<>(list);
        printerForList.print();
        printerForInt.print();
        printerForStr.print();
        printerForDouble.print();
        printerForBool.print();

        shout(42);
        shout("Forty-Two");
        shout(4.2);
        shout(true);

        List<Integer> intList = new ArrayList<>();
        intList.add(42);
        printList(intList);

        List<Double> doubleList = new ArrayList<>();
        doubleList.add(4.2);
        printList(doubleList);

        Integer[] intArray = { 1, 2, 3 };
        String[] stringArray = {"Hello", "World"};

        Printer.printArray(intArray);
        Printer.printArray(stringArray);

        Student<String> student = new Student<>();
        student.insert("New Student");

        Student<Integer> studentNo = new Student<>();
        studentNo.insert(42);

        int fff = 42;
        double abc = 4.2;

        Counter<Integer> validInt = new Counter<>(fff);
        Counter<Double> validDouble = new Counter<>(abc);

        validInt.run();
        validDouble.run();

        String strNew = "I cannot go into the class beacuse I am not an extension of Number.";

        //Counter<String> newStr = new Counter<>(strNew); ---> will not work
    }

    private static <T> void shout(T thingToShout){
        System.out.println(thingToShout + "!!!!!");
    }

    private static void printList(List<?> myList){
        System.out.println();
    }


}