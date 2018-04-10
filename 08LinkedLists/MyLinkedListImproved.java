import java.util.*;

public class MyLinkedListImproved<T extends Comparable<T>> implements Iterable<T> {

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
        
}
