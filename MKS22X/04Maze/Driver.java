public class Driver{

    public static void main(String[]args){
        Maze a;
	try{
        a = new Maze("data1.dat");//true animates the maze.	
        System.out.println(a);
	
        a.setAnimate(true);
        System.out.println(a.solve());
	System.out.println(a);

	}catch(Exception e){}

    }
}
