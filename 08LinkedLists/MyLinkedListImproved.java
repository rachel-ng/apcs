import java.util.*;

public class MyLinkedListImproved<T> { //extends Comparable<T>> implements Iterable<T> {

    private Node start, end;
    private int size;

    private class Node{
	private Node next, prev;
	private T data;

	public Node (T data) {
	    this.data = data;
	}
	
	private Node getNext () {
	    return next; 
	}

	private void setNext (Node n) {
	    next = n; 
	}
	
	private Node getPrev () {
	    return prev;
	}

	private void setPrev (Node n) {
	    prev = n; 
	}
	
	private T getValue () {
	    return data;
	}

	private void setValue (T n) {
	    data = n;
	}
	
	private String toString (Node n) {
	    return "" + data;
	}

	private String sNode () { // also known as sadness 
	    return "[" + prev + ", " + data + ", " + next + "]";
	}
    }
    
    public MyLinkedListImproved () {
	start = null;
	end = null;
	size = 0;
    }

    public String toString () {
	String str = "[";
	
	if (size > 0) {
	    Node n = start;
	    while(n != null) {
		str += n.getValue();
		if (n.getNext() != null) {
		    str += ", ";
		}
		n = n.getNext();
	    }
	}
	
	return str + "]";
    }

    public String backString () { // toString but backwards
	String str = "[";
	
	if (size > 0) {
	    Node n = end;
	    while(n != null) {
		str += n.getValue();
		if (n.getPrev() != null) {
		    str += ", ";
		}
		n = n.getPrev();
	    }
	}
	
	return str + "]";
    }

    public String toString (Node n) {
	return "[prev, " + n.getValue() + ", next]";
    }

    public void clear () {
	start = null;
	end = null;
	size = 0; 
    }

    public int size () {
	return size;
    }

    private Node getNode (int index) {
	if (index >= size) {
	    throw new IndexOutOfBoundsException();
	}
	
	Node n = start;

	for (int i = 0; i < index; i++) {
	    n = n.getNext();
	}

	return n;
    }
    
    public T get(int index) {
	if (index < 0 || index >= size) {
	    throw new IndexOutOfBoundsException();
	}
	if (index == 0) {
	    return start.getValue();
	}
	else if (index == size - 1) {
	    return end.getValue();
	}
	else {
	    return getNode(index).getValue();
	}
    }
    
    
    public T set (int index, T newValue) {
	if (index < 0 || index >= size) {
	    throw new IndexOutOfBoundsException();
	}
	
	Node n = getNode(index);
	T old = n.getValue();
	n.setValue(newValue);
	return old; 
    }

    public int indexOf (T value) {
	Node n = start;
	int i = 0;
	
	while (n != null && i < size) {
	    if (n.getValue() == value) {
		return i;
	    }
	    i++;
	    n = n.getNext();
	}
	
	return -1; 
    }

    public boolean add (T value) {
	Node n = new Node(value);
	
	if (size == 0) {
	    start = n; 
	}
	else {
	    n.setPrev(end);
	    end.setNext(n);
	}

	end = n;
	size++;
	return true;
    }
    
    public void add (int index, T value) {
	if (size == 0 || index < 0 || index > size) {
	    throw new IndexOutOfBoundsException();
	}

	Node n = new Node(value);

	if (index == 0) {
	    n.setNext(start);
	    start.setPrev(n);
	    start = n;
	    size++;
	}
	if (index == size - 1) {
	    end.getPrev().setNext(n);
	    n.setNext(end);
	    end.setPrev(n);
	    size++;
	}
	else if (index != 0 && index != size - 1 && index < size) { // I now have trust issues
	    Node b = getNode(index); // next (index + 1 -> index + 1)
	    Node a = b.getPrev(); // prev (index - 1 -> index - 1)
	    
	    n.setPrev(a);
	    n.setNext(b);
	    a.setNext(n);
	    b.setPrev(n);
	    size++;
	}
    }
    
    public boolean remove (T value) {
	Node n = start;

	while (n != null) {
	    if (n.getValue().equals(value)) {
		if (n == start) {
		    start = n.getNext();
		    n.getNext().setPrev(null);
		    size--; 
		    return true;
		}
		if (n == end) {
		    end = n.getPrev();
		    n.getPrev().setNext(null);
		    size--; 
		    return true;
		}
		else if (n != start && n != end){
		    n.getPrev().setNext(n.getNext());
		    n.getNext().setPrev(n.getPrev());
		    size--; 
		    return true;
		}
	    }
	    else {
		n = n.getNext();
	    }
	}
	return false;
    }
    
