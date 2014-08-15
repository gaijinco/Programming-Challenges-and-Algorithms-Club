import java.io.File;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {

	static SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");

	public static void main(String[] args) throws Exception {
		// Scanner sc = new Scanner(new File("test.txt"));
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		try {
			new Main().calculateLongestNap(sc, out);
		} finally {
			// Close resources
			sc.close();
			out.close();
		}

	}

	void calculateLongestNap(Scanner sc, PrintWriter out) throws Exception {
		Date dayStarts = formatter.parse("10:00");
		Date dayEnds = formatter.parse("18:00");
		int currentDay = 1;
		while (sc.hasNextLine()) {
			int numAppointments = Integer.parseInt(sc.nextLine());
			Appointment[] dailyAppointments = new Appointment[numAppointments];
			for (int i = 0; i < numAppointments; i++) {
				String[] lineArray = sc.nextLine().split("\\s");
				dailyAppointments[i] = new Appointment(
						formatter.parse(lineArray[0]),
						formatter.parse(lineArray[1]));
			}
			// Sort appointments
			Arrays.sort(dailyAppointments);
			// Build possible naps array
			List<Nap> potentialNaps = new ArrayList<>();
			Date lastEnd = null;
			for (int i = 0; i < numAppointments; i++) {
				Appointment appointment = dailyAppointments[i];
				if (i == 0 && appointment.start.after(dayStarts)) {
					// First nap
					potentialNaps.add(new Nap(dayStarts, appointment.start));
				}
				if (i == numAppointments - 1 && appointment.end.before(dayEnds)) {
					// Last nap
					potentialNaps.add(new Nap(appointment.end, dayEnds));
				}
				if (lastEnd != null && appointment.start.after(lastEnd)) {
					// Middle nap
					potentialNaps.add(new Nap(lastEnd, appointment.start));
				}
				lastEnd = appointment.end;
			}
			// Sort naps by duration
			Collections.sort(potentialNaps);
			Nap longestNap = potentialNaps.get(potentialNaps.size() - 1);
			out.printf(
					// napDuration is [H hours and] M minutes
					"Day #%s: the longest nap starts at %s and will last for %s.%n",
					currentDay, formatter.format(longestNap.start),
					longestNap.durationString());
			currentDay++;
		}
	}

	class Appointment implements Comparable<Appointment> {
		Date start;
		Date end;

		public Appointment(Date start, Date end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Appointment o) {
			return this.start.compareTo(o.start);
		}

	}

	class Nap implements Comparable<Nap> {
		Date start;
		Date end;
		int duration;// In minutes

		public Nap(Date start, Date end) {
			this.start = start;
			this.end = end;
			this.duration = (int) TimeUnit.MILLISECONDS.toMinutes(end.getTime()
					- start.getTime());
		}

		@Override
		public int compareTo(Nap o) {
			if (this.duration != o.duration) {
				return this.duration - o.duration;
			} else {
				return o.start.compareTo(this.start);
			}
		}

		public String durationString() {
			return this.duration < 60 ? String.format("%s minutes",
					this.duration) : String.format("%s hours and %s minutes",
					this.duration / 60, this.duration % 60);
		}

	}
}
