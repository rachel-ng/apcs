import java.util.*;

public class Driver {
	
    public static void main(String[]args){

	MyHeap<String> saveMe = new MyHeap<>();
       	System.out.println("\n\ntest add");
	System.out.println(saveMe.toString());
	
	saveMe.add("a");
	saveMe.add("b");
	System.out.println(saveMe.toString());
	saveMe.add("x");
	System.out.println(saveMe.toString());
	saveMe.add("c");
	System.out.println(saveMe.toString());
	saveMe.add("d");
	System.out.println(saveMe.toString());
	saveMe.add("e");
	System.out.println(saveMe.toString());
	saveMe.add("f");
	System.out.println(saveMe.toString());
	saveMe.add("g");
	System.out.println(saveMe.toString());

	
	MyHeap<String> beforeI = new MyHeap<>(false); // min heap
	System.out.println("\n\ntest add");
	System.out.println(beforeI.toString());
	
	beforeI.add("a");
	beforeI.add("b");
	System.out.println(beforeI.toString());
	beforeI.add("x");
	System.out.println(beforeI.toString());
	beforeI.add("c");
	System.out.println(beforeI.toString());
	beforeI.add("d");
	System.out.println(beforeI.toString());
	beforeI.add("e");
	System.out.println(beforeI.toString());
	beforeI.add("f");
	System.out.println(beforeI.toString());
	beforeI.add("g");
	System.out.println(beforeI.toString());


	MyHeap<Integer> failEverything = new MyHeap<>(true); // min heap
	System.out.println("\n\ntest add");
	System.out.println(failEverything.toString());

	failEverything.add(1);
	failEverything.add(3);
	System.out.println(failEverything.toString());
	failEverything.add(2);
	System.out.println(failEverything.toString());
	failEverything.add(6);
	System.out.println(failEverything.toString());
	failEverything.add(4);
	System.out.println(failEverything.toString());
	failEverything.add(7);
	System.out.println(failEverything.toString());
	failEverything.add(5);
	System.out.println(failEverything.toString());
	failEverything.add(8);
	System.out.println(failEverything.toString());

	MyHeap<Integer> asPerUsual = new MyHeap<>(false); // min heap
	System.out.println("\n\ntest add");
	System.out.println(asPerUsual.toString());

	asPerUsual.add(1);
	asPerUsual.add(3);
	System.out.println(asPerUsual.toString());
	asPerUsual.add(2);
	System.out.println(asPerUsual.toString());
	asPerUsual.add(6);
	System.out.println(asPerUsual.toString());
	asPerUsual.add(4);
	System.out.println(asPerUsual.toString());
	asPerUsual.add(7);
	System.out.println(asPerUsual.toString());
	asPerUsual.add(5);
	System.out.println(asPerUsual.toString());
	asPerUsual.add(8);
	System.out.println(asPerUsual.toString());

    }
}
