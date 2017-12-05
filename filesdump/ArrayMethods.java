public class ArrayMethods{
    
   //PART 1 (these two methods are almost the same! -- I count them as 1 problem)
   public static int rowSum(int[][] AR, int x){
       int sum = 0;
       for (int i = 0; i < AR[x].length; i++) {
           sum += AR[x][i];
       }
       return sum;
   }
    //returns the sum of the elements in Row x of AR. 

   public static int columnSum(int[][] AR, int x){
       int sum = 0;
       for (int i = 0; i < AR.length; i++) {
           sum += AR[i][x];
       }
       return sum;
   }
    //returns the sum of the elements in Column x of AR (careful with rows of different lengths!).

   //PART 2
   public static int[] allRowSums(int[][] AR){
       int[] sums = new int[AR.length];
       for (int i = 0; i < AR.length; i++) {
           sums[i] = AR[i].rowSum();
       }
       return sums; 
   }
    //calculates the row sum for every row and returns each of the values in an array. 
    //Index i of the return array contains the sum of elements in row i.

    public static int[] allColSums(int[][] AR){
        int[] lengths = new int[AR.length];
        int[] sums = new int[];
        for (int i = 0; i < AR.length; i++) {
            lengths[i] = AR[i].length;
        }
    }
    //calculates the column sum for every column and returns each of the values in an array. 
    //Index i of the return array contains the sum of elements in column i, ignoring any rows that are too short.

   //The length of the returned array should be the length of the LONGEST array in AR.

   //PART 3 (just use your part 2 answer... look at the difference in the readability)

    public static boolean isRowMagic(int[][] AR){
        int[] data = AR.allRowSums(); 
        for (int i = 0; i < data.length - 1; i++) {
            if (data[i] != data[i + 1]) {
                return false;
            }
        }
        return true;
    }
     //checks if the array is row-magic (this means that every row has the same row sum).