    public boolean remove (int index) {
	if (index < 0 || index >= size) {
	    throw new IndexOutOfBoundsException();
	}

	if (index == 0) {
	    start = start.getNext();
	    start.setPrev(null);
	    size--;
	    return true;
	}
	if (index == size - 1) {
	    end = end.getPrev();
	    end.setNext(null);
	    size--;
	    return true;
	}	
	else if (index != 0 && index != size - 1 && index < size) {
	    Node n = getNode(index);
	    n.getPrev().setNext(n.getNext());
	    n.getNext().setPrev(n.getPrev());
	    size--;
	    return true;
	}
	return false;
    }

    public int max () {
	if (size == 0) {
	    return -1;
	}

	Node n = start;
	T max = start.getValue();
	int i = 0;
	int ind = 0;

	while (n != null) {
	    
	}
	
	return ind;
    }

    public int min () {
	if (size == 0) {
	    return -1;
	}
	return -1;
    }

    public int compareTo (T n) {
	return -1;
	//return T.compare(this.getValue(), n.getValue());
    }

    /*
    
      public Iterator<T> iterator () {
      return Listerator();
      }

      private class Listerator implements Iterator<T>{
      private MyLinkedListImproved l;
      private Node n;

      public Listerator () {
      n = l.getNode(0);
      }

      private boolean hasNext () {
      return n.getNext() != null;
      }

      private Node next () {
      if (n.getNext() == null) {
      throw new NoSuchElementException();
      }
      else {
      return n.getNext();
      }
      }

      private void remove () {
      throw new UnsupportedOperationException();
      }
	
      }

    */
	
