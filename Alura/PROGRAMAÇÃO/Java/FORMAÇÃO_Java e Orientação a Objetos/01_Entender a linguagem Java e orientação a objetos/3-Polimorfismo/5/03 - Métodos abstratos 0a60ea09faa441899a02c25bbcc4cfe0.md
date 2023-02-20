# 03 - Métodos abstratos

Anteriormente, falamos sobre classes abstratas. Aprendemos que não é possível instanciar objetos desta classe, vamos deixar isto em comentário no código:

```
//nao pode instanciar essa classe, pq é abstrata
public abstract class Funcionario {

        private String nome;
        private String cpf;
        private double salario;

//Código omitidoCOPIAR CÓDIGO
```

Dessa forma, evitamos que seja instanciado um funcionário genérico, já que esta função não existe na prática.

Os códigos das classes filhas continuam funcionando normalmente, graças ao polimorfismo, podemos fazer referências genéricas. Não perdemos os benefícios da herança, apenas eliminamos a possibilidade da criação de um objeto com uma referência do tipo `Funcionario`, o que não faria sentido.

Recebemos então uma demanda do nosso chefe, informando que não deve existir uma regra padrão de bonificação para todos. O designer receberá R$200,00, o editor de vídeo recebe R$150,00, e o gerente recebe um salário simples. Não há mais uma regra padrão.

Como temos um parâmetro específico para cada funcionário, não precisamos mais do método `getBonificacao()` na classe `Funcionario`, por isso, a deixaremos em comentários:

```
//nao pode instanciar essa classe, pq é abstrata
public abstract class Funcionario {

        private String nome;
        private String cpf;
        private double salario;

    //public double getBonificacao() {
//        return this.salario * 0.5;
//    }

        public String getNome() {
                return nome;
        }

//Código omitidoCOPIAR CÓDIGO
```

Nenhuma das classes filhas utiliza o método `getBonificacao()` da classe mãe, cada uma conta com seu próprio método específico.

Na classe `TesteFuncionario` vemos que há um erro:

```
public class TesteFuncionario {

        public static void main(String[] args) {

                Funcionario nico = new Gerente();
                nico.setNome("Nico Steppat");
                nico.setcpf("223355646-9");
                nico.setSalario(2600.00);

                System.out.println(nico.getNome());
                System.out.println(nico.getBonificacao());

                //nico.salario = 300.0;
        }
}COPIAR CÓDIGO
```

Ao tentarmos imprimir o valor da bonificação, o Eclipse aponta um erro de compilação.

Estamos criando um gerente, e ele terá uma bonificação. O erro acontece porque utilizamos a referência genérica, do tipo `Funcionario`. Para resolvermos isso, podemos simplesmente alterar a referência para `Gerente`:

```
public class TesteFuncionario {

        public static void main(String[] args) {

                Gerente nico = new Gerente();
                nico.setNome("Nico Steppat");
                nico.setcpf("223355646-9");
                nico.setSalario(2600.00);

                System.out.println(nico.getNome());
                System.out.println(nico.getBonificacao());

                //nico.salario = 300.0;

        }
}COPIAR CÓDIGO
```

Abriremos a classe `ControleBonificacao`:

```
public class ControleBonificacao {

        private double soma;

        public void registra(Funcionario f) {
            double boni = f.getBonificacao();
            this.soma = this.soma + boni;
        }

        public double getSoma() {
            return soma;
        }
}COPIAR CÓDIGO
```

E temos um problema, porque a classe `Funcionario` não tem mais o método `getBonificacao()`, e está apontando para um objeto `f`, do tipo `Funcionario()` - isso significa que o código não compilará.

Se apontasse para um objeto `g`, por exemplo, isso não aconteceria pois, na classe `Gerente`, há um método `getBonificacao` específico.

Ou seja, comentar o método em `Funcionario` não foi uma boa solução. Removeremos as barras para retorná-lo à forma anterior:

```
//não pode instanciar essa classe, pq é abstrata
public abstract class Funcionario {

        private String nome;
        private String cpf;
        private double salario;

        public double getBonificacao() {
        return this.salario * 0.5;
    }

        public String getNome() {
                return nome;
        }

//Código omitidoCOPIAR CÓDIGO
```

