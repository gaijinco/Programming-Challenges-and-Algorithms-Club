import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

class Event implements Comparable<Event> {
	int start;
	int end;

	public Event(String line) {
		String hourStart = line.substring(0, 2);
		String minuteStart = line.substring(3, 5);
		String hourEnd = line.substring(6, 8);
		String minuteEnd = line.substring(9, 11);
		start = Integer.parseInt(hourStart) * 60 + Integer.parseInt(minuteStart);
		end = Integer.parseInt(hourEnd) * 60 + Integer.parseInt(minuteEnd);
	}

	@Override
	public int compareTo(Event o) {
		int compararPorInicio = start - o.start;
		if (compararPorInicio != 0) {
			return compararPorInicio;
		}
		return end - o.end;
	}
}

public class Main {

	public static void main(String[] args) throws IOException {
		try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
				BufferedOutputStream out = new BufferedOutputStream(System.out)) {
			String line = null;
			int day = 1;
			TreeSet<Event> agenda = new TreeSet<>();
			while ((line = in.readLine()) != null) {
				agenda.clear();
				int lineas = Integer.parseInt(line);
				while (lineas-- > 0) {
					agenda.add(new Event(in.readLine()));
				}
				int último = 600;
				int start = 600;
				int max = 0;
				for (Event evento: agenda) {
					int diferencia = evento.start - último;
					if (diferencia > max) {
						start = último;
						max = diferencia;
					}
					último = evento.end;
				}
				int diferencia = 1080 - último;
				if (diferencia > max) {
					start = último;
					max = diferencia;
				}
				String time = max >= 60 ? String.format("%d hours and %d minutes", max / 60, max % 60) : String.format("%d minutes", max); 
				String output = String.format("Day #%d: the longest nap starts at %d:%02d and will last for %s.%n", day++, start / 60, start % 60, time);
				out.write(output.getBytes(), 0, output.length());
			}
		}
	}

}
