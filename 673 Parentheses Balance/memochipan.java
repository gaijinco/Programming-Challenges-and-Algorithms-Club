// UVA 673
// http://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=614

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner sc = new Scanner(System.in);
		
		int lines = Integer.parseInt(sc.nextLine());
		
		for(int i=0; i<lines; i++){
			
			StringBuilder line = new StringBuilder(sc.nextLine());
			
			// Cadena vacía
			if (line.length()==0){
				System.out.println("Yes");
				continue;
			}
			
			// Cadena impar
			if (line.length()%2!=0) {
				System.out.println("No");
				continue;
			}
			
			// Recorre el string eliminando parejas de corchetes.
			int c = -1;
			while (line.length()>0 && c!=0){
				int j = 0; 
				c = 0;
				while (j<line.length()-1){
					if((line.charAt(j)=='(' && line.charAt(j+1)==')') || (line.charAt(j)=='[' && line.charAt(j+1)==']')){
						line.delete(j, j+2);
						c++;
					} else {
						j++;
					}
				}
			}
			
			// Si quedan corchetes no es correcto el string.
			if (line.length()>0) {
				System.out.println("No");
			} else {
				System.out.println("Yes");
			}
		}
		
		sc.close();
	}
}

// Expected Output:
// Yes
// No
// Yes