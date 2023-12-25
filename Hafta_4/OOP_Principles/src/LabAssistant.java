public class LabAssistant extends Assistant{

    public LabAssistant(String fullName, String phoneNumber, String email, String department, String title, int ofisSaati) {
        super(fullName, phoneNumber, email, department, title, ofisSaati);
    }

    public void lablaraGir(){
        System.out.println(this.getFullName() + " entered the labaratory.");
    }

    public void derseGir(){
        System.out.println(this.getTitle() + " " + this.getFullName() + " entered the class as an Assistant.");
    };
}