    public static void main(String[]args){
	MyLinkedListImproved<String> n = new MyLinkedListImproved<>();
	n.add("fish");
	System.out.println(n);
	
	MyLinkedListImproved<Integer> m = new MyLinkedListImproved<>();
	m.add(new Integer(0));
	System.out.println(m);


	
	MyLinkedListImproved<Integer> a = new MyLinkedListImproved<>();
	System.out.println(a.toString() + ", " + a.size()); // toString + size
	
	// test add (boolean, adds to end)
	System.out.println("\n\ntest add (boolean, adds to end)");
	System.out.println(a.toString());
	int[] addValue = new int[] {1, 1, 2, 3, 4, 5, 7, 9, 11};
	for (int i : addValue) {
	    a.add(Integer.valueOf(i));
	    System.out.println(i + " ->\t" + a.toString());
	}

	System.out.println("\n" + a.toString() + ", " + a.size() + "\n" + a.backString());	
	// test add (void, inserts)
	System.out.println("\n\ntest add (void, inserts)");
	System.out.println(a.toString());
	a.add(0,Integer.valueOf(0));
	System.out.println(a.toString() + ", " + a.size());
	a.add(3,Integer.valueOf(2));
	System.out.println(a.toString() + ", " + a.size());
	a.add(8,Integer.valueOf(6));
	System.out.println(a.toString() + ", " + a.size());
	a.add(9,Integer.valueOf(7));
	System.out.println(a.toString() + ", " + a.size());
	a.add(11,Integer.valueOf(9));
	System.out.println(a.toString() + ", " + a.size());
	
	System.out.println("\n" + a.toString() + ", " + a.size() + "\n" + a.backString());

	// test indexOf (int) 
	System.out.println("\n\ntest indexOf (int)");
	System.out.println(a.toString());
	int[] indexOfInt = new int[] {2, 7, 8, 9};
	for (int i : indexOfInt) {
	    System.out.println("index of " + i + ": " + a.indexOf(i));
	}
	
	System.out.println("\n" + a.toString() + ", " + a.size() + "\n" + a.backString());

	// test set (Integer)
	System.out.println("\n\ntest set (Integer)");
	System.out.println(a.toString());	
	System.out.println("set 10 (" + a.set(10,Integer.valueOf(8)) + ") -> 8");
	System.out.println(a.toString());
	System.out.println("set 12 (" + a.set(12,Integer.valueOf(10)) + ") -> 10");
	System.out.println(a.toString());

	System.out.println("\n" + a.toString() + ", " + a.size() + "\n" + a.backString());

	// test getNode (Node) + get (Integer)
	System.out.println("\n\ntest getNode (Node) + get (Integer");
	for (int i = 0; i < a.size(); i++) {
	    System.out.println("get " + i + ": " + a.get(i) + "\t" + a.toString(a.getNode(i)));
	}

	System.out.println("\n" + a.toString() + ", " + a.size() + "\n" + a.backString());

	// test remove (boolean, value)
	System.out.println("\n\ntest remove (boolean, value)");
	System.out.println(a.toString());
        Integer[] removeValue = new Integer[] {0, 6, 7, 9, 11};
	for (int i : removeValue) {
	    System.out.println("remove " + i + ": " + a.remove(Integer.valueOf(i)));
	    if (i == 0) { System.out.println("-> removes start"); }
	    if (i == a.size() - 1) { System.out.println("-> removes end"); }
	    System.out.println(a.toString());	
	}
	
	System.out.println("\n" + a.toString() + ", " + a.size() + "\n" + a.backString());
	
	// test remove (boolean, index)
	System.out.println("\n\ntest remove (boolean, index)");
	System.out.println(a.toString());
	int[] removeIndex = new int[] {7, 0, 6, 2};
	for (int i : removeIndex) {
	    System.out.println("remove " + i + ": " + a.remove(i));
	    if (i == 0) { System.out.println("-> removes start"); }
	    if (i == a.size() - 1) { System.out.println("-> removes end"); }
	}

	System.out.println("\n" + a.toString() + ", " + a.size() + "\n" + a.backString());
	
	// test clear
	System.out.println("\n\ntest clear");
	System.out.println(a.toString());
	a.clear();
	System.out.println(a.toString());
	System.out.println("\n\n\n\n");


	
	MyLinkedListImproved<String> b = new MyLinkedListImproved<>();
	System.out.println(b.toString() + ", " + b.size()); // toString + size

	// test add (boolean, adds to end)
	System.out.println("\n\n\ntest add (boolean, adds to end)");
	System.out.println(b.toString());
	b.add("cries");
	System.out.println(b.toString());
	b.add("dies");
	System.out.println(b.toString());
	b.add("dies");
	System.out.println(b.toString());
	b.add("cries");
	System.out.println(b.toString());
	b.add("cries");
	System.out.println(b.toString());
	b.add("goodbye");
	System.out.println(b.toString());
	
	System.out.println("\n" + b.toString() + ", " + b.size() + "\n" + b.backString());

	// test add (void, inserts)
	System.out.println("\n\n\ntest add (void, inserts)");
	System.out.println(b.toString());
	b.add(4,"cries");
	System.out.println(b.toString() + ", " + b.size());
	b.add(1,"dies");
	System.out.println(b.toString() + ", " + b.size());
	b.add(4,"cries");
	System.out.println(b.toString() + ", " + b.size());
	b.add(2,"dies");
	System.out.println(b.toString() + ", " + b.size());
	b.add(6,"dies");
	System.out.println(b.toString() + ", " + b.size());
	b.add(4,"dies");
	System.out.println(b.toString() + ", " + b.size());
	
	System.out.println("\n" + b.toString() + ", " + b.size() + "\n" + b.backString());
	
	// test set (T)
	System.out.println("\n\n\ntest set (T)");
	System.out.println(b.toString());
	System.out.println("set 3 (dies) -> cries");
	System.out.println(b.set(3,"cries"));
	System.out.println(b.get(3));
	System.out.println("set 5 (dies) -> cries");
	System.out.println(b.set(5,"cries"));
	System.out.println(b.get(5));
	System.out.println("set 9 (cries) -> dies");
	System.out.println(b.set(9,"dies"));
	System.out.println(b.get(9));
	System.out.println(b.toString());

	System.out.println("\n" + b.toString() + ", " + b.size() + "\n" + b.backString());

	// test getNode (Node) + get (T)
	System.out.println("\n\n\ntest getNode (Node) + get (T)");
	for (int i = 0; i < b.size(); i++) {
	    System.out.println("get " + i + ": " + b.get(i) + "\t" + b.toString(b.getNode(i)));
	}

	System.out.println("\n" + b.toString() + ", " + b.size() + "\n" + b.backString());
	
	// test remove (boolean, value)
	System.out.println("\n\n\ntest remove (boolean, value)");
	System.out.println(b.toString());
	String[] removeVal = new String[] {"cries", "dies", "cries", "goodbye"};
	for (String i : removeVal) {
	    System.out.println("remove " + i + ": " + b.remove(i));
	    System.out.println(b.toString() + ", " + b.size());
	}

	System.out.println("\n" + b.toString() + ", " + b.size() + "\n" + b.backString());	
	// test remove (boolean, index)
	System.out.println("\n\n\ntest remove (boolean, index)");
	System.out.println(b.toString());
	int[] removeInd = new int[] {0, 6, 1};
	for (int i : removeInd) {
	    System.out.println("remove " + i + ": " + b.remove(i));
	    System.out.println(b.toString() + ", " + b.size());
	}
	
	System.out.println("\n" + b.toString() + ", " + b.size() + "\n" + b.backString()); 
	
	// test clear
	System.out.println("\n\n\ntest clear");
	System.out.println(b.toString());
	b.clear();
	System.out.println(b.toString());
	
	// test min + max
	System.out.println("\n\n\ntest min + max");
	System.out.println(b.toString());
	System.out.println("\nmin: ");
	System.out.println(b.min());
	System.out.println("\nmax: ");
	System.out.println(b.max());
	
    }
}
