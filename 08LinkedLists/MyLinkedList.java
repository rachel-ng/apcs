import java.util.*;

public class MyLinkedList {

    private Node start,end;
    private int size;

    private class Node{
	private Node next, prev;
	private int data;

	public Node (int data) {
	    this.data = data;
	}
	
	private Node getNext () {
	    return next; 
	}

	private Node setNext (int n) {
	    next = n; 
	}
	
	private Node getPrev () {
	    return prev;
	}

	private Node setPrev (int n) {
	    prev = n; 
	}
	
	private int getValue () {
	    return data;
	}

	private void setValue (int n) {
	    data = n;
	}
	
	private String toString (Node n) {
	    return "" + data;
	}
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
	    str += n;
	    while(n != null) {
		str += ", " + n;
		n = n.getNext();
	    }
	}
	
	return str + "]";
    }
    
    private Node getNode (int index) {
	if (index < 0 || index >= size) {
	    throw new IndexOutOfBoundsException();
	}
	
	Node n = start;

	for (int i = 0; i < index; i++) {
	    n = n.getNext();
	}

	return n; 
    }

    public Integer get(int index) { // exceptions
	if (index == 0) {
	    return start;
	}
	else if (index == length - 1) {
	    return end;
	}
	else {
	    return getNode(index);
	}
    }

    public Integer set (int index, Integer value) { // exceptions
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
	    first = n; 
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
	if (index == 0) {

	}
	if (index == size) {

	}
	if (in(index)) {
	    
	}
	else if (!in(index)) {
	    throw new IllegalArgumentException();
	}
    }

    public boolean remove (Integer value) {
	Node n = start; 

	while (n != null) {
	    if (n.getValue() == value) {
		Node prev = n.getPrev(); 
		Node next = n.getNext();
		prev.setNext(next);
		next.setPrev(prev);

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
	
	System.out.println(a.size());
	System.out.println(a.toString());
    }
    
}
