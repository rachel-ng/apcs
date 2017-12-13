public class temperature {
    public static double CtoF (double t) {
	return (t * 1.8) + 32;
    }

    public static double FtoC (double t) {
	return (t - 32) / 1.8;
    }
}
