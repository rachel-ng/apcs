import java.util.Random;

public class Quick{

    public static int sort (int[] data, int lo, int hi) {
	Random rand = new Random();
	int n = rand.nextInt(hi - lo + 1) + lo;
	int pivot = data[n];

	swap(data,lo,n);
	
	int lt = lo++;
	int gt = hi;

	while (lt <= gt) {
	    if (data[lt] == pivot) {
		lt++;
	    }
	    if (data[lt] > pivot) {
		swap(data,lt,gt);
		gt--;
	    }
	    else {
		lt++;
		gt--;
	    }
	}
	swap(data,lo,gt);
	return data[gt];
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
	int[]data = {999,999,999,4,1,0,3,2,999,999,999};

	System.out.println(toString(data));
	System.out.println(sort(data,0,9));
	System.out.println(toString(data));
    }
}
