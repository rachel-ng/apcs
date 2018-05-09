import java.util.*;

public class MyHeap {
    private String[] data;
    private boolean max, min;
    private int size;
    
    public MyHeap () {
	data = new String[10];
	size = 0;
	max = true;
	min = false;
    }
    
    public MyHeap (boolean m) {
	data = new String[10];
	size = 0;
	max = m;
	min = !m;
    }

    public String toString () {
	String str = "[";
	for (int i = 0; i < data.length; i++) {
	    str += data[i];
	    if (i < data.length - 1) {
		str += ", ";
	    }
	}
	return str + "]";
    }
    
    public void add(String value){
	if (data[0] == null) {
	    data[0] = value;
	    size++;
	    return;
	}
	
	if (size >= data.length - 1){
	    resize();
	}
	
	data[size] = value;
	size++;
	up(size - 1);
    }

    public void up (int index) {
	int p = (index - 1) / 2;
	
	if (max && data[index].compareTo(data[p]) > 0 && index != 0) {
	    swap(index, p, data);
	    up(p);
	}
	if (min && data[index].compareTo(data[p]) < 0 && index != 0) {
	    swap(index, p, data);
	    up(p);
	}
    }
    
    public void down (int index) {
	int l = (index * 2) + 1;
	int r = (index * 2) + 2;
	
	if (max) {
	    if(data[index].compareTo(data[l]) < 0){
		swap(index, l, data);
		down(l);
	    }
	    if(data[index].compareTo(data[r]) < 0){
		swap(index, r, data);
		down(r);
	    }
	}
	
	if (min) {
	    if(data[index].compareTo(data[l]) > 0){
		swap(index, l, data);
		down(l);
	    }
	    if (data[index].compareTo(data[r]) > 0){
		swap(index, r, data);
		down(r);
	    }
	}
    }

    public String remove(){
	String s = peek();
	data[0] = null;
	swap(0, size - 1, data);
	size--; 
	down(0);	
	return s;
    }

    public String peek () {
	return data[0];
    }
    
    public int size (){
	return size;
    }

    public static void swap (int a, int b, String[] dat) {
	String c = dat[a];
	dat[a] = dat[b];
	dat[b] = c;
    }

    public void resize () {
	String[] halp = new String[data.length * 2];
	for (int i = 0; i < size; i++) {
	    halp[i] = data[i];
	}
	data = halp;
    }

}
