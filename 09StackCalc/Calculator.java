import java.util.*;

public class Calculator {
    
    public static double eval (String s){
	@SuppressWarnings("unchecked")
	    Stack<String> data = new Stack();

	System.out.println(s);
	
	String current = ""; 
	for (int i = 0; i < s.length(); i++) {

	    if (s.substring(i,i+1).equals(" ")) {
		data.push(current);
		
		current = "";
	    }
	    else if (!s.substring(i,i+1).equals(" ")) {
		current += s.substring(i,i+1);
		if (current.equals("+") || current.equals("-") || current.equals("*") || current.equals("/") || current.equals("%")){
		    double one = Double.parseDouble(data.pop());
		    double two = Double.parseDouble(data.pop());
		    String meh = process(current, one, two);
		    data.push(meh);
		}
	    }

	    //if(s.charAt(i) == ' '){
	    /*
	      else{
	      data.push(current);
	      }
	      current = "";
	      }

	      else{
	      current += s.charAt(i);
	      }
	      *

	      }
	      /*
	      data.push(current);
	      return process(data);
	    */

	}
	//double one = Double.parseDouble(data.pop());
	//double two = Double.parseDouble(data.pop());
	System.out.println(data.toString());
	return Double.parseDouble(data.pop()); //Double.parseDouble(process(current, one, two));
	
    }

    public static String process (String operator, double one, double two) {
	double result = 0;
	if (operator == "+") {
	    result = one + two;
	}
	else if (operator == "-") {
	    result = one - two;
	}
	else if (operator == "*") {
	    result = one * two;
	}
	else if (operator == "/") {
	    result = one / two;
	}
	else {
	    result = one % two;
	}
	System.out.println(result + "");
	return result + "";
    }

    public static void main(String[]args){
	System.out.println(eval("10 2.0 +"));
    }
    
}
