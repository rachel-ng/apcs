import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class USACO {
    
    public static int bronze(String filename) {
	return bronzeH(filename);
    }

    private static int bronzeH(String filename) {
	
	try {
	    File text = new File(filename);
	    Scanner f = new Scanner(text);
	    
	    int R = f.nextInt(); // rows
	    int C = f.nextInt(); // cols
	    int E = f.nextInt(); // elevation
	    int N = f.nextInt(); // num instructions
	    
	    int[][] lake[R][C];

	    for (int r = 0; r < R; r++) {
		for (int c = 0; c < C; c++) {
		    lake[r][c] = f.nextInt();
		}
	    
	    for (int n = 0; n < N; n++) {

		int R_s = f.nextInt();
		int C_s = f.nextInt();
		int D_s = f.nextInt();

		int max = 0; 

		for (int r = 0; r < 3; r++) {
		    for (int c = 0; c < 3; c++) {
			if (lake[R_s + r][C_s + c] > max) {
			    max = lake[R_s + r][C_s + c];
			}
		    }
		}
		for (int r = 0; r < 3; r++) {
		    for (int c = 0; c < 3; c++) {
			if (lake[R_s + r][C_s + c] > max - D_s) {
			    lake[R_s + r][C_s + c] = max - D_s; 
			}
		    }
		}
	    }

	    int depth = 0;
	    for (int r = 0; r < R; r++) {
		for (int c = 0; c < C; c++) {
		    if (E > lake[r][c]) {
			depth += E - lake[r][c];
		    }
		}
	    }
	    
	    return depth * 72 * 72;
		     
	}catch(Exception e){
	    System.exit(1);
	}
	
	return 0;
    }
    
    public static int silver(String filename) {
	return silverH(filename);
    }

    private static int silverH(String filename) {
	try{
	    
	    File text = new File(filename);
	    Scanner f = new Scanner(text);
	    
	    String str;
	    
	    int N = f.nextInt(); // rows
	    int M = f.nextInt(); // cols
	    int T = f.nextInt(); // time

	    int[][] mooove = {{1,0}, {-1,0}, {0,1}, {0,-1}};
	    int[] m = new int[4];
	    
	    char[][] pasture = new char[N];
	    int[][] past = new int[N][M];
	    int[][] current = new int[N][M];
	    
	    while (f.hasNextLine()) {
		while (f.hasNextInt()) {
		    for (int i = 0; i < 4; i++) {
			m[i] = f.hasNextInt(); // where to move
		    }
		}
		
		for (int i = 0; i < N + 1; i++) {
		    pasture[i] = f.nextLine().toCharArray(); //string > char array
		}
	    }

	    past[m[0]][m[1]] = 1;
	    current[m[0]][m[1]] = 1;

	    for (int t = 0; t < T; t++) {
		for (int r = 0; r < R; r++) {
		    for (int c = 0; c < C; c++) {
			if (pasture[r][c] != '*') {
			    int sum = 0;
				for (int i = 0; i < 4; i++) {
				    if (inPasture(r + mooove[i][0],c + mooove[i][1],R,C)) {
					sum += past[r + mooove[i][0]][c + moooove[i][1]];
				    }
				}
				current[r][c] = sum;
			}
		    }
		}
		past = current;
		current = new int[R][C];
	    }

	    return past[m[2]][m[3]];
		
	}catch(Exception e) {
	    System.exit(1)
	}
	return 0;
    }

    public static boolean inPasture(int cR, int cC, int r, int c) {
	return cR >= 0 && cC >= 0 && cR < r && cC < c;
    }
    
    public static void main(String args[]) throws FileNotFoundException {

    }
}
