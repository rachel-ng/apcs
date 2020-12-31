import java.lang.Math;

public class newXY {
    private int x;
    private int y;
    private int theta;

    public newXY(int xx, int yy, int th) {
	x = xx;
	y = yy;
	theta = th;
    }
    
    public double newX () {
	return ((x * Math.cos(theta)) - (y * Math.sin(theta)));
    }

    public double newY () {
	return ((x * Math.sin(theta)) + (y *  Math.cos(theta)));
    }

    public int getX () {
	return x;
    }

    public int getY () {
        return y;
    }

    public int getTheta () {
	return theta;
    }

    public static void main(String[] args) {
	newXY meh = new newXY(1,1,180);
	
	System.out.println(meh.getX());
	System.out.println(meh.getY());
	System.out.println(meh.getTheta());
	System.out.println(meh.newX());
	System.out.println(meh.newY());
    }
}
