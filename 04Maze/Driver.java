public class Driver{

    public static void main(String[]args){
        Maze a, b, c;
	try{
        a = new Maze("data1.dat");//true animates the maze.	
        
        a.setAnimate(true);
        System.out.println(a.solve());
	System.out.println(a);

	}catch(Exception e){}

    }
}
