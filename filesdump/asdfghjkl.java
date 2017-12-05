public class asdfghjkl{
    public static String argh(int rows, int columns){
	int[][] arrays = new int [rows][columns]; 
	String meh = "";
	for (int count = 0; count < arrays.length; count++) {
	    for (int coun = 0; coun < arrays[count].length; coun++) {
		arrays[count][coun] = coun;
	    }
	}
	for (int cou = 0; cou < arrays.length; cou++) {
	    meh = meh + "\n " + arrays[cou]; 
	}
	return "{" + meh + "}";
    }
    public static void main(String[]args){
        System.out.println(argh(2,3));
    }
}
