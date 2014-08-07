import java.util.ArrayDeque;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		try(Scanner in = new Scanner(System.in)) {
			ArrayDeque<Integer> cola = new ArrayDeque<>();
			ArrayDeque<Integer> sumas = new ArrayDeque<>();
			while (in.hasNext()) {
				cola.clear();
				sumas.clear();
				String[] matrioshka = in.nextLine().split(" ");
				boolean valida = true;
				for (int i = 0; valida && i < matrioshka.length; ++i) {
					int x = Integer.parseInt(matrioshka[i]);
					if (x < 0) {
						x = -x;
						if (!cola.isEmpty() && x >= cola.getLast()) {
							valida = false;
						} else {
							if (!sumas.isEmpty()) {
								int n = sumas.pollLast() - x;
								if (n <= 0) {
									valida = false;
								} else {
									sumas.add(n);
								}
							}
							sumas.add(x);
							cola.add(x);
						}
					} else {
						if (cola.isEmpty()) {
							valida = false;
						} else {
							int apertura = cola.pollLast();
							if (apertura != x) {
								valida = false;
							} else {
								 sumas.pollLast();
							}
						}
					}
				}
				valida &= cola.isEmpty();
				System.out.println(valida ? ":-) Matrioshka!" : ":-( Try again.");
			}
		}
	}

}
