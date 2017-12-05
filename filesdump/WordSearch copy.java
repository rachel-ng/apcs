public class WordSearch{
    private char[][]data;

    /**Initialize the grid to the size specified 
     *fill all of the positions with '_'
     *@param row is the starting height of the WordSearch
     *@param col is the starting width of the WordSearch
     */
     *or there are overlapping letters that do not match, then false is returned.
     */
    public boolean addWordDiagonal(String word,int row, int col){
        for (int i = 0; i < word.length(); i++) {
            data[row][col] = word.charAt(i); 
            row++;
            col++;
        }
        return true;
    }

}
