import java.util.Random;
import java.util.Scanner;

public class Utils {
	
	static Scanner leia = new Scanner(System.in);
	
	public static char recebeChar(String texto) {
		System.out.println(texto);
		return leia.next().charAt(0);
	}
	
	public static String recebeString(String texto) {
		System.out.println(texto);
		return leia.nextLine();
	}
	
	public static int recebeInt(String texto) {
		System.out.println(texto);
		return leia.nextInt();
	}
	
	public static void limparBuffer() {
		leia.nextLine();
	}
	
	public static int valorAleatorio(int minimo, int maximo) {
		Random random = new Random();
		return random.nextInt((maximo - minimo) + 1) + minimo;
	}
}
