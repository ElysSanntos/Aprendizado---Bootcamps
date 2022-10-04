package Exercicio01;

public class TestaPessoa {

	public static void main(String[] args) {
	
		Pessoa [] zePorva = new Pessoa [5];
		
		zePorva[0] = new Pessoa(1,"José Pereira",1.65);
		zePorva[1] = new Pessoa(2,"José Silva",1.75);
		zePorva[2] = new Pessoa(3,"José Soares",1.85);
		zePorva[3] = new Pessoa(4,"José Brasil",1.98);
		zePorva[4] = new Pessoa(5,"José Santos",1.76);
		
		
		double media = Pessoa.mediaAltura(zePorva);
		double mediaFloor = Math.floor(Pessoa.mediaAltura(zePorva)*1000.0)/10000.0;
		
		System.out.println("Média de alturas sem tratamento: \t " + media);
		System.out.printf("Média de alturas Printf:\t\t %3.5f \n" , media);
		System.out.println("Média de alturas Math Floor:\t\t " + mediaFloor);

	}

}
