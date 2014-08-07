import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;


public class Main {

	public static void main(String[] args) throws IOException {
		try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
				BufferedOutputStream out = new BufferedOutputStream(System.out)) {
			int totalCasos = Integer.parseInt(in.readLine());
			ArrayDeque<Character> cola = new ArrayDeque<>();
			for (int caso = 1; caso <= totalCasos; ++caso) {
				cola.clear();
				String linea = in.readLine();
				boolean valida = true;
				for (int i = 0; valida && i < linea.length(); ++i) {
					char c = linea.charAt(i);
					if (c == '(' || c == '[') {
						cola.add(c);
					} else {
						if (cola.isEmpty()) {
							valida = false;
							break;
						}
						char cierre = cola.pollLast();
						valida = (cierre == '(' && c == ')') || (cierre == '[' && c == ']');
					}
				}
				valida &= cola.isEmpty();
				String output = String.format("%s%n", valida ? "Yes" : "No");
				out.write(output.getBytes(), 0, output.length());
			}
		}
	}

}
