import java.util.*;

public class Quick {

    public static void swap (int[] data, int a, int b) {
	int c = data[a];
	data[a] = data[b];
	data[b] = c;
    }

    public static int partition ( int[] data, int start, int end) {
	int n = (int)(Math.random() * (end - start) + start);
	int pivot = data[n];
	
	int s = start + 1;
	int e = end;
	
	swap(data, n, start);
	while (s <= e) {
	    if (data[s] <= pivot) {
		s++;
	    }
	    else {
		swap(data, s, e);
		e--;
	    }
	}
	swap(data, start, e);
	return e;
    }

    public static int quickselect (int[] data, int k) {
	int start = 0;
	int end = data.length -1;

	for (int i = 0; i < data.length; i++) {
	    int[] output = dutchPartition(data, start, end);
	    int hi = output[1];
	    int lo = output[0];
	    
	    if (k >= lo && k <= hi) {
		return data[k];
	    }
	    else if (k > hi) {
		start = hi + 1;
	    }
	    else {
		end = lo - 1;
	    }
	}
	return 0;
    }

    public static void quicksort (int[] data) {
	quicksortH2(data, 0, data.length-1);
    }

    private static void quicksortH (int[] data, int start, int end) {
	int[] output = dutchPartition(data, start, end);
	if (output[0] != start) {
	    quicksortH (data, start, output[0] - 1);
	}
	if (output[1] != end) {
	    quicksortH (data, output[1] + 1, end);
	}
    }

    private static void quicksortH2 (int[] data, int start, int end) {
	if (end - start <= 7) {
	    insertionSort(data, start, end);
	    return;
	}
	int[] output = dutchPartition(data, start, end);
	if (output[0] != start) {
	    quicksortH (data, start, output[0] - 1);
	}
	if (output[1] != end) {
	    quicksortH (data, output[1] + 1, end);
	}
    }

    public static int[] dutchPartition(int[] data, int start, int end) {
	int n = (int)(Math.random() * (end - start) + start);
	int pi = data[n];
	
	int s = start;
	int e = end;
	int at = start;
	
	while (at <= e) {
	    if (data[at] == pi) {
		at++;
	    }
	    else if (data[at] > pi) {
		swap(data, at, e);
		e--;
	    }
	    else {
		swap(data, s, at);
		s++;
		at++;
	    }
	}
	
	int[] output = new int[2];
	
	output[0] = s;
	output[1] = e;
	
	return output;
    }

    public static void insertionSort (int[] data, int start, int end) {
	int i = start;
	
	while (i < end) {
	    int j = i;
	    while (j > 0 && data[j - 1] > data[j]) {
		swap(data, j, j - 1);
		j = j - 1;
	    }
	    i++;
	}
    }

    public static void main(String[]args){

    }
  
}
