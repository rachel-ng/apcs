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

	if (n < 1) {
	    return n;
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
	    if (Math.abs(n - sq) == 0.00000000001) {
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

    public static boolean closeEnough(double a, double b){
	if(a==0.0 && b==0.0)return true;
	if(a==0.0)return Math.abs(b) < 0.00000000001;
	if(b==0.0)return Math.abs(a) < 0.00000000001;
	return Math.abs(a-b)/a < 0.0001;
    }
    
    public static void main(String[]args){

	Recursion a;
	
	double[] sInput = new double[] {1.0, 2.0, 4.0, 7.0, 10.0, 100.0, 1024.0, -1.0, 0.0};
	double[] sOutput = new double[] {1.0,1.4142135623730951,2.0,2.6457513110645907,3.1622776601683795,10.0,32.0,-1,0.0};	    

	for (int i = 0; i < sInput.length; i++) {
	    System.out.println(a.sqrt(sInput[i]));
	    System.out.println(sOutput[i]);
	}
	
	int[] fInput = new int[] {0,1,2,3,5,30,40,45,-1};
	int[] fOutput = new int[] {0,1,1,2,5,832040 ,102334155 ,1134903170 ,-1};

	int[] faInput =  new int[] {0,1,2,3,4,5,10,11,-1};
	int[] faOutput =new int[] {1,1,2,6,24,120,3628800,39916800,-1};

    }
	
}
