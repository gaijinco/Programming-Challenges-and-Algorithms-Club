import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class DNA {
	String cadena;
	int inversiones;
	DNA(String cadena) {
		this.cadena = cadena;
		for (int i = 0; i < cadena.length() - 1; ++i) {
			for (int j = i + 1; j < cadena.length(); ++j) {
				if (cadena.charAt(i) > cadena.charAt(j)) {
					++inversiones;
				}
			}
		}
	}
}

public class Main {

	static int inversiones(String cadena) {
		int total = 0;
		for (int i = 0; i < cadena.length() - 1; ++i) {
			for (int j = i + 1; j < cadena.length(); ++j) {
				if (cadena.charAt(i) > cadena.charAt(j)) {
					++total;
				}
			}
		}
		return total;
	}

	public static void main(String[] args) throws IOException {
		try (Scanner in = new Scanner(System.in)) {
			int M = in.nextInt();
			DNA[] secuencias = new DNA[100];
			for (int caso = 1; caso <= M; ++caso) {
				if (caso != 1) {
					System.out.println();
				}
				in.nextInt();
				int m = in.nextInt();
				for (int i = 0; i < m; ++i) {
					secuencias[i] = new DNA(in.next());
				}
				Arrays.sort(secuencias, 0, m, new Comparator<DNA>(){
					public int compare(DNA uno, DNA otro) {
						return uno.inversiones - otro.inversiones;
					}
				});
				for (int i = 0; i < m; ++i) {
					System.out.println(secuencias[i].cadena);
				}
			}
		}
	}

}
