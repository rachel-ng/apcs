import java.util.*;

public class DriverImproved {
	
    public static void main(String[]args){

	MyLinkedListImproved<String> n = new MyLinkedListImproved<>();
	n.add("fish");
	System.out.println(n);
	
	MyLinkedListImproved<Integer> m = new MyLinkedListImproved<>();
	m.add(new Integer(0));
	System.out.println(m);


	
	MyLinkedListImproved<Integer> a = new MyLinkedListImproved<>();
	System.out.println(a.toString() + ", " + a.size()); // toString + size

	// test add (boolean, adds to end)
	System.out.println("\n\ntest add (boolean, adds to end)");
	System.out.println(a.toString());
	int[] addValue = new int[] {1, 1, 2, 3, 4, 5, 7, 9, 11};
	for (int i : addValue) {
	    a.add(Integer.valueOf(i));
	    System.out.println(i + " ->\t" + a.toString());
	}

	System.out.println("\n" + a.toString() + ", " + a.size() + "\n" + a.backString());	


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
	
	System.out.println("\n" + a.toString() + ", " + a.size() + "\n" + a.backString());

	
	// test indexOf (int) 
	System.out.println("\n\ntest indexOf (int)");
	System.out.println(a.toString());
	int[] indexOfInt = new int[] {2, 7, 8, 9};
	for (int i : indexOfInt) {
	    System.out.println("index of " + i + ": " + a.indexOf(i));
	}
	
	System.out.println("\n" + a.toString() + ", " + a.size() + "\n" + a.backString());

	
	// test set (T)
	System.out.println("\n\ntest set (T)");
	System.out.println(a.toString());	
	System.out.println("set 10 (" + a.set(10,Integer.valueOf(8)) + ") -> 8");
	System.out.println(a.toString());
	System.out.println("set 12 (" + a.set(12,Integer.valueOf(10)) + ") -> 10");
	System.out.println(a.toString());

	System.out.println("\n" + a.toString() + ", " + a.size() + "\n" + a.backString());

	
	// test getNode (Node) + get (T)
	System.out.println("\n\ntest getNode (Node) + get (T)");
	for (int i = 0; i < a.size(); i++) {
	    System.out.println("get " + i + ": " + a.get(i) + "\t" + a.toString(i));
	}

	System.out.println("\n" + a.toString() + ", " + a.size() + "\n" + a.backString());

	
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
	
	System.out.println("\n" + a.toString() + ", " + a.size() + "\n" + a.backString());

	
	// test remove (boolean, index)
	System.out.println("\n\ntest remove (boolean, index)");
	System.out.println(a.toString());
	int[] removeIndex = new int[] {7, 0, 6, 2};
	for (int i : removeIndex) {
	    System.out.println("remove " + i + ": " + a.remove(i));
	    if (i == 0) { System.out.println("-> removes start"); }
	    if (i == a.size() - 1) { System.out.println("-> removes end"); }
	}

	System.out.println("\n" + a.toString() + ", " + a.size() + "\n" + a.backString());

	
	// test clear
	System.out.println("\n\ntest clear");
	System.out.println(a.toString());
	a.clear();
	System.out.println(a.toString());
	System.out.println("\n\n\n\n");


	
	MyLinkedListImproved<String> b = new MyLinkedListImproved<>();
	System.out.println(b.toString() + ", " + b.size()); // toString + size

	// test add (boolean, adds to end)
	System.out.println("\n\n\ntest add (boolean, adds to end)");
	System.out.println(b.toString());
	String[] addStr = new String[] {"cries", "dies", "dies", "cries", "cries", "goodbye"};
	for (String i : addStr) {
	    b.add(i);
	    System.out.println(b.toString());
	}
	
	System.out.println("\n" + b.toString() + ", " + b.size() + "\n" + b.backString());

	
	// test add (void, inserts)
	System.out.println("\n\n\ntest add (void, inserts)");
	System.out.println(b.toString());
	b.add(4,"cries");
	System.out.println(b.toString() + ", " + b.size());
	b.add(1,"dies");
	System.out.println(b.toString() + ", " + b.size());
	b.add(4,"cries");
	System.out.println(b.toString() + ", " + b.size());
	b.add(2,"dies");
	System.out.println(b.toString() + ", " + b.size());
	b.add(6,"dies");
	System.out.println(b.toString() + ", " + b.size());
	b.add(4,"dies");
	System.out.println(b.toString() + ", " + b.size());
	
	System.out.println("\n" + b.toString() + ", " + b.size() + "\n" + b.backString());

	
	// test set (T)
	System.out.println("\n\n\ntest set (T)");
	System.out.println(b.toString());
	System.out.println("set 3 (dies) -> cries");
	System.out.println(b.set(3,"cries"));
	System.out.println(b.get(3));
	System.out.println("set 5 (dies) -> cries");
	System.out.println(b.set(5,"cries"));
	System.out.println(b.get(5));
	System.out.println("set 9 (cries) -> dies");
	System.out.println(b.set(9,"dies"));
	System.out.println(b.get(9));
	System.out.println(b.toString());

	System.out.println("\n" + b.toString() + ", " + b.size() + "\n" + b.backString());

	
	// test getNode (Node) + get (T)
	System.out.println("\n\n\ntest getNode (Node) + get (T)");
	for (int i = 0; i < b.size(); i++) {
	    System.out.println("get " + i + ": " + b.get(i) + "\t" + b.toString(i));
	}

	System.out.println("\n" + b.toString() + ", " + b.size() + "\n" + b.backString());

	
	// test remove (boolean, value)
	System.out.println("\n\n\ntest remove (boolean, value)");
	System.out.println(b.toString());
	String[] removeVal = new String[] {"cries", "dies", "cries", "goodbye"};
	for (String i : removeVal) {
	    System.out.println("remove " + i + ": " + b.remove(i));
	    System.out.println(b.toString() + ", " + b.size());
	}

	System.out.println("\n" + b.toString() + ", " + b.size() + "\n" + b.backString());

	
	// test remove (boolean, index)
	System.out.println("\n\n\ntest remove (boolean, index)");
	System.out.println(b.toString());
	int[] removeInd = new int[] {0, 6, 1};
	for (int i : removeInd) {
	    System.out.println("remove " + i + ": " + b.remove(i));
	    System.out.println(b.toString() + ", " + b.size());
	}
	
	System.out.println("\n" + b.toString() + ", " + b.size() + "\n" + b.backString());

	
	// test iterator (Iterator)
	System.out.println("\n\n\ntest iterator (Iterator)");
	System.out.println(b.toString());
	Iterator itr = b.iterator();
	int count = 0;
	while (itr.hasNext()) {
	    System.out.println(itr.next() + ", " + count);
	    count++;
	}

	
	// test clear
	System.out.println("\n\n\ntest clear");
	System.out.println(b.toString() + ", " + b.size());
	b.clear();
	System.out.println(b.toString() + ", " + b.size());

	
	// test min + max
	System.out.println("\n\n\ntest min + max"); 
	System.out.println(b.toString() + ", " + b.size()); // yes i know this is an empty string, but it's not like it works anyways
	System.out.println("min: " + b.min());
	System.out.println("max: " + b.max());

	
	
	MyLinkedListImproved<Integer> c = new MyLinkedListImproved<>();
	System.out.println(c.toString() + ", " + c.size()); // toString + size
	MyLinkedListImproved<Integer> d = new MyLinkedListImproved<>();
	System.out.println(d.toString() + ", " + d.size()); // toString + size

	// test extend (T)
	System.out.println("\n\n\ntest extend (T)");
	System.out.println(c.toString() + ", " + d.toString());
	for (int i = 0; i < 10; i++) { // create 2 linked lists
	    c.add(Integer.valueOf(i));
	    d.add(Integer.valueOf(i + 10));
	}
	System.out.println("C:\t" + c.toString() + ", " + c.size()); // toString + size
	System.out.println("D:\t" + d.toString() + ", " + d.size()); // toString + size
	
	c.extend(d);
	
	System.out.println("\nC:\t" + c.toString() + ", " + c.size() + "\n\t" + c.backString() + ", " + c.size()); // toString + size
	System.out.println("\nD:\t" + d.toString() + ", " + d.size() + "\n\t" + d.backString() + ", " + d.size()); // toString + size
    }
}
