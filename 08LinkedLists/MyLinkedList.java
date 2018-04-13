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

    public String toString (int n) { // for printing Nodes
	return "[prev, " + getNode(n).getValue() + ", next]";
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
		if (n == start) {
		    start = start.getNext();
		    start.setPrev(null);
		    size--; 
		    return true;
		}
		if (n == end) {
		    end = end.getPrev();
		    end.setNext(null);
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
	return true;
    }
    
    public static void main(String[]args){

    }
    
}
