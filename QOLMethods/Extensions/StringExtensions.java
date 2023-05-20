package QOLMethods.Extensions;

public abstract class StringExtensions {
	
	public static String reverseString(String string) {
		
		String out = "";
		for (char i : string.toCharArray()) {
			out = i + out;
		}
		
		return out;
		
	}
	
}