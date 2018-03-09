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

	int[] input = new int[4]; 

	int l = 1; // # lines

	File text = new File(filename);
	Scanner f = new Scanner(text);

	String str;

	while(f.hasNextInt()) {
	    if (l == 1) {
		for (int i = 0; i < 4; i++) {
		    input[i] = f.hasNextInt();
		}
	    }
	    l++; 
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
	int N, M, T;
	int[][] mooove = new int[2][2]; 
	
	int l = 1; // # lines
	
	File text = new File(filename);
	Scanner f = new Scanner(text);

	String str;

	while(f.hasNextInt()) {
	    if (l == 1) {
		for (int i = 0; i < 3; i++) {
		    input[i] = f.hasNextInt();
		}
		N = input[0];
		M = input[1];
		T = input[2];
		field[N][M];
	    }
	    if ( l == N + 2) {
		for (int i = 0, x = 0; i < 4; i++if (i < 1) {
			
	    }
	    l++;
	}
	
    }
	    
    public static void main(String args[]) throws FileNotFoundException {

    }
}
