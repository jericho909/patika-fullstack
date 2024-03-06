import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Lütfen çalışanın adı ve soyadını giriniz: ");
        String name = input.nextLine();
        System.out.println("Lütfen çalışanın maaşını giriniz: ");
        double salary = input.nextDouble();
        System.out.println("Lütfen çalışanın haftalık çalışma saatini giriniz: ");
        int workHours = input.nextInt();
        System.out.println("Lütfen çalışanın işe başlangıç yılını giriniz: ");
        int hireYear = input.nextInt();

        Employee e1 = new Employee(name, salary, workHours, hireYear);

        e1.infoPrint();

    }
}