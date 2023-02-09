# 02 - Aplicando Polimorfismo

Olá! Tudo bem?

Anteriormente, falávamos sobre o polimorfismo, vimos que se trata de um objeto que pode ser referenciado por uma referência de mesmo tipo, ou genérica. Ou seja, se temos um objeto `Gerente()`, a referência pode ser tanto do tipo `Gerente`, quanto do tipo `Funcionario`.

Mas qual a utilidade disso? É o que veremos nesta aula.

Primeiro, para esclarecermos este conceito, criaremos uma nova classe.

Imaginemos uma situação em que temos uma empresa e, nela, há uma sala específica para controlar a bonificação dos funcionários. Cada um deles entra nela periodicamente, digamos uma vez por mês, para saber qual a sua bonificação. Assim, temos uma pessoa que mantém o controle de todas as bonificações em uma planilha para, ao final, somar tudo.

Portanto, teremos uma classe chamada `ControleBonificacao`. Ela terá um método público `registra`:

```
public class ControleBonificacao {

        public void registra() {

        }
}COPIAR CÓDIGO
```

No registro, teremos os funcionários, por isso, incluiremos o `Gerente g`:

```
public class ControleBonificacao {

        public void registra(Gerente g) {

        }
}COPIAR CÓDIGO
```

O primeiro a fazer é obter a sua bonificação, utilizando o método `getBonificacao()`, que guardaremos em uma variável `boni`:

```
public class ControleBonificacao {

        public void registra(Gerente g) {
            double boni = g.getBonificacao();

        }
}COPIAR CÓDIGO
```

Para podermos lembrar da bonificação, criaremos um atributo `soma`, onde somaremos todas as bonificações:

```
public class ControleBonificacao {

        private double soma;

        public void registra(Gerente g) {
            double boni = g.getBonificacao();

        }
}COPIAR CÓDIGO
```

Assim, teremos que a soma será um resultado da soma atual mais a bonificação informada:

```
public class ControleBonificacao {

        private double soma;

        public void registra(Gerente g) {
            double boni = g.getBonificacao();
            this.soma = this.soma + boni;

        }
}COPIAR CÓDIGO
```

Testaremos isso, na classe `TesteReferencias`, onde criaremos um objeto `ControleBonificacao()`, que será registrado:

```
public class TesteReferencias {

        public static void main(String[] args) {

                Gerente g1 = new Gerente();
                g1.setNome("Marcos");
                g1.setSalario(5000.0);

                ControleBonificacao controle = new ControleBonificacao();
                controle.registra(g1);

        }
}COPIAR CÓDIGO
```

Retornaremos à classe `ControleBonificacao()`, onde criaremos um método para nos devolver a soma de todas as bonificações:

```
public class ControleBonificacao {

        private double soma;

        public void registra(Gerente g) {
            double boni = g.getBonificacao();
            this.soma = this.soma + boni;

        }

        public double getSoma() {
            return soma;
        }
}COPIAR CÓDIGO
```

Retornaremos à classe `TesteReferencias`, e imprimiremos a soma total:

```
public class TesteReferencias {

        public static void main(String[] args) {

                Gerente g1 = new Gerente();
                g1.setNome("Marcos");
                g1.setSalario(5000.0);

                ControleBonificacao controle = new ControleBonificacao();
                controle.registra(g1);

                System.out.println(controle.getSoma());

        }
}COPIAR CÓDIGO
```

Executaremos esta classe, para testarmos se está funcionando. No console, temos a seguinte exibição:

```
5250.0COPIAR CÓDIGO
```

O que indica que funcionou. Temos apenas um gerente, portanto, teremos apenas uma bonificação.

Em seguida, criaremos mais um funcionário, do tipo `Funcionario`, com salário de R$2.000,00, e que também será registrado:

