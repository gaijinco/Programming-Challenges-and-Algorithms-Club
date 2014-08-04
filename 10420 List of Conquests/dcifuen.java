import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		// Get the number of following lines
		int totalLines = Integer.parseInt(sc.nextLine());
		// Map for storing countries with list of women
		SortedMap<String, ArrayList<String>> conquests = new TreeMap<String, ArrayList<String>>();
		for (int i = 0; i < totalLines; i++) {
			String[] lineArray = sc.nextLine().split("\\s", 2);
			String country = lineArray[0];
			ArrayList<String> women = null;
			if (!conquests.containsKey(country)) {
				women = new ArrayList<String>();
				conquests.put(country, women);
			} else {
				women = conquests.get(country);
			}
			// See if the women is in the list already in the list
			String lady = lineArray[1];
			if (!women.contains(lady)) {
				women.add(lady);
			}
		}
		// Print map ordering alphabetically
		for (Map.Entry<String, ArrayList<String>> entry : conquests.entrySet()) {
			System.out.println(entry.getKey() + " "
					+ entry.getValue().size());
		}
	}
}
