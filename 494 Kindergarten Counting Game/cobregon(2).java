import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
				BufferedOutputStream out = new BufferedOutputStream(System.out)) {
			String line = null;
			while ((line = in.readLine()) != null) {
				int total = 0;
				int count = 0;
				for (int i = 0; i < line.length(); ++i) {
					boolean letter = Character.isLetter(line.charAt(i));
					if (letter) {
						++count;
					} else if (count > 0) {
						++total;
						count = 0;
					}
				}
				if (count > 0) {
					++total;
				}
				String output = String.format("%d%n", total);
				out.write(output.getBytes(), 0, output.length());
			}
		}
	}

}
