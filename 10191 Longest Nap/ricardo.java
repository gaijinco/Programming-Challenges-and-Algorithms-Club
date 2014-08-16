package uva.collections;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class LongestNap {

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner sc = new Scanner(new File("src/tests/LongestNap.in"));
		//Scanner sc = new Scanner(System.in);
		
		PrintWriter out = new PrintWriter(System.out);
		//PrintStream out = System.out;
		int t = 0;
		while(sc.hasNextInt()){
			int n = sc.nextInt();
			sc.nextLine();
			ArrayList<Schedule> schedules = new ArrayList<>();
			
			//Getting all schedules
			for(int i = 0; i < n; i++){
				String str = sc.nextLine();
				Scanner line = new Scanner(str.replaceAll(":", " "));
				int h1 = line.nextInt(); //getting hours;
				int m1 = line.nextInt(); //getting minutes		
				
				int h2 = line.nextInt(); //getting hours
				int m2 = line.nextInt(); //getting minutes		
				
				schedules.add(new Schedule(h1,m1, h2, m2));
				line.close();
			}
			schedules.add(new Schedule(9,00, 10, 00));
			schedules.add(new Schedule(18,00, 19, 00));
			Collections.sort(schedules);
			
			int bigger = Integer.MIN_VALUE;
			String napStart = null;
			for(int i = 0; i < schedules.size() - 1; i++) {
				int space = schedules.get(i).distanceTo(schedules.get(i + 1 ));
				if( space > bigger){
					bigger = space;
					napStart = String.format("%02d:%02d", schedules.get(i).h2, schedules.get(i).m2);
				}
			}
			String timef = "";
			if(bigger/60 > 0 )
				timef = String.format("%d hours and %d minutes", bigger/60, bigger%60);
			else 
				timef = String.format("%d minutes", bigger);
				
			out.printf("Day #%d: the longest nap starts at %s and will last for %s.%n", 
					t + 1, napStart, timef  );
			
			t++;
		}
		out.close();
		sc.close();
	}
	
	static class Schedule implements Comparable<Schedule>{
		int h1, m1, h2, m2;
		public Schedule(int h1, int m1, int h2, int m2) {
			this.h1 = h1;
			this.m1 = m1;
			
			this.h2 = h2;
			this.m2 = m2;
		}
		
		public String toString(){
			return String.format("%d:%d  %d:%d", h1, m1, h2, m2);
		}
		
		public int distanceTo(Schedule later) {
			return (later.h1*60 + later.m1) - (h2*60 + m2);
		}

		@Override
		public int compareTo(Schedule s) {
			// TODO Auto-generated method stub
			return (h1*60 + m1) - (s.h1*60 + s.m1);
		}
		
	}

}
