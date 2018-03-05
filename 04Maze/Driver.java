public class Driver{

    public static void main(String[]args){
        Maze f;
	
	try {
	    f = new Maze("data3.dat");//true animates the maze.
	    System.out.println(f.toString());
	    System.out.println(f.solve());
	    System.out.println(f.toString());
	    f.setAnimate(true);
	    
	}catch(Exception e) {}
		
	System.out.println("it's not dead i promise");
    }
}

