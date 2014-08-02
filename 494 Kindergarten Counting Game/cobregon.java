import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {

	public static void main(String[] args) throws IOException {
		try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
				BufferedOutputStream out = new BufferedOutputStream(System.out)) {
			Pattern pattern = Pattern.compile("[a-zA-Z]+");
			String line = null;
			while ((line = in.readLine()) != null) {
				Matcher matcher = pattern.matcher(line);
				int total = 0;
				while (matcher.find()) {
					matcher.group();
					++total;
				}
				String output = String.format("%d%n", total);
				out.write(output.getBytes(), 0, output.length());
			}
		}
	}

}
