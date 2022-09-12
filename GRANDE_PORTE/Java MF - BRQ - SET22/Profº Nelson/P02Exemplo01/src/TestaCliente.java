public class TestaCliente {
	public static void main(String[] args) {
		Cliente c01 = new Cliente(10,"jose","111",8000.0);
		Cliente c02 = new Cliente();
		Cliente c03 = new Cliente(14,"maria","222");
		
		System.out.println(c01.getIdCliente());
		System.out.println(c01.getNomeCliente());
		System.out.println(c01.getCpfCliente());
		System.out.println(c01.getLimiteCliente());
	}
	

}