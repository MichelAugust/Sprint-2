package EmotionsFrase;

public class Frase {

	private int divertido;
	private int chateado;

	public void analisa(String frase) {
		for (int i = 0; i < frase.length(); i++) {
			if (frase.charAt(i) == ':' && frase.charAt(i + 1) == '-' && frase.charAt(i + 2) == ')') {
				divertido++;
			}
			if (frase.charAt(i) == ':' && frase.charAt(i + 1) == '-' && frase.charAt(i + 2) == '(') {
				chateado++;
			}
		}
	}

	public void Resultado() {
		if (divertido > chateado) {
			System.out.println("divertido");
		} else if (chateado > divertido) {
			System.out.println("chateado");
		} else {
			System.out.println("neutro");
		}
	}
}
