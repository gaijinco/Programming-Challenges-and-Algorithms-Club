import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class Main {
	public static void main(String[] args) throws Exception {
		//Scanner sc = new Scanner(new File("test.txt"));
		Scanner sc = new Scanner(System.in);
		// Get the number of following lines
		int totalLines = Integer.parseInt(sc.nextLine());
		// Map for storing countries with list of women
		SortedMap<String, Set<String>> conquests = new TreeMap<>();
		for (int i = 0; i < totalLines; i++) {
			String[] lineArray = sc.nextLine().split("\\s", 2);
			String country = lineArray[0];
			Set<String> women = null;
			if (!conquests.containsKey(country)) {
				women = new HashSet<>();
				conquests.put(country, women);
			} else {
				women = conquests.get(country);
			}
			// See if the women is in the list already in the list
			String lady = lineArray[1];
			women.add(lady);
		}
		// Print map ordering alphabetically
		for (Map.Entry<String, Set<String>> entry : conquests.entrySet()) {
			System.out.printf("%s %s%n", entry.getKey(), entry.getValue().size());
		}
	}
}
