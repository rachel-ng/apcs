public class DriverArray { 
    public static void main(String[]args){
	SuperArray saveMe = new SuperArray();
	saveMe.clear();
	System.out.println(saveMe.toString());
	System.out.println(saveMe.isEmpty());
	System.out.println(saveMe.size());
	System.out.println(saveMe.add("jk"));
	System.out.println(saveMe.toString());
	System.out.println(saveMe.add("just"));
	System.out.println(saveMe.toString());
	System.out.println(saveMe.add("kill"));
	System.out.println(saveMe.toString());
	System.out.println(saveMe.add("me"));
	System.out.println(saveMe.toString());
	System.out.println(saveMe.add("me"));
	System.out.println(saveMe.toString());
	System.out.println(saveMe.add("now"));
        System.out.println(saveMe.toString());
	System.out.println(saveMe.set(2,"feed"));
	System.out.println(saveMe.toString());
	System.out.println(saveMe.remove(3));
	System.out.println(saveMe.toString());
    }
}

