import java.util.*;

public class eval {

    private int start, end;

    private String[] operators = new String["+", "-", "*", "/", "%"];

    private class stack {
	private int length;
	private LinkedList data;

	private stack () {
	    length = data.size();
	    data = this.data;
	}

	private void push () {
	    
	}

	private void pop () {
	    
	}
    }
    
    public eval () {
	start = 0;
	end = 0;
    }

    public int size () {
	return data.length;
    }

    public void resize () {
	int[] n = new int[data.length * 2];
	data = n;
    }
    
    public double eval (String input) {
	String current = ""; 
	for (int i = 0; i < input.length(); i++) {
	    if (input.substring(i) == " ") {
		data[end] = current;
		current = "";
		end ++;
	    }
	    else if (input.substring(i) ==  ".") {

	    }
	    else if (input.substring(i) == int(input.substring(i))) {
		current += input.substring(i);
	    }

	    for (String o : operators) {
		if (input.substring(i) == o) {
		    current += input.substring(i);
		}
	    }
	}
    }

    
    
}
