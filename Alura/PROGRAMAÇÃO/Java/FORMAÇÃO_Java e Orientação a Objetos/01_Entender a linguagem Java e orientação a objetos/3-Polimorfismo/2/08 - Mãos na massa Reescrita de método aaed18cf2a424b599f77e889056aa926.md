# 08 - Mãos na massa: Reescrita de método

Chegou a hora de você executar o que foi visto na aula! Para isso, execute os passos listados abaixo.

---

1) O gerente tem uma bonificação diferente, ele tem a bonificação de um funcionário comum mais um salário. Então, na classe **`Gerente`**, reescreva o método **`getBonificacao()`**.

2) Nesse método, reaproveite o método **`getBonificacao()`** da **superclasse**:

```
public double getBonificacao() {
    return super.getBonificacao();
}COPIAR CÓDIGO
```

3) Além disso, some um salário à bonificação atual. Para tal, acesse o método **`getSalario()`**, também pertencente à superclasse:

```
public double getBonificacao() {
    return super.getBonificacao() + super.getSalario();
}COPIAR CÓDIGO
```

4) Na classe **`TesteGerente`**, imprima ao final a bonificação do gerente e veja o resultado:

```
public class TesteGerente {

    public static void main(String[] args) {

        Gerente g1 = new Gerente();
        g1.setNome("Marco");
        g1.setCpf("235568413");
        g1.setSalario(5000.0);

        System.out.println(g1.getNome());
        System.out.println(g1.getCpf());
        System.out.println(g1.getSalario());

        g1.setSenha(2222);
        boolean autenticou = g1.autentica(2222);

        System.out.println(autenticou);

        System.out.println(g1.getBonificacao());
    }

}
```