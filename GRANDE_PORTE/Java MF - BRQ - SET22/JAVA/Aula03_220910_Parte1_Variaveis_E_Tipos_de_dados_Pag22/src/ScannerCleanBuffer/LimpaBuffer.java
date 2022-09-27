package ScannerCleanBuffer;
import java.util.Scanner;

public class LimpaBuffer {




	    public static void main(String[] args) {
	        Scanner sc = new Scanner (System.in);

	        System.out.print("Digite o numero da conta: ");
	        int numero = sc.nextInt();
	        clearBuffer(sc);

	        System.out.print("Digite o nome do titular da conta: ");
	        String nome = sc.nextLine();

	        System.out.print("Você Deseja realizar um deposito inicial? [ S / N ]: ");
	        String op = sc.next();

	        if (op.equals("S")) {
	            System.out.print("Digite o Valor do deposito inicial: ");
	            int deposito = sc.nextInt();
	            clearBuffer(sc);
	            sc.close();
	        }
	    }

	    private static void clearBuffer(Scanner scanner) {
	        if (scanner.hasNextLine()) {
	            scanner.nextLine();
	        }
	    }
	}

