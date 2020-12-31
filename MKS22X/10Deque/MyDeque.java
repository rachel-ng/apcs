import java.util.*;

public class MyDeque<E> {

    private E[] data;  // LIFO
    private int first, last;
    private int size;

    @SuppressWarnings("unchecked")
    public MyDeque() {
	data = (E[])new Object[10];
	first = 0;
	last = 0;
	size = 0;
    }

    @SuppressWarnings("unchecked")
    public MyDeque(int initialCapacity) {
	if (initialCapacity < 0) {
	    throw new IllegalArgumentException();
	}
	
	data = (E[])new Object[initialCapacity];
	first = 0;
	last = 0;
	size = 0;
    }

    public int size() {
	return size;
    }

    public void addFirst(E thing) {
	if (thing == null) {
	    throw new NullPointerException();
	}
	else if (size == 0) {
	    data[first] = thing;
	}
	else {
	    if (size == data.length) {
		resize();
	    }
	    first = Math.floorMod(first - 1, data.length);
	    data[first] = thing;
	}

	size++;
    }
    
    public void addLast(E thing) {
	if (thing == null) {
	    throw new NullPointerException();
	}
	else if (size == 0) {
	    data[last] = thing;
	}

	else {
	    if (size == data.length){
		resize();
	    }
	    last = Math.floorMod(last + 1, data.length);
	    data[last] = thing;
	}
	
	size++;
    }
    

    public E removeFirst() {
	if (size == 0) {
	    throw new NoSuchElementException();
	}
	
	E thing = getFirst();
	first = Math.floorMod(first + 1, data.length);
	size--;
	
	return thing;
    }

    public E removeLast() {
	if (size == 0) {
	    throw new NoSuchElementException();
	}
	
	E thing = getLast();
	last = Math.floorMod(last - 1, data.length);
	size--;
	
	return thing;
    }

    public E getFirst() {
	if (size == 0) {
	    throw new NoSuchElementException();
	}
	return data[first];
    }
    
    public E getLast() {
	if (size == 0) {
	    throw new NoSuchElementException();
	}
	return data[last];
    }
    
    @SuppressWarnings("unchecked")
    public void resize () {
	E[] halp = (E[])new Object[data.length*2];

	int index = first;
	int i = 0;
	while(index != last){
	    halp[i] = data[index];
	    index = Math.floorMod(index+1, data.length);
	    i++;
	}
	halp[i] = data[index];
	data = halp;
	first = 0;
	last = size()-1;   
    }
    
    public String toString(){
	String str = "";
	int index = first;
	while (index != last) {	    
	    str += data[index] + ", ";
	    index = Math.floorMod(index + 1, data.length);
	}
	str += data[index];
	return str;	
    }

    public static void main(String[]args){
	
	MyDeque<String> morty = new MyDeque<>(5);
	
	System.out.println("\n\nMORTY: " + morty.toString() + "\n\n");

	morty.addFirst("gonna");
	morty.addFirst("never");
	morty.addFirst("cry");
	morty.addFirst("you");
	morty.addLast("say");
	morty.addLast("goodbye");
	morty.addLast("never");
	morty.addLast("gonna");
	morty.addFirst("make");
	morty.addFirst("give");
	morty.removeFirst();
	morty.removeLast();
	morty.removeLast();
	morty.addLast("never");
	morty.addFirst("gonna");
	morty.addFirst("never");
	morty.addLast("a");
	morty.removeFirst();
	morty.removeLast();
	morty.addLast("gonna");
	morty.addLast("tell");
	morty.addFirst("never");
	morty.addFirst("you");
	morty.addFirst("desert");
	morty.addFirst("and");
	morty.addFirst("around");
	morty.addFirst("turn");
	morty.addLast("a");
	morty.addFirst("gonna");
	morty.addFirst("you");
	morty.removeFirst();
	morty.addFirst("tell");
	morty.addLast("lie");
	morty.removeFirst();
	morty.addFirst("never");
	morty.addFirst("down");
	morty.addFirst("you");
	morty.addLast("and");
	morty.addFirst("let");
	morty.addFirst("gonna");
	morty.addFirst("never");
	morty.addLast("hurt");
	morty.addFirst("up");
	morty.addFirst("you");
	morty.addLast("hurt");
	morty.addFirst("give");
	morty.addFirst("gonna");
	morty.addFirst("gonna");
	morty.removeLast();
	morty.addLast("you");
	morty.removeFirst();
	morty.addFirst("never");

	System.out.println(morty.toString() + "\n\n");


	String[] rick = new String[] {"never", "gonna", "give", "you", "up", "never", "gonna", "let", "you", "down", "never", "gonna", "turn", "around", "and", "desert", "you", "never", "gonna", "make", "you", "cry", "never", "gonna", "say", "goodbye", "never", "gonna", "tell", "a", "lie", "and", "hurt", "you"};
	boolean roll = true;
	
	for (String i : rick) {
	    if (!i.equals(morty.removeFirst())) {
		roll = false;
	    }
	}
	
	if (roll) {
	    System.out.println("YOU'VE JUST BEEN RICKROLLED\n\n");
	}
    }
    
}
