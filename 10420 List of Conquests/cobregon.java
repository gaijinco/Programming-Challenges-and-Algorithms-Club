import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;


public class Main {

	public static void main(String[] args) throws IOException {
		try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
				BufferedOutputStream out = new BufferedOutputStream(System.out)) {
			Map<String, Set<String>> list = new TreeMap<>();
			int totalLineas = Integer.parseInt(in.readLine());
			for (int linea = 1; linea <= totalLineas; ++linea) {
				String line = in.readLine();
				int i = line.indexOf(' ');
				String country = line.substring(0, i);
				String maiden = line.substring(i + 1);
				Set<String> women = list.get(country);
				if (women == null) {
					women = new HashSet<>();
					list.put(country, women);
				}
				women.add(maiden);
			}
			for (String country : list.keySet()) {
				String output = String.format("%s %d%n", country, list.get(country).size());
				out.write(output.getBytes(), 0, output.length());
			}
		}
	}

}
