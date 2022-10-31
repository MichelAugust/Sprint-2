package EmotionsFrase;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Frase frase = new Frase();
		frase.analisa(sc.nextLine());
		frase.Resultado();
		sc.close();
	}

}
