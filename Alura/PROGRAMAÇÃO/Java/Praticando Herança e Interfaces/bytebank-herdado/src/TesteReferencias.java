public class TesteReferencias {
    public static void main(String[] args) {
        Funcionario g1 = new Gerente();

        g1.setNome("Marcos");
        g1.setSalario(5000.0);

        String nome = g1.getNome();


        EditorVideo ev = new EditorVideo();
        ev.setNome("Oswaldo");
        ev.setSalario(2500.0);

        Designer designer = new Designer();
        designer.setNome("Maria");
        designer.setSalario(2000.0);

        ControleBonificacao controle = new ControleBonificacao();
        controle.registra(g1);
        controle.registra(ev);
        controle.registra(designer);


        System.out.println();

        System.out.println("Nome do Gerente: " + nome);
        System.out.println("Sálario do Generate: " + g1.getSalario());


        System.out.println();


        System.out.println("Nome do Editor Video: " + ev.getNome());
       System.out.println("Sálario do Editor Video: " + ev.getSalario());


        System.out.println();

        System.out.println("Nome do Designer: " + designer.getNome());
        System.out.println("Sálario do Designer: " + designer.getSalario());

        System.out.println();

        System.out.println("Soma das bonificações " + controle.getSoma());

    }
}



