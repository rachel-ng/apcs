public class Driver {
    public static void main(String[] args) {
	Barcode meh = new Barcode ("11111");
	Barcode halp = new Barcode("54321");
	System.out.println(halp.getZip() + "\t" + halp.checkSum());
	System.out.println(halp.getCode());
	System.out.println(halp.toZip(halp.getCode()));
	System.out.println(halp.equal(meh));
	System.out.println(halp.toString());

	System.out.println(meh.getZip() + "\t" + halp.checkSum());
	System.out.println(meh.getCode());
	System.out.println(meh.toZip(meh.getCode()));
	System.out.println(meh.equal(halp));
	System.out.println(meh.toString());	
    }
}
	   
