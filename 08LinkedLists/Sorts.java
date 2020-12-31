import java.util.*;

public class Sorts {
    
    // ArrayList<String>[] data = new ArrayList [10] ;
    // MyLLI for both arraylist<string>
    // ArrayList < MyLinkedListImproved<Integer>> data = new ArrayList<>();
    // @SuppressWarnings("unchecked");

    public static void radixsortIncludingNegatives(MyLinkedListImproved<Integer> data){ 
	radixsort(data);
    }

    public static void radixsort (MyLinkedListImproved<Integer> data) {
	if (data.size() > 0){
	    @SuppressWarnings("unchecked")
		MyLinkedListImproved<Integer>[] p = new MyLinkedListImproved[10];
	    @SuppressWarnings("unchecked")
		MyLinkedListImproved<Integer>[] n = new MyLinkedListImproved[10];
	    
	    for (int i = 0; i < 10; i++) {
		p[i] = new MyLinkedListImproved<Integer>();
		n[i] = new MyLinkedListImproved<Integer>();
	    }

	    int max = Math.abs(data.max());
	    int min = Math.abs(data.min());
	    int dig = ("" + Math.max(max,min)).length();

	    for (int i = 0; i < dig; i++) {
		for (Integer num: data) {
		    if (num >= 0) {	    
			int index = (int)(num / Math.pow(10, i)) % 10;
			p[index].add(num);
		    }

		    else {
			int index = Math.abs(9-(int)(num*-1 / Math.pow(10, i)) % 10);
			n[index].add(num);
		    }
		}
		
		data.clear();
		
		for (int i = 0; i < n.length; i++) {
		    data.extend(n[i]);
		}
		
		for (int i = 0; i < p.length; i++) {
		    data.extend(p[i]);
		}
		
		System.out.println(data);
	    }
	}
    }

    // probably use compareTo to find the largest value
    // then use log to find the max # of places / digits 
    // then use mod to isolate the last digit
    // then use 

    public static void main(String[]args) {
	MyLinkedListImproved<Integer> m = new MyLinkedListImproved<>();       
	
	for (int i = 10; i>0; i--){
	    m.add(Integer.valueOf(i)); 
	}
	m.add(-5);
	m.add(-1);
	System.out.println(m);
	radixsort(m);
	System.out.println(m);

    }
}
