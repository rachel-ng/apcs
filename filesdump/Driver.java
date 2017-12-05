public class Driver{
    public static void main (String[] args) {
	SuperArray test = new OrderedSuperArray();
	test.clear();
	System.out.println(test.add("a"));
	System.out.println(test.toString());
	System.out.println(test.add("b"));
	System.out.println(test.toString());
	System.out.println(test.get(1));
	System.out.println(test.add("c"));
	System.out.println(test.toString());
	System.out.println(test.add("e"));
	
	System.out.println(test.add("d"));
	System.out.println(test.toString());
    }
}
