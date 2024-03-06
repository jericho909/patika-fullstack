import java.util.Comparator;

public class PageComparator implements Comparator<Books> {

    @Override
    public int compare(Books book1, Books book2) {
        return Integer.compare(book1.getPageCount(), book2.getPageCount());
    }
}
