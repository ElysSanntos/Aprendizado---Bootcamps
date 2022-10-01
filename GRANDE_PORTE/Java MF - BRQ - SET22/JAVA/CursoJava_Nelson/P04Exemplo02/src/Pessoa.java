public class Pessoa {
	protected int id;
	protected String nome;
	private String time;
	
	public Pessoa() {}
	           //    (3,"Marcelo"
	public Pessoa(int id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	public int getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public String getTime() {
		return time;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	protected void imprimeDados() {
		System.out.println("id.........:"+id);
		System.out.println("nome.......:"+nome);
	}
}
