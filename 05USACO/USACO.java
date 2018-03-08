import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class USACO {

    private String read (String filename) {
	File text = new File(filename);
	Scanner inf = new Scanner(text);

	String str;
	
	while(inf.hasNextLine()){
            str += inf.nextLine();
	}

	return str;
    }
    
    public static int bronze(String filename) {
	return bronzeH(filename);
    }

    private static int bronzeH(String filename) {
	int vol = 0;
	int[][] field;

	int l = 1; // # lines

	int R, C, E, N; 

	File text = new File(filename);
	Scanner f = new Scanner(text);

	String str;

	while(f.hasNextInt()) {
	    if (l == 1) {
		
	    }
	}
	    
		     
	
	
	return vol;
    }
    
    public static int silver(String filename) {
	return silverH(filename);
    }

    private static int silverH(String filename) {
	
	char[][] field;
	int[][] past;
	int[][] current;

	int[] input = new int[3];
	
	File text = new File(filename);
	Scanner f = new Scanner(text);

	String str;

	while(f.hasNextInt) {
	    for (int i = 0; i < 3; i++) {
		input[i] = f.ha

	
    }
	    
    public static void main(String args[]) throws FileNotFoundException {

    }
}
