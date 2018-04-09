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
	    return start.getValue();
	}
	else if (index == size - 1) {
	    return end.getValue();
	}
	else {
	    return getNode(index).getValue();
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
	    start.getNext().setPrev(n);
	    n.setNext(start.getNext());
	    start = n;
	}
	if (index == size - 1) {
	    end.getPrev().setNext(n);
	    n.setPrev(end.getPrev());
	    end = n;
	}
	if (in(index)) {
	    Node r = start;
	    
	    for (int i = 0; i < index; i++) {
		r = r.getNext();
	    }

	    
	    n.setPrev(r.getPrev());
	    n.setNext(r.getNext());
	    r.getPrev().setNext(n);
	    r.getNext().setPrev(n);
	    r = n;
	    
	}
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
	
	System.out.println(a.size());
	System.out.println(a.toString());
	a.add(Integer.valueOf(1));
	System.out.println(a.toString());
	a.add(Integer.valueOf(2));
	System.out.println(a.toString());
	a.add(Integer.valueOf(3));
	System.out.println(a.toString());
	a.add(1,Integer.valueOf(5));
	System.out.println(a.toString());
	a.add(Integer.valueOf(4));
	System.out.println(a.toString());
	a.add(1,Integer.valueOf(2));
	System.out.println(a.toString());
	a.remove(Integer.valueOf(2));
	System.out.println(a.toString());
    }
    
}
