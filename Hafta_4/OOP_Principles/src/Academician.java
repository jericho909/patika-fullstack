public class Academician extends Employee{
    private String department;
    private String title;
    public Academician(String fullName, String phoneNumber, String email, String department, String title) {
        super(fullName, phoneNumber, email);
        this.department = department;
        this.title = title;

    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void derseGir(){
        System.out.println(this.getTitle() + " " + this.getFullName() + " entered the class as an Academician.");
    }
}
