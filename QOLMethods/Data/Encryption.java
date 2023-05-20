package QOLMethods.Data;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import QOLMethods.Extensions.StringExtensions;

public abstract class Encryption {
	
	public static String encryptULTRA(String text) {
		Random random = new Random();
		char[] charsJumbled = {'W', 'Q', 'C', 'y', 'E', 'G', 'X', 'e', 'd', 'q', 'k', 'B', 'O', 't', 's', 'L', ' ', '9', 'F', 'A', 'S', 'H', 'a', 'R', '2', 'V', 'Y', 'h', 'p', 'I', '7', 'u', '1', 'c', 'r', '0', 'Z', 'o', 'M', '5', 'U', 'l', 'w', 'i', 'n', '4', 'j', 'P', '3', '6', 'v', 'K', 'J', 'N', 'g', 'f', 'T', 'x', 'b', 'm', 'D', '8', 'z'};
		int[] charValues = {53, 41, 31, 63, 56, 65, 32, 21, 55, 54, 50, 26, 28, 20, 42, 14, 72, 10, 33, 27, 57, 12, 44, 16, 46, 59, 36, 22, 11, 37, 60, 61, 71, 17, 18, 51, 30, 49, 39, 70, 69, 38, 13, 47, 68, 58, 43, 19, 62, 15, 66, 24, 40, 25, 45, 67, 23, 35, 29, 64, 52, 34, 48};
		String[] binary = {"0000", "0001", "0010", "0011", "0100", "0101", "0110", "0111", "1000", "1001"};
		String chars = "AaBbCcDdEeFfGgHhIiJjKkLlMm01234NnOoPpQqRrSsTtUuVvWwXxYyZz56789 ";
		String currentText = "";
		String nextText = "";
		String output = "";
		
		//Convert normal text to jumbled
		for (int i = 0; i < text.length(); i++) {
			currentText += charsJumbled[chars.indexOf(text.charAt(i))];
		}
		for (int i = 0; i < currentText.length(); i++) {
			nextText += charsJumbled[chars.indexOf(currentText.charAt(i))];
		}
		
		//Convert jumbled to numbers
		currentText = "";
		for (int i = 0; i < nextText.length(); i++) {
			currentText += charValues[chars.indexOf(nextText.charAt(i))];
		}
		
		//Convert numbers to binary
		nextText = "";
		for (int i = 0; i < currentText.length(); i++) {
			nextText += binary[Integer.parseInt(currentText.charAt(i) + "")];
		}
		
		//Convert binary to jumbled
		currentText = "";
		for (int i = 0; i < nextText.length(); i++) {
			if (nextText.charAt(i) == '0') {
				currentText += chars.charAt(random.nextInt(30));
			} else if (nextText.charAt(i) == '1') {
				currentText += chars.charAt(random.nextInt(31, 62));
			}
		}
		
		//Finish
		output = StringExtensions.reverseString(currentText);
		return output;
	}
	
	public static String decryptUltra(String text) {
		String chars = "AaBbCcDdEeFfGgHhIiJjKkLlMm01234NnOoPpQqRrSsTtUuVvWwXxYyZz56789 ";
		String currentText = "";
		String nextText = StringExtensions.reverseString(text);
		String output = "";
		List<String> binary = Arrays.asList("0000", "0001", "0010", "0011", "0100", "0101", "0110", "0111", "1000", "1001");
		List<Integer> charValues = Arrays.asList(53, 41, 31, 63, 56, 65, 32, 21, 55, 54, 50, 26, 28, 20, 42, 14, 72, 10, 33, 27, 57, 12, 44, 16, 46, 59, 36, 22, 11, 37, 60, 61, 71, 17, 18, 51, 30, 49, 39, 70, 69, 38, 13, 47, 68, 58, 43, 19, 62, 15, 66, 24, 40, 25, 45, 67, 23, 35, 29, 64, 52, 34, 48);
		List<Character> charsJumbled = Arrays.asList('W', 'Q', 'C', 'y', 'E', 'G', 'X', 'e', 'd', 'q', 'k', 'B', 'O', 't', 's', 'L', ' ', '9', 'F', 'A', 'S', 'H', 'a', 'R', '2', 'V', 'Y', 'h', 'p', 'I', '7', 'u', '1', 'c', 'r', '0', 'Z', 'o', 'M', '5', 'U', 'l', 'w', 'i', 'n', '4', 'j', 'P', '3', '6', 'v', 'K', 'J', 'N', 'g', 'f', 'T', 'x', 'b', 'm', 'D', '8', 'z');
		
		//Convert jumbled to binary
		for (int i = 0; i < nextText.length(); i++) {
			if (chars.indexOf(nextText.charAt(i)) <= 30) {
				currentText += 0;
			} else if (chars.indexOf(nextText.charAt(i)) <= 61) {
				currentText += 1;
			}
		}
		
		//Convert binary to numbers
		for (int i = 0; i < currentText.length(); i += 4) {
			nextText += binary.indexOf(currentText.charAt(i) + "" + currentText.charAt(i + 1) + "" + currentText.charAt(i + 2) + "" + currentText.charAt(i + 3));
		}
		
		//Convert numbers to jumbled
		currentText = "";
		for (int i = 0; i < nextText.length(); i += 2) {
			currentText += chars.charAt(charValues.indexOf(Integer.parseInt(nextText.charAt(i) + "" + nextText.charAt(i + 1))));
		}
		
		//Convert jumbled to words
		nextText = "";
		for (int i = 0; i < currentText.length(); i++) {
			nextText += chars.charAt(charsJumbled.indexOf(currentText.charAt(i)));
		}
		currentText = "";
		for (int i = 0; i < nextText.length(); i++) {
			currentText += chars.charAt(charsJumbled.indexOf(nextText.charAt(i)));
		}
		
		//Finish
		output = currentText;
		return output;
	}
	
}