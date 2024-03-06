public class Employee {
    private String fullName;
    private String phoneNumber;
    private String email;

    public Employee(String fullName, String phoneNumber, String email) {
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void giris(){
        System.out.println(this.fullName + " entered the campus.");
    }

    public void cikis(){
        System.out.println(this.fullName + " exited the campus.");
    }

    public void yemekhane(){
        System.out.println(this.fullName + " entered the dining hall.");
    }
}
