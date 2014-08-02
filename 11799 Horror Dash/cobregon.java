import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		try (BufferedReader in = new BufferedReader(new InputStreamReader(
				System.in));
				BufferedOutputStream out = new BufferedOutputStream(System.out)) {
			int totalCases = Integer.parseInt(in.readLine());
			for (int caso = 1; caso <= totalCases; ++caso) {
				String[] input = in.readLine().split(" ");
				int max = 1;
				for (int i = 0; i < input.length; ++i) {
					int n = Integer.parseInt(input[i]);
					if (n > max) {
						max = n;
					}
				}
				String output = String.format("Case %d: %d%n", caso, max); 
				out.write(output.getBytes(), 0, output.length());
			}
		}
	}

}
