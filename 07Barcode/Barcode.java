public class Barcode implements Comparable<Barcode> {
    private String zip;
    String[] code = new String[] {"||:::", ":::||", "::|:|", "::||:", ":|::|", ":|:|:", ":||::", "|:::|", "|::|:", "|:|::", "||:::"};

    public Barcode (String zipcode) {
	zip = zipcode;
    }

    public String getZip () {
	return zip;
    }

    public String getCode () {
	return converted(zip);
    }

    public String toString () {
	return getCode + getZip;
    }

    public int checkSum (String zipco) {
	int sum = 0;

	for (int i = 0, i < zip.length(); i++) {
	    sum += Integer.parseInt(zip.substring(i,i+1));
	}
	return sum;
    }

    private String converter (int num) {
	return code[int];
    }

    private String converted (String zipco) {
