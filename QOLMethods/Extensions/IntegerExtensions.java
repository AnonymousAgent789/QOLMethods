package QOLMethods.Extensions;

public abstract class IntegerExtensions {
	
	public static long factorial(int num) {
		
		if (num == 0) {
			return 1;
		}
		
		return num * factorial(num - 1);
		
	}
	
}
