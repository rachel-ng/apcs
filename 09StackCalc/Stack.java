import java.util.*;

public class Stack<String> {

    public LinkedList<String> data;
    private int size = 0;

    @SuppressWarnings("unchecked")
    public Stack () {
	data = new LinkedList();
    }
	
    public void push (String s) { // add a new element to the list
	size++;
	data.add(s);
    }

    public String pop () { // remove and return an element
	size--;
	return data.remove(data.size() - 1);
    }

    public String peek () { // return the element at the top 
	return data.get(data.size() - 1);
    }
    
}
