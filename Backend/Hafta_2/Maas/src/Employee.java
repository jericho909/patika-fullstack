public class Employee {
    String name;
    double salary;
    int workHours;
    int hireYear;


    Employee(String name, double salary, int workHours, int hireYear){
        this.name = name;
        this.salary = salary;
        this.workHours = workHours;
        this.hireYear = hireYear;
    }

    public void tax(){
        if (this.salary > 1000) {
            System.out.println("Vergi: " + (this.salary * 0.003));
            this.salary -= (this.salary * 0.003);
        }
    }

    public void bonus(){
        if (this.workHours > 40){
            System.out.println("Bonus: " + ((this.workHours - 40) * 30));
            this.salary += ((this.workHours - 40) * 30);
        }
    }

    public void raiseSalary(){
        if (2021 - this.hireYear >= 20) {
            this.salary += (0.15 * this.salary);
            System.out.println("Çalışanın maaş artışı: " + (0.15 * this.salary));
        } else if (this.hireYear >= 10 && this.salary < 20) {
            this.salary += (0.10 * this.salary);
            System.out.println("Çalışanın maaş artışı: " + (0.10 * this.salary));
        } else if (this.hireYear < 10) {
            System.out.println("Çalışanın maaş artışı: " + (0.05 * this.salary));
            this.salary += (0.05 * this.salary);
        }
    }

    public void infoPrint(){
        System.out.println("Çalışanın adı: " + this.name);
        System.out.println("Çalışanın maaşı: " + this.salary);
        System.out.println("Çalışanın haftalık çalışma saati: " + this.workHours);
        System.out.println("Çalışanın başlangıç yılı: " + this.hireYear);
        bonus();
        raiseSalary();
        tax();
        System.out.println("Çalışanın bonus ve maaş artışı uygulanmış, vergisi düşülmüş maaşı: " + this.salary);
    }
}
