public class TesteContas {
    public static void main(String[] args) {
        Conta conta = new Conta(1337,23334);

        conta.deposita(200.0);
        System.out.println("Saldo da Conta: "+ conta.getSaldo());

        conta.setAgencia(570);

        System.out.println("Agência: " + conta.getAgencia());
        System.out.println("O total de contas é : " + Conta.getTotal());
    }
}
