package Parte2;

public class TestaCliente {

	public static void main(String[] args) {

		
// criando objetos sem referencia
	 new Cliente();
	 
// criando objetos com referência
	Cliente cliente1 = new Cliente();
	cliente1.idCliente = 1;
	cliente1.cpfCliente = "111.111.111-22";
	cliente1.limiteCliente = 1000.0;
	cliente1.nomeCliente = "Elys Sanntos";
	
// criando a referência e depois o objeto
	Cliente cliente2;
	cliente2 = new Cliente();
	
	//Criando objeto com construtor
		Cliente cliente3 = new Cliente(3,"Jose Silva","333.333.333-59",8000.0);
		
		
//Obj instanciado sem referencia é coletado pelo Garbage Collector
	//System.out.println("Endereço em Hexa: " + Cliente);
	System.out.println("Endereço em Hexa do Cliente 1: " + cliente1);
	System.out.println("Endereço em Hexa do Cliente 2: " + cliente2);
	System.out.println("Endereço em Hexa do Cliente 3: " + cliente3);
	

	


	//Perdendo a referencia do obj cliente2, se perde a referencia é coletado.	
		//cliente2 = cliente1;
		//System.out.println("Endereço em Hexa do Cliente 1: " + cliente1);
		//System.out.println("Endereço em Hexa do Cliente 2: " + cliente2);
		//System.out.println("Endereço em Hexa do Cliente 3: " + cliente3);
			
	
//Chamando o método	
	System.out.println("========================================================");
	
	System.out.println("Cliente1: " + cliente1.nomeCliente);	
	cliente1.exibeLimite();
	System.out.println("===========================================");
	
	System.out.println("Cliente2: "  + cliente2.nomeCliente);
	cliente2.exibeLimite();
	
	System.out.println("===========================================");
	
	System.out.println("Cliente3: " + cliente3.getNomeCliente());
	cliente3.exibeLimite();
	
	System.out.println("===========================================");
	
	System.out.println("Metodo dobra: " +cliente1.dobra(8));
	

	}	

}


