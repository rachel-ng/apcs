import java.util.Iterator;

public class SuperArrayIterator implements Iterator<String> {
    private SuperArray data;
    private int index;

    public SuperArrayIterator (SuperArray data) {
	this.data = data;
	num = 0;
    }

    public SuperArray getSuperArray () {
	return data;
    }

    public void setSuperArray (SuperArray newData) {
	data = newData;
    }

    public int getIndex () {
	return index;
    }

    public void setIndex (int num) {
	index = num;
    }

    public E next() {

    }

    boolean hasNext() {

    }
