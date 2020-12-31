public class Location implements Comparable<Location>{
    private int x, y, priority, fromStart;
    private Location previous;
    
    public Location (int _x, int _y, Location prev, int prio, int from){
	x = _x;
	y = _y;
	previous = prev;
	priority = prio;
	fromStart = from;
    }

    public int compareTo (Location other) {
	return this.getPriority() - other.getPriority();
    }

    public int distanceSoFar () {
	return fromStart;
    }

    public int getX () {
	return x;
    }

    public int getY () {
	return y;
    }

    public void setPrev (Location prev) {
	previous = prev;
    }

    public Location getPrev () {
	return previous;
    }

    public boolean equals (Location other) {
	return x == other.getX() && y == other.getY(); 
    }

    public int getPriority () {
	return priority;
    }
    
    public String toString () {
	return x + "\t" + y;
    }
}
