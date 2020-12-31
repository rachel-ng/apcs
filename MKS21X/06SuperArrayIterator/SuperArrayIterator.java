import java.util.*;

public class SuperArrayIterator implements Iterator<String> {
    private String[] data;
    private int at;
    private int end;

    public SuperArrayIterator(String[] da, int start, int stop) {
	data = da;
	at = start;
	end = stop;
    }

    public boolean hasNext() {
	return at <= end;
    }

    public String next () {
	if (hasNext()) {
	    at++;
	}
	else {
	    System.exit(0);
	}

	return data[at - 1];
    }
        
    public void remove() {
	throw new UnsupportedOperationException();
    }

}
