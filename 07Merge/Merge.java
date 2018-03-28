public  class Merge {

    public static void swap (int[] data, int a, int b) {
	int c = data[a];
	data[a] = data[b];
	data[b] = c;
    }
    
    public static int[] merge (int[] data, int[] temp, int lo, int hi) {
	int mid = (lo + hi) / 2;
	int midd = ((lo + hi) / 2) + 1; 
		
	for (int i = lo; i < hi + 1; i++) {
	    if (lo <= mid) {
		if (midd <= hi) {
		    if (data[lo] <= data[midd]) {
			temp[i] = data[lo];
			lo++;
		    }
		    else if (data[midd] < data[lo]){
			temp[i] = data[midd];
			midd++;
		    }
		}
		else {
		    temp[i] = data[lo];
		    lo++;
		}
	    }
	    else if (midd <= hi){
		temp[i] = data[midd];
		midd++;
	    }
	}

	return temp; 
    }

    public static void mergesort(int[]data) {
	int[] temp = new int[data.length];
	msort(data, temp, 0, data.length - 1);
    }

    private static void msort(int[]data, int[]temp, int lo, int hi) {
	int mid = (lo + hi) / 2;
	if (lo >= hi) {
	    return;
	}
	
	for (int i = lo; i <= hi + 1; i++) {
	    temp[i] = data[i];
	}

	msort(temp, data, lo, mid);
	msort(temp, data, mid + 1, hi);
	merge(data,temp,lo,hi);
	
    }

    public static String toString(int[] ary) { // for printing out arrays
	String str = "{" + ary[0];
	for (int i = 1; i < ary.length; i++) {
	    str += ", " + ary[i];
	}
	return str + "}";
    }

    public static void main(String[]args){
	int[] data = {1, 3, 4, 7, 8, 0, 3, 5, 6, 9};
	int[] dataa = new int[10];

	System.out.println(toString(data));
	System.out.println(toString(dataa));
	merge(data, dataa, 0, 9);
	System.out.println(toString(data));
	System.out.println(toString(dataa));
    }
}