```
public class TesteReferencias {

        public static void main(String[] args) {

                Gerente g1 = new Gerente();
                g1.setNome("Marcos");
                g1.setSalario(5000.0);

                Funcionario f = new Funcionario();
                f.setSalario(2000.0);

                ControleBonificacao controle = new ControleBonificacao();
                controle.registra(g1);
                controle.registra(f);

                System.out.println(controle.getSoma());

        }
}COPIAR CÓDIGO
```

Para que possamos registrá-lo, precisamos primeiro criar o método em `ControleBonificacao`:

```
public class ControleBonificacao {

        private double soma;

        public void registra(Gerente g) {
            double boni = g.getBonificacao();
            this.soma = this.soma + boni;

        }

        public void registra(Funcionario f) {
            double boni = f.getBonificacao();
            this.soma = this.soma + boni;

        }

        public double getSoma() {
            return soma;
        }
}COPIAR CÓDIGO
```

Assim, podemos testar nossa classe `TesteReferencias`, tendo em mente que temos dois métodos, com parâmetros diferentes, já que um é gerente e o outro é um funcionário comum. Executando a classe, temos o seguinte resultado no console:

```
5350.0COPIAR CÓDIGO
```

Funcionou! Já havíamos calculado `5250.0` anteriormente, agora, como acrescentamos 5% (bonificação) do salário do funcionário (R$2.000,00), adicionamos `100` àquele número, resultando em `5350.0`.

Em seguida, criaremos em uma nova classe mais um tipo de funcionário, que se chamará `EditorVideo`, ele também estende a classe `Funcionario`, e sua bonificação é o valor padrão, acrescido de R$100,00:

```
public class EditorVideo extends Funcionario {

        public double getBonificacao() {
                return super.getBonificacao() + 100;

        }
}COPIAR CÓDIGO
```

Retornaremos à classe `ControleBonificacao`, onde criaremos um método `registra(EditorVideo ev)`:

```
public class ControleBonificacao {

        private double soma;

        public void registra(Gerente g) {
            double boni = g.getBonificacao();
            this.soma = this.soma + boni;
        }

        public void registra(Funcionario f) {
            double boni = f.getBonificacao();
            this.soma = this.soma + boni;
        }

        public void registra(EditorVideo ev) {
            double boni = ev.getBonificacao();
            this.soma = this.soma + boni;
        }

        public double getSoma() {
            return soma;
        }
}COPIAR CÓDIGO
```

Partiremos para a classe `TesteReferencias`, para criarmos um novo objeto `EditorVideo()`:

```
public class TesteReferencias {

        public static void main(String[] args) {

            Gerente g1 = new Gerente();
            g1.setNome("Marcos");
            g1.setSalario(5000.0);

            Funcionario f = new Funcionario();
            f.setSalario(2000.0);

            EditorVideo ev = new EditorVideo();
            ev.setSalario(2500.0);

            ControleBonificacao controle = new ControleBonificacao();
            controle.registra(g1);
            controle.registra(f);
            controle.registra(ev);

            System.out.println(controle.getSoma());

        }
}COPIAR CÓDIGO
```

Como podemos observar, estamos repetindo muitas linhas de código e, como sabemos, isto não é uma boa prática de programação.

Executaremos a classe, para testarmos, e temos o seguinte resultado no console:

```
5575.0COPIAR CÓDIGO
```

Funcionou! Temos a soma de todas as bonificações.

Entretanto, se retornarmos à classe `ControleBonificacao` e a observarmos, vemos que há três métodos que executam a mesma função, sendo que para cada tipo, temos um método específico, o que nos resulta em um código verboso. Cada vez que um novo tipo de funcionário for inserido, um novo método específico será criado - não queremos que isto aconteça.

Para resolvermos, primeiro, vamos pensar na situação real, em que há uma sala em determinada empresa onde é feito o controle da bonificação. Quantas portas esta sala tem? Não temos como saber, mas não nos parece lógico que haja uma porta para cada tipo de funcionário. O mais provável é que haja uma única porta, com uma placa "funcionários", sendo que todos aqueles que forem funcionários podem entrar por ela.

