import java.util.*;
public class rerandom{
    public static void main(String[]args){
	int seed = (int)(Math.random()*100000);
	//seed = 17127;
        //change this to any seed you want.
	System.out.println("This is your seed: "+seed);
	Random randgen = new Random(seed);

	for(int i=0;i<10;i++){
	    System.out.println(randgen.nextInt());
	}
    }
}
