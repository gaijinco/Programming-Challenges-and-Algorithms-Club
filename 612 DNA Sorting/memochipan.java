// UVA 612
// http://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=553

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		
//		Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(new File("files/cases.txt"));
		
		int testCases = sc.nextInt();
		
		// Se itera sobre los casos.
		for (int i=0; i<testCases; i++){
			
			sc.nextInt();
			int numberStrings = sc.nextInt();
			sc.nextLine();
			
			TreeMap<Integer,ArrayList<String>> orderMap = new TreeMap<Integer,ArrayList<String>>();
			
			// Se itera sobre las líneas de cada caso almacenando las cadenas en un TreeMap de acuerdo con su grado de orden.
			for (int j=0; j<numberStrings; j++){
				
				String string = sc.nextLine(); 
				int order = getOrder(string);
				ArrayList<String> strings;
				
				if (orderMap.containsKey(order)){
					strings = orderMap.get(order);
				} else {
					strings = new ArrayList<String>();
				}
				
				strings.add(string);
				orderMap.put(order,strings);
			}

			// Se itera sobre el TreeMap para mostrar los resultados en orden.
			for(ArrayList<String> bucket: orderMap.values()) {
				for (int k=0; k<bucket.size(); k++){  
					System.out.println(bucket.get(k));
				}
			}
			
			System.out.println();
		}
		
		sc.close();
	}
	
	// Dada una cadena obtiene su grado de orden basado en el número de trasposiciones. 
	private static int getOrder(String string) {
		
		char[] charArray = string.toCharArray();  	
		int order = 0;
		
		for (int i=0; i<charArray.length; i++){
			for (int j=i+1; j<charArray.length; j++){
				if (charArray[i]>charArray[j]){
					order++;
				}
			}
		}
		
		return order;
	}
}

// Expected Output:
// CCCGGGGGGA
// AACATGAAGG
// GATCAGATTT
// ATCGATGCAT
// TTTTGGCCAA
// TTTGGCCAAA