# 05 - Tipo da referência

Continuando com o exemplo `Veiculo`, `Moto` e `Carro`:

```
public class Veiculo {
    public void liga() {
        System.out.println("Ligando Veiculo");
    }
}

public class Carro extends Veiculo {
    public void liga() {
        System.out.println("Ligando Carro");
    }
}

public class Moto extends Veiculo {
    public void liga() {
        System.out.println("Ligando Moto");
    }
}COPIAR CÓDIGO
```

E veja o código quase completo:

```
public class Teste {

    public static void main(String[] args) {

        ???? v = new Carro();

    }

}COPIAR CÓDIGO
```

O que podemos inserir no lugar de **`????`** para compilar o código sem erros?

Alternativa correta[x] 
`Carro`
Correto, podemos sempre usar o mesmo tipo na referência e objeto.Alternativa correta[x] 
`Veiculo`
Correto, pois o `Carro` é um `Veiculo`.