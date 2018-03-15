import java.util.Random;

public class quick{

    public static int so (int[] data, int st, int end) {
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

    public static void swap(int[] array, int a, int b) {
	int c = array[a];
	array[a] = array[b];
	array[b] = c;
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
	int[]ary = { 2, 10, 15, 23, 0,  5};  //sorted :  {0,2,5,10,15,23}

	System.out.println(toString(ary));
	System.out.println(so(ary,0,5));
	System.out.println(toString(ary));
	
	/*
	select(ary,0);
	select(ary,1);
	select(ary,2);
	select(ary,3);
	select(ary,4);
	select(ary,5);
	*/
    }
}
