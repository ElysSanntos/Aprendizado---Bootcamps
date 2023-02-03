public class TestaReferencia {

    public static void main(String[] args) {

        Conta primeiraConta = new Conta();
        primeiraConta.saldo = 300;

        System.out.println("Saldo 1ªConta: " + primeiraConta.saldo);

        Conta segundaConta = primeiraConta;
        System.out.println("Saldo 2ªConta: " + segundaConta.saldo);

        segundaConta.saldo +=100;
        System.out.println("Saldo 2ªConta com deposito: " + segundaConta.saldo);

        System.out.println("Saldo 1ªConta depois do deposito realizado pela 2ªConta: " + primeiraConta.saldo);

        segundaConta.agencia = 146;
        System.out.println("Agora a segunda conta está na agência: " + segundaConta.agencia);

    if(primeiraConta == segundaConta){

        System.out.println("Mesma conta");
    }else{
        System.out.println("Contas diferentes");
    }

        System.out.println("Indica que é uma referencia para um objeto do tipo Conta: "+ primeiraConta);
        System.out.println("Indica que é uma referencia para um objeto do tipo Conta: "+ segundaConta);

    }
}
