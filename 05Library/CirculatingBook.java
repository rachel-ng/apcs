public class CirculatingBook extends LibraryBook {
    private String currentHolder;
    private String dueDate;

    public CirculatingBook (String au, String ti, String is, String cn) {
	super(au, ti, is, cn);
	currentHolder = null;
	dueDate = null;
    }

    public String getCurrentHolder () {
	return currentHolder;
    }

    public String getDueDate () {
	return dueDate;
    }

    public void setCurrentHolder (String ch) {
	currentHolder = ch;
    }

    public void setDueDate (String dd) {
	dueDate = dd;
    }

    public void checkout (String patron, String due) {
	currentHolder = patron;
	dueDate = due;
    }

    public void returned () {
	setCurrentHolder(null);
	setDueDate(null);
    }

    public String circulationStatus () {
	if (currentHolder == null) {
	    return "Book available on shelves";
	}
	else {
	    return getCurrentHolder() + ", " + getDueDate();
	}
    }

    public String toString () {
	return super.toString() + ", " + circulationStatus() ;
    }
}
