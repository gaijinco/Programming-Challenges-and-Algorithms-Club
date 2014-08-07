import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;


class ListOfConquests {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		//Scanner sc = new Scanner(new File("src/tests/ListOfConquests.in"));
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		
		Map<String,Integer> count = new HashMap<String,Integer>();
		
		int cases = sc.nextInt();
		
		
		while(sc.hasNextLine()){
			
			String str = sc.nextLine();
			//Limpiamos el String
			if(str.trim().length()!=0){
				/* Usamos split para dividir el array 
				 * y tomar el primer elemento que corresponde al pais 
				 */
				String[] items = str.split(" ");
				
				/* obtenemos el contador de conquistas del pais, si nos devuelve null lo convertimos en 0 
				 * luego actualizamos el pais incrementando en uno su contador.
				 *  */
				int counter = (count.get(items[0]) != null? count.get(items[0]):0);				
				count.put(items[0], counter + 1 );
			}
		}
		/* Aca simplemente obtenemos todos los keys y los ordenamos para luego mostrarlos con su respectivo value.
		   Hubieramos podido utilizar treeMap para evitar esto, pero el put(key,value) tiene mayor
		   complejidad con treeMap. */
		String[] items = new String[count.size()];
		items = count.keySet().toArray(items); 
		Arrays.sort(items);
		for(Object st : items){
			out.println( st + " " + count.get(st) );
		}
		
		out.close();

	}

}
