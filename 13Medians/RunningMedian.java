import java.util.*;

public class RunningMedian {

    private MyHeap<Double> smol, tol;
    
    public RunningMedian() {
	smol = new MyHeap<Double>();
	tol = new MyHeap<Double>(false);
    }
    
    public void add(Double value) {
	if (smol.size() == 0 || value < smol.peek()){
	    smol.add(value);
	}
	else {
	    tol.add(value);
	}

	if (smol.size() - tol.size() > 1) {
	    tol.add(smol.remove());
	}
	else if (tol.size() - smol.size() > 1) {
	    smol.add(tol.remove());
	}
	
    }
    
    public Double getMedian() {
	if (smol.size() == 0 || tol.size() == 0) {
	    throw new NoSuchElementException();
	}
	
	if (smol.size() > tol.size()) {
	    return smol.peek();
	}
	else if (tol.size() > smol.size()) {
	    return tol.peek();
	}
	
	return (smol.peek() + tol.peek()) / 2;
    }

    public MyHeap getSmol () {
	return smol;
    }

    public MyHeap getTol () {
	return tol;
    }

    public static void main(String[]args){
	
	RunningMedian x = new RunningMedian();

	x.add(1.0);
	x.add(3.0);
	x.add(5.0);
	x.add(7.0);
	x.add(9.0);
	x.add(11.0);
	System.out.println("s: " + x.getSmol());
	System.out.println("l: " + x.getTol());
	System.out.println("median: " + x.getMedian());
	
    }
    
}
