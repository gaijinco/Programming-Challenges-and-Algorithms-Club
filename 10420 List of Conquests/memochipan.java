// UVA 10420
// http://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=1361

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		
//		Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(new File("files/input.txt"));
		ArrayList<String> countries = new ArrayList<String>();
		HashMap<String,Integer> m = new HashMap<String,Integer>();
		
		if (sc.hasNextLine()){
			sc.nextInt();
		}
		
		while(sc.hasNextLine()){
			String country = sc.next();
			if(m.get(country)==null){
				m.put(country,0);
			}
			m.put(country,m.get(country)+1); 
			if (!countries.contains(country)){
				countries.add(country);
			}
			sc.nextLine();
		}
	
		Collections.sort(countries);
	
		for (String k: countries) {
			System.out.println(k+" "+m.get(k));
		}
		
		sc.close();
	}
} 

// Expected Output:
// England 1
// Spain 2