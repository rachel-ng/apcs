import java.util.*;

public class MyLinkedListImproved<T> {//extends Comparable<T>> implements Iterator<T> {

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
	
	private String toString (Node n) { // I can't tell whether I'm just stupid or if I just can't get this to work right
	    return "" + data;
	}

	private String sNode () {
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
	    if (n.getValue() == value) {
		n.getPrev().setNext(n.getNext());
		n.getNext().setPrev(n.getPrev());
		size--; 
		return true;
	    }
	    else {
		n = n.getNext();
	    }
	}
	return false;
	
	/*
	while (n != null) {
	    if (n.getValue().equals(value)) {
		if (n == start) {
		    n.getNext().setPrev(n.getPrev());
		    n = start;
		}
		if (n == end) {
		    n.getPrev().setNext(n);
		    n = end;
		}
		else if (n != start && n != end) {
		    n.getPrev().setNext(n.getNext());
		    n.getNext().setPrev(n.getPrev());
		}
		size--; 
		return true;
	    }
	    else {
		n = n.getNext();
	    }
	}
	return false;
	*/
    }
    
    public boolean remove (int index) {
	if (index < 0 || index >= size) {
	    throw new IndexOutOfBoundsException();
	}

	if (index == 0) {
	    Node n = new Node(get(1));
	    n.setNext(getNode(1).getNext());
	    start = n;
	    size--;
	}
	if (index == size - 1) {
	    Node n = new Node(end.getPrev().getValue());
	    n.setPrev(end.getPrev());
	    end.getPrev().setNext(n);
	    end = n;
	    size--;
	}	
	else if (index != 0 && index != size - 1 && index < size) {
	    Node n = getNode(index);
	    n.getPrev().setNext(n.getNext());
	    n.getNext().setPrev(n.getPrev());
	    size--;
	}
	return true;
    }

    public int max() {
	if (size == 0) {
	    return -1;
	}
	return -1;
    }

    public int min() {
	if (size == 0) {
	    return -1;
	}
	return -1;
    }

    public static void main(String[]args){
	MyLinkedListImproved<String> n = new MyLinkedListImproved<>();
	n.add("fish");
	System.out.println(n);
	
	MyLinkedListImproved<Integer> m = new MyLinkedListImproved<>();
	m.add(new Integer(0));
	System.out.println(m);

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
	
	System.out.println("\n" + b.toString() + ", " + b.size()); 

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
	
	System.out.println("\n" + b.toString() + ", " + b.size()); 

	// test set (T)
	System.out.println("\n\n\ntest set (T)");
	System.out.println(b.toString());
	System.out.println("set 3 (dies) -> cries");
	System.out.println(b.set(3,"cries"));
	System.out.println("set 5 (dies) -> cries");
	System.out.println(b.set(5,"cries"));
	System.out.println("set 7 (dies) -> cries");
	System.out.println(b.set(6,"cries"));
	System.out.println(b.toString());

	System.out.println("\n" + b.toString() + ", " + b.size());

	// test getNode (Node) + get (T)
	System.out.println("\n\n\ntest getNode (Node) + get (T)");
	for (int i = 0; i < b.size(); i++) {
	    System.out.println("get " + i + ": " + b.get(i) + "\t" + b.toString(b.getNode(i)));
	}

	System.out.println("\n" + b.toString() + ", " + b.size());

	/*
	
	// test remove (boolean, value)
	System.out.println("\n\n\ntest remove (boolean, value)");
	System.out.println(b.toString());
	System.out.println("remove cries: " + b.remove("cries"));
	System.out.println(b.toString());
	System.out.println("remove dies: " + b.remove("dies"));
	System.out.println(b.toString());

	System.out.println("\n" + b.toString() + ", " + b.size());

	*/

	// test remove (boolean, index)
	System.out.println("\n\n\ntest remove (boolean, index)");
	System.out.println(b.toString());
	System.out.println("remove 0: " + b.remove(0));
	System.out.println(b.toString() + ", " + b.size());
	System.out.println("remove 1: " + b.remove(1));
	System.out.println(b.toString() + ", " + b.size());
	System.out.println("remove 6: " + b.remove(6));
	System.out.println(b.toString() + ", " + b.size());
	System.out.println("remove 7: " + b.remove(7));
	System.out.println(b.toString() + ", " + b.size());

	System.out.println("\n" + b.toString() + ", " + b.size());

	// test clear
	System.out.println("\n\n\ntest clear");
	System.out.println(b.toString());
	b.clear();
	System.out.println(b.toString());
	
    }
}
