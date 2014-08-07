package uva.adhoc;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

class KindergartenCountingGame {

	public static void main(String[] args) throws FileNotFoundException  {
		//Scanner sc = new Scanner(new File("src/uva/adhoc/KindergartenCountingGame.in"));
		Scanner sc = new Scanner(System.in);
		
		/* Utilizamos la clase  PrintWriter en vez de utilizar directamente System.out.println
		 * ya que mejora notablemente el rendimiento (ya uque usa Buffers), hay problemas que nos dan timeLimitExceded por usar
		 * System.out.println... 
		*/
		PrintWriter out = new PrintWriter(System.out);
		
		while(sc.hasNextLine()){
			String st = sc.nextLine();
			
			/**
			 * Con esta expresion estoh haciendo dos cosas para Normalizar el string:
			 * 1) Reemplazar todo lo que no sean letras
			 * 3) Reemplazar todos los espacios dobles por un solo ejemplo "hola    mundo" quedaria "hola mundo"
			 * 
			 */
			st = st.replaceAll("(?i)[^a-z ]", " ").replaceAll(" +", " ").trim();

			/*Despues simplemente usamos split, que parte el string en pedazos creando un array
			utilizando el parametro " "(espacio) como separador. */
			out.println(st.split(" ").length);
		}
		
		 /*Hay que cerrar el out para que se vacie el buffer
		 Hay una sintaxis mejor para auto-cerrarlo usando try/catch, 
		 pero en estos problemas prefiero no tener muchos corchetes*/
		out.close();
		

	}

}
