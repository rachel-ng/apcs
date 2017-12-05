public abstract class Barcode implements Comparable<Barcode>{
    private String _zip;
    String[] code = new String[] {"||:::", ":::||", "::|:|", "::||:", ":|::|", ":|:|:", ":||::", "|:::|", "|::|:", "|:|::", "||:::"};

    // How do I make emacs stop deleting my code every once in a while .-.

    public Barcode (String zip) {
	if (zip.length() != 5) {
	    throw new IllegalArgumentException();
	}
	_zip = zip;
    }

    public String getZip () {
	return _zip;
    }

    public String getCode () {
	return converted(_zip);
    }

    public String toString () {
	return getCode() + "\n" + getZip() + checkSum() + "\tEMACS STOP DELETING MY CODE ASDFGHJKL";
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

    private String converted (String zip) {
	String zipco = zip;
	String bar = "|";
	int num = 0;
	for (int i = 0; i < zipco.length(); i++) {
	    bar += converter(Integer.parseInt(zip.substring(i,i+1)));
	}
	return bar + converter(checkSum()) +  "|";
    }

    //    public int compareTo (Barcode other) {
    //   }
}
