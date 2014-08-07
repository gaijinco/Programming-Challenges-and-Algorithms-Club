import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		new dcifuen().sortDNASequences();
	}

	void sortDNASequences() throws Exception {
		//Scanner sc = new Scanner(new File("test.txt"));
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		// Get the number of data sets in the input
		int totalDatasets = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < totalDatasets; i++) {
			// Blank line
			sc.nextLine();
			// Get the string sizing
			String[] lineArray = sc.nextLine().split("\\s");
			int sequenceLength = Integer.parseInt(lineArray[0]);
			int totalSequences = Integer.parseInt(lineArray[1]);
			// Get the sequences and put them ordered in a map
			List<Sequence> dataset = new ArrayList<>();
			for (int j = 0; j < totalSequences; j++) {
				dataset.add(new Sequence(sc.nextLine(), sequenceLength));
			}
			Collections.sort(dataset);
			// Print map sorted by
			for (Sequence sequence : dataset) {
				out.println(sequence);
			}
			//If there are more data sets add blank line
			if (i+1 < totalDatasets){
				out.println();
			}
		}
		out.close();
	}

	class Sequence implements Comparable<Sequence> {
		String sequence;
		int sequenceLength;

		public Sequence(String sequence, int sequenceLength) {
			this.sequence = sequence;
			this.sequenceLength = sequenceLength;
		}

		@Override
		public int compareTo(Sequence otherSeq) {
			return this.getInversions() - otherSeq.getInversions();
		}
		
		private int getInversions(){
			int numInversions = 0;
			char[] chars = this.sequence.toCharArray();
			for (int i = 0; i < this.sequenceLength; i++) {
				for (int j = i+1; j < this.sequenceLength; j++) {
					if (chars[i]>chars[j]){
						numInversions++;
					}
				}
			}
			return numInversions;
		}

		@Override
		public String toString() {
			return this.sequence;
		}
	}
}