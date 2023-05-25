package QOLMethods.Extensions;

public abstract class IntegerExtensions {
	
	public static long factorial(int num) {
		
		return num == 0 ? 1 : num * factorial(num - 1);
		
	}
	
}
