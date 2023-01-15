public class Conta {

    // atributos// método deposita// método saca// método transfere// getSaldo// método getNumero //
    private double saldo;
    private int agencia;
    private int numero;

    private static int total;

    public Conta(){
        System.out.println("Sou um contrutor padrão , e estou criando uma nova Conta().");
        System.out.println();
    }

    public Conta(int numero, int agencia){

        this.numero = numero;
        this.agencia = agencia;

        System.out.println("Sou um contrutor com parametros , " +
                "e estou criando uma nova Conta(), com dados de agencia e numero inicializados"
        + "\nNumero: " + this.numero + "\nAgência: " + this.agencia);
        System.out.println();
    }

    // Para vincular a conta ao cliente, alteramos o tipo String, pelo tipo Cliente
    private  Cliente titular;


    public void deposita(double valor){
        this.saldo += valor;

    }

    public boolean saca(double valor){
        if(this.saldo >= valor){
            this.saldo -=valor;
            return  true;
        }else{
            return false;
        }

    }

    public boolean transfere(double valor, Conta destino){
        if (this.saldo >= valor){
            this.saldo -= valor;
            //destino.saldo +=valor;
            destino.deposita(valor);
            return true;
        }
        return false;
    }

   public double getSaldo(){

        return  this.saldo;

    }

    public int getNumero(){
        return  this.numero;
    }

    public void setNumero(int novoNumero) {
        if (novoNumero <= 0){
            System.out.println("Valor informado para o número é menor ou igual a Zero");
            return;
        }
        this.numero = novoNumero;
    }

    public int getAgencia(){

        return this.agencia;
    }

    public void setAgencia(int agencia){
        if (agencia <= 0){
            System.out.println("Valor informado para a agencia é, menor ou igual a Zero");
            return;
        }

        this.agencia = agencia;

    }

    public void setTitular(Cliente titular) {
        this.titular = titular;
    }

    public Cliente getTitular() {
        return titular;
    }

    public static int getTotal(){
        return Conta.total;
    }
}

