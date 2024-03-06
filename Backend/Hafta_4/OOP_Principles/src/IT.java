public class IT extends Official{
    private String role;
    public IT(String fullName, String phoneNumber, String email, String department, int workHours, String role) {
        super(fullName, phoneNumber, email, department, workHours);
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void networkKurulum(){
        System.out.println(this.getFullName() + " started the network installation.");
    }

}
