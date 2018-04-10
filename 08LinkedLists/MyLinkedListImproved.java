import java.util.*;

public class MyLinkedList {

    private Node start, end;
    private int size;

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
	// i'm weak i'm not even using it 
    }
    
    public MyLinkedList () {
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

    public String toString (Node n) { // for printing Nodes
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

    private Node getNode (int index) { // has exceptions
	if (index >= size) {
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
    } // gets the value of the node
    // n.get(index) -> gives you the value of a specific node
    // - utilizes getNode
    
    
    public Integer set (int index, Integer newValue) { // has exceptions
	if (index < 0 || index >= size) {
	    throw new IndexOutOfBoundsException();
	}
	
	Node n = getNode(index);
	Integer old = n.getValue();
	n.setValue(newValue);
	return old; 
    }
    // just changes the value of a Node and returns the old value

    public int indexOf (int value) {
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
    
    public boolean remove (Integer value) {
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
	    n.setPrev(end.getPrev().getPrev());
	    n.getPrev().setNext(n);
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
    
    public static void main(String[]args){
	MyLinkedList a = new MyLinkedList();
	
	System.out.println(a.toString() + ", " + a.size()); // toString + size
				   
	// test add (boolean, adds to end)
	System.out.println("\n\n\ntest add (boolean, adds to end)");
	System.out.println(a.toString());
	a.add(Integer.valueOf(1));
	System.out.println(a.toString());
	a.add(Integer.valueOf(2));
	System.out.println(a.toString());
	a.add(Integer.valueOf(3));
	System.out.println(a.toString());
	a.add(Integer.valueOf(4));
	System.out.println(a.toString());
	a.add(Integer.valueOf(5));
	System.out.println(a.toString());
	a.add(Integer.valueOf(7));
	System.out.println(a.toString());
	a.add(Integer.valueOf(8));
	System.out.println(a.toString());
	a.add(Integer.valueOf(11));
	System.out.println(a.toString());

	System.out.println("\n" + a.toString() + ", " + a.size()); 
	
	// test add (void, inserts)
	System.out.println("\n\n\ntest add (void, inserts)");
	System.out.println(a.toString());
	a.add(0,Integer.valueOf(0));
	System.out.println(a.toString() + ", " + a.size());
	a.add(2,Integer.valueOf(2));
	System.out.println(a.toString() + ", " + a.size());
	a.add(7,Integer.valueOf(6));
	System.out.println(a.toString() + ", " + a.size());
	a.add(8,Integer.valueOf(7));
	System.out.println(a.toString() + ", " + a.size());
	a.add(11,Integer.valueOf(9));
	System.out.println(a.toString() + ", " + a.size());
	
	System.out.println("\n" + a.toString() + ", " + a.size()); 

	// test indexOf (int) 
	System.out.println("\n\n\ntest indexOf (int)");
	System.out.println(a.toString());
	System.out.println("index of 2: " + a.indexOf(2));
	System.out.println("index of 7: " + a.indexOf(7));
	System.out.println("index of 8: " + a.indexOf(8));
	System.out.println("index of 9: " + a.indexOf(9));
	System.out.println("\n" + a.toString() + ", " + a.size()); 
	
	// test set (Integer)
	System.out.println("\n\n\ntest set (Integer)");
	System.out.println(a.toString());
	System.out.println("set 9 (7) -> 8");
	System.out.println(a.set(9,Integer.valueOf(8)));
	System.out.println(a.toString());
	System.out.println("set 11 (9) -> 10");
	System.out.println(a.set(11,Integer.valueOf(10)));
	System.out.println(a.toString());

	System.out.println("\n" + a.toString() + ", " + a.size());
	
	// test getNode (Node) + get (Integer)
	System.out.println("\n\n\ntest getNode (Node) + get (Integer");
	//System.out.println(a.getNode(0).sNode()); // works too!
	for (int i = 0; i < a.size(); i++) { // ah yes, a for loop for testing getNode and get because i'm lazy
	    System.out.println("get " + i + ": " + a.get(i) + "\t" + a.toString(a.getNode(i)));
	}

	System.out.println("\n" + a.toString() + ", " + a.size());

	// test remove (boolean, value)
	System.out.println("\n\n\ntest remove (boolean, value)");
	System.out.println(a.toString());
	System.out.println("remove 6: " + a.remove(Integer.valueOf(6)));
	System.out.println(a.toString());
	System.out.println("remove 7: " + a.remove(Integer.valueOf(7)));
	System.out.println(a.toString());
	System.out.println("remove 9: " + a.remove(Integer.valueOf(9)));
	System.out.println(a.toString());

	System.out.println("\n" + a.toString() + ", " + a.size());
	
	// test remove (boolean, index)
	System.out.println("\n\n\ntest remove (boolean, index)");
	System.out.println(a.toString());
	System.out.println("remove 7: " + a.remove(7));
	System.out.println(a.toString() + ", " + a.size());
	System.out.println("remove 0: " + a.remove(0));
	System.out.println(a.toString() + ", " + a.size());
	System.out.println("remove 6: " + a.remove(6));
	System.out.println(a.toString() + ", " + a.size());
	System.out.println("remove 2: " + a.remove(2));
	System.out.println(a.toString() + ", " + a.size());
	System.out.println("remove 5: " + a.remove(5));
	System.out.println(a.toString() + ", " + a.size());
	
	System.out.println("\n" + a.toString() + ", " + a.size());
	
	// test clear
	System.out.println("\n\n\ntest clear");
	System.out.println(a.toString());
	a.clear();
	System.out.println(a.toString());

	System.out.println("\n\n\n");
    }
    
}
