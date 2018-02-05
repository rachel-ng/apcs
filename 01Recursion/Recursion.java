import java.lang.Math;

public class Recursion {

    public int fact (int n) {
	if (n < 0) {
	    throw new IllegalArgumentException();
	}
	if (n <= 1) {
	    return n;
	}
	else {
	    return n * fact(n - 1);
	}
    }
    
    public int fib (int n) {
	if (n < 0) {
	    throw new IllegalArgumentException();
	}
	if (n <= 1) {
	    return n;
	}
	else {
	    return n + fib(n - 1);
	}
    }
    
    public double sqrt (double n) {
	int guess = 1;
	int sq = guess * guess;
	if (n < 0) {
	    throw new IllegalArgumentException();
	}
	if (n == 0) {
	    return 0;
	}

	return halpSqrt
    }

    public double halpSqrt (double n, double guess) {
	double better = (n / (guess + guess)) / 2;
	double sq = (better * better) / n;
	double s = (guess * guess) / n;
	
	if (Math.abs(n - sq) > Math.abs(n - s)) {
	    if (Math.abs(n - sq) == 0.00000001) {
		return better;
	    }
	    else {
		return halpSqrt(n,better);
	    }
	}
	else {
	    return s;
	}
    }
}
