import java.io.File;
import java.io.PrintWriter;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		// Scanner sc = new Scanner(new File("test.txt"));
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		try {
			while (sc.hasNextLine()) {
				String[] lineArray = sc.nextLine().split("\\s");
				boolean isCorrect = true;
				// Stack with opened (negative) toys
				Deque<Integer> openedToysStack = new LinkedList<>();
				// Stack with room left for other toys
				Deque<Integer> roomLeftStack = new LinkedList<>();
				for (int i = 0; i < lineArray.length && isCorrect; i++) {
					int currentToy = Integer.parseInt(lineArray[i]);
					if (currentToy < 0) {
						if (!roomLeftStack.isEmpty()) {
							// Check if there is enough room for the current toy
							int currentRoomLeft = roomLeftStack.removeFirst()
									- currentToy;
							if (currentRoomLeft >= 0) {
								isCorrect = false;
							} else {
								roomLeftStack.push(currentRoomLeft);
							}
						}
						openedToysStack.push(currentToy);
						roomLeftStack.push(currentToy);
					} else {
						if (openedToysStack.isEmpty()) {
							isCorrect = false;
						} else {
							// Dequeue and check if correct
							int lastToy = openedToysStack.removeFirst();
							if (currentToy + lastToy != 0) {
								isCorrect = false;
							}
							roomLeftStack.removeFirst();
						}
					}
				}
				out.println(isCorrect && openedToysStack.isEmpty() ? ":-) Matrioshka!"
						: ":-( Try again.");
			}
		} finally {
			// Close resources
			sc.close();
			out.close();
		}
	}
}
