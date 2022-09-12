public class Cliente {
	// variáveis de instâncias
	private int    idCliente;
	private String nomeCliente;
	private String cpfCliente;
	private double limiteCliente = 5000.0;
	
	public int getIdCliente() {
		return idCliente;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public String getCpfCliente() {
		return cpfCliente;
	}

	public double getLimiteCliente() {
		return limiteCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public void setCpfCliente(String cpfCliente) {
		this.cpfCliente = cpfCliente;
	}

	public void setLimiteCliente(double limiteCliente) {
		this.limiteCliente = limiteCliente;
	}

	public Cliente() {
	}

	public Cliente(int idCliente, String nomeCliente, String cpfCliente) {
		this.idCliente = idCliente;
		this.nomeCliente = nomeCliente;
		this.cpfCliente = cpfCliente;
	}

	public Cliente(int idCliente, String nomeCliente, String cpfCliente, double limiteCliente) {
		this.idCliente = idCliente;
		this.nomeCliente = nomeCliente;
		this.cpfCliente = cpfCliente;
		this.limiteCliente = limiteCliente;
	}

	// métodos
	public void exibeLimite() {
		System.out.println("limite = " + limiteCliente);
	}
}