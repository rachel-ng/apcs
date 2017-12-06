public class Driver {
    public static void main(String[] args) {
	Barcode halp = new Barcode("54321");
	System.out.println(halp.getZip());
	System.out.println(halp.checkSum());
	System.out.println(halp.getCode());
	System.out.println(halp.toZip(halp.getCode()));
	System.out.println(halp.toString());
    }
}
	   
