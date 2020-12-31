public class SuperArray {
    private String[] data;
    private int size; 

    public SuperArray () {
	String[] data = new String[10];
	int size = 0;
    }

    public void clear () {
	data = new String[10];
	size = 0; 
    }

    public int size () {
	return size; 
    }

    public boolean isEmpty () {
	return size == 0;
    }

    public boolean add(String element) {
	if (size == data.length) {
	    resize();
	}
	if (size < data.length) {
	    data[size] = element; 
	    size += 1; 
	    return true;
	}
	return false;
    }

    public String get (int index) {
	return data[index];
    }

    public String set (int index, String element) {
	if (index < data.length) {
	    data[index] = element;
	}
	return null; 
    } 

    public String toString() {
	String str = "[" + data[0]; 
	for (int i = 1; i < size; i++) {
	    str += ", " + data[i]; 
	} 
	return str + "]";
    }

    private void resize () {
	String[] young = new String[(data.length * 2) + 1];
	for (int i = 0; i < data.length; i++) {
	    young[i]= data[i];
	}
	data = young;
    }

    public boolean contains (String target) {
	for (int i = 0; i < size; i++) {
	    if (data[i].equals(target)) {
		return true;
	    }
	}
	return false;
    }

    public int indexOf (String target) {
	for (int i = 0; i < size; i++) {
	    if (data[i].equals(target)) {
		return i;
	    }
	}
	return -1;
    }

    public int lastIndexOf (String target) {
	for (int i = size - 1; i > 0; i--) {
	    if (data[i].equals(target)) {
		return i;
	    }
	}
	return -1;
    }

    public void add (int index, String addition) {
	if (size == data.length) {
	    resize();
	}
	if (index < size) {
	    for (int i = size; i > index; i--) {
		this.set(i, data[i-1]);
	    }
	    this.set(index, addition);
	}
	System.out.println("(index < 0 || index >= size())");
    }

    public String remove(int index){
	if (index < 0 || index >= size()){
	    System.out.println("out of range error");
	    return null;
	}
	String toReturn = data[index];
	for (int i = index; i< size-1; i++){
	    data[i] = data[i+1];
	}
	String[] updated = new String[size-1];
	for (int i=0; i<size-1; i++){
	    updated[i] = data[i];
	}
	data = updated;
	size -= 1;
	return toReturn;	
    }
	   
    public boolean remove (String element) {
	int index = indexOf(element);
	remove(index);
	return true;
    }
}
