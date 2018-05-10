public class FrontierQueue implements Frontier {

    Deque data = new Deque();
    
    public Location next () {
	return data.pop();
    }

    public void add (Location n) {
	data.add(n);
	
    }

    public boolean hasNext () {

    }
    
}
