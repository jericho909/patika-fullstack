public class Main {
    public static void main(String[] args) {
        Academician a1 = new Academician("John Smith", "0531 241 3131", "john@edu.com",
                "CENG", "Prof.");
        TeachingAssistant t1 = new TeachingAssistant("Mary Sue", "0522 221 1111", "mary@edu.tr",
                "EENG", "Prof.", 301);
        Assistant ass1 = new Assistant("Michael Doe", "0569 669 3131", "michael@edu.com",
                "SOL", "Mr.", 20);
        LabAssistant la1 = new LabAssistant("Kobe Bryant", "0523 240 2424", "kobe@edu.com",
                "LAL", "Prof.", 15);

        Official off1 = new Official("Jack Doe", "0569 669 6969", "jack@edu.com",
                "SOP", 100);
        IT it1 = new IT("Linus Tech", "0526 525 5252", "linus@edu.com",
                "IT", 100, "Sr. Specialist");
        Security sec1 = new Security("Bruce Wayne", "batsignal", "bruce@batman.biz",
                "BATMAN", 250, "Bat Credit Card");

        System.out.println(a1.getFullName());
        ass1.quizYap();
        t1.senatoToplanti();
        la1.lablaraGir();
        off1.calis();
        it1.networkKurulum();
        sec1.nobet();
    }

}
