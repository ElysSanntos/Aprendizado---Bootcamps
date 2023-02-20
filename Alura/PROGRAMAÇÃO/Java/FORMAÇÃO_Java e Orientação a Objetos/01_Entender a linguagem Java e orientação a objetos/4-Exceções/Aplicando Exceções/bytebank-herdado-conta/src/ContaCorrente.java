public class ContaCorrente extends Conta implements Tributavel{

    public ContaCorrente(int agencia, int numero) {
        super(agencia, numero);
    }

    //Nova regra: Para saques em CC, o banco cobra uma taxa de 0,20c
    @Override
    public void saca(double valor) throws SaldoInsuficienteException {
        double valorASacar = valor + 0.2;
        super.saca(valorASacar);
    }

    @Override
    public double getValorImposto() {
        return super.getSaldo() * 0.01;
    }
}
