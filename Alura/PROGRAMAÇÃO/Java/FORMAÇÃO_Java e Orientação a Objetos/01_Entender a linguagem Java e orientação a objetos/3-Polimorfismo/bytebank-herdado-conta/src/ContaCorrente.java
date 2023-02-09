public class ContaCorrente extends Conta{

    public ContaCorrente(int agencia, int numero) {
        super(agencia, numero);
    }

    //Nova regra: Para saques em CC, o banco cobra uma taxa de 0,20c
    @Override
    public boolean saca(double valor) {
        double valorASacar = valor + 0.2;
        return super.saca(valorASacar);
    }
}
