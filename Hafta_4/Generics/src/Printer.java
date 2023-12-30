import java.util.Objects;

public class Printer <T>{
    private T thingToPrint;
    public Printer(T thingToPrint){
        this.thingToPrint = thingToPrint;
    }

    public void print(){
        System.out.println(thingToPrint);
    }

    public static <T> void printArray(T[] arr){
        for (T element:arr) {
            System.out.println(element);
        }
    }
}
