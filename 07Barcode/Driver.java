public class Driver {
    public static void main(String[] args) {
	Barcode meh = new Barcode ("11111");
	Barcode halp = new Barcode("54321");
	Barcode nap = new Barcode("13579");
	
	System.out.println(halp.getZip() + "\t" + halp.checkSum());
	System.out.println(halp.getCode());
	System.out.println(halp.toZip(halp.getCode()));
	System.out.println("meh: " + nap.equal(meh));
	System.out.println("nap: " + nap.equal(nap));
	System.out.println(halp.toString());

	System.out.println("\n");
	
	System.out.println(meh.getZip() + "\t" + meh.checkSum());
	System.out.println(meh.getCode());
	System.out.println(meh.toZip(meh.getCode()));
	System.out.println("halp: " + nap.equal(halp));
	System.out.println("nap: " + nap.equal(nap));
	System.out.println(meh.toString());

	System.out.println("\n");

	System.out.println(nap.getZip() + "\t" + nap.checkSum());
	System.out.println(nap.getCode());
	System.out.println(nap.toZip(nap.getCode()));
	System.out.println("halp: " + nap.equal(halp));
	System.out.println("meh: " + nap.equal(meh));
	System.out.println(nap.toString());	

    }
}
	   
