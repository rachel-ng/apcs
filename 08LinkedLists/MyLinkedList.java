import java.util.*;

public class MyLinkedList {

    private Node start,end;
    private int size;

    private class Node{
	private Node next, prev;
	private int data;
	
	private Node getNext () {
	    return next; 
	}

	private Node getPrev () {
	    return prev;
	}
	
	private int getValue () {
	    return data;
	}
	
	private String toString (Node n) {
	    str = "";
	    return str;
	}
	
	private void get (Node n) {
	    
	}
	
	private void set (Node n) {
	    
	}
    }
    
    /*
    private Node getNode (int index) {
	
    }
    */
    
    public MyLinkedList () {
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

    public void clear () {

    }

    public int size () {
	return size;
    }
    
    public Integer get(int index) {
	return index;
    }

    public Integer set (int index, Integer value) {
	return value; 
    }

    public boolean in (int index) {
	return index < size;
    }

    public boolean add (Integer newData) {
	
	return false; 
    }

    public void add (int index, Integer value) {
	if (in(index)) {
	}
	else {
	    throw new IllegalArgumentException();
	}
    }

    public boolean remove (Integer value) {
	return false;
    }
    
    public boolean remove (int index) {
	if (!in(index)) {
	    return false;
	}
	else {
	    throw new IllegalArgumentException();
	}
    }

    public static void main(String[]args){

	MyLinkedList a = new MyLinkedList(); 
	
	System.out.println(a.size());
	System.out.println(a.toString());
    }
    
}
