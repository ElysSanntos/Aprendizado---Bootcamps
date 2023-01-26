# Aula 03 - Mais uma dúvida

Ainda no mesmo projeto você encontrou outro código:

```
boolean existe1 = Banco.existeBanco("CAIXA");
boolean existe2 = Banco.existeBanco(394);
```

Seu amigo está com dificuldade de entender. Será que pode ajudá-lo e marcar todas as alternativas corretas?

*Selecione 3 alternativas*

- `existeBanco` tem acesso estático.
    
    Correto pois usamos a classe `Banco` para chamar.
    
- Alternativa correta
    
    `existeBanco` é uma forma de *sobrecarga*.
    
    Correto, existem duas versões desse método que variam nos parâmetros, a primeira recebe uma `String` e a segunda recebe uma valor `int`.
    
- Alternativa correta
    
    `existeBanco` é um método.
    
    Correto, as parênteses deixam claro que se trata de um método.
    
    - Os parênteses deixam claro que se trata de um método.
    - o `existeBanco`  é chamado a partir da classe `Banco` . Para ser da instância é preciso usar uma referência.
    - *sobrescrita*  é relacionado com a herança que não é o caso nesse exemplo.