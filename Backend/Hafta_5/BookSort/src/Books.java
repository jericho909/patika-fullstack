public class Books implements Comparable{
    private String bookName;
    private int pageCount;

    private String authorName;

    private int yearOfPublishing;

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getYearOfPublishing() {
        return yearOfPublishing;
    }

    public void setYearOfPublishing(int yearOfPublishing) {
        this.yearOfPublishing = yearOfPublishing;
    }

    public Books(String bookName, int pageCount, String authorName, int yearOfPublishing) {
        this.bookName = bookName;
        this.pageCount = pageCount;
        this.authorName = authorName;
        this.yearOfPublishing = yearOfPublishing;
    }


    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
