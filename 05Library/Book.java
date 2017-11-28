public class Book {
    private String author;
    private String title;
    private String ISBN;

    public null Book () {
	
    }
    
    public Book (String auth, String titl, String bookNum) {
	title = titl;
	author = auth;
	ISBN = bookNum;
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
    
    public void setAuthor (String auth) {
	author = auth;
    }

    public void setTitle (String titl) {
	title = titl;
    }

    public void setISBN (String bookNum) {
	ISBN = bookNum;
    }

    public String toString () {
	return "Title: " + title + "\nAuthor: " + author + "\nISBN: " + ISBN; 
    }
    
}
