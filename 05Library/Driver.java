public class Driver {
    public static void main(String[] args) {
	Book milk = new Book();
	Book sun = new Book("rupi kaur", "the sun and her flowers", "2");

	System.out.println(milk);
	System.out.println(sun);

	System.out.println("\n");
	
        milk.setAuthor("rupi kaur");
	milk.setTitle("milk and honey");
	milk.setISBN("1");

	System.out.println(milk.getTitle());
	System.out.println(milk.getAuthor());
	System.out.println(milk.getISBN());
	System.out.println(milk.toString());

	System.out.println("\n");

	System.out.println(sun.getTitle());
	System.out.println(sun.getAuthor());
	System.out.println(sun.getISBN());
	System.out.println(sun.toString());

	System.out.println("\n");
	
       	System.out.println(milk);
	System.out.println(sun);
    }
}
