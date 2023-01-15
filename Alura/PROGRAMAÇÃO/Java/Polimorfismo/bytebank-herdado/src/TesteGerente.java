public class TesteGerente {
    public static void main(String[] args) {
        Gerente g1 = new Gerente();
        g1.setNome("Genildo Silva");
        g1.setCpf("123456789");
        g1.setSalario(5000.0);

        System.out.println("Nome: " + g1.getNome());
        System.out.println("CPF: " +g1.getCpf());
        System.out.println("Sálario R$ " +g1.getSalario());

        g1.setSenha(2222);
        boolean autenticou = g1.autentica(2222);
        System.out.println("A senha esá correta? " + autenticou);
    }
}
