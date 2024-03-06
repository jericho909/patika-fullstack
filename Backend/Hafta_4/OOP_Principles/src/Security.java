public class Security extends Official{
    private String document;
    public Security(String fullName, String phoneNumber, String email, String department, int workHours, String document) {
        super(fullName, phoneNumber, email, department, workHours);
        this.document = document;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public void nobet(){
        System.out.println(this.getFullName() + " started their guard shift. You can reach them in case of emergencies by calling "
                + this.getPhoneNumber() + " this number.");
    }
}
