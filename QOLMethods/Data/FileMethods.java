package QOLMethods.Data;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class FileMethods {
	
	public static ArrayList<String> readFileWithAsterisk(File file) {
		ArrayList<String> list = new ArrayList<String>();
		try {
			String string = "";
			FileReader reader = new FileReader(file);
			int data = reader.read();
			string = string + (char) data;
		
			while (data != -1) {
				data = reader.read();
				while ((char) data != '*') {
					string = string + (char) data;
					data = reader.read();
				}
				list.add(string);
				string = "";
				data = reader.read();
				string = string + (char) data;
			}
		
			reader.close();
		} catch (IOException e) {}
		return list;
	}
	
	public static ArrayList<Integer> readIntegerFileWithAsterisk(File file) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		try {
			String string = "";
			FileReader reader = new FileReader(file);
			int data = reader.read();
			string = string + (char) data;
		
			while (data != -1) {
				data = reader.read();
				while ((char) data != '*') {
					string = string + (char) data;
					data = reader.read();
				}
				list.add(Integer.parseInt(string));
				string = "";
				data = reader.read();
				string = string + (char) data;
			}
		
			reader.close();
		} catch (IOException e) {}
		return list;
	}
	
	public static void writeFileWithAsterisk(File file, String[] list) {
		try {
			FileWriter writer = new FileWriter(file);
			String data = "";
			for (String item : list) {
				data = data + item + '*';
			}
			writer.write(data);
			writer.close();
		} catch (IOException e) {}
	}
	
	public static void writeIntegerFileWithAsterisk(File file, int[] list) {
		try {
			FileWriter writer = new FileWriter(file);
			String data = "";
			for (int item : list) {
				data = data + item + '*';
			}
			writer.write(data);
			writer.close();
		} catch (IOException e) {}
	}
	
	public static void writeFileWithAsterisk(File file, ArrayList<String> list) {
		try {
			FileWriter writer = new FileWriter(file);
			String data = "";
			for (String item : list) {
				data = data + item + '*';
			}
			writer.write(data);
			writer.close();
		} catch (IOException e) {}
	}
	
	public static void writeIntegerFileWithAsterisk(File file, ArrayList<Integer> list) {
		try {
			FileWriter writer = new FileWriter(file);
			String data = "";
			for (Integer item : list) {
				data = data + item + '*';
			}
			writer.write(data);
			writer.close();
		} catch (IOException e) {}
	}
	
	public static ArrayList<String> readFileWithLines(File file) {
		ArrayList<String> list = new ArrayList<String>();
		try {
			Scanner scanner = new Scanner(file);
			String string = scanner.nextLine();
			while (scanner.hasNext()) {
				list.add(string);
				try {
					string = scanner.nextLine();
				} catch (java.util.NoSuchElementException e) {
					break;
				}
			}
			scanner.close();
		} catch (FileNotFoundException e) {}
		
		return list;
	}
	
	public static ArrayList<Integer> readIntegerFileWithLines(File file) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		try {
			Scanner scanner = new Scanner(file);
			String string = scanner.nextLine();
			while (scanner.hasNext()) {
				list.add(Integer.parseInt(string));
				try {
					string = scanner.nextLine();
				} catch (java.util.NoSuchElementException e) {
					break;
				}
			}
			scanner.close();
		} catch (FileNotFoundException e) {}
		
		return list;
	}
	
}