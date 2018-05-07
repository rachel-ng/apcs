import java.util.*;

public class Calculator {
    
    private class Stack<String> {
	private LinkedList<String> data;
	private int size = 0;

	@SuppressWarnings("unchecked")
	private Stack () {
	    data = this.data;
	}
	
	private void push (String s) { // add a new element to the list
	    size++;
	    data.add(s);
	}

	private String pop () { // remove and return an element
	    size--;
	    return data.remove(size - 1);
	}

	private String peek () { // return the element at the top 
	    return data.get(size - 1);
	}

	private int size () {
	    return size;
	}
	
    }
    
    public static double eval (String s){
	Stack<String> data = new Stack<String>();
	
	String current = ""; 
	for (int i = 0; i < s.length(); i++) {
	    if (s.substring(i,i+1).equals(" ")) {
		data.push(current);
		current = "";
	    }
	    else if (!s.substring(i,i+1).equals(" ")) {
		current += s.substring(i,i+1);
	    }
	}
	data.push(current);
	return process(data);
    }

    public static double process (Stack<String> data) {
	double result = 0;
	double one = Double.parseDouble(data.pop());
	double two = Double.parseDouble(data.pop());
	System.out.println(data.pop());

	for (int i = 0; i < data.size(); i++) {
	    if (data.pop() == "+") {
		//one = Double.parseDouble(data.pop());
		//two = Double.parseDouble(data.pop());
		result = one + two;
	    }
	    /*
	    if (data.pop() == "-") {
		
	    }
	    if (data.pop() == "*") {
		
	    }
	    if (data.pop() == "/") {
		
	    }
	    if (data.pop() == "%") {
		
	    }
	    else {
		one = Double.parseDouble(data.pop());
		System.out.println(one);
		System.out.println(two);
	    }
	    */
	}

	//System.out.println(data.pop());
	return result;
    }

    public static void main(String[]args){
	Calculator a = new Calculator();
	System.out.println(a.eval("10 2.0 +"));
    }
    
}
