public  class Merge {

    public static void swap (int[] data, int a, int b) {
	int c = data[a];
	data[a] = data[b];
	data[b] = c;
    }
    
    public static int[] merge (int[] data, int[] temp, int lo, int hi) {
	int mid = (lo + hi) / 2;
	int midd = ((lo + hi) / 2) + 1; 
	
	int l = hi - lo + 1;
	
	for (int i = 0; i < l; i++) {
	    if (lo <= mid) {
		if (midd <= hi) {
		    if (data[lo] <= data[midd]) {
			lo++;
		    }
		    else {
			swap(data, lo, midd);
			midd++;
		    }
		}
		else {
		    data[
	}

	return data; 
    }

    public static void mergesort(int[]data) {
	int[] temp = new int[data.length];
	msort(data, temp, 0, data.length - 1);
    }

    private static void msort(int[]data, int[]temp, int lo, int hi) {
	int mid = (lo + hi) / 2;
	if ( lo >= hi) {
	    return;
	}
	
	for (int i = lo; i < hi + 1; i++) {
	    temp[lo] = data[hi];
	}

	msort(temp, data, lo, mid);
	msort(temp, data, mid + 1, hi);
	
    }

    public static String toString(int[] ary) { // for printing out arrays
	String str = "{" + ary[0];
	for (int i = 1; i < ary.length; i++) {
	    str += ", " + ary[i];
	}
	return str + "}";
    }

    public static void main(String[]args){
	int[] a = {1, 3, 4, 7, 8};
	int[] b = {0, 2, 5, 6, 9};
	int[] data;

	System.out.println(toString(a) + "\n" + toString(b));
	data = merge(a,b);
	System.out.println(toString(data));
    }
}
