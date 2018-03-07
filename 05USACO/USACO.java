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
	int[][];

	
	
	return vol;
    }
    
    public static int silver(String filename) {

    }

    public static void main(String args[]) throws FileNotFoundException {

    }
}
