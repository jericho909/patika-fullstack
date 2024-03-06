public class Main {
    public static void main(String[] args) {
        int a = 42;

        //Autoboxing
        Integer b = a;

        //Boxing
        Integer c = Integer.valueOf(a);

        //Auto-unboxing
        int d = c;

        //Unboxing
        int i = c.intValue();

    }
}