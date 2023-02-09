public class TesteReferencias {
    public static void main(String[] args) {
        Funcionario g1 = new Gerente();

        g1.setNome("Marcos");
        g1.setSalario(5000.0);

        String nome = g1.getNome();

        Funcionario funcionario = new Funcionario();
        funcionario.setNome("Jair");
        funcionario.setSalario(2000.0);

        EditorVideo ev = new EditorVideo();
        ev.setNome("Oswaldo");
        ev.setSalario(2500.0);

        Designer designer = new Designer();
        ev.setNome("Maria");
        ev.setSalario(2000.0);

        ControleBonificacao controle = new ControleBonificacao();
        controle.registra(g1);
        controle.registra(funcionario);
        controle.registra(ev);
        controle.registra(designer);



        System.out.println("Nome do Gerente: " + nome);
        System.out.println("Sálario do Gerente: " + g1.getSalario());
        System.out.println("Bonificação do Gerente: " + controle.getSoma());

        System.out.println();

        System.out.println("Nome do Funcionário: " + funcionario.getNome());
        System.out.println("Sálario do Funcionário: " + funcionario.getSalario());
        System.out.println("Bonificação do Funcionário: " + controle.getSoma());

        System.out.println();

        System.out.println("Nome do Editor Video: " + ev.getNome());
        System.out.println("Sálario do Editor Video: " + ev.getSalario());
        System.out.println("Bonificação do Editor Video: " + controle.getSoma());



    }
}



