import java.util.*;

public class FrontierQueue implements Frontier {

    Deque<Location> data = new ArrayDeque<>();
    
    public Location next () {
	return data.removeFirst();
    }

    public void add (Location n) {
	data.addLast(n);
    }

    public boolean hasNext () {
	return data.peekFirst() != null;
    }

    public static void main(String[]args) {
	FrontierQueue fq = new FrontierQueue();

	Location a = new Location(0,0,null);
	fq.add(a);
	Location b = new Location(1,1,null);
	fq.add(b);
	Location c = new Location(2,2,null);
	fq.add(c);

	System.out.println(fq.next());
	System.out.println(fq.next());
	System.out.println(fq.next());
    }
    
}
