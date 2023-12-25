public class TeachingAssistant extends Academician{
    private int doorNumber;
    public TeachingAssistant(String fullName, String phoneNumber, String email, String department, String title, int doorNumber) {
        super(fullName, phoneNumber, email, department, title);
        this.doorNumber = doorNumber;
    }

    public int getDoorNumber() {
        return doorNumber;
    }

    public void setDoorNumber(int doorNumber) {
        this.doorNumber = doorNumber;
    }

    public void senatoToplanti(){
        System.out.println(this.getTitle() + " " + this.getFullName() + " attended the University Senate meeting.");
    }

    public void sinavYap(){
        System.out.println(this.getTitle() + " " + this.getFullName() + " concluded a " + this.getDepartment() + " exam.");
    }
}
