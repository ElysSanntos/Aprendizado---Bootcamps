public class CriaConta {
    public static void main(String[] args) {

        Conta primeiraConta = new Conta();
        primeiraConta.saldo = 200;

        System.out.println("Saldo 1ªConta: "+ primeiraConta.saldo);

       primeiraConta.saldo +=100;
        System.out.println("Saldo 1ªConta com depósito: "+primeiraConta.saldo);


        Conta segundaConta = new Conta();
        segundaConta.saldo = 300;

        System.out.println("1ªConta tem saldo: "+ primeiraConta.saldo);
        System.out.println("2ªConta tem saldo: "+ segundaConta.saldo);

        primeiraConta.agencia = 146;
        System.out.println("1ªConta nº: "+ primeiraConta.numero);
        System.out.println("1ªConta AG: "+primeiraConta.agencia);

        System.out.println("**************************************************************************");

        segundaConta.agencia = 146;
        System.out.println("2ªConta nº: "+ segundaConta.numero);
        System.out.println("2ªConta AG: "+ segundaConta.agencia);

        System.out.println("**************************************************************************");

        if (primeiraConta == segundaConta){
            System.out.println("As contas é a mesma.");
        }else{
            System.out.println("As contas são  diferentes!");
        }

        System.out.println("Indica que é uma referência para um objeto do tipo Conta: "+ primeiraConta);
        System.out.println("Indica que é uma referência para um objeto do tipo Conta: "+ segundaConta);

    }
}