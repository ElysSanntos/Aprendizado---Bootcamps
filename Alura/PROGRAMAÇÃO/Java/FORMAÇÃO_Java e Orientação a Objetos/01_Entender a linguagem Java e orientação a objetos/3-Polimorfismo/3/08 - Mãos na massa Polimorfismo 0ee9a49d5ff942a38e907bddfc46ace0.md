# 08 - Mãos na massa: Polimorfismo

Chegou a hora de você executar o que foi visto na aula! Para isso, execute os passos listados abaixo.

---

1) Para controlar a bonificação dos funcionários, crie a classe **`ControleBonificacao`** com o atributo privado **`soma`**, do tipo **double**, e seu *getter*.

2) Nessa classe, crie o método **`registra`**, que recebe um **`Funcionario`** por parâmetro, pega a sua bonificação, e em seguida a soma com as outras bonificações. E, crie também o método **`getSoma`** para retornar o valor do atributo **`soma`**:

```
public void registra(Funcionario f) {
    double boni = f.getBonificacao();
    this.soma = this.soma + boni;
}

public double getSoma() {
    return this.soma;
}COPIAR CÓDIGO
```

3) Para testar, crie dois novos funcionários, ou seja, duas novas classes, com bonificações diferentes. Por exemplo, a classe **`EditorVideo`** com bonificação de R$150 e a classe **`Designer`**, com bonificação de R$200.

4) E crie a classe **`TesteReferencias`**, onde você instancia funcionários diferentes, registra suas bonificações e visualiza a sua soma:

```
public class TesteReferencias {

    public static void main(String[] args) {

        Gerente g1 = new Gerente();
        g1.setNome("Marcos");
        g1.setSalario(5000.0);

        EditorVideo ev = new EditorVideo();
        ev.setSalario(2500.0);

        Designer d = new Designer();
        d.setSalario(2000.0);

        ControleBonificacao controle = new ControleBonificacao();
        controle.registra(g1);
        controle.registra(ev);
        controle.registra(d);

        System.out.println(controle.getSoma());

    }

}
```

A classe **`ControleBonificacao`** ficará assim:

```
public class ControleBonificacao {

    private double soma;

    public void registra(Funcionario f) {
        this.soma += f.getBonificacao();
    }

    public double getSoma() {
        return soma;
    }

}
```