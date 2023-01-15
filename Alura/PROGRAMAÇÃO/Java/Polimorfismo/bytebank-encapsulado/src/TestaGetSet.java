public class TestaGetSet {

    public static void main(String[] args) {
        Conta conta = new Conta();

//        //Com o atributo numero alterado para privado, esse trecho de código não roda mais
//        conta.numero = 1334;
//        System.out.println(conta.numero);

        conta.setNumero(1337);
        System.out.println("Numero da conta: "+ conta.getNumero());


        Cliente paulo = new Cliente();
        //conta.titular = paulo;


        conta.setTitular(paulo);
        paulo.setNome("Elys Sanntos");
        paulo.setProfissao("Desenvolvedor");
        System.out.println("Nome do Titular: " + conta.getTitular().getNome());
        System.out.println("Nome do Titular: "+ conta.getTitular().getProfissao());


        System.out.println("*************************Código em duas linhas*******************************");

        Cliente titularDaConta = conta.getTitular();

        titularDaConta.setNome("Elys Sanntos");
        titularDaConta.setProfissao("Desenvolvedor");
        titularDaConta.setCpf("123.123.123-23");

        System.out.println(titularDaConta.getNome());
        System.out.println(titularDaConta.getProfissao());
        System.out.println(titularDaConta.getCpf());


        System.out.println("*************************Endereços de memória*******************************");

        System.out.println("Get Titular: titularDaConta     " + titularDaConta);
        System.out.println("Get Titular: paulo              " + paulo);
        System.out.println("Get Titular: conta.getTitular() " + conta.getTitular());

    }
}
