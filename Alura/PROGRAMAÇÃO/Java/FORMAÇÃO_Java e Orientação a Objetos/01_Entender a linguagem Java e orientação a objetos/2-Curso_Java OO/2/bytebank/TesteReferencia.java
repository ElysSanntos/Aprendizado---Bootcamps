public class TesteReferencia {

    public static void main(String[] args) {

        Conta primeiraConta = new Conta();
        primeiraConta.saldo = 300;

        System.out.println("Saldo 1ªConta" + primeiraConta.saldo);

        Conta segundaConta = primeiraConta;



    }
}
