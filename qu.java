import java.util.Random;

public class Quick{

    public static int sort (int[] data, int st, int end) {
	Random rand = new Random();
	int n = rand.nextInt(end - st + 1) + st;
	int pivot = data[n];

	swap(data,st,n);
	
	int s = st + 1;
	int e = end;

	while (s <= e) {
	    if (data[s] < pivot) {
		s++;
	    }
	    else if (data[s] > pivot) {
		swap(data,s,e);
		e--;
	    }
	}
	swap(data,st,e);
	return e;
    }

    public static void swap(int[]array, int a, int b) {
	int c = array[a];
	array[a] = array[b];
	array[b] = c;
    }

    public static int quickselect(int[]art, int k) {
	return 1; 
    }

    public static String toString(int[] data){
	String str = "{";
	for (int i = 0; i < data.length; i ++){
	    str += data[i];
	    if (i < data.length -1){
		str += ", ";
	    }
	}
	str += "}";
	return str;
    }
    
    public static void main(String[]args){
	int[]ary = {999,999,999,4,1,0,3,2,999,999,999};

	System.out.println(toString(ary));
	System.out.println(sort(ary,0,9));
	System.out.println(toString(ary));
	
	/*
	quickselect(ary,0);
	quickselect(ary,1);
	quickselect(ary,2);
	quickselect(ary,3);
	quickselect(ary,4);
	quickselect(ary,5);
	*/
    }
}
