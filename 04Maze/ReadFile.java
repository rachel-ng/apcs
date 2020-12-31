import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class ReadFile {
  public static void main(String args[]) throws FileNotFoundException {


        //instead of a try/catch, you can throw the FileNotFoundException.
        File text = new File("data1.dat");// can be a path like: "/full/path/to/file.txt" 
        int lines = 0;
	int cha = 0;

        //inf stands for the input file

        Scanner inf = new Scanner(text);

        while(inf.hasNextLine()){
	    lines++;
            String line = inf.nextLine();
	    if (lines < 1) {
		for (int i = 0; i < lines.length; i++) {
		    cha++;
		}
	    }
	}
	    System.out.println(line);//hopefully you can do other things with the line
	    System.out.println(lines + ", " + cha);
  }   
}
