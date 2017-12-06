public class Barcode implements Comparable<Barcode>{

    private String _zip;
    private String barcode;

    
    // How do I make emacs stop deleting my code every once in a while .-.

    public Barcode (String zip) {
	 _zip = zip;
	if (zip.length() != 5) {
	    throw new IllegalArgumentException();
	}
	else {
	    try {
		for (int i = 0; i < zip.length(); i++) {
		    Integer.parseInt(zip.substring(i,i+1));
		}
	    }
	    catch (NumberFormatException e) {
		throw new IllegalArgumentException();
	    }
	}
    }

    public String getZip () {
	return _zip;
    }

    public String getCode () {
	return toCode(_zip);
    }

    public String toString () {
	return getCode() + " (" +  getZip() + checkSum() + ")";
    }

    public int checkSum () {
	int sum = 0;
	
	for (int i = 0; i < _zip.length(); i++) {
	    sum += Integer.parseInt(_zip.substring(i,i+1));
	}
	return sum % 10;
    }
    
    private static String toCode (String zip) {
	String[] cypher = new String[] {"||:::", ":::||", "::|:|", "::||:", ":|::|", ":|:|:", ":||::", "|:::|", "|::|:", "|:|::", "||:::"};
	String bar = "|";
	int checkSum = 0;
		
	if (zip.length() != 5) {
	    throw new IllegalArgumentException();
	}

	else {
	    try {
		for (int i = 0; i < zip.length(); i++) {
		    Integer.parseInt(zip.substring(i,i+1));
		}
	    }
	    catch (NumberFormatException e) {
		throw new IllegalArgumentException();
	    }
	}
	
	for (int i = 0; i < zip.length(); i++) {
	    bar += cypher[Integer.parseInt(zip.substring(i,i+1))];
	    checkSum += Integer.parseInt(zip.substring(i,i+1));
	}
	checkSum = checkSum % 10;
	return bar + cypher[checkSum] + "|";
    }

    public String toZip (String code) {
        String[] cypher = new String[] {"||:::", ":::||", "::|:|", "::||:", ":|::|", ":|:|:", ":||::", "|:::|", "|::|:", "|:|::", "||:::"};
	String zip = "";
	int checkSum = 0;
	int num = 0;
	
	if (code.length() != 32 || !code.substring(0,1).equals("|") && !code.substring(31,32).equals("|")) {
	    throw new IllegalArgumentException();
	}
	else {
	    code = code.substring(1,31);
	    
	    for (int i = 0; i < code.length(); i++) {
		if (!code.substring(i, i+1).equals("|") && !code.substring(i, i+1).equals(":")){
		    throw new IllegalArgumentException();
		}
	    }

	    for (int i = 0; i < code.length(); i += 5) {
		for (int x = 0; x < 10; x++) {
		    if (code.substring(i,i+5).equals(cypher[x])) {
			zip += x;
			checkSum += x;
		    }
		}
	    }

	    num =  Integer.parseInt(zip.substring(5,6));
	    checkSum = (checkSum - num) % 10;

	    if (checkSum != num) {
		throw new IllegalArgumentException();
	    }
	}
	return zip.substring(0,5);
    }

    public boolean equal (Barcode other) {
	return this.getZip().compareTo(other.getZip()) == 0;
    }
    
    public int compareTo (Barcode other) {
	return this.getZip().compareTo(other.getZip());
    }
}
