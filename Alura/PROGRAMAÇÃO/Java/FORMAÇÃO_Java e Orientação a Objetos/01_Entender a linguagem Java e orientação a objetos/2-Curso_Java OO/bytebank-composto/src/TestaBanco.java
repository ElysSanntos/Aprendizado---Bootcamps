public class TestaBanco {
    public static void main(String[] args) {


           //Criando a referencia para a classe cliente e populando os dados
            Cliente paulo = new Cliente();

            paulo.nome = "Paulo Silveira";
            paulo.cpf = "222.222.222-22";
            paulo.profissao = "programador";


            //Crinado a conta conta do cliente e add saldo
            Conta contaDoPaulo = new Conta();
            contaDoPaulo.deposita(100);

            //Essa linha compoe os objetos : Linka a classe testa banco com a classe cliente.
            contaDoPaulo.titular = paulo;

            System.out.println("Nome do Cliente: "+ contaDoPaulo.titular.nome);
            System.out.println("Endereço na mémoria para a classe Conta: "+ contaDoPaulo);


    }
    }
