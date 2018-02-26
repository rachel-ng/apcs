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
	int sum = 0;
	int a = 0;
	int b = 1;
	int c = a;
	
	if (n < 0) {
	    throw new IllegalArgumentException();
	}
	while (n > 1) {
	    sum = a + b;
	    c = a;
	    a = b;
	    b = c + a;
	    n--;
	}
	return sum;
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

	return halpSqrt(n,0);
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
    
    public boolean isPrime(int n) {
	if (n <= 0) {
	    throw new IllegalArgumentException();
	}
        if (n == 1) {
	    return true;
	}
	else {
	    return halpPrime(n, 2);
	}
    }

    public boolean halpPrime(int n, int mult) {
	if (n == mult + 1) {
	    return true;
	}
	if (n % mult == 0) {
	    return false;
	}
	else {
	    return halpPrime(n, mult + 1);
	}
    }

}
