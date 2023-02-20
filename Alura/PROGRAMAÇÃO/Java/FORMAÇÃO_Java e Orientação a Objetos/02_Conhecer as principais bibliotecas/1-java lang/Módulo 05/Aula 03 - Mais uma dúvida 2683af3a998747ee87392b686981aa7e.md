# Aula 03 - Mais uma dúvida

Ainda no mesmo projeto você encontrou outro código:

```
boolean existe1 = Banco.existeBanco("CAIXA");
boolean existe2 = Banco.existeBanco(394);COPIAR CÓDIGO
```

Seu amigo está com dificuldade de entender. Será que pode ajudá-lo e marcar todas as alternativas corretas?

Alternativa correta[x] 
`existeBanco` tem acesso estático.
Correto pois usamos a classe `Banco` para chamar.Alternativa correta[x] 
`existeBanco` é uma forma de *sobrecarga*.
Correto, existem duas versões desse método que variam nos parâmetros, a primeira recebe uma `String` e a segunda recebe uma valor `int`.Alternativa correta[x] 
`existeBanco` é um método.
Correto, as parênteses deixam claro que se trata de um método.

- **Para ser da instância é preciso usar uma referência.**
- **s*obrescrita***  é relacionado com a herança