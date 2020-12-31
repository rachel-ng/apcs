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

	return halpFib(n, 0, 1);
    }

    public int halpFib (int n, int sum, int lower) {
	if (n == 0) {
	    return sum;
	}

	return halpFib(n - 1, lower, sum + lower);
    }
	
    
    public double sqrt (double n) {
	if (n < 0) {
	    throw new IllegalArgumentException();
	}
	
	if (n == 0) {
	    return 0;
	}
	
	return halpSqrt(n, (n / 1 + 1) / 2);
    }

    public double halpSqrt (double n, double guess) {	
	guess = (n / guess + guess) / 2;

	if(Math.abs((n-guess*guess))/n < 0.00000000001) {
	    return guess;
	}

	return halpSqrt(n, guess);
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
    
    public static void main(String[]args){

	Recursion r = new Recursion();
	
	double[] sInput = new double[] {1.0, 2.0, 4.0, 7.0, 10.0, 100.0, 1024.0};
	double[] sOutput = new double[] {1.0,1.4142135623730951,2.0,2.6457513110645907,3.1622776601683795,10.0,32.0};	    

	for (int i = 0; i < sInput.length; i++) {
	    System.out.println(r.sqrt(sInput[i])  + " == " + sOutput[i]);
	}

	System.out.println("\n\n\n");
	
	int[] fInput = new int[] {1,2,3,5,30,40,45};
	int[] fOutput = new int[] {1,1,2,5,832040 ,102334155 ,1134903170};

	for (int i = 0; i < fInput.length; i++) {
	    System.out.println(r.fib(fInput[i]) + " == " + fOutput[i]);
	}

	System.out.println("\n\n\n");
	
	int[] faInput =  new int[] {1,2,3,4,5,10,11};
	int[] faOutput = new int[] {1,2,6,24,120,3628800,39916800};

	for (int i = 0; i < faInput.length; i++) {
	    System.out.println(r.fact(faInput[i]) + " == " + faOutput[i]);
	}
    }
	
}
