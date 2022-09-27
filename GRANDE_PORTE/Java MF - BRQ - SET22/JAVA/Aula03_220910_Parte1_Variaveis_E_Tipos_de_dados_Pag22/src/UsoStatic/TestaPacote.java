package UsoStatic;

public class TestaPacote {

	public static void main(String[] args) {
		 // criando quatro pacotes
		 Pacote p1 = new Pacote();
		 Pacote p2 = new Pacote();
		 Pacote p3 = new Pacote();
		 Pacote p4 = new Pacote();
		 
		 // exibindo seus atributos
		 System.out.println("p1 => "+p1.getProximoId()+" => "+p1.getIdPacote());
		 System.out.println("p2 => "+p2.getProximoId()+" => "+p2.getIdPacote());
		 System.out.println("p3 => "+p3.getProximoId()+" => "+p3.getIdPacote());
		 System.out.println("p4 => "+p4.getProximoId()+" => "+p4.getIdPacote());
		 }
	}


