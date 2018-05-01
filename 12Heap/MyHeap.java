import java.util.*;

public class MyHeap{

    private String[] data;
    private boolean max;
    private int size;
    
    public class MyHeap () {
	data = new String[10];
	max = true; 
	size = 10;
    }
    // - construct empty max heap
    
    public class MyHeap (boolean m) {
	data = new String[10];
	max = m; 
	size = 0;
    }
    // - true: construct empty max heap, false: construct empty min heap.

    // Methods

    public String toString (){

    }

    public void add (String value) {
	if (data[0] == null) {
	    data[0] = value;
	}
	else if (size < data.length() - 1) {
	    data[size] = value;
	    size++;
	}
	else if (size == data.length() - 1) {
	    
	}
    }

    public String remove () {
	
    }
    
    public String peek () {
	
    }

    public int size () {
	return size;
    }

    public void resize () {
	int re = data.length() * 2;
	String[] ne = String[re];
	
	for (int i = 0; i < data.length(); i++) {
	    ne[i] = data[i];
	}

	data = ne;
    }
    
    public static void swap (int a, int b, String[] data) {
	String c = data[a];
	data[a] = data[b];
	data[b] = c;
    }
    
}
