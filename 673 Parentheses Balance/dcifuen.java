import java.io.File;
import java.io.PrintWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		// Scanner sc = new Scanner(new File("test.txt"));
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int totalStrings = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < totalStrings; i++) {
			char[] line = sc.nextLine().toCharArray();
			boolean isCorrect = true;
			// Stack with "(" and "[" enqueued
			Deque<Character> stack = new LinkedList<>();
			for (int j = 0; j < line.length && isCorrect; j++) {
				if (line[j] == '(' || line[j] == '[') {
					stack.push(line[j]);
				} else {
					if (stack.isEmpty()) {
						isCorrect = false;
					} else {
						//Dequeue and check if correct
						char lastChar = stack.removeFirst();
						if ((line[j] == ')' && lastChar != '(')
								|| (line[j] == ']' && lastChar != '[')) {
							isCorrect = false;
						}
					}

				}
			}
			out.println(isCorrect && stack.isEmpty() ? "Yes" : "No");
		}
		// Close resources
		sc.close();
		out.close();
	}
}
