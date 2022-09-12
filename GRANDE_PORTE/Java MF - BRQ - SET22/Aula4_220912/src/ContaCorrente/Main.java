package ContaCorrente;

public class Main {

	public static void main(String[] args) {
		ContaCorrente cc1= new ContaCorrente(121,1000.0);
		ContaCorrente cc2 = new ContaCorrente();
		
		cc1.depositar(100.0);
		cc2.setNumCC(223);
		cc2.setSaldoCC(80.0);
		
		
		cc1.imprimeCC();
		cc2.imprimeCC();
		
		cc1.sacar(60.0);
		cc1.imprimeCC();
		
		cc2.depositar(196.32);
		cc2.imprimeCC();

	}

}
