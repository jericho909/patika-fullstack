import java.util.Comparator;

public class NameComparitor implements Comparator<Books>{

    @Override
    public int compare(Books book1, Books book2) {
        return book1.getBookName().compareTo(book2.getBookName());
    }
}
