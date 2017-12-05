//for file stuff:
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;


public class Demo2{
  public static void main(String[]args){
    String fileName = "file.txt";
    
    try{
      File f = new File(fileName);//can combine
      Scanner in = new Scanner(f);//into one line

      int num = 0; 
      
      while(in.hasNext()){
	  String word = "";
	  //do something with word
	  for (int i = 0; i < wow.length; i++) {
	      wow[i] = in.next();
	  }
	  System.out.println(word);
      }

      System.out.println(Arrays.toString(wow));
      
            
    }catch(FileNotFoundException e){
      System.out.println("File not found: " + fileName);
      //e.printStackTrace();
      System.exit(1);
    }

    //How can we use the file here? Where should you put it?
  }
}
