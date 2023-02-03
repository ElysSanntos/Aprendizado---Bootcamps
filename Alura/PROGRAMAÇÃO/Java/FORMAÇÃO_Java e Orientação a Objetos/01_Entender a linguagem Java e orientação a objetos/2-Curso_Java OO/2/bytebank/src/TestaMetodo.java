public class TestaMetodo {
    public static void main(String[] args) {
        Conta contaDaElys = new Conta();
        contaDaElys.saldo = 100;
        contaDaElys.deposita(100);

        Conta contaDoCleiton = new Conta();
        contaDoCleiton.deposita(1500);


        System.out.println("Saldo Conta da Elys: R$ "+ contaDaElys.saldo);


        boolean conseguiuRetirar = contaDaElys.saca(20);
        System.out.println("Consegiu sacar Elys? " + conseguiuRetirar);
        System.out.println("Elys, seu saldo após saque: R$"+ contaDaElys.saldo);

            System.out.println("Saldo Conta do Cleiton: R$ "+ contaDoCleiton.saldo);

            if(contaDoCleiton.transfere(300,contaDaElys)){

                System.out.println("Transferencia realizada com sucesso");
        }else{
                System.out.println("Verifique seu saldo");
            }

            System.out.println("Saldo da Conta do Cleiton após transferencia R$ " + contaDoCleiton.saldo);
            System.out.println("Saldo da Conta do Elys após  receber a transferencia R$ " + contaDaElys.saldo);


        System.out.println("Consegiu sacar? " + conseguiuRetirar);
        System.out.println("Saldo após saque: R$"+ contaDoCleiton.saldo);

        contaDoCleiton.titular = "Cleiton Peres";
        System.out.println(contaDoCleiton.titular);

    }
}
