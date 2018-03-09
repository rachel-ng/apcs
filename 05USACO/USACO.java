import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class USACO {
    
    public static int bronze(String filename) {
	return bronzeH(filename);
    }

    private static int bronzeH(String filename) {
	int vol = 0;
	int[][] field;

	int[] input = new int[4];
	int[] stomp = new int[9];

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
	int[] mooove = new int[4]; 
	
	int l = 1; // # lines
	
	File text = new File(filename);
	Scanner f = new Scanner(text);

	String str;

	while(f.hasNextLine()) {
	    while(l == 0 && f.hasNextInt()) {
		    for (int i = 0; i < 3; i++) {
			input[i] = f.nextInt();
		    }
		    N = input[0];
		    M = input[1];
		    T = input[2];
		    field = new char[N][M];
	    }
	    while(l == N + 2 && f.hasNextInt()) {
		for (int i = 0; i < 4; i++) {
		    mooove[i] = f.nextInt();
		}
		l++;
	    }
	    if (l > 1 && l < N + 2) {
		for (int i = 0; i < N; i++) {
		    field[i] = f.nextLine().toCharArray();
		}
	    }
	}
    }
    
    public static void main(String args[]) throws FileNotFoundException {

    }
}
