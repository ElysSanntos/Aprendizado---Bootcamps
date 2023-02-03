public class Conta {

    private double saldo;
    int agencia;
    int numero;
    // Para vincular a conta ao cliente, alteramos o tipo String, pelo tipo Cliente
    Cliente titular;

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
}
