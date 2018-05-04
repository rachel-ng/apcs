import java.util.*;

public class RunningMedian {

    private int size;
    private MyHeap<Double> smol, tol;
    
    public RunningMedian() {
	smol = new MyHeap<Double>();
	tol = new MyHeap<Double>(false);
	size = 0;
    }
    // - makes an empty container for Doubles.
    
    public void add(Double value) {
	if (value > getMedian()) {
	    tol.add(value);
	}
	else if (value < getMedian() {
		smol.add(value);
	    }
    }
    // - insert a Double into the data structure.
    
    public Double getMedian() {

    }
    // - return the current median, throws NoSuchElementException when size is 0.
    
    public int size() {
	return size;
    }

    public MyHeap getSmol () {
	return smol;
    }

    public MyHeap getTol () {
	return tol;
    }
    
}
