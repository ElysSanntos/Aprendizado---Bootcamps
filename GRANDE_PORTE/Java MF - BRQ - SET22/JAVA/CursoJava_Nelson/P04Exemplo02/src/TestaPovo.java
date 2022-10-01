public class TestaPovo {
	public static void main(String[] args) {
		Pessoa p = new Pessoa(1,"Adilson");
		p.setTime("São Paulo Futebol Clube");
		p.imprimeDados();
		//-------------------------------
		Funcionario f = new Funcionario(2,"Sinomar",212,"Analista");
		f.imprimeDados();
		//-------------------------------
		Gerente g = new Gerente(3,"Marcelo",432,"Gerente","Marketing");
		g.imprimeDados();
	}
}