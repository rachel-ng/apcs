import java.util.*;

public class MyLinkedList {

    private Node first,last;
    private int length;
    
    private class Node{
	private Node next, prev;
	private int data;
	
	private Node getNext () {
	}
	
	private Node getPrev () {
	}
	
	private int getValue () {
	}
	
	private String toString (Node n) {
	}
	
	private void get (Node n) {
	    
	}
	
	private void set (Node n) {
	    
	}
    }

    public MyLinkedList () {
	
    }

    public String toString () {
	String str = "[";

	for () {
	    str += 
	}
	
	return str + "]";
    }

    public int get(int index) {
	
    }

    public int set (int index, int value) {
	
    }

    public int size () {
	return length;
    }

    public boolean in (int index) {
	return index < length;
    }

    public boolean add (int index, int value) {
	if (in(index)) {

	}
	else {
	    throw new IllegalArgumentException();
	}
    }

    public boolean remove (int index) {
	if (!in(index)) {
	    throw new IllegalArgumentException();
	}
    }

    
}
