import java.util.*;

public class Driver {
	
    public static void main(String[]args){

	MyLinkedList a = new MyLinkedList();
	
	System.out.println(a.toString() + ", " + a.size()); // toString + size
	
	// test add (boolean, adds to end)
	System.out.println("\n\ntest add (boolean, adds to end)");
	System.out.println(a.toString());
	int[] addValue = new int[] {1, 1, 2, 3, 4, 5, 7, 9, 11};
	for (int i : addValue) {
	    a.add(Integer.valueOf(i));
	    System.out.println(i + " ->\t" + a.toString());
	}

	System.out.println("\n" + a.toString() + ", " + a.size()); 
	
	// test add (void, inserts)
	System.out.println("\n\ntest add (void, inserts)");
	System.out.println(a.toString());
	a.add(0,Integer.valueOf(0));
	System.out.println(a.toString() + ", " + a.size());
	a.add(3,Integer.valueOf(2));
	System.out.println(a.toString() + ", " + a.size());
	a.add(8,Integer.valueOf(6));
	System.out.println(a.toString() + ", " + a.size());
	a.add(9,Integer.valueOf(7));
	System.out.println(a.toString() + ", " + a.size());
	a.add(11,Integer.valueOf(9));
	System.out.println(a.toString() + ", " + a.size());
	
	System.out.println("\n" + a.toString() + ", " + a.size()); 

	// test indexOf (int) 
	System.out.println("\n\ntest indexOf (int)");
	System.out.println(a.toString());
	int[] indexOfInt = new int[] {2, 7, 8, 9};
	for (int i : indexOfInt) {
	    System.out.println("index of " + i + ": " + a.indexOf(i));
	}
	
	System.out.println("\n" + a.toString() + ", " + a.size()); 
	
	// test set (Integer)
	System.out.println("\n\ntest set (Integer)");
	System.out.println(a.toString());	
	System.out.println("set 10 (" + a.set(10,Integer.valueOf(8)) + ") -> 8");
	System.out.println(a.toString());
	System.out.println("set 12 (" + a.set(12,Integer.valueOf(10)) + ") -> 10");
	System.out.println(a.toString());

	System.out.println("\n" + a.toString() + ", " + a.size());
	
	// test getNode (Node) + get (Integer)
	System.out.println("\n\ntest getNode (Node) + get (Integer");
	for (int i = 0; i < a.size(); i++) {
	    System.out.println("get " + i + ": " + a.get(i) + "\t" + a.toString(i));
	}

	System.out.println("\n" + a.toString() + ", " + a.size());

	// test remove (boolean, value)
	System.out.println("\n\ntest remove (boolean, value)");
	System.out.println(a.toString());
        Integer[] removeValue = new Integer[] {0, 6, 7, 9, 11};
	for (int i : removeValue) {
	    System.out.println("remove " + i + ": " + a.remove(Integer.valueOf(i)));
	    if (i == 0) { System.out.println("-> removes start"); }
	    if (i == a.size() - 1) { System.out.println("-> removes end"); }
	    System.out.println(a.toString());	
	}
	
	System.out.println("\n" + a.toString() + ", " + a.size());
	
	// test remove (boolean, index)
	System.out.println("\n\ntest remove (boolean, index)");
	System.out.println(a.toString());
	int[] removeIndex = new int[] {7, 0, 6, 2};
	for (int i : removeIndex) {
	    System.out.println("remove " + i + ": " + a.remove(i));
	    if (i == 0) { System.out.println("-> removes start"); }
	    if (i == a.size() - 1) { System.out.println("-> removes end"); }
	}

	System.out.println("\n" + a.toString() + ", " + a.size());
	
	// test clear
	System.out.println("\n\ntest clear");
	System.out.println(a.toString());
	a.clear();
	System.out.println(a.toString());
	System.out.println("\n\n\n\n");
	
    }
}