A porta, pensando no código, é o nosso método. Queremos ter apenas um método, que sirva para os funcionários de forma geral:

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

Salvaremos e podemos observar que tudo continuará funcionando, ou seja, o código está compilando - isto é um bom sinal.

Na classe `TesteReferencias` criamos um gerente, um funcionário comum e um editor de vídeo. Em seguida, criamos o `ControleBonificacao()` onde registramos cada um dos tipos de funcionário, utilizando um mesmo método.

Agora, na classe `ControleBonificacao` temos apenas um método `registra()`, que recebe uma referência do tipo `Funcionario`, como todos são funcionários, podemos utilizar a referência mais genérica. É por isso que o código em `TesteReferencias` continua funcionando, porque o método `registra` recebe um tipo `Funcionario`, que é capaz de englobar tanto a classe `Gerente` quanto `EditorVideo`.

Na classe `TesteReferencias` temos o `ControleBonificacao`, no qual registramos um tipo de funcionário, por exemplo um gerente, passamos a referência `g1`, e nela é guardado o tipo `Funcionario`.

É assim que funciona o polimorfismo, é possível comunicarmos com o `Gerente` a partir de uma referência genérica, como `Funcionario`.

Temos na classe `ControleBonificacao` o seguinte método:

```
//Código omitido

public void registra(Funcionario f) {
        double boni = f.getBonificacao();
        this.soma = this.soma + boni;
}

//Restante do código omitidoCOPIAR CÓDIGO
```

Nele, chamamos o método `getBonificacao()` mas, neste caso, qual será executado? O específico da classe `Gerente`, ou o geral, presente na classe `Funcionario`?

Cada funcionário desejará ganhar a bonificação à qual faz jus, por isso, sempre será utilizado o método específico. Se estamos lidando com um gerente, o `getBonificacao()` será aquele específico da classe `Gerente`.

Para visualizar isso, criaremos um imprimível dentro do método `getBonificacao()` na classe `Gerente`:

```
public class Gerente extends Funcionario {

        private int senha;

        public void setSenha(int senha) {
            if(this.senha == senha) {
                return true;
            } else {
                return false;
            }
        }

        public double getBonificacao() {
            System.out.println("Chamando o método bonificacao do GERENTE");
            return super.getBonificacao() + super.getSalario();
        }
}COPIAR CÓDIGO
```

Executaremos o código. No console, temos o seguinte resultado:

```
Chamando o método de bonificacao do GERENTE
5575.0COPIAR CÓDIGO
```

Foi impressa nossa mensagem contida dentro do método `getBonificacao()` da classe `Gerente`, provando que foi utilizado o método específico. O resultado numérico não mudou.

Faremos mais teste, agora na classe `EditorVideo`, onde inseriremos uma frase a ser impressa:

```
public class EditorVideo extends Funcionario {

        public double getBonificacao() {
                System.out.println("Chamando o método de bonificacao do Editor de Video");
                return super.getBonificacao() + 100;

        }

}COPIAR CÓDIGO
```

Retornaremos à classe `TesteReferencias`, executaremos novamente e temos o seguinte resultado:

```
Chamando o método de bonificacao do GERENTE
Chamando o método de bonificacao do Editor de Video
5575.0COPIAR CÓDIGO
```

As duas mensagens foram impressas, o que significa que, para um destes tipos de `Funcionario` foi utilizado o método `getBonificacao()` específico de sua respectiva classe. **Ao executarmos o código, sempre será chamado o método específico**, é esta a real vantagem do polimorfismo.

Ao vermos o código, em `ControleBonificacao` não podemos identificar qual método será utilizado, pois pode ser a regra geral de `Funcionario`, ou qualquer outro método específico de alguma outra classe. Isso depende do objeto, ou seja, para qual lugar a referência está apontando.

Temos apenas um método genérico e, mesmo assim, o método específico será chamado. É esta a vantagem do polimorfismo.