# 09 - Para saber mais: Sobrecarga

Existe um outro conceito nas linguagens OO que se chama de **sobrecarga** que é muito mais simples do que a *sobrescrita* e não é dependente da herança.

Por exemplo, na nossa classe `Gerente`, imagine um outro novo método `autentica` que recebe além da `senha` também o `login`:

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

    //novo método, recebendo dois params
    public boolean autentica(String login, int senha) {
        //implementacao omitida
    }

    //outros métodos omitidos
}COPIAR CÓDIGO
```

Repare que criamos uma nova versão do método `autentica`. Agora temos dois métodos `autentica` na mesma classe que variam na quantidade ou tipos de parâmetros. Isso se chama **sobrecarga** de métodos.

A sobrecarga não leva em conta a visibilidade ou retorno do método, apenas os parâmetros e não depende da herança.