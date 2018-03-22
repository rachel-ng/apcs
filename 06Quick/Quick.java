zimport java.util.Random;

public class Quick{

    public static void swap (int[] data, int a, int b) {
	int c = data[a];
	data[a] = data[b];
	data[b] = c;
    }

    public static int partition (int[] ary, int start, int end) {
	Random rng = new Random();
	int r = rng.nextInt(end - start + 1) + start;
	
	int pivot = ary[r];
	swap(ary, r, start);

	int s = start + 1;
	int e = end;
	
	while (s <= e) {
	    if (ary[s] < pivot) {
		s++;
	    }
	    else {
		swap(ary, s, e);
		e--;
	    }
	}
	swap(ary, start, e);
	return e;
    }

    public static int quicksort (int[] ary) {
	int lo = 0;
	int hi = ary.length - 1;

	Random rng = new Random();
	int pi = rng.nextInt(hi - lo + 1) + lo;
	
	swap(ary, pi, lo);
	
	int i = lo + 1;
	int j = hi;

	while (i <= j) {
	    if (ary[i] >= ary[lo]) {
		swap(ary, i, j);
		j--;
	    }
	    else {
		i++;
	    }
	}
	swap(ary, j, lo);
	return j;
    }

    public static int quickselect(int[] ary, int k){
	int s = 0;
	int e = ary.length - 1;

	for (int i = 0; i < ary.length; i++) {
	    int in = partition(ary, s, e);
	    if (in == k) {
		return ary[in];
	    }
	    else if (in < k) {
		s = in + 1;
	    }
	    else {
		e = in - 1;
	    }
	}
	return -1; 
    }

    public static int dutch(int[] ary){
	int lo = 0;	
	int hi = ary.length - 1;
	
	int lt = 0; 
	int gt = ary.length - 1;

	for (int i = 0; i < hi + 1; i++) {
	    int in = partition(ary, lt, gt);
	    if (in == ee) {
		return ary[in];
	    }
	    else if (in < ee) {
		lo = in + 1;
	    }
	    else {
		hi = in - 1;
	    }
	}
	return -1; 
    }
    
    public static String toString(int[] ary) { // for printing out arrays
	String str = "{" + ary[0];
	for (int i = 1; i < ary.length; i++) {
	    str += ", " + ary[i];
	}
	return str + "}";
    }
	
    
    public static void main(String[]args){

	//int[] data = {17, 61, 67, 47, 93, 12, 20, 4, 44, 68}; // array from partition
	//int[] data = {2, 10, 15, 23, 0, 5}; // array from quickselect
	//int[] data = {999, 999, 999, 4, 1, 0, 3, 2, 999, 999, 999}; // array from quickselect
	int[] data = {1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 2, 0, 3, 0, 1, 4, 0}; // array from dutch flag
	
	/* for partition
	System.out.println(toString(data));
	System.out.println(partition(data, 0, 9));
	System.out.println(toString(data));
	*/


	/* for quicksort
	System.out.println(toString(data1));
	System.out.println(quicksort(data1));
	System.out.println(toString(data1));
	*/
	
	/*  for quickselect
	System.out.println(toString(data));
	System.out.println(quickselect(data,0)); // 0 / 0
	System.out.println(quickselect(data,1)); // 2 / 1
	System.out.println(quickselect(data,3)); // 5 / 2
	System.out.println(quickselect(data,5)); // 10 / 3
	System.out.println(quickselect(data,9)); // 15 / 4
	System.out.println(quickselect(data,16)); // 23 / 999
	System.out.println(toString(data));
	*/

	/*  for dutch */
	System.out.println(toString(data));
	System.out.println(dutch(data));
	System.out.println(toString(data));
	/**/

	
    }
}
