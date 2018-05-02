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
	size = 10;
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

    public void add (String s) {
	if (size == data.length) {
	    resize();
	}

	data[size] = s;
	up(size);
	size++;
    }

    public void up (int index) {
	int p = (index - 1) /2;

	if ( ) {

	}
    }

    public void down (int index) {
	int l = index * 2 + 1;
	int r = index * 2 + 2;
	
    }

    public String remove () {
	String s = peek();
	swap(0, size - 1);
	length--;	
	pushDown(0);	
	return s;
    }
    
    public String peek () {
	return data[0];
    }

    public int size () {
	return size;
    }

    public void swap (int a, int b, String[] data) {
	String c = data[a];
	data[a] = data[b];
	data[b] = c;
    }

    public void resize () {
	String[] str = new String[size * 2];
	for (int i = 0; i < size; i++) {
	    str[i] = data[i];
	}
	data = str;
    }
    
}
