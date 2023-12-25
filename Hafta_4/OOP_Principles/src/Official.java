public class Official extends Employee{
    private String department;
    private int workHours;
    public Official(String fullName, String phoneNumber, String email, String department, int workHours) {
        super(fullName, phoneNumber, email);
        this.department = department;
        this.workHours = workHours;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getWorkHours() {
        return workHours;
    }

    public void setWorkHours(int workHours) {
        this.workHours = workHours;
    }

    public void calis(){
        System.out.println(this.getFullName() + " started working.");
    }
}
