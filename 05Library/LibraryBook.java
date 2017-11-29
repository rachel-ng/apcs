abstract Class LibraryBook extends Book implements Comparable<LibraryBook> {
    private String callNumber;

    public LibraryBook (String titl, String auth, String bookNum, String callNum) {
	title = titl;
	author = auth;
	ISBN = bookNum;
	callNumber = callNum;
    }
    
    public String getAuthor () {
	return author;
    }

    public String getTitle () {
	return title;
    }

    public String getISBN () {
	return ISBN;
    }

    public String getCallNumber () {
	return callNumber;
    }
    
    public void setAuthor (String auth) {
	author = auth;
    }

    public void setTitle (String titl) {
	title = titl;
    }

    public void setISBN (String bookNum) {
	ISBN = bookNum;
    }

    public void setCallNumber (String callNum) {
	callNumber = callNum;
    }

    public String toString () {
	return "Title: " + title + "\nAuthor: " + author + "\nISBN: " + ISBN + "\nCirculation Status: " + circulationStatus() + "\nCall Number: " + callNumber; 
    }
    
    abstract void checkout(String patron, String due);
    
    abstract void returned();
    
    abstract String circulationStatus();

    public int compareTo (LibraryBook other) {
	return (getCallNumber() - other.getCallNumber());
    }
    
}
