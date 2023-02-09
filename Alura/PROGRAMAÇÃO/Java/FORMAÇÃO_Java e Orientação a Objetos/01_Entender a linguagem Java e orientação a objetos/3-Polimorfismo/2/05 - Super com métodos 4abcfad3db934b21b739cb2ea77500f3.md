# 05 - Super com métodos

Daremos continuidade ao aprendizado da herança, falando ainda sobre o método `getBonificacao()`.

Até o momento, tratamos de aspectos bastante conceituais e escrevemos, de fato, poucas linhas de código. Este conceito que estamos aprendendo serve para outras linguagens, por exemplo C#, Python e Ruby, todas trabalham com a herança.

Temos um problema agora - nosso chefe solicitou a alteração da bonificação do gerente, ela passará a ser o valor padrão para os funcionários, mais um salário inteiro do próprio gerente.

A bonificação padrão de todos os funcionários está na classe `Funcionario`:

```
public class Funcionario {

        private String nome;
        private String cpf;
        protected double salario;

        public double getBonificacao() {
            return this.salario * 0.1;
        }

//Código omitidoCOPIAR CÓDIGO
```

Nosso primeiro passo será então passar este cálculo dos 10% do salário para dentro do método `getBonificacao()`, dentro da classe `Gerente`:

```
public class Gerente extends Funcionario {

        private int senha;

        public void setSenha(int senha) {
            this.senha = senha;
        }

        public boolean autentica(int senha) {
            if(this.senha == senha) {
                return true;
            } else {
                return false;
            }
        }

        public double getBonificacao() {
            return (this.salario * 0.1) + super.salario;
        }
}COPIAR CÓDIGO
```

Assim, podemos realizar um teste, utilizando a classe `TesteGerente`, da forma como está, iremos executá-la. Vemos no console:

```
Marco
235568413
5000.0
true
5500.0COPIAR CÓDIGO
```

Temos o valor correto da bonificação, ou seja, 10% do salário, R$ 500,00, mais um salário integral, R$ 5.000,00. Isso significa que nosso método funcionou.

E se a regra geral de bonificação dos funcionários mudasse? E se passasse a ser 5% do salário? Teríamos que fazer essa alteração, também, na classe `Gerente`, e se esquecêssemos, a regra antiga continuaria vigente. Não é uma boa prática de programação repetirmos código, quando algo já foi implementado na classe super.

A ideia é reaproveitarmos o método da super classe para os herdeiros.

Para isso, utilizaremos a palavra `super`, indicando que queremos acessar algo definido na classe mãe. Ao digitarmos `super.` o Eclipse nos mostra o atributo `protected`, e também os métodos `getBonificacao()` e `getSalario()`. Ou seja, isso nos permite chamar a implementação padrão da classe `Funcionario`.

Assim, reaproveitamos a implementação padrão e, se algo for alterado no método na classe `Funcionario`, automaticamente, isso será refletido para a classe `Gerente`.

Testaremos isso, executando a classe `TesteGerente`. Como havíamos alterado a regra de bonificação para 5%, temos o seguinte resultado no console:

```
Marco
235568413
5000.0
true
5250.0COPIAR CÓDIGO
```

O que indica que nosso código está funcionando.

Neste caso, somos obrigados a utilizar o `super`, indicando que queremos utilizar, especificamente, o método que está definido na classe mãe. Se utilizarmos o `this`, a execução entrará em um loop infinito, e resultará em erro.

Retornaremos à classe `Funcionario`, só que agora não iremos mais utilizar o `protected`, no dia a dia este modificador de visibilidade é pouco utilizado, é mais comum que os atributos permaneçam privados.

Há outro meio pelo qual podemos obter o `salario` de `Funcionario`, que é utilizando os métodos. Assim, na classe `Gerente`, em vez de acessarmos `salario` diretamente, acessaremos `getSalario()`:

```
public class Gerente extends Funcionario {

        private int senha;

        public void setSenha(int senha) {
            this.senha = senha;
        }

        public boolean autentica(int senha) {
            if(this.senha == senha) {
                return true;
            } else {
                return false;
            }
        }

        public double getBonificacao() {
            return super.getBonificacao() + super.getSalario();
        }
}COPIAR CÓDIGO
```

Assim não é necessário mexermos na visibilidade, podemos manter tudo privado.

Não é necessário utilizarmos o `protected`, assim, manteremos o `private` na classe `Funcionario`:

```
public class Funcionario {

        private String nome;
        private String cpf;
        private double salario;

//Código omitidoCOPIAR CÓDIGO
```

Testaremos nosso código, executando a classe `TesteGerente`. No console, vemos os mesmos valores impressos, indicando que está tudo funcionando:

```
Marco
235568413
5000.0
true
5250.0COPIAR CÓDIGO
```

Ainda temos bastante conceitos para aprender, veremos mais adiante. Até lá!