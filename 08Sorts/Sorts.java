import java.util.Arrays;

public class Sorts{
    public static String name (){
	return "10,Ng,Rachel"; 
    }
    
    public static boolean isSorted (int[]ary){
        for(int i = 0; i < ary.length - 1 ; i++){
	    if(ary[i] > ary[i+1]){
		return false;
	    }
        }
	return true;
    }

    public static void bogoSort (int[] ary){
	while(!isSorted(ary)){
            for(int i = 0 ; i < ary.length; i++){
		int temp = ary[i];
		int newSpot = (int)(Math.random()*ary.length);
		ary[i] = ary[newSpot];
		ary[newSpot] = temp;
	    }
	}
    }

    private static void swap (int[]ary,int a, int b){
	int c = ary[a];
	ary[a] = ary[b];
        ary[b] = c;
    }

    
    public static void insertionSort (int[] data) {
	int num = 0;
	
	while (num < data.length) {
	    int i = num;
	    while (i > 0 && data[i] < data[i-1]) {
		swap(data,i,i-1);
		i = i - 1;
	    }
	    num ++;
	}
    }

    public static void selectionSort (int[] data) {
	int num = 0;

	for (int i = 0; i < data.length; i++) {
	    int min = data[i];
	    for (int x = i + 1; x < data.length; x++) {
		if (min > data[x]) {
		    min = data[x];
		    num = x;
		}
		if (min < data[i]) {
		    data[num] = data[i];
		    data[i] = min;
		}
	    }
	}
    }

    public static void bubbleSort (int[] data) {
	while (!isSorted(data)) {
	    for (int i = 0; i < data.length; i++) {
		if (data[i] > data[i]) {
		    swap(data,i,i+1);
		}
	    }
	}
    }

    public static void main (String[]arg){
        int[] randish = new int[5];
        for(int i = 0 ; i < randish.length; i++){
            randish[i] =(int)(Math.random()*100);
        }
	
	int[] randish1 = new int[5];
        for(int i = 0 ; i < randish1.length; i++){
            randish1[i] =(int)(Math.random()*100);
        }

	int[] randish2 = new int[5];
        for(int i = 0 ; i < randish2.length; i++){
            randish2[i] =(int)(Math.random()*100);
        }
	
        System.out.println(Arrays.toString(randish));
        selectionSort(randish);
	System.out.println(Arrays.toString(randish));

	System.out.println(Arrays.toString(randish1));
        insertionSort(randish1);
	System.out.println(Arrays.toString(randish1));

	/*
	System.out.println(Arrays.toString(randish2));
        bubbleSort(randish2);
	System.out.println(Arrays.toString(randish2));
	*/
    }
}
