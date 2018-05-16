import java.util.*;

public class FrontierStack implements Frontier {

    Deque<Location> data = new ArrayDeque<>();
    
    public Location next () { //Location next () {
	return data.removeLast();
    }

    public void add (Location n) { //Location n) {
	data.addLast(n);
    }

    public boolean hasNext () {
	return data.peekLast() != null;
    }

    public static void main(String[] args) {

	FrontierStack fs = new FrontierStack();

	Location a = new Location(0,0,null);
	fs.add(a);
	Location b = new Location(1,1,null);
	fs.add(b);
	Location c = new Location(2,2,null);
	fs.add(c);

	System.out.println(fs.hasNext());
	System.out.println(fs.next());
	System.out.println(fs.hasNext());
	System.out.println(fs.next());
	System.out.println(fs.hasNext());
	System.out.println(fs.next());
	System.out.println(fs.hasNext());
	
    }
    
}

