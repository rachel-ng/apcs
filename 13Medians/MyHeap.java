import java.util.*;

public class MyHeap<T extends Comparable<T>> {
    private T[] data;
    private boolean max, min;
    private int size;

    @SuppressWarnings("unchecked")
    public MyHeap () {
	data = (T[])new Comparable[10];
	size = 0;
	max = true;
	min = false;
    }

    @SuppressWarnings("unchecked")
    public MyHeap (boolean m) {
	data = (T[])new Comparable[10];
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
    
    public void add(T value){
	if (size == data.length){
	    resize();
	}
	
	data[size] = value;
	up(size);
	size++;
    }

    public void up (int index) {
	int p = (index - 1) / 2; // parent
	
	if (max && data[index].compareTo(data[p]) > 0) {
	    swap(index, p);
	    up(p);
	}
	
	if (min && data[index].compareTo(data[p]) < 0) {
	    swap(index, p);
	    up(p);
	}
    }
    
    public void down (int index) {
	int l = (index * 2) + 1; // wrong child
	int r = (index * 2) + 2; // right child
	
	if (max) { // max heap
	    if (data[index].compareTo(data[l]) < 0){
		swap(index, l);
		down(l);
	    }
	    if (data[index].compareTo(data[r]) < 0){
		swap(index, r);
		down(r);
	    }
	}
	
	if (min) { // min heap
	    if (data[index].compareTo(data[l]) > 0){
		swap(index, l);
		down(l);
	    }
	    else if (data[index].compareTo(data[r]) > 0){
		swap(index, r);
		down(r);
	    }
	}
    }

    public T remove(){
	T s = peek();
	swap(0, size - 1);
	size--;
	down(0);
	return s;
    }

    public T peek () {
	return data[0];
    }
    
    public int size (){
	return size;
    }

    public void swap (int a, int b) {
	T c = data[a];
	data[a] = data[b];
	data[b] = c;
    }

    @SuppressWarnings("unchecked")
    public void resize () {
	T[] halp = (T[])new Comparable[data.length * 2];
	for (int i = 0; i < size; i++) {
	    halp[i] = data[i];
	}
	data = halp;
    }

}
