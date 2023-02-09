public class TestaContaSemCliente {

    public static void main(String[] args) {
        Conta contaDaMarcela = new Conta();


        System.out.println("*********************************Teste 1******************************");

//        System.out.println("Saldo da Marcela: " + contaDaMarcela.saldo);
//
//        //Aqui temos o erro: Exception in thread "main" java.lang.NullPointerException
//        //O NUll seria uma referencia para lugar nenhum.
//        System.out.println("O que tem dentro de titular? "+ contaDaMarcela.titular);
//
//        contaDaMarcela.titular.nome = "Marcela Silva";
//
//        System.out.println(contaDaMarcela.titular.nome);






        System.out.println("*********************************Teste 2******************************");

        contaDaMarcela.titular = new Cliente();

        contaDaMarcela.titular.nome = "Marcela Silva";
        System.out.println("O que tem dentro de titular? "+ contaDaMarcela.titular);
        System.out.println("Nome do Titular: "+ contaDaMarcela.titular.nome);
        System.out.println("Saldo da Marcela: " + contaDaMarcela.getSaldo());



    }



}
