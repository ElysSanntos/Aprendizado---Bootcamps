public class TestaSacaNegativo {
    public static void main(String[] args) {
        Conta conta = new Conta();

        conta.deposita(100);

        System.out.println("Posso deixar a conta com saldo negativo? " + conta.saca(200));

//        //Antes do atributo saldo se tornar privado, podemos acessa-lo diretamente.
//        conta.saldo = conta.saldo - 101;



        System.out.println("Saldo private "+ conta.getSaldo());
    }
}
