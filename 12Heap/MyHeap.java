import java.util.*;

public class MyHeap <T extends Comparable<T>> {

    private String[] data;
    private boolean max;
    private int size;

    @SuppressWarnings("unchecked")
    public class MyHeap () {
	data = (T[])new Comparable[10];
	max = true; 
	size = 10;
    }
    // - construct empty max heap

    @SuppressWarnings("unchecked")
    public class MyHeap (boolean m) {
	data = (T[])new Comparable[10];
	max = m; 
	size = 0;
    }
    // - true: construct empty max heap, false: construct empty min heap.

    // Methods

    public String toString (){
	String str = "[";
	for (int i = 0; i < size; i++) {
	    str += data[i];
	    if (i < size - 1) {
		str += ", ";
	    }
	}
	return str + "]"
    }

    public void add (T value) {
	if (data[0] == null) {
	    data[0] = value;
	}
	else if (size <= data.length() - 1) {
	    data[size] = value;
	    up(size);
	    size++;
	}
	else if (size == data.length() && data[0] == null) {
	    resize();
	    data[size] = value;
	    up(size);
	    size++;
	}
    }

    public void up (int index) {
	int p = (index - 1) /2;

	if (max ) {

	}
	if (max ) {

	}
    }

    public void down (int index) {
	int l = index * 2 + 1;
	int r = index * 2 + 2;

	if (max ) {

	}
	if (max ) {

	}
	
    }

    public String remove () {
	String s = peek();
	swap(0, size - 1);
	pushDown(0);	
	return s;
    }
    
    public String peek () {
	return data[0];
    }

    public int size () {
	return size;
    }

    public int parent () {
	(n - 1) / 2;
    }
    
    public int LChild () {
	2n + 1;
    }

    public int RChild () {
	2n + 2;
    }
        
    public static void swap (int a, int b, String[] data) {
	String c = data[a];
	data[a] = data[b];
	data[b] = c;
    }

    public void resize () {
	T[] halp = (T[])new Comparable[size * 2];
	for (int i = 0; i < size; i++) {
	    halp[i] = data[i];
	}
	data = halp;
    }
    
}
