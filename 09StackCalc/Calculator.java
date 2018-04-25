import java.util.*;

public class Calculator {
    
    public static double eval (String s){
	@SuppressWarnings("unchecked")
	    Stack<String> data = new Stack();
	
	String current = ""; 
	for (int i = 0; i < s.length(); i++) {
	    if (s.substring(i,i+1).equals("+") || s.substring(i,i+1).equals("-") || s.substring(i,i+1).equals("*") || s.substring(i,i+1).equals("/") || s.substring(i,i+1).equals("%")){
		current = "" + process(s.substring(i,i+1), Double.parseDouble(data.pop()), Double.parseDouble(data.pop()));
		data.push(current);
	    }
	    else if (!(s.substring(i,i+1).equals("+") || s.substring(i,i+1).equals("-") || s.substring(i,i+1).equals("*") || s.substring(i,i+1).equals("/") || s.substring(i,i+1).equals("%")) && s.substring(i,i+1).equals(" ")) {
		data.push(current);
		current = "";
	    }
	    else if (!(s.substring(i,i+1).equals("+") || s.substring(i,i+1).equals("-") || s.substring(i,i+1).equals("*") || s.substring(i,i+1).equals("/") || s.substring(i,i+1).equals("%") || s.substring(i,i+1).equals(" "))){
		current += s.substring(i,i+1);
	    }
	}
	return Double.parseDouble(data.pop());
	
    }

    public static double process (String operator, double b, double a) {
	if (operator.equals("+")) {
	    return a + b;
	}
	else if (operator.equals("-")) {
	    return a - b;
	}
	else if (operator.equals("*")){
	    return a * b;
	}
	else if (operator.equals("/")) {
	    return a / b;
	}
	else {
	    return a % b;
	}
    }

    public static void main(String[]args){
	System.out.println(eval("10 2.0 +") + "\n");
	System.out.println(eval("11 3 - 4 + 2.5 *") + "\n");
	System.out.println(eval("8 2 + 99 9 - * 2 + 9 -") + "\n");
	System.out.println(eval("8 2 + 99 9 - *") + "\n");
	System.out.println(eval("3 2 -") + "\n");
    }
    
}
