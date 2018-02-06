public class isPossibleSum {

    public static boolean isPossibleSum(int n, int target) {
	return halp(n, target, 1, 0);
    }

    public static boolean halp (int n, int target, int current, int sum) {
	if (current > n) {
	    System.out.println(sum);
	    return sum == target;
	}
	return halp(n,target,
    }

}
