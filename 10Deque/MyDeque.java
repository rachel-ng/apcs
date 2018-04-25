public class MyDeque<E> {

    private E[] deq;  // LIFO
    private int front, back;
    private int size;

    @SuppressWarnings("unchecked")
    public MyDeque() {
	deq = (E[])new Object[10];
	front = -1;
	back = -1;
	size = 10;
    }
    
    public MyDeque(int initialCapacity) {
	if (initialCapacity < 0) {
	    throw new IllegalArgumentException();
	}
	
	deq = (E[])new Object[10];
	front = -1;
	back = -1;
	size = initialCapacity;
    }

    public int size() {
	return size;
    }

    public void addFirst(E thing) {
	if (thing == null) {
	    throw new NullPointerException();
	}
    }
    
    public void addLast(E thing) {
	if (thing == null) {
	    throw new NullPointerException();
	}
    }

    public E removeFirst() {
	if (size == 0) {
	    throw new NoSuchElementException();
	}
    }

    public E removeLast() {
	if (size == 0) {
	    throw new NoSuchElementException();
	}
    }

    public E getFirst() {
	if (size == 0) {
	    throw new NoSuchElementException();
	}
    }
    
    public E getLast() {
	if (size == 0) {
	    throw new NoSuchElementException();
	}
    }

    
    
}
