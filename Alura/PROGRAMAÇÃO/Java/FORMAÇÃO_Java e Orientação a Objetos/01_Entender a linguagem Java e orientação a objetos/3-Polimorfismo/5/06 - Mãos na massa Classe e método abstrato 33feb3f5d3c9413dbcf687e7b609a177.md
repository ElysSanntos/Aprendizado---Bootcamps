# 06 - Mãos na massa: Classe e método abstrato

1) Volte ao projeto **bytebank-herdado** das últimas aulas, onde foi trabalhado a questão de funcionários

2) Transforme a classe **Funcionario** em abstrata, utilizando a palavra reservada **abstract**, veja abaixo:

```
public abstract class Funcionario{

    //conteúdo da classe

}
COPIAR CÓDIGO
```

3) Repare que agora não conseguimos mais criar um objeto do tipo **Funcionário**, que agora é abstrato! Corrija o código onde for preciso e crie um `Gerente` ou outro funcionário concreto.

4) Na classe `Funcionario` declare o método **getBonificacao** como abstrato para garantir que ele seja implementado pelas classes filhas. O código deve ficar assim:

```
//método sem corpo, não há implementação
public abstract double getBonificacao();
COPIAR CÓDIGO
```

5) Agora cada classe filha deve implementar seu próprio método **getBonificacao**. Veja se tudo está compilando e teste seu código!

6) Rode suas classes de teste, fique atento ao erros de compilação.