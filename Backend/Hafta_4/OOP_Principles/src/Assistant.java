public class Assistant extends Academician{
    private int ofisSaati;
    public Assistant(String fullName, String phoneNumber, String email, String department, String title, int ofisSaati) {
        super(fullName, phoneNumber, email, department, title);
        this.ofisSaati = ofisSaati;
    }

    public int getOfisSaati() {
        return ofisSaati;
    }

    public void setOfisSaati(int ofisSaati) {
        this.ofisSaati = ofisSaati;
    }

    public void quizYap(){
        System.out.println(this.getTitle() + " " + this.getFullName() + " concluded a quiz on " + this.getDepartment());
    }
}
