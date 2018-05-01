public class MyDeque<E> {

    private E[] deq;  // LIFO
    private int front, back;
    private int size;

    @SuppressWarnings("unchecked")
    public MyDeque() {
	deq = (E[])new Object[10];
	front = -1;
	back = -1;
	size = 10;
    }
    
    public MyDeque(int initialCapacity) {
	if (initialCapacity < 0) {
	    throw new IllegalArgumentException();
	}
	
	deq = (E[])new Object[10];
	front = -1;
	back = -1;
	size = initialCapacity;
    }

    public int size() {
	return size;
    }

    public void addFirst(E thing) {
	if (thing == null) {
	    throw new NullPointerException();
	}
	if (front == -1) {
	    
	}
    }
    
    public void addLast(E thing) {
	if (thing == null) {
	    throw new NullPointerException();
	}
    }

    public E removeFirst() {
	if (size == 0) {
	    throw new NoSuchElementException();
	}
    }

    public E removeLast() {
	if (size == 0) {
	    throw new NoSuchElementException();
	}
    }

    public E getFirst() {
	if (size == 0) {
	    throw new NoSuchElementException();
	}
    }
    
    public E getLast() {
	if (size == 0) {
	    throw new NoSuchElementException();
	}
    }

    public String toString(){
	String ans = "[";
	if(start < end){
	    for (int i = start; i <= end; i++){
		ans += data[i] + " , ";
	    }
	}
	else{
	    for(int i = start; i < data.length; i++){
		ans += data[i] + ", ";
	    }
	    for(int i = 0; i <= end; i++){
		ans += data[i] + ", ";
	    }
	}
	ans = ans.substring(0, ans.length() - 2) + "]";
	return ans;
    }

    public static void main(String[] args) {
	MyDeque<String> a = new MyDeque<>(), a1 = new MyDeque<>();
	ArrayList<String> b = new ArrayList<>();

	int size = Integer.parseInt(args[0]);
	for(int i = 0; i < size; i++){
	    int temp = (int)(Math.random() * 1000);
	    if(temp % 2 == 0){
		a.addFirst("" + temp);
		a1.addFirst("" + temp);
		b.add(0, "" + temp);
	    }
	    else{
		a.addLast("" + temp);
		a1.addLast("" + temp);
		b.add("" + temp);
	    }
	}

	int index = 0;
	boolean hasError = false;
	String errorEvaluation = "Errors found at these indices: ";
	for (String x : b){
	    if (!(x.equals(a.getFirst()))){
		System.out.println("The getFirst() function is incorrect at index " + index);
		hasError = true;
	    }
	    if (!(x.equals(a.removeFirst()))){
		System.out.println("There is an error at index " + index);
		errorEvaluation += index + ", ";
		hasError = true;
	    }
	    index++;
	}


	if(hasError){
	    errorEvaluation = errorEvaluation.substring(0, errorEvaluation.length() - 2);
	    System.out.println(errorEvaluation);
	    System.out.println("MyDeque: " + a1);
	    System.out.println("Actual Deque: " + b);
	}
	else{
	    System.out.println("Your deque is bug-free!");
	}
    }
	
    
}
