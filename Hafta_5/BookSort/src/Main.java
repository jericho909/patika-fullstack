import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Books book1 = new Books("The Lord of the Rings: The Fellowship of the Ring",
                432, "J.R.R. Tolkien",1954);
        Books book2 = new Books("My Shit Life So Far",
                304, "Frankie Boyle", 2009);
        Books book3 = new Books("Based on a True Story, Not a Memoir",
                272, "Norm Macdonald", 2017);
        Books book4 = new Books("Benim de Söyleyeceklerim Var",
                248, "Umut Sarıkaya", 2012);
        Books book5 = new Books("Blood, Sweat, and Pixels: The Triumphant, Turbulent Stories Behind How Video " +
                "Games Are Made", 304, "Jason Schreier", 2017);


        Set<Books> nameSortedBookset = new TreeSet<>();
        nameSortedBookset.add(book1);
        nameSortedBookset.add(book2);
        nameSortedBookset.add(book3);
        nameSortedBookset.add(book4);
        nameSortedBookset.add(book5);

        for (Books book: nameSortedBookset) {
            System.out.println(book.getBookName());
        }


    }
}