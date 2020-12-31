public class OrderedSuperArray extends SuperArray{
    private String[] data;
    private int size;

    public OrderedSuperArray (){
	super();
    }

    public void add(int index, String value){
	add(value);
    }

    //public boolean add(String value){
    //if (size == 0) {
    //add(0, value);
    //}
	//for (int i = 0; i < size; i++) {
	    //if (data[i].compareTo(value) > 0) {
	//add(value);
		//}
		//}
    //return true;
    // }
}
