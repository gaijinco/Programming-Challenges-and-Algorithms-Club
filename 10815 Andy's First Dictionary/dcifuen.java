import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
	public static void main(String[] args) throws Exception {
		// Scanner sc = new Scanner(new File("test.txt"));
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		try {
			Set<String> wordSet = new TreeSet<>();
			while (sc.hasNextLine()) {
				String[] lineArray = sc.nextLine().split("[^a-z^A-Z]");
				for (String inputWord : lineArray) {
					if (inputWord.matches("[a-zA-Z]+")) {
						wordSet.add(inputWord.toLowerCase());
					}
				}
			}
			// Print one word for each line
			for (String word : wordSet) {
				out.println(word);
			}
		} finally {
			// Close resources
			sc.close();
			out.close();
		}

	}
}
