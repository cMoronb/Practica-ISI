// javac 
// javac -cp .:../../hamcrest-core-1.3.jar:../../junit-4.12.jar AllTests.java
// java -cp .:../../hamcrest-core-1.3.jar:../../junit-4.12.jar AllTests
import java.util.Scanner;

public class RomanNumeral {
// Parámetro: s es un número romano.
// Devuelve : s en base 10
//No se especifica qué ocurre si el número no es romano


//Si a la derecha de una cifra romana se escribe otra igual o menor, el valor de ésta se suma a la anterior.
//Si un símbolo está a la izquierda inmediata de otro de mayor valor, se resta al valor del segundo el valor del primero.
//Se permiten a lo sumo tres repeticiones consecutivas del mismo símbolos I, X y C.
//No se permite la repetición de una misma símbolos V, L y D. (Muchos relojes el uso de IIII para el numeral 4, en lugar del correcto IV.)
//La cifra I colocada delante de la V o la X, les resta una unidad; la X, precediendo a la L o a la C, les resta diez unidades y la C, delante de la D o la M, les resta cien unidades.


	private int valueFromRoman(char c){
		int val;

		val = 0;

		switch(c){
		case 'I': val = 1;
			break;
		case 'V': val = 5;
			break;
		case 'X': val = 10;
			break;
		case 'L': val = 50;
			break;
		case 'C': val = 100;
			break;
		case 'D': val = 500;
			break;
		case 'M': val = 1000;
			break;
		default: val = 0;
			break;
		}
		return val;
	}

	public int convierte(String s){
		char charActual, charAnt;
		int total, rep;
		charActual = 'Z';
		charAnt = 'Z';

		if (s == null){
			return -1;
		}
		
		s = s.toUpperCase();

		total = 0;
		rep = 1;
		for (int n = s.length()-1 ; n>=0; n--){
			char c = s.charAt (n); 
//			System.out.println (valueFromRoman(c));
			if(n!=s.length()-1){
				charAnt = charActual;
				charActual = c;
			}else{
				charActual = c;
				charAnt = c;
				rep = 0;
			}

			if(valueFromRoman(charActual) >= valueFromRoman(charAnt)){
				total = total + valueFromRoman(charActual);
			}else{
				total = total - valueFromRoman(charActual);
			}

			if(valueFromRoman(charActual) == valueFromRoman(charAnt)){
				rep = rep + 1;
			}else{
				rep = 1;
			}

			if(rep > 3){
				System.out.println("El número introducido no es válido: Demasiadas repeticiones de una letra");
				return -1; //System.exit(1);
			}else if(rep > 1 && (charActual == 'V' || charActual == 'L' || charActual == 'D')){
				System.out.println("El número introducido no es válido: V,L o D repetido");
				return -1;
			}

			if( charActual == 'I' && charAnt != 'V' && charAnt != 'X' && charAnt != 'I'){
				System.out.println("Posición errónea en las letras");
				return -1;
			}else if( charActual == 'X' && (charAnt == 'D' || charAnt == 'M') ){
				System.out.println("Posición errónea en las letras");
				return -1;
			}
//			System.out.println("La cuenta va en: " + total);
		}
		
		return total;
	}

	public static void main(String[] args){
//		String str = "MCDLXXIIX";
//		String str = "MCDLXIVV"; //1464
		System.out.print("Enter a RomanNumber: ");
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		RomanNumeral rn = new RomanNumeral();
		System.out.println("El número es: " + rn.convierte(input));
	}
}
