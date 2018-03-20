public  class Merge {

    public static int[] merge (int[] a, int[] b) {//int[] data, int[] temp, int lo, int hi) {
	int data[] = new int[a.length + b.length];
	
	int c = 0;
	int d = 0;
	
	for (int i = 0; i < data.length; i++) {
	    if (a[c] < b[d]) {
		data[i] = a[c];
		c++;
	    }
	    else if (b[d] < a[c]) {
		data[i] = b[d];
		d++;
	    }
	    System.out.println(toString(data));
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
	data = merge(a,b,);
	System.out.println(toString(data));
    }
}
