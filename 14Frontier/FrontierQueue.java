import java.util.*;

public class FrontierQueue implements Frontier {

    private LinkedList<Location> data;
    
    public Location next () {
	return data.remove();
    }

    public FrontierQueue(){
	data = new LinkedList<Location>();
    }
    
    public void add (Location n) {
	data.add(n);
    }

    public boolean hasNext () {
	return data.peek() != null;
    }

}
