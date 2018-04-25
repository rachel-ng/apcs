import java.util.*;

public class Calculator {
    
    public static String eval (String s){
	@SuppressWarnings("unchecked")
	    Stack<String> data = new Stack();
	
	String current = ""; 
	for (int i = 0; i < s.length(); i++) {
	    if (s.substring(i,i+1).equals("+") || s.substring(i,i+1).equals("-") || s.substring(i,i+1).equals("*") || s.substring(i,i+1).equals("/") || s.substring(i,i+1).equals("%")){
		current = s.substring(i,i+1);
		current = "" + process(current, Double.parseDouble(data.pop()), Double.parseDouble(data.pop()));
		data.push(current);
		System.out.println(current + " push");
	    }
	    if (s.substring(i,i+1).equals(" ")) {
		data.push(current);
		System.out.println(current + " push");
		current = "";
	    }
	    else if (!(s.substring(i,i+1).equals("+") || s.substring(i,i+1).equals("-") || s.substring(i,i+1).equals("*") || s.substring(i,i+1).equals("/") || s.substring(i,i+1).equals("%") || s.substring(i,i+1).equals(" "))){
		current += s.substring(i,i+1);
	    }
	}
	return current;
	
    }

    public static double process (String operator, double b, double a) {
	System.out.println(a + " " + operator + " " +  b);
	if (operator.equals("+")) {
	    System.out.println(a + b);
	    return a + b;
	}
	else if (operator.equals("-")) {
	    System.out.println(a - b);
	    return a - b;
	}
	else if (operator.equals("*")){
	    System.out.println(a * b);
	    return a * b;
	}
	else if (operator.equals("/")) {
	    System.out.println(a / b);
	    return a / b;
	}
	else {
	    System.out.println(a % b);
	    return a % b;
	}
    }

    public static void main(String[]args){
	System.out.println(eval("10 2.0 +") + "\n");
	System.out.println(eval("11 3 - 4 + 2.5 *") + "\n");
	System.out.println(eval("8 2 + 99 9 - * 2 + 9 -") + "\n");
	System.out.println(eval("3 2 -") + "\n");
	
    }
    
}
