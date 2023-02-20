# Aula 03 - Cast explicito e implícito

# **Cast explícito e implícito**

Já falamos bastante sobre o *Type Cast* que é nada mais do que a conversão de um tipo para outro.

# **Cast implícito e explícito de primitivos**

Para ser correto, já vimos o cast acontecendo antes mesmo de defini-lo. Temos dois exemplos, o primeiro do mundo de primitivos:

```
int numero = 3;
double valor = numero; //cast implícitoCOPIAR CÓDIGO
```

Repare que colocamos um valor da variável `numero` (tipo `int`) na variável `valor` (tipo `double`), sem usar um cast explícito. Isso funciona? A resposta é sim, pois qualquer inteiro cabe dentro de um double. Por isso o compilador fica quieto e não exige um *cast explicito*, mas nada impede de escrever:

```
int numero = 3;
double valor = (double) numero; //cast explícitoCOPIAR CÓDIGO
```

Agora, o contrário não funciona sem cast, uma vez que um `double` não cabe em um `int`:

```
double valor = 3.56;
int numero = (int) valor; //cast explicito é exigido pelo compiladorCOPIAR CÓDIGO
```

Nesse caso o compilador joga todo valor fracional fora e guarda apenas o valor inteiro.

# **Cast implícito e explícito de referências**

Nas referências, o mesmo princípio se aplica. Se o cast sempre funciona não é necessário deixá-lo explícito, por exemplo:

```
ContaCorrente cc1 = new ContaCorrente(22, 33);
Conta conta = cc1; //cast implicitoCOPIAR CÓDIGO
```

Aqui também poderia ser explícito, mas novamente, o compilador não exige pois qualquer `ContaCorrente` é uma `Conta`:

```
ContaCorrente cc1 = new ContaCorrente(22, 33);
Conta conta = (Conta) cc1; //cast explícito mas
```