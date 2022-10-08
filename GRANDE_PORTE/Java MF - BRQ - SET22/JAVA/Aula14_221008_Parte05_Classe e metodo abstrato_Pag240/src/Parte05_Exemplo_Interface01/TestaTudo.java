package Parte05_Exemplo_Interface01;

public class TestaTudo {

		public static void main(String[] args) {

			FazTudo ze =new FazTudo();
			Robo t1 = new Robo("Tesla Optimus");
			MaquinaDeLavarRoupas m1 = new MaquinaDeLavarRoupas("Brastemp  new white");
			Funcionario f = new Funcionario(22,"Bolsonaro Mito", "CFO");
			
			ze.apertaPlay(t1);
			ze.apertaPlay(m1);
			//ze.apertaPlay(f); //Não assinou o contrato de botões
			ze.apertaStop(t1);
			ze.imprime(t1, 2, 100, 20);
			//ze.imprime(m1, 2, 100, 20); // maquina não implementou métodos comuns
			ze.imprime(f, 2, 160, 55);
	}

}
