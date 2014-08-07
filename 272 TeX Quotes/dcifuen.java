import java.io.File;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		//Scanner sc = new Scanner(new File("test.txt"));
		Scanner sc = new Scanner(System.in);
		// Get the whole input text in a variable
		StringBuilder textOutput = new StringBuilder();
		boolean isOpen = true;
		while (sc.hasNextLine()) {
			int i = 0;
			String lineInput = sc.nextLine();
			while (i < lineInput.length()) {
				// Search for quotes occurrences
				int indexOfQuote = lineInput.indexOf("\"", i);
				if (indexOfQuote >= 0) {
					//Append substring from last occurrence to current
					textOutput.append(lineInput.substring(i, indexOfQuote));
					//Figure whether to add open or close
					textOutput.append(isOpen ? "``" : "''");
					isOpen = !isOpen;
					i = indexOfQuote + 1;
				} else {
					textOutput.append(lineInput.substring(i, lineInput.length()));
					i = lineInput.length();
				}
			}
			textOutput.append("\n");
		}
		System.out.print(textOutput.toString());
	}
}
