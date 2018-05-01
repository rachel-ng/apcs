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
	if(this==null){
	    return"[]";
	}else{
	    return Arrays.toString(arr);
	}
    }

    public void add (String s) {
	if (data[0] == null) {
	    data[0] = s;
	}
    }

    public String remove () {
	
    }
    
    public String peek () {
	
    }

    public int size () {

    }

    public static void swap (int a, int b, String[] data) {
	String c = data[a];
	data[a] = data[b];
	data[b] = c;
    }
    
}
