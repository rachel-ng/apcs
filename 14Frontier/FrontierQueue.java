public class FrontierQueue implements Frontier {

    Deque data = new Deque();
    
    public Location next () {
	return data.getFirst();
    }

    public void add (Location n) {
	data.addLast(n);
    }

    public boolean hasNext () {
	return data.peekFirst() != null;
    }
    
}
