# Aula 08 - Mãos na massa: Catch genérico

No projeto `java-pilha`, abra a classe `Conta` (aquela classe de teste). No método `deposita()`, lance a exceção que criamos anteriormente.

1) O corpo ficará desse jeito:

```
void deposita() throws MinhaExcecao {
    //codigo omitido
}COPIAR CÓDIGO
```

*Lembrando que a classe `MinhaExcecao` é checked*.

2) Agora, para podermos testar nossa exceção, vamos criar a classe `TestaContaComExcecaoChecked`. Dentro dela, faremos uma chamada ao método deposita. Ao chamar o método, somos obrigados a tratar a exceção:

```
public class TestaContaComExcecaoChecked {

    public static void main(String[] args) {

        Conta c = new Conta();
        try {
            c.deposita();
        } catch(MinhaExcecao ex) {
            System.out.println("tratamento ....");
        }

    }
}COPIAR CÓDIGO
```

3) Agora, abra a classe `Fluxo`. Similarmente, dentro do `catch` dessa classe, experimente o "catch genérico" usando apenas `Exception`:

```
try {
    metodo1();
} catch(Exception ex) { //catch genérico, capturando qq exceção
    String msg = ex.getMessage();
    System.out.println("Exception " + msg);
    ex.printStackTrace();
}COPIAR CÓDIGO
```

4) Se você encontrar um erro de compilação na classe `FluxoComError`, pode ser por conta da exceção `MinhaExcecao` que é *checked*. Verifique se ainda está tratando essa exceção, dentro do `catch`, e apague essa parte. Vamos deixar do jeito antigo (sem `MinhaExcecao`):

```
//na classe FluxoComError
try {
    metodo1();
} catch(ArithmeticException | NullPointerException ex) {
    String msg = ex.getMessage();
    System.out.println("Exception " + msg);
    ex.printStackTrace();
}COPIAR CÓDIGO
```

Está tudo compilando? Verifique as classes e ajuste o código. No próximo exercício alteraremos a conta de verdade!