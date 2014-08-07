import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextLine()) {
			int wordCounter = 0;
			String textInput = sc.nextLine();
			String[] inputArray = textInput.split("[^a-z^A-Z]");
			for (String inputWord : inputArray) {
				if (inputWord.matches("[a-zA-Z]+")) {
					wordCounter++;
				}
			}
			System.out.println(wordCounter);
		}
	}
}
