public class BarMerindus {
	public static void main(String[] args) {
		ContaCorrente c1 = new ContaCorrente();
		ContaCorrente c2 = new ContaCorrente(121,1000.0);
		
		c1.setNumCC(212);
		c1.depositar(500.0);
		c1.sacar(100.0);
		c2.sacar(300.0);

		/* 
		System.out.println("numCC   = " + c1.getNumCC());
		System.out.println("saldoCC = " + c1.getSaldoCC());
		System.out.println("numCC   = " + c2.getNumCC());
		System.out.println("saldoCC = " + c2.getSaldoCC());
		*/
		
		c1.imprimeCC();
		c2.imprimeCC();
	}
}