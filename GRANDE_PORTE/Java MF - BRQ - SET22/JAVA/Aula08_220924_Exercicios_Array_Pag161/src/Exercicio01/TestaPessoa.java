package Exercicio01;

public class TestaPessoa {

	public static void main(String[] args) {
	
		Pessoa [] zePorva = new Pessoa [5];
		
		zePorva[0] = new Pessoa(1,"Jos� Pereira",1.65);
		zePorva[1] = new Pessoa(2,"Jos� Silva",1.75);
		zePorva[2] = new Pessoa(3,"Jos� Soares",1.85);
		zePorva[3] = new Pessoa(4,"Jos� Brasil",1.98);
		zePorva[4] = new Pessoa(5,"Jos� Santos",1.76);
		
		
		double media = Pessoa.mediaAltura(zePorva);
		double mediaFloor = Math.floor(Pessoa.mediaAltura(zePorva)*1000.0)/10000.0;
		
		System.out.println("M�dia de alturas sem tratamento: \t " + media);
		System.out.printf("M�dia de alturas Printf:\t\t %3.5f \n" , media);
		System.out.println("M�dia de alturas Math Floor:\t\t " + mediaFloor);

	}

}
