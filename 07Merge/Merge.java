import java.util.*;

public class Merge {

    public static void merge (int[] data, int[] temp, int start, int humpdayyyyy, int end) { // aka the squish function 
	int i = start;
	int ii = humpdayyyyy + 1;
	int dataIndex = start;
	while (i <= humpdayyyyy || ii <= end) {
	    if (i > humpdayyyyy) {
		data[dataIndex] = temp[ii];
		ii++;
	    }
	    else if (ii > end) {
		data[dataIndex] = temp[i];
		i++;
	    }
	    else if (temp[i] <= temp[ii]) {
		data[dataIndex] = temp[i];
		i++;
	    }
	    else {
		data[dataIndex] = temp[ii];
		ii++;
	    }
	    dataIndex++;
	}
    }

    public static void mergesort (int[] data) {
	int[] temp = new int[data.length];
	msort2(data, temp, 0, data.length - 1);
    }

    private static void msort (int[] data, int[] temp, int lo, int hi) {
	if (lo >= hi) {
	    return; // to sender
	}
	for (int i = lo; i < hi + 1; i++) {
	    temp[i] = data[i];
	}
	int humpdayyyyy = (lo / 2) + (hi / 2);
	msort(temp, data, lo, humpdayyyyy);
	msort(temp, data, humpdayyyyy + 1, hi);
	merge(data, temp, lo, humpdayyyyy, hi);
    }

    private static void msort2 (int[] data, int[] temp, int lo, int hi) {
	if (hi - lo <= 7) {
	    insertionSort(data, lo, hi);
	    return;
	}
	for (int i = lo; i < hi + 1; i++) {
	    temp[i] = data[i];
	}
	int humpdayyyyy = (lo/2) + (hi/2);
	msort(temp, data, lo, humpdayyyyy);
	msort(temp, data, humpdayyyyy + 1, hi);
	merge(data, temp, lo, humpdayyyyy, hi);
    }

    public static void swap (int[] data, int a, int b) {
	int c = data[a];
	data[a] = data[b];
	data[b] = c;
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
