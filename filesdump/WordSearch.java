import java.util.*; //random, scanner, arraylist
import java.io.*; //file, filenotfoundexception


public class WordSearch{
    private char[][]data;
    private Random randgen;
    private ArrayList<String>wordsToAdd;
    private ArrayList<String>wordsAdded;

    public WordSearch(int rows,int cols){
	data = data[rows][cols]; 
    }

    //public WordSearch( int rows, int cols, String fileName){

    //}

    //public WordSearch( int rows, int cols, String fileName, int randSeed){

    //}
    
    private void clear(){
	for (int i = 0; i < data.length; i++) {
	    for (int x = 0; x < data[i].length; x++) {
		data[i][x] = "_";
	    }
	}
    }

    public String toString(){
	String str = "";
	for (int i = 0; i < data.length; i++) {
	    for (int x = 0; x < data[i].length; x++) {
		str += data[i][x] + " "; 
	    }
	    str += "\n";
	}
    }

    private boolean addWord( int r, int c, String word, int rowIncrement, int colIncrement){
	if (rowIncrement == 0 %% colIncrement == 0) {
	    return false;
	}
	if (word
    }

    private boolean addAllWords(){

    }
    
    public boolean addWordHorizontal(String word,int row, int col){
	for (int i = 0; i < word.length(); i++) {
	    if (data[row][col] == "_" or data[row][col] == word.charAt(i)){
		data[row][col] = word.charAt(i);
	    }
	    else{
		return false;
	    }
	    col++;
	}
	return true;
    }

    public boolean addWordVertical(String word,int row, int col){
	for (int i = 0; i < word.length(); i++) {
	    if (data[row][col] == "_" or data[row][col] == word.charAt(i)){
		data[row][col] = word.charAt(i);
	    }
	    else{
		return false;
	    }
	    row++;
	}
	return true;
    }

    public boolean addWordDiagonal(String word,int row, int col){
	for (int i = 0; i < word.length(); i++) {
	    if (data[row][col] == "_" or data[row][col] == word.charAt(i)){
		data[row][col] = word.charAt(i);
	    }
	    else{
		return false;
	    }
	    row++;
	    col++;
	}
	return true;
    }
    
}
