public abstract class LibraryBook extends Book implements Comparable<LibraryBook> {
    private String callNumber;

    public LibraryBook (String au, String ti, String is, String cn) {
	super(au, ti, is);
	callNumber = cn;
    }
    
    public String getCallNumber () {
	return callNumber;
    }
    
    public void setCallNumber (String cn) {
	callNumber = cn;
    }

    public String toString () {
	return super.toString() + ", " + circulationStatus() + ", " + getCallNumber();
    }
    
    public abstract void checkout(String patron, String due);
    
    public abstract void returned();
    
    public abstract String circulationStatus();

    public int compareTo (LibraryBook other) {
	return getCallNumber.compareTo(other.getCallNumber());
    }
    
}
