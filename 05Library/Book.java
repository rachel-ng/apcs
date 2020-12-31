public class Book {
    private String author;
    private String title;
    private String ISBN;

    public Book () {}
    
    public Book (String au, String ti, String is) {
	author = au;
	title = ti;
	ISBN = is;
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
    
    public void setAuthor (String au) {
	this.author = au;
    }

    public void setTitle (String ti) {
	this.title = ti;
    }

    public void setISBN (String is) {
	this.ISBN = is;
    }

    public String toString () {
	return title + ", " + author + ", " + ISBN; 
    }
    
}
