import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

class Player implements Comparable<Player> {
	String name;
	int attack;
	int defense;
	public Player(String name, int attack, int defense) {
		super();
		this.name = name;
		this.attack = attack;
		this.defense = defense;
	}
	@Override
	public String toString() {
		return name;
	}
	@Override
	public int compareTo(Player o) {
		int comparaciónPorAtaque = attack - o.attack;
		if (comparaciónPorAtaque != 0) {
			return comparaciónPorAtaque;
		}
		int comparaciónPorDefensa = o.defense - defense;
		if (comparaciónPorDefensa != 0) {
			return comparaciónPorDefensa;
		}
		return o.name.compareTo(name);
	}
}

public class Main {

	static final String EOL = String.format("%n");
	
	public static void main(String[] args) throws IOException {
		try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
				BufferedOutputStream out = new BufferedOutputStream(System.out)) {
			int totalCasos = Integer.parseInt(in.readLine());
			Player[] jugadores = new Player[10];
			for (int caso = 1; caso <= totalCasos; ++caso) {
				for (int i = 0; i < 10; ++i) {
					String[] input = in.readLine().split(" ");
					jugadores[i] = new Player(input[0], Integer.parseInt(input[1]), Integer.parseInt(input[2]));
				}
				Arrays.sort(jugadores);
				Comparator<Player> compararPorNombres = new Comparator<Player>() {
					@Override
					public int compare(Player uno, Player otro) {
						return uno.name.compareTo(otro.name);
					}
				};
				Arrays.sort(jugadores, 0, 5, compararPorNombres);
				Arrays.sort(jugadores, 5, 10, compararPorNombres);
				StringBuilder output = new StringBuilder("Case ").append(caso).append(':').append(EOL)
						.append('(');
				for (int i = 5; i < 9; ++i) {
					output.append(jugadores[i]).append(", ");
				}
				output.append(jugadores[9]).append(')').append(EOL)
						.append('(');
				for (int i = 0; i < 4; ++i) {
					output.append(jugadores[i]).append(", ");
				}
				output.append(jugadores[4]).append(')').append(EOL);
				String s = output.toString();
				out.write(s.getBytes(), 0, s.length());
			}
		}
	}

}
