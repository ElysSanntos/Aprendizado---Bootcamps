# Aula 11 - Mão na massa: Trabalhando com pacotes

Chegou o momento de aplicarmos o que foi visto nas aulas!

---

1) Conforme mostrado no vídeo, abra o **navigator** e crie a pasta **modelo** e coloque todas as suas classes que **não são testes**

2) Crie uma segunda pasta com o nome **teste** e mova todos seus arquivos de testes para ela

3) Na sua classe **CalculadorDeImposto** coloque o package onde ela se encontra, no caso, package modelo!

```
package modelo;

public class CalculadorDeImposto{

    ...COPIAR CÓDIGO
```

4) Agora replique o código de declaração do package para todos os arquivos que realmente estejam contidos nesse package modelo!

5) Faça o mesmo passo acima, mas agora para seu package teste.

6) Modifique o nome das classes para indicar em qual package elas estão (full qualified name)

```
modelo.ContaCorrente cc = new ContaCorrente(222, 333);COPIAR CÓDIGO
```

OBS: Isso irá corrigir os erros que o eclipse nos indicará!

7) Crie uma pasta com o nome do projeto, no curso utilizamos **banco**

8) Coloque suas pastas **modelo** e **teste** dentro da pasta do projeto.

OBS: Repare que teremos o mesmo erro de compilação anterior.

9) Crie uma pasta com o nome da empresa, no caso, **bytebank** e coloque sua pasta **banco** dentro dela.

10) Conforme explicado no vídeo, crie as pastas **br** e **com**, coloque a pasta **bytebank** dentro de **com**, após isso, coloque a pasta **com** dentro de **br**

OBS: O Full Qualified Name de **ContaCorrente** agora é **br.com.bytebank.banco.modelo.ContaCorrente**

11) Modifique o nome dos seus packages em seus arquivos como foi feito no passo 3

```
package br.com.bytebank.banco.modelo;COPIAR CÓDIGO
```

12) Pare de utilizar o FQN e passe a importar o pacote necessário para sua classe!

```
import br.com.bytebank.banco.modelo.*;COPIAR CÓDIGO
```

OBS: O * indica que estamos importando todo o conteúdo de modelo.

13) Faça todas as alterações para que seu código compile.