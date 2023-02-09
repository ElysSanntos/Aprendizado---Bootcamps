public class TestaValores {
    public static void main(String[] args) {
        System.out.println("******************Criando Conta com Contrutor SEM parametros****************");
        System.out.println();
        Conta conta = new Conta();

        // A conta está inconsistente quanto a regra de negócio
        conta.setNumero(-330);
        conta.setAgencia(-50);

        //Toda conta nasce com valor zero, e agora?
        System.out.println("Agência: "+ conta.getAgencia());


        System.out.println();
        System.out.println("******************Criando Conta COM Contrutor com parametros****************");
        System.out.println();

        Conta conta1 = new Conta(102030,302010);

        System.out.println("Número: "+ conta1.getNumero());
        System.out.println("Agência: "+ conta1.getAgencia());

    }
}
