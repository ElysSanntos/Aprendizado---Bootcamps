package Parte2;

public class Cliente {

//Variaveis de classe -- Fica apenas na classe e tem por obrigatoriedade a palavra static
	public static int numero;

// atributos
// Variaveis de instancia -- Aparecem na classe	
	public int idCliente;
	public String nomeCliente;
	public String cpfCliente;
	public double limiteCliente;

//Construtor Default
	public Cliente() {
	}

//Construtor
//Apertando CTRL + 3 e digitando gcuf

	public Cliente(int idCliente, String nomeCliente, String cpfCliente, double limiteCliente) {

		this.idCliente = idCliente;
		this.nomeCliente = nomeCliente;
		this.cpfCliente = cpfCliente;
		this.limiteCliente = limiteCliente;
	}

//Getters e Setters	
// apertar CTRL + 3 e vamos digitar ggas para gerar os Getters e Setters 			

	public static int getNumero() {
		return numero;
	}

	public static void setNumero(int numero) {
		Cliente.numero = numero;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getCpfCliente() {
		return cpfCliente;
	}

	public void setCpfCliente(String cpfCliente) {
		this.cpfCliente = cpfCliente;
	}

	public double getLimiteCliente() {
		return limiteCliente;
	}

	public void setLimiteCliente(double limiteCliente) {
		this.limiteCliente = limiteCliente;
	}

	public double dobra(int n) {
		double d = 2.0 * n;
		return d;
	}

// métodos
	public void exibeLimite() {
		System.out.println("Limite R$" + limiteCliente);

		double limite = 100.0;
		if (limiteCliente > limite) {
			viva();
		} else {
			System.out.println("Seu limite é inferior ao desejado!");

		}

	}

	private void viva() {
		System.out.println("Vivaaa, seu limite é maior que R$ 100,00");
	}

	public int maior(int a, int b) {

		if (a > b)
			return a;

		return b;
	}
}
