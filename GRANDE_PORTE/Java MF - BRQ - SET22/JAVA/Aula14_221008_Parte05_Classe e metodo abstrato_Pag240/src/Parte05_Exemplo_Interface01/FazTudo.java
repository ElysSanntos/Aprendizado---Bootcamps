package Parte05_Exemplo_Interface01;

public class FazTudo {
	
	public void imprime(MetodosComuns m, int t, double a, double b) {
		m.imprimeLinha(t);
		m.calcula(a, b);
		System.out.println("Valor: " + m.calcula(a, b));
		m.imprimeLinha(t);
	}
	
	public void apertaPlay(InterfaceBotoes b) {
		b.play();
	}
	public void apertaStop(InterfaceBotoes b) {
		b.stop();
	}

	
}
