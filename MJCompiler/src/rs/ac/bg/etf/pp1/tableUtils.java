package rs.ac.bg.etf.pp1;

public class tableUtils {
	
	public static String typeOfStructNode(int i) {
		switch(i) {
		case 0:
			return "NONE";
		case 1:
			return "INT";
		case 2:
			return "CHAR";
		case 3:
			return "ARRAY";
		case 4:
			return "CLASS";
		case 5:
			return "BOOL";
		default:
			return "ERROR";	
		}
	}

}