Já que não podemos implementar nada, poderíamos definir o retorno simplesmente como `-1`:

```
//não pode instanciar essa classe, pq é abstrata
public abstract class Funcionario {

        private String nome;
        private String cpf;
        private double salario;

        public double getBonificacao() {
        return -1;
    }

        public String getNome() {
                return nome;
        }

//Código omitidoCOPIAR CÓDIGO
```

Mas, nesse caso, se alguém perde dinheiro, alguma coisa está errada, a pessoa reclamará e a bonificação deverá ser refeita. Isso não é a forma correta de lidar com este problema.

Temos que garantir que este método exista para as classes filhas. Ele precisa existir, para que o `ControleBonificacao` funcione. Entretanto, o ideal seria que ele não tivesse uma implementação, ou seja, que existisse da seguinte forma:

```
//não pode instanciar essa classe, pq é abstrata
public abstract class Funcionario {

        private String nome;
        private String cpf;
        private double salario;

        public double getBonificacao();

        public String getNome() {
                return nome;
        }

//Código omitidoCOPIAR CÓDIGO
```

Algo que não é permitido pelo Java. Como não podemos ter um método concreto, o declararemos como abstrato:

```
//não pode instanciar essa classe, pq é abstrata
public abstract class Funcionario {

        private String nome;
        private String cpf;
        private double salario;

        public abstract double getBonificacao();

        public String getNome() {
                return nome;
        }

//Código omitidoCOPIAR CÓDIGO
```

Da mesma forma que existem classes abstratas, também existem métodos abstratos.

Na classe, significa que não é possível instanciar objetos desta classe. No método, significa que ele não tem um corpo, ou seja, que não foi implementado:

```
//não pode instanciar essa classe, pq é abstrata
public abstract class Funcionario {

        private String nome;
        private String cpf;
        private double salario;

        //metodo sem corpo, nao ha implementacao
        public abstract double getBonificacao();

        public String getNome() {
                return nome;
        }

//Código omitidoCOPIAR CÓDIGO
```

O método será implementado somente nas classes filhas.

Na classe `Designer`:

```
public class Designer extends Funcionario {

    public double getBonificacao() {
        System.out.println("Chamando o método de bonificacao do Designer");
        return 200;
    }
}COPIAR CÓDIGO
```

Removeremos totalmente o método `getBonificacao`:

```
public class Designer extends Funcionario {

}
COPIAR CÓDIGO
```

Salvaremos. A classe passará a **não compilar**. O Eclipse nos informa que isso se dá porque a classe `Designer` precisa implementar o método abstrato `getBonificacao`.

O compilador percebe que o método é abstrato, e assim sendo, não funcionará em uma classe concreta. Necessariamente ele deve ser implementado. Por isso, retornaremos a implementação do método:

```
public class Designer extends Funcionario {

    public double getBonificacao() {
        System.out.println("Chamando o método de bonificacao do Designer");
        return 200;
    }
}COPIAR CÓDIGO
```

Ao colocar um método abstrato em uma classe mãe, obrigamos os filhos a implementar tal método.

Testaremos isso, executando a classe `TesteReferencias`. No console, temos o seguinte resultado:

```
Chamando o método de bonificacao do GERENTE
Chamando o método de bonificacao do Editor de video
Chamando o método de bonificacao do Designer
5350.0COPIAR CÓDIGO
```

Funcionou.

Mas há alguma outra forma de conseguirmos compilar esta classe, sem que seja utilizando um método abstrato? Sim, poderíamos implementar o método diretamente na classe filha, ou, indicar que a própria classe filha é abstrata.

Nesta última hipótese, teríamos um problema na classe `TesteReferencias`, pois não seria possível instanciarmos um objeto do tipo `Designer()`.

Sendo assim, aprendemos que `abstract` é uma palavra-chave que podemos utilizar tanto antes de uma classe quanto antes de um método. Apesar de seu significado estar relacionado, ele é diferente da herança.

Na classe, significa que não será possível instanciar nenhum objeto daquele tipo, enquanto que para o método, indica que ele não tem implementação, e o primeiro filho concreto precisará implementá-lo.