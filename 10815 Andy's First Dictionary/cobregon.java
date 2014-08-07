import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeSet;


public class Main {

	public static void main(String[] args) throws IOException {
		try (Scanner in = new Scanner(System.in)) {
			TreeSet<String> dictionary = new TreeSet<>();
			while (in.hasNext()) {
				StringBuilder builder = new StringBuilder();
				String word = in.next();
				for (int i = 0; i < word.length(); ++i) {
					char c = word.charAt(i);
					if (!Character.isLetter(c)) {
						if (builder.length() > 0) {
							dictionary.add(builder.toString());
						}
						builder = new StringBuilder();
					} else {
						builder.append(Character.toLowerCase(c));
					}
				}
				if (builder.length() > 0) {
					dictionary.add(builder.toString());
				}
			}
			for (String word: dictionary) {
				System.out.println(word);			
			}
		}
	}
}
