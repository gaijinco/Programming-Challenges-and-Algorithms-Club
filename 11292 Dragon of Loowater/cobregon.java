import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static int[] dragones = new int[20000];
	static int[] heroes = new int[20000];
	static boolean[] usados = new boolean[20000];

	static int ceilling(int n, int totalHeroes) {
		return ceilling(n, Main.heroes, totalHeroes);
	}

	static int ceilling(int n, int[] heroes, int totalHeroes) {
		int low = 0;
		int high = totalHeroes - 1;
		while (low <= high) {
			int median = (low + high) / 2;
			if (n == heroes[median]) {
				return median;
 			} else if (n < heroes[median]) {
				high = median - 1;
			} else if (n > heroes[median]) {
				low = median + 1;
			}
		}
		return low;
	}

	static int calcularCosto(int totalDragones, int totalHeroes) {
		Arrays.sort(dragones, 0, totalDragones);
		Arrays.sort(heroes, 0, totalHeroes);
		if (dragones[totalDragones -1 ] > heroes[totalHeroes - 1]) {
			return -1;
		}
		int total = 0;
		for (int i = 0; i < totalDragones; ++i) {
			int k = ceilling(dragones[i], totalHeroes);
			while (k < totalHeroes && usados[k]) {
				++k;
			}
			if (k >= totalHeroes) {
				return -1;
			}
			usados[k] = true;
			total += heroes[k++];
		}
		return total;
	}

	public static void main(String[] args) throws IOException {
		try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
				BufferedOutputStream out = new BufferedOutputStream(System.out)) {
			while (true) {
				String[] data = in.readLine().split(" ");
				int totalDragones = Integer.parseInt(data[0]);
				if (totalDragones == 0) {
					break;
				}
				int totalHeroes = Integer.parseInt(data[1]);
				Arrays.fill(usados, false);
				for (int i = 0; i < totalDragones; ++i) {
					int d = Integer.parseInt(in.readLine());
					dragones[i] = d;
				}
				for (int i = 0; i < totalHeroes; ++i) {
					int h = Integer.parseInt(in.readLine());
					heroes[i] = h;
				}
				int costo = totalDragones > totalHeroes ? -1 : calcularCosto(
						totalDragones, totalHeroes);
				System.out.println(costo != -1 ? String.format("%s", costo)
						: "Loowater is doomed!");
			}
		}
	}

}
