public class ReferenceBook extends LibraryBook {
    private String collection;

    public LibraryBook (String au, String ti, String is, String cn, String co) {
	super(au, ti, is, cn);
	collection = co;
    }

    public String getCollection () {
	return collection;
    }

    public void setCollection (String co) {
	collection = co;
    }

    public void checkout (String patron, String due) {
	System.out.println("Cannot check out a reference book");
    }

    public void returned () {
	System.out.println("Reference book could not have been checked out -- return impossible");
    }

    public String circulationStatus () {
	return "Non-circulating reference book";
    }

    public String toString () {
	return getTitle() + ", " + getAuthor() + ", " + getISBN() + ", " + circulationStatus() + ", " + getCallNumber() + ", " + getCollection();
    }

}
