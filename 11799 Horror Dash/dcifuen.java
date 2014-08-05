import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		//Scanner sc = new Scanner(new File("test.txt"));
		Scanner sc = new Scanner(System.in);
		// Get the number of following lines
		int totalCases = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < totalCases; i++) {
			String[] lineArray = sc.nextLine().split("\\s");
			int totalStudents = Integer.parseInt(lineArray[0]);
			int maxSpeed = 0;
			for (int j = 1; j <= totalStudents; j++) {
				int currentSpeed = Integer.parseInt(lineArray[j]);
				if (currentSpeed > maxSpeed){
					maxSpeed = currentSpeed;
				}
			}
			System.out.printf("Case %s: %s%n", (i + 1), maxSpeed);
		}
	}
}
