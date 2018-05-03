import java.util.*;

public class RunningMedian {

    private int size;
    private MyHeap<Double> min, max;
    
    public RunningMedian() {
	min = new MyHeap<Double>(false);
	max = new MyHeap<Double>();
	size = 0;
    }
    // - makes an empty container for Doubles.
    
    public void add(Double value) {
	if (value > getMedian()) {
	    min.add(value);
	}
	else if (value < getMedian() {
		max.add(value);
	    }
    }
    // - insert a Double into the data structure.
    
    public Double getMedian() {

    }
    // - return the current median, throws NoSuchElementException when size is 0.
    
    public int size() {
	return size;
    }
    
}
