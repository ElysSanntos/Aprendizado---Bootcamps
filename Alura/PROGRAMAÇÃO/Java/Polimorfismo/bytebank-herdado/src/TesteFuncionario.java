public class TesteFuncionario {
    public static void main(String[] args) {
        Funcionario nico = new Funcionario();
        nico.setNome("Nico Nico");
        nico.setCpf("123.123.123-59");
        nico.setSalario(2600.00);

        System.out.println("Nome do Funcionario: " + nico.getNome());
        System.out.println("Bonificação: " + nico.getBonificacao());
    }
}
