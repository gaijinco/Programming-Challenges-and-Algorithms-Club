import java.util.Scanner;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		// Get the number of following lines
		int totalCases = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < totalCases; i++) {
			String[] lineArray = sc.nextLine().split("\\s");
			int totalStudents = Integer.parseInt(lineArray[0]);
			TreeSet<Integer> studentSpeeds = new TreeSet<Integer>();
			for (int j = 1; j <= totalStudents; j++) {
				studentSpeeds.add(Integer.parseInt(lineArray[j]));
			}
			System.out.println("Case " + (i + 1) + ": " + studentSpeeds.last());
		}
	}
}
