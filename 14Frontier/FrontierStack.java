public class FrontierStack implements Frontier {

    Deque data = new Deque();
    
    public int next () { //Location next () {
	return data.getLast();
    }

    public void add (int n) { //Location n) {
	data.addLast(n);
    }

    public boolean hasNext () {
	return data.peekLast() != null;
    }

    public static void main(String[] args) {

	FrontierStack f  = new FrontierStack();

	int[] nums =  {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

	for (int i : nums) {
	    f.add(i);
	}

	for (int i = 0; i < 10; i++) {
	    System.out.println(f.hasNext());
	    System.out.println(f.next());
	}
	
    }
    
}
