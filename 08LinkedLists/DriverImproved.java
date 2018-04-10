public class DriverImproved {
	
    public static void main(String[]args){

	System.out.println("\n\n\n\n\nINTEGERS");
	
	MyLinkedListImproved<Integer> a = new MyLinkedListImproved<>();
	
	System.out.println(a.toString() + ", " + a.size()); // toString + size

	// test add (boolean, adds to end)
	System.out.println("\n\n\ntest add (boolean, adds to end)");
	System.out.println(a.toString());
	a.add(Integer.valueOf(1));
	System.out.println(a.toString());
	a.add(Integer.valueOf(2));
	System.out.println(a.toString());
	a.add(Integer.valueOf(3));
	System.out.println(a.toString());
	a.add(Integer.valueOf(4));
	System.out.println(a.toString());
	a.add(Integer.valueOf(5));
	System.out.println(a.toString());
	a.add(Integer.valueOf(7));
	System.out.println(a.toString());
	a.add(Integer.valueOf(8));
	System.out.println(a.toString());
	a.add(Integer.valueOf(11));
	System.out.println(a.toString());

	System.out.println("\n" + a.toString() + ", " + a.size()); 
	
	// test add (void, inserts)
	System.out.println("\n\n\ntest add (void, inserts)");
	System.out.println(a.toString());
	a.add(0,Integer.valueOf(0));
	System.out.println(a.toString() + ", " + a.size());
	a.add(2,Integer.valueOf(2));
	System.out.println(a.toString() + ", " + a.size());
	a.add(7,Integer.valueOf(6));
	System.out.println(a.toString() + ", " + a.size());
	a.add(8,Integer.valueOf(7));
	System.out.println(a.toString() + ", " + a.size());
	a.add(11,Integer.valueOf(9));
	System.out.println(a.toString() + ", " + a.size());
	
	System.out.println("\n" + a.toString() + ", " + a.size()); 

	// test indexOf (int) 
	System.out.println("\n\n\ntest indexOf (int)");
	System.out.println(a.toString());
	System.out.println("index of 2: " + a.indexOf(2));
	System.out.println("index of 7: " + a.indexOf(7));
	System.out.println("index of 8: " + a.indexOf(8));
	System.out.println("index of 9: " + a.indexOf(9));
	
	System.out.println("\n" + a.toString() + ", " + a.size()); 
	
	// test set (T)
	System.out.println("\n\n\ntest set (T)");
	System.out.println(a.toString());
	System.out.println("set 9 (7) -> 8");
	System.out.println(a.set(9,Integer.valueOf(8)));
	System.out.println(a.toString());
	System.out.println("set 11 (9) -> 10");
	System.out.println(a.set(11,Integer.valueOf(10)));
	System.out.println(a.toString());

	System.out.println("\n" + a.toString() + ", " + a.size());
	
	// test getNode (Node) + get (T)
	System.out.println("\n\n\ntest getNode (Node) + get (T)");
	for (int i = 0; i < a.size(); i++) {
	    System.out.println("get " + i + ": " + a.get(i) + "\t" + a.toString(a.getNode(i)));
	}

	System.out.println("\n" + a.toString() + ", " + a.size());

	// test remove (boolean, value)
	System.out.println("\n\n\ntest remove (boolean, value)");
	System.out.println(a.toString());
	System.out.println("remove 6: " + a.remove(Integer.valueOf(6)));
	System.out.println(a.toString());
	System.out.println("remove 7: " + a.remove(Integer.valueOf(7)));
	System.out.println(a.toString());
	System.out.println("remove 9: " + a.remove(Integer.valueOf(9)));
	System.out.println(a.toString());

	System.out.println("\n" + a.toString() + ", " + a.size());
	
	// test remove (boolean, index)
	System.out.println("\n\n\ntest remove (boolean, index)");
	System.out.println(a.toString());
	System.out.println("remove 7: " + a.remove(7));
	System.out.println(a.toString() + ", " + a.size());
	System.out.println("remove 0: " + a.remove(0));
	System.out.println(a.toString() + ", " + a.size());
	System.out.println("remove 6: " + a.remove(6));
	System.out.println(a.toString() + ", " + a.size());
	System.out.println("remove 2: " + a.remove(2));
	System.out.println(a.toString() + ", " + a.size());
	System.out.println("remove 5: " + a.remove(5));
	System.out.println(a.toString() + ", " + a.size());
	
	System.out.println("\n" + a.toString() + ", " + a.size());
	
	// test clear
	System.out.println("\n\n\ntest clear");
	System.out.println(a.toString());
	a.clear();
	System.out.println(a.toString());

	
	
	System.out.println("\n\n\n\n\nSTRINGS");
	
	MyLinkedListImproved<String> b = new MyLinkedListImproved<>();
	System.out.println(b.toString() + ", " + b.size()); // toString + size

	// test add (boolean, adds to end)
	System.out.println("\n\n\ntest add (boolean, adds to end)");
	System.out.println(b.toString());
	b.add("cries");
	System.out.println(b.toString());
	b.add("dies");
	System.out.println(b.toString());
	b.add("dies");
	System.out.println(b.toString());
	b.add("cries");
	System.out.println(b.toString());
	b.add("cries");
	System.out.println(b.toString());
	
	System.out.println("\n" + b.toString() + ", " + b.size()); 

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
	
	System.out.println("\n" + b.toString() + ", " + b.size()); 

	// test set (T)
	System.out.println("\n\n\ntest set (T)");
	System.out.println(b.toString());
	System.out.println("set 3 (dies) -> cries");
	System.out.println(b.set(3,"cries"));
	System.out.println("set 5 (dies) -> cries");
	System.out.println(b.set(5,"cries"));
	System.out.println("set 7 (dies) -> cries");
	System.out.println(b.set(6,"cries"));
	System.out.println(b.toString());

	System.out.println("\n" + b.toString() + ", " + b.size());

	// test getNode (Node) + get (T)
	System.out.println("\n\n\ntest getNode (Node) + get (T)");
	for (int i = 0; i < b.size(); i++) {
	    System.out.println("get " + i + ": " + b.get(i) + "\t" + b.toString(b.getNode(i)));
	}

	System.out.println("\n" + b.toString() + ", " + b.size());

	/*
	
	// test remove (boolean, value)
	System.out.println("\n\n\ntest remove (boolean, value)");
	System.out.println(b.toString());
	System.out.println("remove cries: " + b.remove("cries"));
	System.out.println(b.toString());
	System.out.println("remove dies: " + b.remove("dies"));
	System.out.println(b.toString());

	System.out.println("\n" + b.toString() + ", " + b.size());

	*/

	// test remove (boolean, index)
	System.out.println("\n\n\ntest remove (boolean, index)");
	System.out.println(b.toString());
	System.out.println("remove 0: " + b.remove(0));
	System.out.println(b.toString() + ", " + b.size());
	System.out.println("remove 1: " + b.remove(1));
	System.out.println(b.toString() + ", " + b.size());
	System.out.println("remove 6: " + b.remove(6));
	System.out.println(b.toString() + ", " + b.size());
	System.out.println("remove 7: " + b.remove(7));
	System.out.println(b.toString() + ", " + b.size());

	System.out.println("\n" + b.toString() + ", " + b.size());

	// test clear
	System.out.println("\n\n\ntest clear");
	System.out.println(b.toString());
	b.clear();
	System.out.println(b.toString());


	
	System.out.println("\n\n\n\n\nMORE STUFF");

	System.out.println("phase 1 make it work with generics");
	MyLinkedListImproved<String> n = new MyLinkedListImproved<>();
	n.add("fish");
	System.out.println(n);
	
	MyLinkedListImproved<Integer> m = new MyLinkedListImproved<>();
	m.add(new Integer(0));
	System.out.println(m);
    }
}
