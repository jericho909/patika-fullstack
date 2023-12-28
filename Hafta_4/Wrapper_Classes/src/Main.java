public class Main {
    public static void main(String[] args) {
        int a = 20;

        Integer b = 20;
        Short s = 2;
        String strlong = "5454";
        int c = Integer.parseInt(strlong);
        System.out.println(a + b + c);
        String str = b.toString();
        System.out.println(str);
        System.out.println(s.byteValue());
    }
}