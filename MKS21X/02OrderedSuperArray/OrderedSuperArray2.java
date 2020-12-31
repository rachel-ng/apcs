public class OrderedSuperArray extends SuperArray{
    private String[] data;
    private int size;

    public OrderedSuperArray(){
	super();
    }

    public void add(int index, String value){
	add(value);
    }

    public boolean add(String value){
	boolean added = false;
	if (size == 0) {
		add(0, value);
	}
	for (int i = 0; i < size && added == false; i++) {
	    if (data[i].compareTo(value) <  0) {
		add(i, value);
		added = true;
	    }
	}
	if (added == false) {
	    add(size, value);
	}
	return added; 
    }
}
