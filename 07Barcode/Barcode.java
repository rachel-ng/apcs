public class Barcode{
    private String _zip;
    String[] code = new String[] {"||:::", ":::||", "::|:|", "::||:", ":|::|", ":|:|:", ":||::", "|:::|", "|::|:", "|:|::", "||:::"};

    // How do I make emacs stop deleting my code every once in a while .-.

    public Barcode (String zip) {
	if (zip.length() != 5) {
	    throw new IllegalArgumentException();
	}
	else {
	    _zip = zip;
	}
    }

    public String getZip () {
	return _zip;
    }

    public String getCode () {
	return toCode(_zip);
    }

    public String toString () {
	return getCode() + " (" +  getZip() + checkSum() + ")"+ "\nEMACS STOP DELETING MY CODE ASDFGHJKL";
    }

    public int checkSum () {
	int sum = 0;
	
	for (int i = 0; i < _zip.length(); i++) {
	    sum += Integer.parseInt(_zip.substring(i,i+1));
	}
	return sum % 10;
    }

    private String converter (int num) {
	return code[num];
    }

    private static String toCode (String zip) {
	String bar = "|";
	int num = 0;
	if (zip.length() != 5) {
	    throw new IllegalArgumentException();
	}
	
	else {
	    for (int i = 0; i < zip.length(); i++) {
		bar += converter(Integer.parseInt(zip.substring(i,i+1)));
	    }
	    return bar + converter(checkSum()) +  "|";
	}
    }

    public String toZip (String code) {
	if (code.length() != 32) {
	    throw new IllegalArgumentException();
	}
    }

    //    public int compareTo (Barcode other) {
    //   }
}
