import java.util.*;

public class MyLinkedList {

    private Node start, end;
    private int size;

    public boolean testing; // set to false so functions don't print a ton of extra code
    /* 
    if (testing) {
	System.out.println();
	System.out.println("");
    }			   
    */

    private class Node{
	private Node next, prev;
	private Integer data;

	public Node (Integer data) {
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
	
	private Integer getValue () {
	    return data;
	}

	private void setValue (Integer n) {
	    data = n;
	}
	
	private String toString (Node n) { // I can't tell whether I'm just stupid or if I just can't get this to work right
	    return "" + data;
	}

	private String sNode () {
	    return "[" + prev + ", " + data + ", " + next + "]";
	}

	// returns something like this
	// [null, 1, MyLinkedList$Node@7852e922] (first)
	// [MyLinkedList$Node@4e25154f, 2, MyLinkedList$Node@70dea4e] (middle)
	// [MyLinkedList$Node@70dea4e, 4, null] (last) 
    }
    
    public MyLinkedList () {
	start = null;
	end = null;
	size = 0;
    }

    public void clear () {
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

    public String toString (Node n) { // a toString that takes a Node and prints it out
	return "[prev, " + n.getValue() + ", next]";
    }
    
    private Node getNode (int index) {
	if (!in(index) || index >= size) {
	    throw new IndexOutOfBoundsException();
	}
	
	Node n = start;

	for (int i = 0; i < index; i++) {
	    n = n.getNext();
	}

	return n; 
    } // gets the node
    // n.getNode(index) -> gives you the specific node
    
    public Integer get(int index) { // has exceptions
	if (index == 0) {
	    return start.getValue();
	}
	else if (index == size - 1) {
	    return end.getValue();
	}
	else {
	    return getNode(index).getValue();
	}
    } // gets the value of the node
    // n.get(index) -> gives you the value of a specific node
    // - utilizes getNode
    
    
    public Integer set (int index, Integer value) { // has exceptions
	Node n = new Node(value);
	return value; 
    } 
    
    public int size () {
	return size;
    }

    public boolean in (int index) { // returns true if "in", returns false if not
	return index < size;
    }

    public boolean add (Integer value) {
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
    
    public void add (int index, Integer value) {
	if (!in(index)) {
	    throw new IllegalArgumentException();
	}

	Node n = new Node(value);
	
	if (index == 0) {
	    Node s = start;	    
	    n.setNext(s);
	    s.setPrev(n);
	    start = n; 
	}
	
	else if (index == size - 1) {
	    n.setPrev(end);
	    end.setNext(n);
	    end = n;
	}
	else if (index != 0 && in(index)) {
	    Node b = getNode(index); // next (index + 1 -> index + 1)
	    Node a = b.getPrev(); // prev (index - 1 -> index - 1)
	    
	    n.setPrev(a);
	    n.setNext(b);
	    a.setNext(n);
	    b.setPrev(n);
	    
	    /* this replaced the Node that was at the index rather than inserting it rip
	    n.setPrev(r.getPrev());
	    n.setNext(r.getNext());
	    r.getPrev().setNext(n);
	    r.getNext().setPrev(n);
	    r = n;
	    */
	}
	size++; 
    }
    
    public boolean remove (Integer value) {
	Node n = start; 

	while (n != null) {
	    if (n.getValue() == value) {
		n.getPrev().setNext(n.getNext());
		n.getNext().setPrev(n.getPrev());
		return true;
	    }
	    else {
		n = n.getNext();
	    }
	}
	
	return false;
    }
    
    public boolean remove (int index) {
	if (!in(index)) { // if not (index < size)
	    throw new IllegalArgumentException();
	}
	else {
	    
	}
	return true;
    }
    
    public static void main(String[]args){
	MyLinkedList a = new MyLinkedList();
	boolean testing = true;

	System.out.println("testing: " + testing);
	System.out.println(a.toString() + ", " + a.size()); // toString + size
				   
	// test add (boolean, adds to end)
	System.out.println("\ntest add (boolean, adds to end)");
	a.add(Integer.valueOf(1));
	System.out.println(a.toString());
	a.add(Integer.valueOf(3));
	System.out.println(a.toString());
	a.add(Integer.valueOf(4));
	System.out.println(a.toString());
	a.add(Integer.valueOf(5));
	System.out.println(a.toString());
	a.add(Integer.valueOf(7));
	System.out.println(a.toString());

	System.out.println("\n" + a.toString() + ", " + a.size()); // toString + size
	
	// test add (void, inserts)
	System.out.println("\ntest add (void, inserts)");
	a.add(0,Integer.valueOf(0));
	System.out.println(a.toString());
	System.out.println(a.size() + "\n");
	a.add(2,Integer.valueOf(2));
	System.out.println(a.toString());
	System.out.println(a.size() + "\n");
	a.add(5,Integer.valueOf(6));
	System.out.println(a.toString());
	System.out.println(a.size() + "\n");

	System.out.println("\n" + a.toString() + ", " + a.size()); // toString + size
	
	// test set (Integer)
	System.out.println("\ntest set (Integer)");

	System.out.println("\n" + a.toString() + ", " + a.size()); // toString + size
	
	// test getNode (Node) + get (Integer)
	System.out.println("\ntest getNode (Node) + get (Integer)");
	//System.out.println(a.getNode(0).sNode());
	System.out.println(a.toString(a.getNode(0)));
	System.out.println("get 0: " + a.get(0));
	//System.out.println(a.getNode(1).sNode());
	System.out.println(a.toString(a.getNode(1)));
	System.out.println("get 1: " +a.get(1));
	//System.out.println(a.getNode(2).sNode()); 
	System.out.println(a.toString(a.getNode(2)));
	System.out.println("get 2: " +a.get(2));
	//System.out.println(a.getNode(3).sNode());
	System.out.println(a.toString(a.getNode(3)));
	System.out.println("get 3: " +a.get(3));

	// test remove (boolean, value)
	System.out.println("\ntest remove (boolean, value)");
	System.out.println(a.remove(Integer.valueOf(6)));
	System.out.println(a.toString());
	System.out.println(a.remove(Integer.valueOf(7)));
	System.out.println(a.toString());

	System.out.println("\n" + a.toString() + ", " + a.size()); // toString + size
	
	// test remove (boolean, index)
	System.out.println("\ntest remove (boolean, index)");
	System.out.println("???"); 
	System.out.println(a.toString());

	System.out.println("\n" + a.toString() + ", " + a.size()); // toString + size
	
	// test clear
	System.out.println("\ntest clear");
	a.clear();
	System.out.println(a.toString());

	System.out.println("\n\n\n\n\n\n\n\n\n");
    }
    
}
