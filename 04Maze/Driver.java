public class Driver{

    public static void main(String[]args){
        Maze a, b, c;
	try{
        a = new Maze("data1.dat");//true animates the maze.	
        
        a.setAnimate(true);
        System.out.println(a.solve());
	System.out.println(a);
	
	b = new Maze("data2.dat");//true animates the maze.	
        
        b.setAnimate(true);
        System.out.println(b.solve());
	System.out.println(b);
	
	c = new Maze("data3.dat");//true animates the maze.	
        
        c.setAnimate(true);
        System.out.println(c.solve());
	System.out.println(c);
	
	}catch(Exception e){}

    }
}
