import java.util.*;

public class Sorts {

    public static void heapsort (int[] data) {
	Heapify(data);

	int size = data.length - 1;

	for (int i = 0; i < data.length; i++) {
	    swap(data, 0, size);
	    down(data, 0, size);
	    size--; 
	}
	
    }
    
    public static void Heapify (int[] data) {
	for (int i = data.length-1; i >= 0; i--){
	    down(data, i, data.length);
	}
    }

    public static void down (int[] data, int index, int size) {
	int l = (index * 2) + 1; // wrong child
	int r = (index * 2) + 2; // right child
	
	if (l < size && data[index] < data[l] && (r >= size || data[r] <= data[l])) {
	    swap(data, index, l);
	    down(data, l, size);
	}
	else if (r < size && data[index] < data[r] && (l >= size || data[l] < data[r])) {
	    swap(data, index, r);
	    down(data, r, size);
	}
    }
    
    public static void swap (int[] data, int a, int b) {
	int c = data[a];
	data[a] = data[b];
	data[b] = c;
    }
        
}
